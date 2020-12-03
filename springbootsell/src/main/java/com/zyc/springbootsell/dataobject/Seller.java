package com.zyc.springbootsell.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
public class Seller {

    @Id
    @GenericGenerator(name ="idGenerator" ,strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    String username;

    String password;

}
