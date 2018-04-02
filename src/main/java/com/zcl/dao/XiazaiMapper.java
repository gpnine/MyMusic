package com.zcl.dao;


import java.util.List;

import com.zcl.entity.Xiazai;

public interface XiazaiMapper {
    public int addDownload(Xiazai xiazai);

    public Integer selectSongsCount(int songId);

    public List<Xiazai> selectUserCount();
}