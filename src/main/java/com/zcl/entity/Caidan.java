package com.zcl.entity;

import java.util.List;

/**
 * @author zcl
 * @date 2018年1月16日
 */
public class Caidan {
    private int mId;
    private String mName;
    private int pId;
    private List<Caidan> caidans;

    /**
     * @param mId
     * @param mName
     * @param pId
     * @param caidans
     */
    public Caidan(int mId, String mName, int pId, List<Caidan> caidans) {
        super();
        this.mId = mId;
        this.mName = mName;
        this.pId = pId;
        this.caidans = caidans;
    }

    public List<Caidan> getCaidans() {
        return caidans;
    }

    public void setCaidans(List<Caidan> caidans) {
        this.caidans = caidans;
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

    /**
     *
     */
    public Caidan() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Caidan [mId=" + mId + ", mName=" + mName + ", pId=" + pId + ", caidans=" + caidans + "]";
    }

}