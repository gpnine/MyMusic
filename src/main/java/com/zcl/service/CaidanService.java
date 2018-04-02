package com.zcl.service;

import java.util.List;

import com.zcl.entity.Caidan;

public interface CaidanService {
    List<Caidan> selectAll(int page);

    List<Caidan> selectBypId(int pId);

    int caidanCount();

    Caidan selectBymId(int mId);

    int addMenu(String mName,int pId);

    Caidan selectBymName(String mName);

    int updateCaidan(int mId,String mName);

    int deleteMenus(int mId);
}