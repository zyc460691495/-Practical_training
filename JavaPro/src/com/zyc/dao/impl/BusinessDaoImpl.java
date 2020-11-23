package com.zyc.dao.impl;

import com.zyc.dao.BusinessDao;
import com.zyc.domain.Admin;
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
    public List<Business> listBusiness(String businessName,String businessAddress) {

        List<Business> list = new ArrayList<>();
        StringBuffer sql;
        try {
            sql=new StringBuffer("select * from business where 1=1");
            if(businessName!=null&&!businessName.equals("")){
                sql.append(" and businessName LIKE '%").append(businessName).append("%'");
            }
            if(businessAddress!=null&&!businessAddress.equals("")){
                sql.append(" and businessAddress like '%").append(businessAddress).append("%'");
            }
            Connection con = JDBCUtils.getConnection();
            PreparedStatement pdst = con.prepareStatement(sql.toString());
            ResultSet rs = pdst.executeQuery();
            while (rs.next()) {

                Business business = new Business();
//                business.toString();
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

    @Override
    public Business getBusinessById(Integer businessId) {
        Business business = null;
        String sql = "select * from business where businessId = ?";
        Connection con=null;
        PreparedStatement pdst=null;
        ResultSet rs=null;
        try {
            con = JDBCUtils.getConnection();
            pdst = con.prepareStatement(sql);
            pdst.setInt(1, businessId);
            rs = pdst.executeQuery();
            while (rs.next()){
                business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pdst, con);
        }
        return business;
    }

    @Override
    public int addBusiness(String businessName, String password) {
        int id = 0;
        try {
            Connection con = JDBCUtils.getConnection();
            String sql = "insert into business(businessName, password) values (?, ?)";
            PreparedStatement pdst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pdst.setString(1, businessName);
            pdst.setString(2, password);
            int count = pdst.executeUpdate();
            ResultSet rs = pdst.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public int removeBusiness(Integer businessId) {
        int count = 0;
        Connection con = null;
        try {
            String sql = "delete from business where businessId = ?";
            con = JDBCUtils.getConnection();
            con.setAutoCommit(false);
            /*开启事务*/
            PreparedStatement pdst = con.prepareStatement(sql);
            pdst.setInt(1, businessId);
            count = pdst.executeUpdate();
            /* int a=1/0 */
            ;
            /*提交事务*/
            con.commit();
        } catch (SQLException e) {
            count = 0;
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
        Connection con = null;
        int result = 0;
        String sql = "update business set businessName = ?,businessAddress=? , businessExplain =?, starPrice=?, deliveryPrice = ? where businessId = ?";
        try {
            con = JDBCUtils.getConnection();
            con.setAutoCommit(false);
            PreparedStatement pdst = con.prepareStatement(sql);
            String str = null;
            Double dou = null;
            Integer in = null;


            if ((str = business.getBusinessName()) != null) {
                pdst.setString(1, str);
            } else {
                System.exit(1);
            }
            pdst.setObject(2, business.getBusinessAddress());
            pdst.setObject(3, business.getBusinessExplain());
            pdst.setObject(4, business.getStarPrice());
            pdst.setObject(5, business.getDeliveryPrice());
            if ((in = business.getBusinessId()) != null) {
                pdst.setInt(6, in);
            } else {
                System.exit(1);
            }
            result = pdst.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            result = 0;
            try {
                con.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Business getBusinessByIdAndPassword(Integer businessId, String businessPassword) {
        Business business = null;
        String sql = "select * from business where businessId = ? and password = ? ";
        Connection con = null;
        PreparedStatement pdst = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConnection();
            pdst = con.prepareStatement(sql);
            pdst.setInt(1, businessId);
            pdst.setString(2, businessPassword);
            rs = pdst.executeQuery();
            while (rs.next()) {
                business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pdst, con);
        }

        return business;
    }

    @Override
    public int updateBusinessPassword(Integer businessId,String password) {
        String sql="update business set password = ? where businessId = ?";
        Connection con = null;
        PreparedStatement pdst = null;
        int rs = 0;
        try {
           con=JDBCUtils.getConnection();
           pdst=con.prepareStatement(sql);
           pdst.setString(1,password);
           pdst.setInt(2,businessId);
           rs=pdst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    @Override
    public int updateBusinessById(Integer businessId) {

        return 0;
    }

}
