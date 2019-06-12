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
public class AccessDevController implements org.springframework.web.servlet.mvc.Controller{

	private IDevService iDevService;
	@Resource(name="devService")
   
	public void setiDevService(IDevService iDevService) {
		this.iDevService = iDevService;
	}

	@RequestMapping(value="/accessDevController.do")

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
		System.out.println(sb.toString());
		System.out.println(json.getString("type"));
		String deviceName=json.getString("deviceName");
		String deviceID=json.getString("deviceID");
		String deviceType=json.getString("deviceType");
		String type=json.getString("type");
		DevInfo devInfo=new DevInfo();
		devInfo.setDeviceID(deviceID);
		devInfo.setDeviceType(Integer.parseInt(deviceType));
		devInfo.setType(Integer.parseInt(type));
		System.out.println(devInfo.getType());
		devInfo.setDeviceName(deviceName);
		int ret=iDevService.modifyDevByid(devInfo);
		arg1.setStatus(200);
	    return null;
			
      
	}

}
