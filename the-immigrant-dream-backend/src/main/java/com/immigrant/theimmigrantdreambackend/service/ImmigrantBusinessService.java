package com.immigrant.theimmigrantdreambackend.service;

import com.immigrant.theimmigrantdreambackend.entity.ImmigrantBusiness;

import java.util.List;

public interface ImmigrantBusinessService {
    List<ImmigrantBusiness> getImmigrantBusinessList();
    ImmigrantBusiness saveImmigrantBusiness(ImmigrantBusiness immigrantBusiness);
    ImmigrantBusiness getImmigrantBusinessById(String id);
    ImmigrantBusiness updateImmigrantBusiness(String id, ImmigrantBusiness immigrantBusiness);
    void deleteImmigrantBusiness(String id);
}
