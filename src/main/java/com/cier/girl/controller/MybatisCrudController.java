package com.cier.girl.controller;

import com.cier.girl.pojo.IMoocJSONResult;
import com.cier.girl.pojo.SysUser;
import com.cier.girl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("mybatis")
public class MybatisCrudController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/saveUser")
    @ResponseBody
    public IMoocJSONResult saveUser() throws Exception {
        SysUser user = new SysUser();
        user.setId(String.valueOf(new Date().getTime()));
        user.setUsername("imooc" + new Date());
        user.setNickname("imooc" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        userService.insertUser(user);
        return IMoocJSONResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public IMoocJSONResult updateUser() {

        SysUser user = new SysUser();
        user.setId("10011001");
        user.setUsername("10011001-updated" + new Date());
        user.setNickname("10011001-updated" + new Date());
        user.setPassword("10011001-updated");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.updateUser(user);

        return IMoocJSONResult.ok("保存成功");
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public IMoocJSONResult deleteUser(String userId) {

        userService.deleteUser(userId);

        return IMoocJSONResult.ok("删除成功");
    }

    @RequestMapping("/queryUserById")
    @ResponseBody
    public IMoocJSONResult queryUserById(String userId) {
        return IMoocJSONResult.ok(userService.queryUserById(userId));
    }

    @RequestMapping("/queryUserListPaged")
    @ResponseBody
    public IMoocJSONResult queryUserListPaged(@RequestParam(value = "pageNum") Integer pageNum,@RequestParam(value = "pageSize") Integer pageSize) {
        return IMoocJSONResult.ok(userService.queryUserListPaged(pageNum,pageSize));
    }
}
