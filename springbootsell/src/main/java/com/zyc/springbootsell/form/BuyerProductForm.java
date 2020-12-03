package com.zyc.springbootsell.form;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class BuyerProductForm {

    private String productName;

    private String productIcon;

    private BigDecimal productPrice;

    private Integer productQuantity;
}
