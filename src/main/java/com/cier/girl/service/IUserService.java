package com.cier.girl.service;

import com.cier.girl.pojo.SysUser;
import com.github.pagehelper.PageInfo;

public interface IUserService {
    void insertUser(SysUser user);

    void updateUser(SysUser user);

    void deleteUser(String userId);

    SysUser queryUserById(String userId);

    PageInfo queryUserListPaged(Integer page, Integer pageSize);
}
