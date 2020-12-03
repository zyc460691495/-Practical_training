package com.zyc.springbootsell.services.impl;

import com.zyc.springbootsell.dataobject.Seller;
import com.zyc.springbootsell.repository.SellerRepo;
import com.zyc.springbootsell.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepo repo;

    @Override
    public Seller checkUser(String username, String password) {
        Seller seller = repo.findByUsernameAndPassword(username, password);
        return seller;
    }
}
