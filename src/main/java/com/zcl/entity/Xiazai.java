package com.zcl.entity;

/**
 * @author zcl
 * @date 2018年1月19日
 */
public class Xiazai {
    private int dId;
    private int userId;
    private int songId;
    public Xiazai() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Xiazai(int dId, int userId, int songId) {
        super();
        this.dId = dId;
        this.userId = userId;
        this.songId = songId;
    }
    public int getdId() {
        return dId;
    }
    public void setdId(int dId) {
        this.dId = dId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getSongId() {
        return songId;
    }
    public void setSongId(int songId) {
        this.songId = songId;
    }
    @Override
    public String toString() {
        return "Xiazai [dId=" + dId + ", userId=" + userId + ", songId=" + songId + "]";
    }

}