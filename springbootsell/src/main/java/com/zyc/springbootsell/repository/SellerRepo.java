package com.zyc.springbootsell.repository;

import com.zyc.springbootsell.dataobject.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<Seller,String> {

    Seller findByUsernameAndPassword(String username, String password);
}
