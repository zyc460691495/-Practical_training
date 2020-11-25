package com.example.redbag;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GenericGenerator(name ="idGenerator" ,strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    String id;

    @Column(name = "username",unique = true,nullable = false,length = 64)
    String username;
    @Column(name = "password",nullable = false,length = 64)
    String password;
    @Column(name = "email",length = 64)
    String email;
}
