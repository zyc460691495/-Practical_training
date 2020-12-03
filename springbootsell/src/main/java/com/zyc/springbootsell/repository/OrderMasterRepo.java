package com.zyc.springbootsell.repository;

import com.zyc.springbootsell.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderMasterRepo extends JpaRepository<OrderMaster,String> {

    List<OrderMaster> findByUserName(String username);
}
