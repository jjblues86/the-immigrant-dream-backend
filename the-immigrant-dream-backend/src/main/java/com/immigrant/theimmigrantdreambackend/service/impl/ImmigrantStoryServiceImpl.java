package com.immigrant.theimmigrantdreambackend.service.impl;

import com.immigrant.theimmigrantdreambackend.entity.ImmigrantStory;
import com.immigrant.theimmigrantdreambackend.exception.ResourceNotFoundException;
import com.immigrant.theimmigrantdreambackend.payload.ImmigrantStoryDto;
import com.immigrant.theimmigrantdreambackend.repository.ImmigrantStoryRepository;
import com.immigrant.theimmigrantdreambackend.service.ImmigrantStoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImmigrantStoryServiceImpl implements ImmigrantStoryService {

    private ImmigrantStoryRepository immigrantStoryRepository;
    private ModelMapper mapper;

    public ImmigrantStoryServiceImpl(ImmigrantStoryRepository immigrantStoryRepository, ModelMapper mapper) {
        this.immigrantStoryRepository = immigrantStoryRepository;
        this.mapper = mapper;
    }

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

        ImmigrantStory immigrantStory = mapper.map(immigrantStoryDto, ImmigrantStory.class);
        return immigrantStory;
    }

    private ImmigrantStoryDto mapToDTO(final ImmigrantStory newImmigrantStory) {
        ImmigrantStoryDto immigrantStoryDto = mapper.map(newImmigrantStory, ImmigrantStoryDto.class);
        return immigrantStoryDto;
    }

}
