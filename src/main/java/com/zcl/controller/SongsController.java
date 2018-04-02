package com.zcl.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zcl.entity.Caidan;
import com.zcl.entity.Songs;
import com.zcl.service.CaidanService;
import com.zcl.service.SongsService;
import com.zcl.util.PingyinUtil;

@Controller
@RequestMapping("/songs/")
public class SongsController {
    @Autowired
    private SongsService songsService;
    @Autowired
    private CaidanService caidanService;

    @RequestMapping("selectAll")
    @ResponseBody
    public List<Songs> selectAll(int page) {
        List<Songs> songs = songsService.selectAll(page);
        return songs;
    }

    @RequestMapping("selectDownload")
    @ResponseBody
    public List<Songs> selectDownload(int page) {
        List<Songs> songs = songsService.selectDownload(page);
        return songs;
    }

    @RequestMapping("selectBySid")
    public String selectBySid(int sId,HttpServletRequest request) {
        Songs songs = songsService.selectBySid(sId);
        request.setAttribute("songs", songs);
        return "music/page-play";
    }

    @RequestMapping("selectLike")
    @ResponseBody
    public List<Songs> selectLike(String title,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        List<Songs> songs = songsService.selectLike(title);
        request.setAttribute("songs", songs);
        request.setAttribute("title", title);
        return songs;
    }


    @RequestMapping("loadSong")
    public String loadSong(HttpSession session,MultipartFile myFile, HttpServletRequest req) throws IOException {
        Caidan caidan1 = caidanService.selectBymId(21);
        req.setAttribute("mName", caidan1.getmName());
        String songName = "";
        if(!myFile.isEmpty()){
            try {
                String songSrc = myFile.getOriginalFilename().toString();
                PingyinUtil hanyuPinyinHelper = new PingyinUtil() ;
                String songFile = hanyuPinyinHelper.toHanyuPinyin(songSrc);
                String srcName = songsService.songSrc("file/"+songFile);
                if (srcName==null) {
                    File file = new File("C:\\Users\\Yz\\Downloads\\SSM_webMusic-master\\CRM\\src\\main\\webapp\\resource\\views\\songs\\file\\"+songFile);
                    FileUtils.copyInputStreamToFile(myFile.getInputStream(),file);
                    songName = "file/"+songFile;
                }else {
                    req.setAttribute("msgclass", "update-msg1");
                    req.setAttribute("msg", "已存在");
                    return "menus/page-songs";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int result = 0;
        if (songName!="") {
            result = songsService.loadSong(songName);
        }
        if (result == 1) {
            req.setAttribute("msgclass", "update-msg");
            req.setAttribute("msg", "添加成功");
            return "menus/page-songs";
        } else {
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "添加失敗");
            return "menus/page-songs";
        }
    }
    @RequestMapping("xiugaiSongs")
    public String xiugaiSongs(int sId, HttpServletRequest req) {
        Songs song = songsService.selectBySid(sId);
        req.setAttribute("song", song);
        return "songs/songInfo";
    }

    @RequestMapping("loadCover")
    public String loadCover(int sId,MultipartFile cover, HttpServletRequest req) {
        Songs song = songsService.selectBySid(sId);
        PingyinUtil hanyuPinyinHelper = new PingyinUtil();
        String image = "";
        if(cover!=null){
            try {
                String coverSrc = cover.getOriginalFilename().toString();
                String coverFile = hanyuPinyinHelper.toHanyuPinyin(coverSrc);
                File coverName = new File("C:\\Users\\Yz\\Downloads\\SSM_webMusic-master\\CRM\\src\\main\\webapp\\resource\\views\\images\\"+coverFile);
                FileUtils.copyInputStreamToFile(cover.getInputStream(),coverName);
                image = "images/"+coverFile;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        req.setAttribute("song", song);
        int result = songsService.loadCover(sId,image);
        if (result == 1) {
            req.setAttribute("msgclass", "update-msg");
            req.setAttribute("msg", "上传成功");
            return "menus/page-songs";
        } else {
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "上传失敗");
            return "menus/page-songs";
        }
    }

    @RequestMapping("loadLyric")
    public String loadLyric(int sId,MultipartFile lyric, HttpServletRequest req) {
        Songs song = songsService.selectBySid(sId);
        PingyinUtil hanyuPinyinHelper = new PingyinUtil();
        String lyrics = "";
        if(lyric!=null){
            try {
                String lyricSrc = lyric.getOriginalFilename().toString();
                String lyricFile = hanyuPinyinHelper.toHanyuPinyin(lyricSrc);
                File lyricName = new File("C:\\Users\\Yz\\Downloads\\SSM_webMusic-master\\CRM\\src\\main\\webapp\\resource\\views\\music\\data\\"+lyricFile);
                FileUtils.copyInputStreamToFile(lyric.getInputStream(),lyricName);
                lyrics = "data/"+lyricFile;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        req.setAttribute("song", song);
        int result = songsService.loadLyric(sId,lyrics);
        if (result == 1) {
            req.setAttribute("msgclass", "update-msg");
            req.setAttribute("msg", "上传成功");
            return "menus/page-songs";
        } else {
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "上传失敗");
            return "menus/page-songs";
        }
    }

    @RequestMapping("updateSongs")
    public String updateSongs(int sId,String title,String singer, HttpServletRequest req) {
        Songs song = songsService.selectBySid(sId);
        req.setAttribute("song", song);
        Date date = new Date(System.currentTimeMillis());
        int result = songsService.updateSongs(sId,title,singer,date);
        if (result == 1) {
            req.setAttribute("msgclass", "update-msg");
            req.setAttribute("msg", "修改成功");
            return "menus/page-songs";
        } else {
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "修改失敗");
            return "menus/page-songs";
        }
    }

    @RequestMapping("deleteSongs")
    public String deleteSongs(int sId, HttpServletRequest req) {
        int result = songsService.deleteSongs(sId);
        if (result == 1) {
            req.setAttribute("msgclass", "update-msg");
            req.setAttribute("msg", "删除成功");
            return "menus/page-songs";
        } else {
            req.setAttribute("msgclass", "update-msg1");
            req.setAttribute("msg", "删除失敗");
            return "menus/page-songs";
        }
    }

    @RequestMapping("clearDownloads")
    public String clearDownloads(int sId, HttpServletRequest req) {
        int result = songsService.clearDownloads(sId);
        if (result == 1) {
            return "menus/page-download";
        } else {
            return "menus/page-download";
        }
    }

}