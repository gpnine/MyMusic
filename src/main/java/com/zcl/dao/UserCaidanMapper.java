package com.zcl.dao;

import java.util.List;

import com.zcl.entity.UserCaidan;

public interface UserCaidanMapper {
    public List<UserCaidan> selectAll(int page);

    public List<UserCaidan> selectBypId(int pId);

    public UserCaidan selectBymId(int mId);

    public Integer userCaidanCount();

    public int updateCaidan(UserCaidan userCaidan);

    public UserCaidan selectBymName(String mName);

    public int deleteMenus(int mId);

    public int addMenu(UserCaidan userCaidan);
}
