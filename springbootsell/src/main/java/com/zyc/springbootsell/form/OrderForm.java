package com.zyc.springbootsell.form;


import lombok.Data;

@Data
public class OrderForm {

    private String productName;

    private Integer productQuantity;
}
