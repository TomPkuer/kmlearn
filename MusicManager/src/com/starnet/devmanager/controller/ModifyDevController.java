package com.starnet.devmanager.controller;

import java.nio.channels.NonWritableChannelException;

import javax.annotation.Resource;
import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.starnet.devmanager.dao.DevInfo;
import com.starnet.devmanager.service.IDevService;
import com.starnet.usermanager.dao.SysUser;
import com.starnet.usermanager.utils.StringUtils;
@org.springframework.stereotype.Controller
public class ModifyDevController implements Controller {

	private IDevService iDevService;
	@Resource(name="devService")
   
	public void setiDevService(IDevService iDevService) {
		this.iDevService = iDevService;
	}
	@RequestMapping(value="/modifyDevController.do")
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		arg1.setHeader("Content-type","text/html;charset=UTF-8");
		String deviceName=arg0.getParameter("deviceName");
		
        String type=arg0.getParameter("type");
        String deviceType=arg0.getParameter("deviceType");
        String deviceID=arg0.getParameter("deviceID");
        System.out.println(deviceID);
        DevInfo devInfo=new DevInfo();
        devInfo.setDeviceID(deviceID);
        devInfo.setDeviceName(deviceName);
        //devInfo.setDeviceType(deviceType);
        //devInfo.setType(type);
        if(StringUtils.isEmpty(deviceType)){
        	devInfo.setDeviceType(0);
		}else{
			//否则设置为对应的年龄ֵ
			devInfo.setDeviceType(Integer.parseInt(deviceType));
		}
        
        if(StringUtils.isEmpty(type)){
        	devInfo.setType(0);
		}else{
			//否则设置为对应的年龄ֵ
			devInfo.setType(Integer.parseInt(type));
		}
        int ret=iDevService.modifyDevByid(devInfo);
        arg1.getOutputStream().write(String.valueOf(ret).getBytes());
		return null;
		}

}
