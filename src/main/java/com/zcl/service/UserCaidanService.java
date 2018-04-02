package com.zcl.service;

import java.util.List;

import com.zcl.entity.UserCaidan;

public interface UserCaidanService {

    List<UserCaidan> selectAll(int page);

    List<UserCaidan> selectBypId(int pId);

    UserCaidan selectBymId(int mId);

    int userCaidanCount();

    int updateCaidan(int mId,String mName);

    int deleteMenus(int mId);

    int addMenu(String mName,int pId);

    UserCaidan selectBymName(String mName);

}
