package com.cier.girl.service.impl;

import com.cier.girl.dao.SysUserMapper;
import com.cier.girl.pojo.SysUser;
import com.cier.girl.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Override
    public PageInfo queryUserListPaged(Integer pageNum, Integer pageSize) {
        // 开始分页
        PageHelper.startPage(pageNum, pageSize);
        List<SysUser> userList = sysUserMapper.selectList();
        PageInfo<SysUser> userPageInfo = new PageInfo<>(userList);
        return userPageInfo;
    }



    @Override
    public SysUser queryUserByIdCustom(String userId) {
        return null;
    }

    @Override
    public void saveUserTransactional(SysUser user) {

    }
}
