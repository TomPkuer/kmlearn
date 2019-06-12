package com.starnet.devmanager.controller;


import com.alibaba.fastjson.JSONArray;
import com.starnet.devmanager.service.IDevService;
import com.starnet.usermanager.service.ISysUserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class GetDevListController implements org.springframework.web.servlet.mvc.Controller{
    
    
    
    private IDevService devService;
    @Resource(name="devService")
	public void setIDevService(IDevService iDevService) {
		devService = iDevService;
	}

	@RequestMapping(value="/getDevListController.do")
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        arg1.setHeader("Content-type","text/html;charset=UTF-8");
        JSONArray jsonArray=new JSONArray();
         jsonArray.addAll(devService.listAll());
         byte[]retArr=jsonArray.toJSONString().getBytes();
         
         arg1.getOutputStream().write(retArr);
         return null;

    }
    
}