package com.zyc.springbootsell.services;

import com.zyc.springbootsell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    List<ProductInfo> findAllUp();

    Page<ProductInfo> findAllPage(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    void increaseStock(String productId);

    void decreseStock(String productId);

    ProductInfo onSale(String  productId);

    ProductInfo offSale(String  productId);
}
