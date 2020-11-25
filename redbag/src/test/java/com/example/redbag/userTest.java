package com.example.redbag;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class userTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    public void listAll(){
        for (User user:userRepo.findAll()){
            System.out.println(user);
        }
    }
    @Test
    public void getById(){
        Optional<User> byId = userRepo.findById("4028098175fe9c9d0175fe9ca5160000");
        System.out.println(byId);
    }
    @Test
    public void save(){
        User user=new User();
        user.setUsername("zzzz");
        user.setPassword("123");
        userRepo.save(user);
    }
    @Test
    public void update(){
        User user = new User();
        user.setId("4028098175fe9c9d0175fe9ca5160000");
        user.setUsername("yyyy");
        user.setPassword("7777");
        userRepo.save(user);
    }
    @Test
    public void delete(){
        String id = "4028098175fe9c9d0175fe9ca5160000";
        userRepo.deleteById(id);
    }
}

