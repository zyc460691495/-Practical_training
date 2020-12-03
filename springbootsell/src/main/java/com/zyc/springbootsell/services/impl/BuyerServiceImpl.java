package com.zyc.springbootsell.services.impl;

import com.zyc.springbootsell.dataobject.Buyer;
import com.zyc.springbootsell.dataobject.Seller;
import com.zyc.springbootsell.repository.BuyerRepo;
import com.zyc.springbootsell.services.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerRepo repo;

    @Override
    public Buyer checkUser(String username, String password) {
        Buyer buyer = repo.findByUsernameAndPassword(username, password);
        return buyer;
    }
}
