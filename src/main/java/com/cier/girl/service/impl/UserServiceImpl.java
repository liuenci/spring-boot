package com.cier.girl.service.impl;

import com.cier.girl.dao.SysUserMapper;
import com.cier.girl.pojo.SysUser;
import com.cier.girl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iUserService")
public class UserServiceImpl implements IUserService{
    @Autowired
    private SysUserMapper sysUserMapper;

    public void insertUser(SysUser user){
        sysUserMapper.insert(user);
    }

    @Override
    public void updateUser(SysUser user) {
        sysUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUser(String userId) {
        sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public SysUser queryUserById(String userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }
}
