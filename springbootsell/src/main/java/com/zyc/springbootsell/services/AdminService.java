package com.zyc.springbootsell.services;


import com.zyc.springbootsell.dataobject.Admin;
import com.zyc.springbootsell.dataobject.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminService {

    Admin checkUser(String username, String password);
    Page<Admin> findAllPage(Pageable pageable);
}
