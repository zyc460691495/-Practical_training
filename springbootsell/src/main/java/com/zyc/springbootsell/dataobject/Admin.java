package com.zyc.springbootsell.dataobject;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "admin")
public class Admin {

    @Id
    @GenericGenerator(name ="idGenerator" ,strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")

    private String AdminId;

    private String username;

    private String password;

}
