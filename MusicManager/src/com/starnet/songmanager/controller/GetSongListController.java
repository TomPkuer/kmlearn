package com.starnet.songmanager.controller;

import com.alibaba.fastjson.JSONArray;
import com.starnet.devmanager.service.IDevService;
import com.starnet.songmanager.service.ISongService;
import com.starnet.usermanager.service.ISysUserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class GetSongListController implements org.springframework.web.servlet.mvc.Controller{
    
	private ISongService songService;
	
    @Resource(name="songService")

	public void setSongService(ISongService songService) {
		this.songService = songService;
	}



	@RequestMapping(value="/getSongListController.do")
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        arg1.setHeader("Content-type","text/html;charset=UTF-8");
        JSONArray jsonArray=new JSONArray();
         jsonArray.addAll(songService.listAll());
         byte[]retArr=jsonArray.toJSONString().getBytes();
         arg1.getOutputStream().write(retArr);
         return null;

    }
    
}
