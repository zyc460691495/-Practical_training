package com.zyc.springbootsell.services.impl;

import com.zyc.springbootsell.dataobject.Admin;
import com.zyc.springbootsell.repository.AdminRepo;
import com.zyc.springbootsell.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo adminRepo;

    @Override
    public Admin checkUser(String username, String password) {
        return adminRepo.findAdminByUsernameAndPassword(username,password);
    }

    @Override
    public Page<Admin> findAllPage(Pageable pageable) {
        return adminRepo.findAll(pageable);
    }
}
