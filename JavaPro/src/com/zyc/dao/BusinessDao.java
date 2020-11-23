package com.zyc.dao;

import com.zyc.domain.Business;

import java.util.List;

public interface BusinessDao {
    public List<Business> listBusiness(String businessName,String businessAddress);
    public Business getBusinessById(Integer businessId);
    public int addBusiness(String businessName,String password);
    public int removeBusiness(Integer businessId);
    public int updateBusiness(Business business);
    public int updateBusinessById(Integer businessId);
    public Business getBusinessByIdAndPassword(Integer businessId, String businessPassword);
    public int updateBusinessPassword(Integer businessId,String password);
}
