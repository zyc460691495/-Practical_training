package com.example.redbag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    //查询
    @GetMapping("/all")
    public List<User> findAll(){
        return userRepo.findAll();
    }
    //查询
    @GetMapping("/all/{id}")
    public User findById(@PathVariable("id") String id){

        return userRepo.findById(id).orElse(null);

//        Optional<User> byId = userRepo.findById(id);
//        return byId.orElseGet(User::new);
    }
    //新建
    @PostMapping("/new")
    public User save(@RequestParam(value = "username",required = true) String username,
                     @RequestParam(value = "password",required = true) String password,
                     @RequestParam(value = "email",required = true)String email){
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        userRepo.save(user);
        return user;
    }
    @PostMapping("/")
    public User save1(@RequestBody User user){

        return userRepo.save(user);
    }

    //更新
    @PutMapping("/update/{id}")
    public User updateusername(@PathVariable("id") String id,
                       @RequestParam(value = "username") String username){
        User user=userRepo.findById(id).get();
        user.setUsername(username);
        return user;
    }
    //删除
    @DeleteMapping("/delete")
    public String delete(@RequestParam(value = "id")String id){
        User user=userRepo.findById(id).get();
        userRepo.delete(user);
//        if(userRepo.findById(id).get()!=null){
//            return "失败";
//        }else {
//            return "成功";
//        }
        return "end";
    }
}
