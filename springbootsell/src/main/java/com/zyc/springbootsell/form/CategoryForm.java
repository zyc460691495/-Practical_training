package com.zyc.springbootsell.form;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryForm {
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
