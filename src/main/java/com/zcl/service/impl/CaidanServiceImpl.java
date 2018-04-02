package com.zcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcl.dao.CaidanMapper;
import com.zcl.entity.Caidan;
import com.zcl.service.CaidanService;
import com.zcl.util.ContextUtil;

@Service("caidanService")
public class CaidanServiceImpl implements CaidanService{
    @Autowired
    private CaidanMapper caidanMapper;

    @Override
    public List<Caidan> selectAll(int page) {
        // TODO Auto-generated method stub
        page = (page - 1) * ContextUtil.Count;
        return caidanMapper.selectAll(page);
    }


    @Override
    public List<Caidan> selectBypId(int pId) {
        // TODO Auto-generated method stub
        return caidanMapper.selectBypId(pId);
    }

    @Override
    public Caidan selectBymId(int mId) {
        // TODO Auto-generated method stub
        return caidanMapper.selectBymId(mId);
    }


    @Override
    public int addMenu(String mName, int pId) {
        // TODO Auto-generated method stub
        Caidan caidan = new Caidan();
        caidan.setmName(mName);
        caidan.setpId(pId);
        return caidanMapper.addMenu(caidan);
    }


    @Override
    public Caidan selectBymName(String mName) {
        // TODO Auto-generated method stub
        return caidanMapper.selectBymName(mName);
    }


    @Override
    public int updateCaidan(int mId,String mName) {
        // TODO Auto-generated method stub
        Caidan caidan = new Caidan();
        caidan.setmId(mId);
        caidan.setmName(mName);
        return caidanMapper.updateCaidan(caidan);
    }


    @Override
    public int deleteMenus(int mId) {
        // TODO Auto-generated method stub
        return caidanMapper.deleteMenus(mId);
    }


    @Override
    public int caidanCount() {
        // TODO Auto-generated method stub
        return caidanMapper.caidanCount();
    }

}
