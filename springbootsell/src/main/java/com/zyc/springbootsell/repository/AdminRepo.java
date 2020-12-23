package com.zyc.springbootsell.repository;

import com.zyc.springbootsell.dataobject.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,String> {

    Admin findAdminByUsernameAndPassword(String username, String password);
}
