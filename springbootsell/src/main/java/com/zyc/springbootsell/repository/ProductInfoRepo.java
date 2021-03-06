package com.zyc.springbootsell.repository;

import com.zyc.springbootsell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepo extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer integer);

}

