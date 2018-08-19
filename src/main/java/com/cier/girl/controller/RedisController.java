package com.cier.girl.controller;

import com.cier.girl.pojo.IMoocJSONResult;
import com.cier.girl.pojo.SysUser;
import com.cier.girl.pojo.User;
import com.cier.girl.utils.JsonUtils;
import com.cier.girl.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisOperator redisOperator;

    @RequestMapping("test")
    @ResponseBody
    public IMoocJSONResult test() {
        stringRedisTemplate.opsForValue().set("imooc-cache", "hello imooc");

        SysUser user = new SysUser();
        user.setId("100111");
        user.setUsername("imooc");
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        stringRedisTemplate.opsForValue().set("json:user", JsonUtils.objectToJson(user));

        SysUser jsonUser = JsonUtils.jsonToPojo(stringRedisTemplate.opsForValue().get("json:user"), SysUser.class);
        return IMoocJSONResult.ok(jsonUser);
    }

    @RequestMapping("/getJsonList")
    @ResponseBody
    public IMoocJSONResult getJsonList() {

        User user = new User();
        user.setAge(18);
        user.setName("慕课网");
        user.setPassword("123456");
        user.setBirthday(new Date());

        User u1 = new User();
        u1.setAge(19);
        u1.setName("imooc");
        u1.setPassword("123456");
        u1.setBirthday(new Date());

        User u2 = new User();
        u2.setAge(17);
        u2.setName("hello imooc");
        u2.setPassword("123456");
        u2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u1);
        userList.add(u2);

        redisOperator.set("userlist", JsonUtils.objectToJson(userList), 2000);

        String userListJson = redisOperator.get("userlist");
        List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);

        return IMoocJSONResult.ok(userListBorn);
    }
}
