package com.zcl.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zcl.entity.Songs;
import com.zcl.entity.User;
import com.zcl.service.SongsService;
import com.zcl.service.UserService;
import com.zcl.service.XiazaiService;
@Controller
@RequestMapping("/xiazai/")
public class XiazaiController {
    @Autowired
    private XiazaiService xiazaiService;
    @Autowired
    private UserService userService;
    @Autowired
    private SongsService songsService;

    @RequestMapping("downloadSong")
    public String downFiles(String phone,int sId,HttpServletRequest req,HttpServletResponse resp) throws IOException{
        req.setCharacterEncoding("UTF-8");
        User user = userService.selectPhone(phone);
        Songs song = songsService.selectBySid(sId);
        if(user!=null) {
            if (user.getVip()==0&&song.getLoves()==0||user.getVip()==1) {
                //获取要下载的文件名
                String songName = song.getSrc();
                //第一步：设置响应类型
                resp.setContentType("application/force-download");//应用程序强制下载
                //第二读取文件
                String songPath = "C:\\Users\\Yz\\Downloads\\SSM_webMusic-master\\CRM\\src\\main\\webapp\\resource\\views\\songs\\"+songName;
                InputStream in_song = new FileInputStream(songPath);
                songName = URLEncoder.encode(songName, "UTF-8");
                resp.setHeader("Content-Disposition", "attachment;filename="+songName);
                resp.setContentLength(in_song.available());
                OutputStream out_song = resp.getOutputStream();
                byte[] b_song = new byte[1024];
                int len_song = 0;
                while((len_song = in_song.read(b_song))!=-1){
                    out_song.write(b_song, 0, len_song);
                }
                out_song.flush();
                out_song.close();
                in_song.close();
                int userId = user.getcId();
                int result = xiazaiService.addDownload(userId, sId);
                if (result == 1) {
                    req.setAttribute("msgclass", "update-msg");
                    req.setAttribute("msg", "下载成功");
                    return "user/user-downloadList";
                } else {
                    req.setAttribute("msgclass", "update-msg1");
                    req.setAttribute("msg", "下载失敗");
                    return "user/user-downloadList";
                }
            }
        }
        req.setAttribute("msgclass", "update-msg1");
        req.setAttribute("msg", "下载失敗");
        return "user/user-downloadList";

//	    String lyric = song.getLyric();
//	    String lyricPath = "C:\\Users\\Yz\\Downloads\\SSM_webMusic-master\\CRM\\src\\main\\webapp\\resource\\views\\music\\"+lyric;
//	    InputStream in_lyric = new FileInputStream(lyricPath);
//	    lyric = URLEncoder.encode(lyric, "UTF-8");
//	    resp.setHeader("Content-Disposition", "attachment;filename="+lyric);
//	    resp.setContentLength(in_lyric.available());
//	    OutputStream out_lyric = resp.getOutputStream();
//	    byte[] b_lyric = new byte[1024];
//	    int len_lyric = 0;
//	    while((len_lyric = in_lyric.read(b_lyric))!=-1){
//	      out_lyric.write(b_lyric, 0, len_lyric);
//	    }
//	    out_lyric.flush();
//	    out_lyric.close();
//	    in_lyric.close();

//	    String image = song.getCover();
//	    String imagePath = "C:\\Users\\Yz\\Downloads\\SSM_webMusic-master\\CRM\\src\\main\\webapp\\resource\\views\\"+image;
//	    InputStream in_image = new FileInputStream(imagePath);
//	    image = URLEncoder.encode(image, "UTF-8");
//	    resp.setHeader("Content-Disposition", "attachment;filename="+image);
//	    resp.setContentLength(in_image.available());
//	    byte[] b_image = new byte[1024];
//	    int len_image = 0;
//	    OutputStream out_image = resp.getOutputStream();
//	    while((len_image = in_image.read(b_image))!=-1){
//	      out_image.write(b_image, 0, len_image);
//	    }
//	    in_image.close();
//	    out_image.flush();
//	    out_image.close();
    }
}
