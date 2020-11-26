package com.zyc.springbootsell.repository;

import com.zyc.springbootsell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDteailRepo extends JpaRepository<OrderDetail,String> {
}
