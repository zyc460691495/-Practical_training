package com.zyc.dao;

import com.zyc.domain.Admin;

public interface AdminDao {
    public Admin getAdminByNameAndPassword(String adminName, String password);
}
