package com.zcl.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcl.entity.UserCaidan;
import com.zcl.service.SongsService;
import com.zcl.service.UserCaidanService;

@Controller
@RequestMapping("/userCaidan/")
public class UserCaidanController {
    @Autowired
    private UserCaidanService userCaidanService;
    @Autowired
    private SongsService songsService;

    @RequestMapping("selectAll")
    @ResponseBody
    public List<UserCaidan> selectAll(int page) {
        List<UserCaidan> aList = userCaidanService.selectAll(page);
        return aList;
    }

    @RequestMapping("selectBypId")
    @ResponseBody
    public List<UserCaidan> selectBypId(UserCaidan caidan1, int pId) {
        List<UserCaidan> aList = userCaidanService.selectBypId(pId);
        for (UserCaidan userCaidan : aList) {
            userCaidan.setUserCaidans(selectBypId(caidan1, userCaidan.getmId()));
        }
        return aList;
    }

    @RequestMapping("selectBymId")
    public String selectBymId(int mId, HttpServletRequest req,HttpSession session) {
        UserCaidan userCaidan = userCaidanService.selectBymId(mId);
        Date date = new Date(System.currentTimeMillis());
        session.setAttribute("date", date);
        int songCount = songsService.songsCount();
        session.setAttribute("songCount", songCount);
        req.setAttribute("mId", mId);
        req.setAttribute("mName", userCaidan.getmName());
        String caidanName = userCaidan.getmName();
        if (caidanName.equals("播放页面")) {
            return "music/user-play";
        }
        if (caidanName.equals("下载列表")) {
            return "user/user-downloadList";
        }
        if (caidanName.equals("点击充值")) {
            return "user/user-buyVip";
        }
        return "menus/userCaidan" + mId;
    }

    @RequestMapping("addMenu")
    public String addMenu(String addName, HttpServletRequest req, HttpServletResponse res){
        UserCaidan userCaidan = userCaidanService.selectBymName(addName);
        int result = 0;
        if (userCaidan == null) {
            result = userCaidanService.addMenu(addName, 0);
        } else {
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "菜单已经存在");
            return "user/user-menus";
        }
        if (result == 1) {
            req.setAttribute("addName", addName);
            req.setAttribute("msgclass", "update-msg");
            req.setAttribute("msg", "添加成功");
            return "user/user-menus";
        } else {
            req.setAttribute("addName", addName);
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "添加失敗");
            return "user/user-menus";
        }
    }

    @RequestMapping("addChildMenus")
    public String addChildMenus(int mId, HttpServletRequest req) {
        UserCaidan userCaidan = userCaidanService.selectBymId(mId);
        req.setAttribute("userCaidan", userCaidan);
        return "user/childCaidan";
    }

    @RequestMapping("addChildMenu")
    public String addChildMenu(String addName,int pId,HttpServletRequest req, HttpServletResponse res) {
        UserCaidan userCaidan = userCaidanService.selectBymName(addName);
        int result = 0;
        if (userCaidan == null) {
            result = userCaidanService.addMenu(addName, pId);
        } else {
            req.setAttribute("addName", addName);
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "菜单已经存在");
            return "user/user-menus";
        }
        if (result == 1) {
            req.setAttribute("addName", addName);
            req.setAttribute("msgclass", "update-msg");
            req.setAttribute("msg", "添加成功");
            return "user/user-menus";
        } else {
            req.setAttribute("addName", addName);
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "添加失敗");
            return "user/user-menus";
        }
    }

    @RequestMapping("xiugaiMenus")
    public String xiugaiMenus(int mId, HttpServletRequest req) {
        UserCaidan userCaidan = userCaidanService.selectBymId(mId);
        req.setAttribute("userCaidan", userCaidan);
        return "user/caidanInfo";
    }

    @RequestMapping("updateCaidan")
    public String updateCaidan(int mId, String mName, HttpServletRequest req) {
        UserCaidan userCaidan = userCaidanService.selectBymId(mId);
        req.setAttribute("userCaidan", userCaidan);
        int result = userCaidanService.updateCaidan(mId, mName);
        if (result == 1) {
            req.setAttribute("msgclass", "update-msg");
            req.setAttribute("msg", "修改成功");
            return "user/user-menus";
        } else {
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "修改失敗");
            return "user/user-menus";
        }
    }

    @RequestMapping("deleteMenus")
    public String deleteMenus(int mId, HttpServletRequest req) {
        int result = userCaidanService.deleteMenus(mId);
        if (result == 1) {
            req.setAttribute("msgclass", "update-msg");
            req.setAttribute("msg", "删除成功");
            return "user/user-menus";
        } else {
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "删除失敗");
            return "user/user-menus";
        }
    }
}