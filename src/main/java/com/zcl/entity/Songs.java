package com.zcl.entity;

import java.sql.Date;

/**
 * @author zcl
 * @date 2018年1月19日
 */
public class Songs {
    private int sId;
    private String title;
    private String src;
    private String cover;
    private String singer;
    private String lyric;
    private int download;
    private int loves;
    private Date updateDate;
    private int deleteId;
    public Songs() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Songs(int sId, String title, String src, String cover, String singer, String lyric, int download, int loves,
                 Date updateDate, int deleteId) {
        super();
        this.sId = sId;
        this.title = title;
        this.src = src;
        this.cover = cover;
        this.singer = singer;
        this.lyric = lyric;
        this.download = download;
        this.loves = loves;
        this.updateDate = updateDate;
        this.deleteId = deleteId;
    }
    public int getsId() {
        return sId;
    }
    public void setsId(int sId) {
        this.sId = sId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSrc() {
        return src;
    }
    public void setSrc(String src) {
        this.src = src;
    }
    public String getCover() {
        return cover;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }
    public String getSinger() {
        return singer;
    }
    public void setSinger(String singer) {
        this.singer = singer;
    }
    public String getLyric() {
        return lyric;
    }
    public void setLyric(String lyric) {
        this.lyric = lyric;
    }
    public int getDownload() {
        return download;
    }
    public void setDownload(int download) {
        this.download = download;
    }
    public int getLoves() {
        return loves;
    }
    public void setLoves(int loves) {
        this.loves = loves;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public int getDeleteId() {
        return deleteId;
    }
    public void setDeleteId(int deleteId) {
        this.deleteId = deleteId;
    }
    @Override
    public String toString() {
        return "Songs [sId=" + sId + ", title=" + title + ", src=" + src + ", cover=" + cover + ", singer=" + singer
                + ", lyric=" + lyric + ", download=" + download + ", loves=" + loves + ", updateDate=" + updateDate
                + ", deleteId=" + deleteId + "]";
    }


}