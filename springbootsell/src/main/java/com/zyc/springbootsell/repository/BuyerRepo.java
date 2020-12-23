package com.zyc.springbootsell.repository;

import com.zyc.springbootsell.dataobject.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepo extends JpaRepository<Buyer,String> {
    Buyer findByUsernameAndPassword(String username, String password);
}
