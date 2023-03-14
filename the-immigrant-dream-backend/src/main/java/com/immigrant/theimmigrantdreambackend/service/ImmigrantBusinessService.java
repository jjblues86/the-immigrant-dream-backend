package com.immigrant.theimmigrantdreambackend.service;

import com.immigrant.theimmigrantdreambackend.entity.ImmigrantBusiness;
import com.immigrant.theimmigrantdreambackend.payload.ImmigrantBusinessDto;
import com.immigrant.theimmigrantdreambackend.payload.ImmigrantStoryDto;

import java.util.List;

public interface ImmigrantBusinessService {
    List<ImmigrantBusinessDto> getImmigrantBusinessList();
    ImmigrantBusinessDto saveImmigrantBusiness(ImmigrantBusinessDto immigrantBusinessDto);
    ImmigrantBusinessDto getImmigrantBusinessById(String id);
    ImmigrantBusinessDto updateImmigrantBusiness(String id, ImmigrantBusinessDto immigrantBusinessDto);
    void deleteImmigrantBusiness(String id);
}
