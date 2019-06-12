package com.starnet.devmanager.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import com.starnet.devmanager.dao.DevInfo;
import com.starnet.devmanager.service.IDevService;
import com.starnet.usermanager.dao.SysUser;
import com.starnet.usermanager.service.ISysUserService;
import com.starnet.usermanager.utils.StringUtils;

@Controller
public class AddDevController implements org.springframework.web.servlet.mvc.Controller{

	private IDevService iDevService;
	@Resource(name="devService")
   
	public void setiDevService(IDevService iDevService) {
		this.iDevService = iDevService;
	}

	@RequestMapping(value="/addDevController.do")

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		arg1.setHeader("Content-type","text/html;charset=UTF-8");
		//获取与请求的信息
        String deviceName=arg0.getParameter("deviceName");
        String type=arg0.getParameter("type");
        String deviceType=arg0.getParameter("deviceType");
        String deviceID=arg0.getParameter("deviceID");
        //实例化DevInfo对象
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
        

        

        
        int ret=iDevService.addDevinfo(devInfo);
        arg1.getOutputStream().write(String.valueOf(ret).getBytes());
        return null;
	}

}
