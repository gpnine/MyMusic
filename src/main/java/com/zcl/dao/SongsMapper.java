package com.zcl.dao;

import java.util.List;

import com.zcl.entity.Songs;

public interface SongsMapper {
    public List<Songs> selectAll(int page);

    public List<Songs> selectDownload(int page);

    public int clearDownloads(int pId);

    public Integer songsCount();

    public String songSrc(String srcName);

    public Songs selectBySid(int sId);

    public List<Songs> selectLike(String title);

    public int loadSong(String fileName);

    public int updateSongs(Songs songs);

    public int deleteSongs(int sId);

    public int loadCover(Songs songs);

    public int loadLyric(Songs songs);

    public int updateDownload(Songs songs);
}
