package com.zcl.service;

import java.util.List;

import com.zcl.entity.User;

/**
 * @author zcl
 * @date 2018年1月15日
 */
public interface UserService {
    User selectPhone(String phone);

    List<User> selectCphone();

    User selectById(int cId);

    List<User> selectAll(int page);

    int userCount();

    List<User> selectVip(int page);

    int vipCount();

    int reg(String phone, String password);

    int selectAdmin(String phone);

    List<User> selectLike(String cName);

    List<User> vipLike(String cName);

    int updateCrm_user(String password, String cName, String email, String birthDay, String adress, String phone);

    User login(String phone, String password, int adminId);

    int updateVip(String phone);
}
