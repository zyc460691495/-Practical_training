package com.zyc.springbootsell.services.impl;

import com.zyc.springbootsell.dataobject.Business;
import com.zyc.springbootsell.repository.BusinessRepo;
import com.zyc.springbootsell.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessRepo businessRepo;


    @Override
    public Business checkUser(String businessId, String password) {
        return businessRepo.findByPasswordAndBusinessId(businessId,password);
    }

    @Override
    public Page<Business> findAllPage(Pageable pageable) {
        return businessRepo.findAll(pageable);
    }
}
