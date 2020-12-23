package com.zyc.springbootsell.dataobject;


import com.zyc.springbootsell.enums.ProductStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
@NoArgsConstructor
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    private String businessId;

    private BigDecimal productPrice;

    private Integer productStock=0;

    private String productDescription;

    private String productIcon;

    private Integer productStatus= ProductStatusEnum.UP.getCode();

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @Override
    public String toString() {
        return "ProductInfo{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", businessId='" + businessId + '\'' +
                ", productPrice=" + productPrice +
                ", productStock=" + productStock +"\n"+
                ", productDescription='" + productDescription + '\'' +
                ", productIcon='" + productIcon + '\'' +
                ", productStatus=" + productStatus +
                ", categoryType=" + categoryType +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
