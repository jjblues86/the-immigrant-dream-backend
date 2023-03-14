package com.immigrant.theimmigrantdreambackend.service.impl;

import com.immigrant.theimmigrantdreambackend.entity.ImmigrantBusiness;
import com.immigrant.theimmigrantdreambackend.service.ImmigrantBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImmigrantBusinessServiceImpl implements ImmigrantBusinessService {

//    @Autowired
//    private ImmigrantBusinessRepository immigrantBusinessRepository;

    @Override
    public List<ImmigrantBusiness> getImmigrantBusinessList() {
        return null;
    }

    @Override
    public ImmigrantBusiness saveImmigrantBusiness(ImmigrantBusiness immigrantBusiness) {
        return null;
    }

    @Override
    public ImmigrantBusiness getImmigrantBusinessById(String id) {
        return null;
    }

    @Override
    public ImmigrantBusiness updateImmigrantBusiness(String id, ImmigrantBusiness immigrantBusiness) {
        return null;
    }

    @Override
    public void deleteImmigrantBusiness(String id) {

    }
}
