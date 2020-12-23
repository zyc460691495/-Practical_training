package com.zyc.springbootsell.dataobject;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Business {

    @Id
    @GenericGenerator(name ="idGenerator" ,strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String businessId;

    private String businessName;

    private String password;

    private String businessAddress;

    private String businessExplain;

    private Double starPrice;

    private Double deliveryPrice;

}
