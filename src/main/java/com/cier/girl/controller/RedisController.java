package com.cier.girl.controller;

import com.cier.girl.pojo.IMoocJSONResult;
import com.cier.girl.pojo.SysUser;
import com.cier.girl.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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
}
