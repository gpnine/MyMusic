package com.zcl.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcl.dao.SongsMapper;
import com.zcl.entity.Songs;
import com.zcl.service.SongsService;
import com.zcl.util.ContextUtil;

@Service("songsService")
public class SongsServiceImpl implements SongsService {
    @Autowired
    private SongsMapper songsMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Songs> selectAll(int page) {
        // TODO Auto-generated method stub
        page = (page - 1) * ContextUtil.Count;
        return songsMapper.selectAll(page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Songs selectBySid(int sId) {
        // TODO Auto-generated method stub
        return songsMapper.selectBySid(sId);
    }

    @Override
    public int loadSong(String fileName) {
        // TODO Auto-generated method stub
        return songsMapper.loadSong(fileName);
    }

    @Override
    public int updateSongs(int sId, String title, String singer, Date updateDate) {
        // TODO Auto-generated method stub
        Songs songs = new Songs();
        songs.setsId(sId);
        songs.setTitle(title);
        songs.setSinger(singer);
        songs.setUpdateDate(updateDate);
        return songsMapper.updateSongs(songs);
    }

    @Override
    public int deleteSongs(int sId) {
        // TODO Auto-generated method stub
        return songsMapper.deleteSongs(sId);
    }

    @Override
    public int loadCover(int sId, String cover) {
        // TODO Auto-generated method stub
        Songs songs = new Songs();
        songs.setsId(sId);
        songs.setCover(cover);
        return songsMapper.loadCover(songs);
    }

    @Override
    public int loadLyric(int sId, String lyric) {
        // TODO Auto-generated method stub
        Songs songs = new Songs();
        songs.setsId(sId);
        songs.setLyric(lyric);
        return songsMapper.loadLyric(songs);
    }

    @Override
    public List<Songs> selectLike(String title) {
        // TODO Auto-generated method stub
        title = "%"+title+"%";
        return songsMapper.selectLike(title);
    }

    @Override
    public int songsCount() {
        // TODO Auto-generated method stub
        return songsMapper.songsCount();
    }

    @Override
    public List<Songs> selectDownload(int page) {
        // TODO Auto-generated method stub
        page = (page - 1) * ContextUtil.Count;
        return songsMapper.selectDownload(page);
    }

    @Override
    public int clearDownloads(int pId) {
        // TODO Auto-generated method stub
        return songsMapper.clearDownloads(pId);
    }

    @Override
    public String songSrc(String srcName) {
        // TODO Auto-generated method stub
        return songsMapper.songSrc(srcName);
    }

    @Override
    public int updateDownload(int count, int sId) {
        // TODO Auto-generated method stub
        Songs songs = new Songs();
        songs.setDownload(count);
        songs.setsId(sId);
        return songsMapper.updateDownload(songs);
    }


}