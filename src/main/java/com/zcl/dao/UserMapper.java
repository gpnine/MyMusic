package com.zcl.dao;

import java.util.List;

import com.zcl.entity.User;

public interface UserMapper {
    public User selectPhone(String phone);

    public List<User> selectCphone();

    public List<User> selectAll(int page);

    public Integer userCount();

    public List<User> selectVip(int page);

    public Integer vipCount();

    public List<User> selectLike(String cName);

    public List<User> vipLike(String cName);

    public int insertCrm_user(User user);

    public Integer selectAdmin(String phone);

    public int updateCrm_user(User user);

    public User selectCrm_user(User user);

    public int updateVip(String phone);

    public User selectById(int cId);

}
