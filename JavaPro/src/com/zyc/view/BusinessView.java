package com.zyc.view;

import com.zyc.domain.Business;

public interface BusinessView {
    void listAllBusiness();
    void selectBusiness();
    void addBusiness();
    void removeBusiness();
    Business login();
    void updateBusiness(Business business);
    void updateBusinessPassword(Integer businessId);
}
