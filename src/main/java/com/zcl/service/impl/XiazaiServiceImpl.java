package com.zcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcl.dao.XiazaiMapper;
import com.zcl.entity.Xiazai;
import com.zcl.service.XiazaiService;

@Service("xiazaiService")
public class XiazaiServiceImpl implements XiazaiService {
    @Autowired
    private XiazaiMapper xiazaiMapper;

    @Override
    public int addDownload(int userId, int songId) {
        // TODO Auto-generated method stub
        Xiazai xiazai = new Xiazai();
        xiazai.setUserId(userId);
        xiazai.setSongId(songId);
        return xiazaiMapper.addDownload(xiazai);
    }

    @Override
    public int selectSongsCount(int songId) {
        // TODO Auto-generated method stub
        return xiazaiMapper.selectSongsCount(songId);
    }

    @Override
    public List<Xiazai> selectUserCount() {
        // TODO Auto-generated method stub
        return xiazaiMapper.selectUserCount();
    }

}