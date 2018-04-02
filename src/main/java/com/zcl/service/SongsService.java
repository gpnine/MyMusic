package com.zcl.service;

import java.sql.Date;
import java.util.List;

import com.zcl.entity.Songs;

public interface SongsService {

    List<Songs> selectAll(int page);

    List<Songs> selectDownload(int page);

    int songsCount();

    String songSrc(String srcName);

    int clearDownloads(int pId);

    Songs selectBySid(int sId);

    List<Songs> selectLike(String title);

    int loadSong(String fileName);

    int updateSongs(int sId,String title,String singer,Date updateDate);

    int deleteSongs(int sId);

    int loadCover(int sId, String cover);

    int loadLyric(int sId, String lyric);

    int updateDownload(int count,int sId);

}