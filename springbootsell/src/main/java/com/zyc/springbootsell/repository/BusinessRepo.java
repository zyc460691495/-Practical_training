package com.zyc.springbootsell.repository;

import com.zyc.springbootsell.dataobject.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepo extends JpaRepository<Business,String> {

    Business findByPasswordAndBusinessId(String businessId,String password);
}
