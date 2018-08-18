package com.cier.girl.service;

import com.cier.girl.pojo.SysUser;

public interface IUserService {
    void insertUser(SysUser user);

    void updateUser(SysUser user);

    void deleteUser(String userId);

    SysUser queryUserById(String userId);
}
