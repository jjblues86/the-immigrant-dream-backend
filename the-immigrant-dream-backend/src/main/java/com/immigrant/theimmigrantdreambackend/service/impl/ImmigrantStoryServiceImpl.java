package com.immigrant.theimmigrantdreambackend.service.impl;

import com.immigrant.theimmigrantdreambackend.entity.ImmigrantStory;
import com.immigrant.theimmigrantdreambackend.exception.ResourceNotFoundException;
import com.immigrant.theimmigrantdreambackend.payload.ImmigrantStoryDto;
import com.immigrant.theimmigrantdreambackend.repository.ImmigrantStoryRepository;
import com.immigrant.theimmigrantdreambackend.service.ImmigrantStoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImmigrantStoryServiceImpl implements ImmigrantStoryService {

    private final ImmigrantStoryRepository immigrantStoryRepository;
    private final ModelMapper mapper;

    @Override
    public List<ImmigrantStoryDto> getImmigrantStoriesList() {
        final List<ImmigrantStory> immigrantStories = (List<ImmigrantStory>) immigrantStoryRepository.findAll();

        return immigrantStories.stream().map((immigrantStory) -> mapper.map(immigrantStory, ImmigrantStoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ImmigrantStoryDto saveImmigrantStory(final ImmigrantStoryDto immigrantStoryDto) {

        //convert DTO to entity
        final ImmigrantStory immigrantStory = mapToEntity(immigrantStoryDto);

        // convert entity to DTO
        final ImmigrantStory newImmigrantStory = immigrantStoryRepository.save(immigrantStory);

        return mapToDTO(newImmigrantStory);
    }

    @Override
    public ImmigrantStoryDto getImmigrantStoryById(final String immigrantStoryId) {
        final ImmigrantStory immigrantStory = immigrantStoryRepository.findById(immigrantStoryId)
                .orElseThrow(() -> new ResourceNotFoundException("ImmigrantStory", "id", immigrantStoryId));

        return mapper.map(immigrantStory, ImmigrantStoryDto.class);
    }

    @Override
    public ImmigrantStoryDto updateImmigrantStory(final String immigrantStoryId, final ImmigrantStoryDto immigrantStoryDto) {
        final ImmigrantStory immigrantStory = immigrantStoryRepository.findById(immigrantStoryId)
                .orElseThrow(() -> new ResourceNotFoundException("ImmigrantStory", "id", immigrantStoryId));

        immigrantStory.setId(immigrantStoryId);
        immigrantStory.setFirstName(immigrantStoryDto.getFirstName());
        immigrantStory.setLastName(immigrantStoryDto.getLastName());
        immigrantStory.setProfession(immigrantStoryDto.getProfession());
        immigrantStory.setStory(immigrantStoryDto.getStory());
        immigrantStory.setHobby(immigrantStoryDto.getHobby());
        immigrantStory.setOrigin(immigrantStoryDto.getOrigin());
        immigrantStory.setQuote(immigrantStoryDto.getQuote());

        ImmigrantStory saveUpdatedImmigrantStory = immigrantStoryRepository.save(immigrantStory);

        return mapper.map(saveUpdatedImmigrantStory, ImmigrantStoryDto.class);
    }

    @Override
    public void deleteImmigrantStory(final String immigrantStoryId) {
        final ImmigrantStory immigrantStory = immigrantStoryRepository.findById(immigrantStoryId)
                .orElseThrow(() -> new ResourceNotFoundException("ImmigrantStory", "id", immigrantStoryId));

        immigrantStoryRepository.delete(immigrantStory);
    }

    private ImmigrantStory mapToEntity(final ImmigrantStoryDto immigrantStoryDto) {

        return mapper.map(immigrantStoryDto, ImmigrantStory.class);
    }

    private ImmigrantStoryDto mapToDTO(final ImmigrantStory newImmigrantStory) {
        return mapper.map(newImmigrantStory, ImmigrantStoryDto.class);
    }
}
