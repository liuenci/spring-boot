package com.cier.girl.service.impl;

import com.cier.girl.dao.SysUserMapper;
import com.cier.girl.pojo.SysUser;
import com.cier.girl.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("iUserService")
public class UserServiceImpl implements IUserService{
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertUser(SysUser user){
        sysUserMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(SysUser user) {
        sysUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(String userId) {
        sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public SysUser queryUserById(String userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageInfo queryUserListPaged(Integer pageNum, Integer pageSize) {
        // 开始分页
        PageHelper.startPage(pageNum, pageSize);
        List<SysUser> userList = sysUserMapper.selectList();
        PageInfo<SysUser> userPageInfo = new PageInfo<>(userList);
        PageHelper.orderBy("id username");
        return userPageInfo;
    }
}
