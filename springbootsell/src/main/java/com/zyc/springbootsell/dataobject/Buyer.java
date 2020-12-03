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
public class Buyer {

    @Id
    @GenericGenerator(name ="idGenerator" ,strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String username;

    private String password;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenId;

}
