package com.zyc.springbootsell.repository;

import com.zyc.springbootsell.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepo extends JpaRepository<OrderMaster,String> {
}
