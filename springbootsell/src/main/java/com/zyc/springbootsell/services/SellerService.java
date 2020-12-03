package com.zyc.springbootsell.services;

import com.zyc.springbootsell.dataobject.Seller;


public interface SellerService {
    Seller checkUser(String username, String password);
}
