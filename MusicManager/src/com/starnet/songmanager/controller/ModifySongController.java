package com.starnet.songmanager.controller;

import com.alibaba.fastjson.JSONArray;
import com.starnet.devmanager.service.IDevService;
import com.starnet.songmanager.dao.SongInfo;
import com.starnet.songmanager.service.ISongService;
import com.starnet.usermanager.dao.SysUser;
import com.starnet.usermanager.service.ISysUserService;
import com.starnet.usermanager.utils.StringUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class ModifySongController implements org.springframework.web.servlet.mvc.Controller{
    
	private ISongService songService;
	
    @Resource(name="songService")

	public void setSongService(ISongService songService) {
		this.songService = songService;
	}



	@RequestMapping(value="/modifySongController.do")
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		arg1.setHeader("Content-type","text/html;charset=UTF-8");
		String id=arg0.getParameter("id");
		String songName=arg0.getParameter("songName");
        String title=arg0.getParameter("title");
        String sort=arg0.getParameter("sort");
        String status=arg0.getParameter("status");
        
        SongInfo songInfo=new SongInfo();
        songInfo.setId(Long.parseLong(id));
		songInfo.setSongName(songName);
		songInfo.setTitle(title);
		songInfo.setSort(Integer.parseInt(sort));
		if(StringUtils.isEmpty(status)){
			//性别为空，则设置为默认值 0
			songInfo.setStatus(0);
		}else{
			//否则设置为对应的性别ֵ
			songInfo.setStatus(Integer.parseInt(status));
		}
        int ret=songService.modifySongrByid(songInfo);
        arg1.getOutputStream().write(String.valueOf(ret).getBytes());
		return null;
	}
	
}
    

