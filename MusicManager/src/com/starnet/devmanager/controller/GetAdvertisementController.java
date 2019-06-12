package com.starnet.devmanager.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.starnet.devmanager.dao.DevInfo;
import com.starnet.devmanager.service.IDevService;
import com.starnet.usermanager.dao.SysUser;
import com.starnet.usermanager.service.ISysUserService;
import com.starnet.usermanager.utils.StringUtils;

@Controller
public class GetAdvertisementController implements org.springframework.web.servlet.mvc.Controller{

	private IDevService iDevService;
	@Resource(name="devService")
   
	public void setiDevService(IDevService iDevService) {
		this.iDevService = iDevService;
	}

	@RequestMapping(value="/getAdvertisementController.do")

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(arg0.getInputStream(),"utf-8"));
		StringBuilder sb = new StringBuilder();
		String jkString;
		while ((jkString = br.readLine()) != null) {
			sb.append(jkString);
		}
		JSONObject json = new JSONObject();
		json = JSONObject.parseObject(sb.toString());
        

		System.out.println("设备编号为:  "+json.getString("id")+"  收到的广告:"+json.getString("adv"));
		
	    return null;
			
      
	}

}
