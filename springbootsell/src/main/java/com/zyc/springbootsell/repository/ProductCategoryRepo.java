package com.zyc.springbootsell.repository;

import com.zyc.springbootsell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory,Integer> {
}
