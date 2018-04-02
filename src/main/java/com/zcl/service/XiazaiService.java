package com.zcl.service;

import java.util.List;

import com.zcl.entity.Xiazai;

public interface XiazaiService {
    int addDownload(int userId, int songId);

    int selectSongsCount(int songId);

    List<Xiazai> selectUserCount();
}