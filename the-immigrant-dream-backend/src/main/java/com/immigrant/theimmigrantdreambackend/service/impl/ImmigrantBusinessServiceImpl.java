package com.immigrant.theimmigrantdreambackend.service.impl;

import com.immigrant.theimmigrantdreambackend.entity.ImmigrantBusiness;
import com.immigrant.theimmigrantdreambackend.exception.ResourceNotFoundException;
import com.immigrant.theimmigrantdreambackend.payload.ImmigrantBusinessDto;
import com.immigrant.theimmigrantdreambackend.repository.ImmigrantBusinessRepository;
import com.immigrant.theimmigrantdreambackend.service.ImmigrantBusinessService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImmigrantBusinessServiceImpl implements ImmigrantBusinessService {

    private final ImmigrantBusinessRepository immigrantBusinessRepository;
    private final ModelMapper mapper;

    @Override
    public List<ImmigrantBusinessDto> getImmigrantBusinessList() {
        final List<ImmigrantBusiness> immigrantBusinessList = (List<ImmigrantBusiness>) immigrantBusinessRepository.findAll();

        return immigrantBusinessList.stream().map((immigrantBusinessDto) -> mapper.map(immigrantBusinessDto, ImmigrantBusinessDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ImmigrantBusinessDto saveImmigrantBusiness(final ImmigrantBusinessDto immigrantBusinessDto) {
        //convert DTO to entity
        final ImmigrantBusiness immigrantBusiness = mapToEntity(immigrantBusinessDto);

        // convert entity to DTO
        final ImmigrantBusiness newImmigrantBusiness = immigrantBusinessRepository.save(immigrantBusiness);

        return mapToDto(newImmigrantBusiness);
    }

    @Override
    public ImmigrantBusinessDto getImmigrantBusinessById(final String immigrantBusinessId) {
        final ImmigrantBusiness immigrantBusiness = immigrantBusinessRepository.findById(immigrantBusinessId)
                .orElseThrow(() -> new ResourceNotFoundException("ImmigrantBusiness", "id", immigrantBusinessId));

        return mapper.map(immigrantBusiness, ImmigrantBusinessDto.class);
    }

    @Override
    public ImmigrantBusinessDto updateImmigrantBusiness(final String immigrantBusinessId, final ImmigrantBusinessDto immigrantBusinessDto) {
        final ImmigrantBusiness immigrantBusiness = immigrantBusinessRepository.findById(immigrantBusinessId)
                .orElseThrow(() -> new ResourceNotFoundException("ImmigrantBusiness", "id", immigrantBusinessId));

        immigrantBusiness.setId(immigrantBusinessDto.getId());
        immigrantBusiness.setBusinessName(immigrantBusinessDto.getBusinessName());
        immigrantBusiness.setBusinessLocation(immigrantBusinessDto.getBusinessLocation());
        immigrantBusiness.setBusinessDescription(immigrantBusinessDto.getBusinessDescription());
        immigrantBusiness.setBusinessType(immigrantBusinessDto.getBusinessType());
        immigrantBusiness.setBusinessWebsite(immigrantBusinessDto.getBusinessWebsite());

        final ImmigrantBusiness savedUpdatedImmigrantBusiness = immigrantBusinessRepository.save(immigrantBusiness);

        return mapper.map(savedUpdatedImmigrantBusiness, ImmigrantBusinessDto.class);
    }

    @Override
    public void deleteImmigrantBusiness(final String immigrantBusinessId) {
        final ImmigrantBusiness immigrantBusiness = immigrantBusinessRepository.findById(immigrantBusinessId)
                .orElseThrow(() -> new ResourceNotFoundException("ImmigrantBusiness", "id", immigrantBusinessId));

        immigrantBusinessRepository.delete(immigrantBusiness);
    }

    private ImmigrantBusinessDto mapToDto(final ImmigrantBusiness newImmigrantBusiness) {

        return mapper.map(newImmigrantBusiness, ImmigrantBusinessDto.class);
    }

    private ImmigrantBusiness mapToEntity(ImmigrantBusinessDto immigrantBusinessDto) {

        return mapper.map(immigrantBusinessDto, ImmigrantBusiness.class);
    }
}
