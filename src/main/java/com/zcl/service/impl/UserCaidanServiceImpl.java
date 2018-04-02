package com.zcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcl.dao.UserCaidanMapper;
import com.zcl.entity.UserCaidan;
import com.zcl.service.UserCaidanService;
import com.zcl.util.ContextUtil;

@Service("userCaidanService")
public class UserCaidanServiceImpl implements UserCaidanService {
    @Autowired
    private UserCaidanMapper userCaidanMapper;

    @Override
    public List<UserCaidan> selectBypId(int pId) {
        // TODO Auto-generated method stub
        return userCaidanMapper.selectBypId(pId);
    }

    @Override
    public UserCaidan selectBymId(int mId) {
        // TODO Auto-generated method stub
        return userCaidanMapper.selectBymId(mId);
    }

    @Override
    public int userCaidanCount() {
        // TODO Auto-generated method stub
        return userCaidanMapper.userCaidanCount();
    }

    @Override
    public List<UserCaidan> selectAll(int page) {
        // TODO Auto-generated method stub
        page = (page - 1) * ContextUtil.Count;
        return userCaidanMapper.selectAll(page);
    }

    @Override
    public int updateCaidan(int mId, String mName) {
        // TODO Auto-generated method stub
        UserCaidan userCaidan = new UserCaidan();
        userCaidan.setmId(mId);
        userCaidan.setmName(mName);
        return userCaidanMapper.updateCaidan(userCaidan);
    }

    @Override
    public int deleteMenus(int mId) {
        // TODO Auto-generated method stub
        return userCaidanMapper.deleteMenus(mId);
    }

    @Override
    public int addMenu(String mName, int pId) {
        // TODO Auto-generated method stub
        UserCaidan userCaidan = new UserCaidan();
        userCaidan.setmName(mName);
        userCaidan.setpId(pId);
        return userCaidanMapper.addMenu(userCaidan);
    }

    @Override
    public UserCaidan selectBymName(String mName) {
        // TODO Auto-generated method stub
        return userCaidanMapper.selectBymName(mName);
    }
}