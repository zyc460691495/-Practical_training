package com.zyc.dao.impl;

import com.zyc.dao.BusinessDao;
import com.zyc.domain.Business;
import com.zyc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {


    @Override
    public List<Business> businessList() {

        List<Business> list = new ArrayList<Business>();
        try {
            Connection con = JDBCUtils.getConnection();
            String sql = "select * from business;";
            PreparedStatement pdst = con.prepareStatement(sql);
            ResultSet rs = pdst.executeQuery();
            while (rs.next()) {
                Business business = new Business();
                business.setBusinessId(rs.getInt(1));
                business.setPassword(rs.getString(2));
                business.setBusinessName(rs.getString(3));
                business.setBusinessAddress(rs.getString(4));
                business.setBusinessExplain(rs.getString(5));
                business.setStarPrice(rs.getDouble(6));
                business.setDeliveryPrice(rs.getDouble(7));
                list.add(business);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public int addBusiness(String businessName,String password) {
        int id=0;
        try {
            Connection con = JDBCUtils.getConnection();
            String sql = "insert into business(businessName, password) values (?, ?)";
            PreparedStatement pdst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pdst.setString(1, businessName);
            pdst.setString(2, password);
            int count = pdst.executeUpdate();
            ResultSet rs=pdst.getGeneratedKeys();
            if (rs.next()) {
                id=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public int removeBusiness(int businessId) {
        int count=0;
        Connection con = null;
        try {
            String sql = "delete from business where businessId = ?";
            con = JDBCUtils.getConnection();
            con.setAutoCommit(false);
            /*开启事务*/
            PreparedStatement pdst = con.prepareStatement(sql);
            pdst.setInt(1, businessId);
            count = pdst.executeUpdate();
            /* int a=1/0 */;
            /*提交事务*/
            con.commit();
        } catch (SQLException e) {
            count=0;
            try {
                /*回滚*/
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return count;
    }
    @Override
    public int updateBusiness(Business business) {
        Connection con=null;
        int result=0;
        String sql="update business set businessName = ?,businessAddress=? , businessExplain =?, starPrice=?, deliveryPrice = ? where businessId = ?";
        try {
            con=JDBCUtils.getConnection();
            con.setAutoCommit(false);

            PreparedStatement pdst=con.prepareStatement(sql);

            String str=null;
            Double dou=null;
            Integer in=null;
            if((str=business.getBusinessName())!=null) {
                pdst.setString(1,business.getBusinessName());
            }else {
                System.exit(1);
            }
            if((str=business.getBusinessAddress())!=null) {
                pdst.setString(2,business.getBusinessAddress());
            }
            if((str=business.getBusinessExplain())!=null) {
                pdst.setString(3,business.getBusinessExplain());
            }
            if((dou=business.getStarPrice())!=null) {
                pdst.setDouble(4,business.getStarPrice());
            }
            if((dou=business.getDeliveryPrice())!=null) {
                pdst.setDouble(5,business.getDeliveryPrice());
            }
            if((in=business.getBusinessId())!=null) {
                pdst.setDouble(6,business.getBusinessId());
            }else {
                System.exit(1);
            }
            result = pdst.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            result=0;
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public int updateBusinessById(int businessId) {

        return 0;
    }

}
