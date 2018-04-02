package com.zcl.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcl.entity.User;
import com.zcl.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("buyVip")
    public String buyVip(String phone, HttpServletRequest req, HttpServletResponse res) {
        int result = userService.updateVip(phone);
        if (result == 1) {
            req.setAttribute("msgclass", "update-msga");
            req.setAttribute("msg", "充值成功");
            return "user/user-buyVip";
        } else {
            req.setAttribute("msgclass", "update-msga1");
            req.setAttribute("msg", "充值失败");
            return "user/user-buyVip";
        }
    }


    @RequestMapping("reg")
    public String reg(String phone, String password, String password2, HttpServletRequest req, HttpServletResponse res) {
        User user = userService.selectPhone(phone);
        if (user == null) {
            if (!password.equals(password2)) {
                req.setAttribute("Errorpwd", "两次密码输入不一致");
                return "music/page-register";
            } else {
                userService.reg(phone, password);
                return "music/page-play";
            }
        } else {
            req.setAttribute("Errormsg", "该用户已存在");
            return "music/page-register";
        }
    }

    @RequestMapping("userInfo")
    public String userInfo(String phone, HttpServletRequest req, HttpServletResponse res) {
        User user = userService.selectPhone(phone);
        if (user != null) {
            req.setAttribute("user", user);
            int adminId = user.getAdminId();
            if (adminId==1) {
                return "music/page-userInfo";
            }else {
                return "music/user-userInfo";
            }
        } else {
            return "music/page-login";
        }
    }

    @RequestMapping("update")
    public String update(String password, String cName, String email, String birthDay, String adress, String phone, HttpServletRequest req, HttpServletResponse res) {
        int result = userService.updateCrm_user(password, cName, email, birthDay, adress, phone);
        User user = userService.selectPhone(phone);
        if (result == 1) {
            req.setAttribute("user", user);
            req.setAttribute("msgclass", "update-msg");
            req.setAttribute("msg", "修改成功");
            int adminId = user.getAdminId();
            if (adminId==1) {
                return "music/page-userInfo";
            }else {
                return "music/user-userInfo";
            }
        } else {
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "修改失敗");
            return "music/page-userInfo";
        }
    }

    // 登录
    @RequestMapping("/login")
    public String login(String phone, String password, String noneed, HttpServletRequest req, HttpServletResponse res, HttpSession session) {
        int adminId = userService.selectAdmin(phone);
        User user = userService.login(phone, password,adminId);
        if (user == null) {
            List<User> sList = userService.selectCphone();
            User user2  = userService.selectPhone(phone);
            String rpassword = user2.getPassword();
            if (!rpassword.equals(password)) {
                req.setAttribute("Errorpwd", "密码错误");
                return "music/page-login";
            }
            for (int i = 0; i < sList.size(); i++) {
                String rphone = sList.get(i).getcPhone();
                if (!rphone.equals(phone)) {
                    req.setAttribute("Errormsg", "该用户不存在");
                    return "music/page-login";
                }
            }
        }
        int times = 60 * 60 * 24 * 7;
        if (user != null) {
            if ("need".equals(noneed)) {
                Cookie userPhoneCookie = new Cookie("phone", phone);
                Cookie userPasswordCookie = new Cookie("password", password);
                userPhoneCookie.setMaxAge(times);
                userPasswordCookie.setMaxAge(times);
                res.addCookie(userPhoneCookie);
                res.addCookie(userPasswordCookie);
                session.setAttribute("phone", phone);
                session.setAttribute("password", password);
            }
            Cookie userPhoneCookie = new Cookie("phone", phone);
            Cookie userPasswordCookie = new Cookie("password", password);
            res.addCookie(userPhoneCookie);
            res.addCookie(userPasswordCookie);
            session.setAttribute("phone", phone);
            session.setAttribute("password", password);
            if (user.getVip() == 0) {
                session.setAttribute("vip", "普通用户");
            } else if (user.getVip() == 1){
                session.setAttribute("vip", "高级会员");
            }else if (user.getVip() == 100) {
                session.setAttribute("vip", "管理员");
            }
            req.setAttribute("phone", phone);
            req.setAttribute("password", password);
            if (adminId==1) {
                return "music/page-play";
            }else {
                return "music/user-play";
            }
        } else {
            return "music/page-login";
        }
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public List<User> selectAll(int page) {
        List<User> users = userService.selectAll(page);
        return users;
    }

    @RequestMapping("selectLike")
    @ResponseBody
    public List<User> selectLike(String cName,HttpServletRequest req,HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        List<User> users = userService.selectLike(cName);
        req.setAttribute("users", users);
        req.setAttribute("cName", cName);
        return users;
    }

    @RequestMapping("vipLike")
    @ResponseBody
    public List<User> vipLike(String cName,HttpServletRequest req,HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        List<User> users = userService.vipLike(cName);
        req.setAttribute("users", users);
        req.setAttribute("cName", cName);
        return users;
    }

    @RequestMapping("selectVip")
    @ResponseBody
    public List<User> selectVip(int page) {
        List<User> users = userService.selectVip(page);
        return users;
    }

    @RequestMapping("updateVip")
    public String updateVip(String phone,HttpServletRequest req) {
        int result  = userService.updateVip(phone);
        if (result == 1) {
            req.setAttribute("msgclass", "update-msg");
            req.setAttribute("msg", "修改成功");
            return "music/page-userInfo";
        } else {
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "修改失敗");
            return "music/page-userInfo";
        }
    }
}