package com.zcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcl.dao.UserMapper;
import com.zcl.entity.User;
import com.zcl.service.UserService;
import com.zcl.util.ContextUtil;

/**
 * @author zcl
 * @date 2018年1月15日
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public User selectPhone(String phone) {
        // TODO Auto-generated method stub
        return userMapper.selectPhone(phone);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int reg(String phone, String password) {
        // TODO Auto-generated method stub
        User user = new User();
        user.setcPhone(phone);
        user.setPassword(password);
        return userMapper.insertCrm_user(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User login(String phone, String password,int adminId) {
        User user = new User();
        user.setcPhone(phone);
        user.setPassword(password);
        user.setAdminId(adminId);
        return userMapper.selectCrm_user(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> selectCphone() {
        // TODO Auto-generated method stub
        return userMapper.selectCphone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int updateCrm_user(String password, String cName, String email, String birthDay, String adress, String phone) {
        // TODO Auto-generated method stub
        User user = new User();
        user.setPassword(password);
        user.setcName(cName);
        user.setEmail(email);
        user.setBirthDay(birthDay);
        user.setAdress(adress);
        user.setcPhone(phone);
        return userMapper.updateCrm_user(user);
    }

    @Override
    public int selectAdmin(String phone) {
        // TODO Auto-generated method stub
        return userMapper.selectAdmin(phone);
    }

    @Override
    public List<User> selectAll(int page) {
        // TODO Auto-generated method stub
        page = (page - 1) * ContextUtil.Count;
        return userMapper.selectAll(page);
    }

    @Override
    public int userCount() {
        // TODO Auto-generated method stub
        return userMapper.userCount();
    }

    @Override
    public List<User> selectVip(int page) {
        // TODO Auto-generated method stub
        page = (page - 1) * ContextUtil.Count;
        return userMapper.selectVip(page);
    }

    @Override
    public int vipCount() {
        // TODO Auto-generated method stub
        return userMapper.vipCount();
    }

    @Override
    public List<User> selectLike(String cName) {
        // TODO Auto-generated method stub
        cName = "%"+cName+"%";
        return userMapper.selectLike(cName);
    }

    @Override
    public List<User> vipLike(String cName) {
        // TODO Auto-generated method stub
        cName = "%"+cName+"%";
        return userMapper.vipLike(cName);
    }

    @Override
    public int updateVip(String phone) {
        // TODO Auto-generated method stub
        return userMapper.updateVip(phone);
    }

    @Override
    public User selectById(int cId) {
        // TODO Auto-generated method stub
        return userMapper.selectById(cId);
    }

}