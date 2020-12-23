package com.zyc.springbootsell.services;

import com.zyc.springbootsell.dataobject.Admin;
import com.zyc.springbootsell.dataobject.Business;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BusinessService {
    Business checkUser(String username, String password);

    Page<Business> findAllPage(Pageable pageable);
}
