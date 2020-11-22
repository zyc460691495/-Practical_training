package com.zyc.dao;

import com.zyc.domain.Business;

import java.util.List;

public interface BusinessDao {
    public List<Business> businessList();
    public int addBusiness(String businessName,String password);
    public int removeBusiness(int businessId);
    public int updateBusiness(Business business);
    public int updateBusinessById(int businessId);
}
