package com.zyc.springbootsell.repository;

import com.zyc.springbootsell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoRepo extends JpaRepository<ProductInfo,String> {
}
