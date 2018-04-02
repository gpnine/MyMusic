package com.zcl.controller;

import com.zcl.entity.Caidan;
import com.zcl.service.CaidanService;
import com.zcl.service.SongsService;
import com.zcl.service.UserCaidanService;
import com.zcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/caidan/")
public class CaidanController {
    @Autowired
    private CaidanService caidanService;
    @Autowired
    private SongsService songsService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserCaidanService userCaidanService;

    @RequestMapping("selectAll")
    @ResponseBody
    public List<Caidan> selectAll(int page) {
        List<Caidan> aList = caidanService.selectAll(page);
        return aList;
    }

    @RequestMapping("selectBymId")
    public String selectBymId(int mId, HttpServletRequest req,HttpSession session) {
        Caidan caidan = caidanService.selectBymId(mId);
        Date date = new Date(System.currentTimeMillis());
        session.setAttribute("date", date);
        int songCount = songsService.songsCount();
        session.setAttribute("songCount", songCount);
        int vipCount = userService.vipCount();
        session.setAttribute("vipCount", vipCount);
        int caidanCount = caidanService.caidanCount();
        session.setAttribute("caidanCount", caidanCount);
        int userCount = userService.userCount();
        session.setAttribute("userCount", userCount);
        int userCaidanCount = userCaidanService.userCaidanCount();
        session.setAttribute("userCaidanCount", userCaidanCount);
        req.setAttribute("mId", mId);
        req.setAttribute("mName", caidan.getmName());
        String caidanName = caidan.getmName();
        if (caidanName.equals("功能操作")) {
            return "menus/page-menus";
        }
        if (caidanName.equals("歌单操作")) {
            return "menus/page-songs";
        }
        if (caidanName.equals("查看所有客户")) {
            return "menus/page-allUsers";
        }
        if (caidanName.equals("查看VIP用户")) {
            return "menus/page-vipUser";
        }
        if (caidanName.equals("下载榜")) {
            return "menus/page-download";
        }
        if (caidanName.equals("用户菜单管理")) {
            return "user/user-menus";
        }
        return "menus/caidan" + mId;
    }

    @RequestMapping("selectBypId")
    @ResponseBody
    public List<Caidan> selectBypId(Caidan caidan1, int pId) {
        List<Caidan> aList = caidanService.selectBypId(pId);
        for (Caidan caidan : aList) {
            caidan.setCaidans(selectBypId(caidan1, caidan.getmId()));
        }
        return aList;
    }

    @RequestMapping("addMenu")
    public String addMenu(String addName, HttpServletRequest req, HttpServletResponse res){
        Caidan caidan = caidanService.selectBymName(addName);
        int result = 0;
        if (caidan == null) {
            result = caidanService.addMenu(addName, 0);
        } else {
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "菜单已经存在");
            return "menus/page-menus";
        }
        if (result == 1) {
            req.setAttribute("addName", addName);
            req.setAttribute("msgclass", "update-msg");
            req.setAttribute("msg", "添加成功");
            return "menus/page-menus";
        } else {
            req.setAttribute("addName", addName);
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "添加失敗");
            return "menus/page-menus";
        }
    }

    @RequestMapping("addChildMenus")
    public String addChildMenus(int mId, HttpServletRequest req) {
        Caidan caidan = caidanService.selectBymId(mId);
        req.setAttribute("caidan", caidan);
        return "menus/childCaidan";
    }

    @RequestMapping("addChildMenu")
    public String addChildMenu(String addName,int pId,HttpServletRequest req, HttpServletResponse res) {
        Caidan caidan = caidanService.selectBymName(addName);
        int result = 0;
        if (caidan == null) {
            result = caidanService.addMenu(addName, pId);
        } else {
            req.setAttribute("addName", addName);
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "菜单已经存在");
            return "menus/page-menus";
        }
        if (result == 1) {
            req.setAttribute("addName", addName);
            req.setAttribute("msgclass", "update-msg");
            req.setAttribute("msg", "添加成功");
            return "menus/page-menus";
        } else {
            req.setAttribute("addName", addName);
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "添加失敗");
            return "menus/page-menus";
        }
    }

    @RequestMapping("xiugaiMenus")
    public String xiugaiMenus(int mId, HttpServletRequest req) {
        Caidan caidan = caidanService.selectBymId(mId);
        req.setAttribute("caidan", caidan);
        return "menus/caidanInfo";
    }

    @RequestMapping("updateCaidan")
    public String updateCaidan(int mId, String mName, HttpServletRequest req) {
        Caidan caidan = caidanService.selectBymId(mId);
        req.setAttribute("caidan", caidan);
        int result = caidanService.updateCaidan(mId, mName);
        if (result == 1) {
            req.setAttribute("msgclass", "update-msg");
            req.setAttribute("msg", "修改成功");
            return "menus/page-menus";
        } else {
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "修改失敗");
            return "menus/page-menus";
        }
    }

    @RequestMapping("deleteMenus")
    public String deleteMenus(int mId, HttpServletRequest req) {
        int result = caidanService.deleteMenus(mId);
        if (result == 1) {
            req.setAttribute("msgclass", "update-msg");
            req.setAttribute("msg", "删除成功");
            return "menus/page-menus";
        } else {
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "删除失敗");
            return "menus/page-menus";
        }
    }
}

