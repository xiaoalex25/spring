package com.xiao.spring5.web;

import com.xiao.spring5.dao.UserRepository;
import com.xiao.spring5.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/demo")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add")
    public void addUser(@RequestParam String name, @RequestParam String email) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setEmail(email);
        userRepository.save(userEntity);
    }
}
