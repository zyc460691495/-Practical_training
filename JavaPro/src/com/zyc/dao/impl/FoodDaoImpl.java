package com.zyc.dao.impl;


import com.zyc.dao.FoodDao;
import com.zyc.domain.Business;
import com.zyc.domain.Food;
import com.zyc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        List<Food> list = new ArrayList<>();
        String sql;
        try {
            sql = "select * from food where businessId=?";
            Connection con = JDBCUtils.getConnection();
            PreparedStatement pdst = con.prepareStatement(sql);
            pdst.setInt(1, businessId);
            ResultSet rs = pdst.executeQuery();
            while (rs.next()) {
                Food food = new Food();
                food.setFoodId(rs.getInt(1));
                food.setFoodName(rs.getString(2));
                food.setFoodExplain(rs.getString(3));
                food.setFoodPrice(rs.getDouble(4));
                food.setBusinessId(rs.getInt(5));
                list.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int saveFood(Food food) {
        int id = 0;
        Connection con = null;
        PreparedStatement pdst = null;
        ResultSet rs=null;
        String sql = "insert into food(foodName, foodPrice,businessId) values (?, ?,?)";
        try {
            con = JDBCUtils.getConnection();
            pdst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pdst.setString(1, food.getFoodName());
            pdst.setDouble(2, food.getFoodPrice());
            pdst.setInt(3, food.getBusinessId());
            int count = pdst.executeUpdate();
            rs = pdst.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pdst,con);
        }
        return id;
    }

    @Override
    public int updateFood(Food food) {
        Connection con = null;
        int result = 0;
        PreparedStatement pdst = null;
        String sql = "update food set foodName = ? , foodExplain =?, foodPrice=? where foodId = ?";
        try {
            con = JDBCUtils.getConnection();
            con.setAutoCommit(false);
            pdst = con.prepareStatement(sql);
            String str = null;
            Integer in = null;

            if ((str = food.getFoodName()) != null) {
                pdst.setString(1, str);
            } else {
                System.exit(1);
            }
            pdst.setObject(2, food.getFoodExplain());
            pdst.setObject(3, food.getFoodPrice());
            pdst.setObject(4, food.getFoodId());
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
        } finally {
            JDBCUtils.close(pdst, con);
        }
        return result;
    }

    @Override
    public int removeFood(Integer foodId) {

        int count = 0;
        Connection con = null;
        String sql = "delete from food where foodId = ?";
        PreparedStatement pdst=null;

        try {

            con = JDBCUtils.getConnection();
            con.setAutoCommit(false);
            /*开启事务*/
            pdst = con.prepareStatement(sql);
            pdst.setInt(1, foodId);
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
        }finally {
            JDBCUtils.close(pdst,con);
        }
        return count;
    }

    @Override
    public Food getFoodById(Integer foodId) {
        Business business = null;
        String sql = "select * from food where foodId = ?";
        Connection con = null;
        PreparedStatement pdst = null;
        ResultSet rs = null;
        Food food = null;
        try {
            con = JDBCUtils.getConnection();
            pdst = con.prepareStatement(sql);
            pdst.setInt(1, foodId);
            rs = pdst.executeQuery();
            while (rs.next()) {
                food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pdst, con);
        }
        if (food == null) {
            System.out.println("没有该编号的食品");
        }
        return food;
    }
}
