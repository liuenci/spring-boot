package com.cier.girl.controller;

import com.cier.girl.pojo.IMoocJSONResult;
import com.cier.girl.pojo.Resource;
import com.cier.girl.pojo.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {
    @Autowired
    private Resource resource;
    @RequestMapping("/getResource")
    public IMoocJSONResult getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);

        return IMoocJSONResult.ok(bean);
    }

    @RequestMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setName("imooc");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPassword("imooc");
        return user;
    }

    @RequestMapping("/getUserJson")
    public IMoocJSONResult getUser2(){
        User user = new User();
        user.setName("imooc");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPassword("imooc");
        return IMoocJSONResult.ok(user);
    }
}
