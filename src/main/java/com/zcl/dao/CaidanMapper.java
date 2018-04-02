package com.zcl.dao;

import java.util.List;

import com.zcl.entity.Caidan;

public interface CaidanMapper {
    public List<Caidan> selectAll(int page);

    public Integer caidanCount();

    public List<Caidan> selectBypId(int pId);

    public Caidan selectBymId(int mId);

    public int addMenu(Caidan caidan);

    public Caidan selectBymName(String mName);

    public int updateCaidan(Caidan caidan);

    public int deleteMenus(int mId);
}