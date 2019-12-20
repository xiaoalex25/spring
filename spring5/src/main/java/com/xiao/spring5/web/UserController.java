package com.xiao.spring5.web;

import com.xiao.spring5.dao.UserRepository;
import com.xiao.spring5.entity.UserEntity;
import com.xiao.spring5.vo.invo.UserVo4Convert;
import com.xiao.spring5.vo.invo.UserVo4Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@Controller
@RequestMapping("/demo")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @PostMapping("/add")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setEmail(email);
        userRepository.save(userEntity);
        return "success";
    }

    @ResponseBody
    @GetMapping("/all")
    public Iterable<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/getByName")
    public UserEntity getByName(@RequestParam String name) throws ExecutionException, InterruptedException {
        //异步调用
        Future<UserEntity> allByName = userRepository.findAllByName(name);
        UserEntity userEntity = allByName.get();
        return userEntity;
    }

    /**
     * 测试数据校验
     * @param user
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(@Valid @RequestBody UserVo4Validate user, Errors errors) {
        if (errors.hasErrors())
            return errors.getFieldError().getDefaultMessage();
        return "success";
    }

    /**
     * 测试请求数据转换
     *
     * @param user
     * @return
     */
    @RequestMapping("/convert")
    @ResponseBody
    public String convert(@RequestBody UserVo4Convert user) {
        return "success";
    }
}
