package com.starnet.songmanager.controller;

import com.alibaba.fastjson.JSONArray;
import com.starnet.devmanager.service.IDevService;
import com.starnet.songmanager.service.ISongService;
import com.starnet.usermanager.service.ISysUserService;
import com.starnet.usermanager.utils.StringUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class DeleteSongController implements org.springframework.web.servlet.mvc.Controller{
    
	private ISongService songService;
	
    @Resource(name="songService")

	public void setSongService(ISongService songService) {
		this.songService = songService;
	}



	@RequestMapping(value="/deleteSongController.do")
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		 String songIds=arg0.getParameter("songIds");
	        if (StringUtils.isEmpty(songIds)){
	            return null;
	        }
	        String[]songIdArr=songIds.split(",");
	        if (songIdArr==null){
	            return null;

	        }
	        List<Long>songIdList=new ArrayList<Long>();
	        for (String songId:songIdArr){
	            songIdList.add(Long.valueOf(songId));
	        }
	        try {
	            int ret=songService.deleteSong(songIdList);
	            arg1.getOutputStream().write(String.valueOf(ret).getBytes());

	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return null;
	    }

    }
    

