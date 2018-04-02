package com.zcl.entity;

/**
 * @author zcl
 * @date 2018年1月17日
 */
public class User {
    private int cId;
    private String cName;
    private String birthDay;
    private String cPhone;
    private String password;
    private String email;
    private String adress;
    private int vip;
    private int deleteId;
    private int adminId;
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public User(int cId, String cName, String birthDay, String cPhone, String password, String email, String adress,
                int vip, int deleteId, int adminId) {
        super();
        this.cId = cId;
        this.cName = cName;
        this.birthDay = birthDay;
        this.cPhone = cPhone;
        this.password = password;
        this.email = email;
        this.adress = adress;
        this.vip = vip;
        this.deleteId = deleteId;
        this.adminId = adminId;
    }
    public int getcId() {
        return cId;
    }
    public void setcId(int cId) {
        this.cId = cId;
    }
    public String getcName() {
        return cName;
    }
    public void setcName(String cName) {
        this.cName = cName;
    }
    public String getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    public String getcPhone() {
        return cPhone;
    }
    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public int getVip() {
        return vip;
    }
    public void setVip(int vip) {
        this.vip = vip;
    }
    public int getDeleteId() {
        return deleteId;
    }
    public void setDeleteId(int deleteId) {
        this.deleteId = deleteId;
    }
    public int getAdminId() {
        return adminId;
    }
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
    @Override
    public String toString() {
        return "User [cId=" + cId + ", cName=" + cName + ", birthDay=" + birthDay + ", cPhone=" + cPhone + ", password="
                + password + ", email=" + email + ", adress=" + adress + ", vip=" + vip + ", deleteId=" + deleteId
                + ", adminId=" + adminId + "]";
    }

}
