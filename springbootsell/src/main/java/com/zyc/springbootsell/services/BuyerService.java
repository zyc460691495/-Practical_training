package com.zyc.springbootsell.services;

import com.zyc.springbootsell.dataobject.Buyer;
import com.zyc.springbootsell.dataobject.Seller;

public interface BuyerService {
    Buyer checkUser(String username, String password);
}
