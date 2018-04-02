package com.zcl.entity;

import java.util.List;

/**
 * @author zcl
 * @date 2018年1月16日
 */
public class UserCaidan {
    private int mId;
    private String mName;
    private int pId;
    private List<UserCaidan> userCaidans;
    public UserCaidan() {
        super();
        // TODO Auto-generated constructor stub
    }
    public UserCaidan(int mId, String mName, int pId, List<UserCaidan> userCaidans) {
        super();
        this.mId = mId;
        this.mName = mName;
        this.pId = pId;
        this.userCaidans = userCaidans;
    }
    @Override
    public String toString() {
        return "UserCaidan [mId=" + mId + ", mName=" + mName + ", pId=" + pId + ", userCaidans=" + userCaidans + "]";
    }
    public int getmId() {
        return mId;
    }
    public void setmId(int mId) {
        this.mId = mId;
    }
    public String getmName() {
        return mName;
    }
    public void setmName(String mName) {
        this.mName = mName;
    }
    public int getpId() {
        return pId;
    }
    public void setpId(int pId) {
        this.pId = pId;
    }
    public List<UserCaidan> getUserCaidans() {
        return userCaidans;
    }
    public void setUserCaidans(List<UserCaidan> userCaidans) {
        this.userCaidans = userCaidans;
    }


}