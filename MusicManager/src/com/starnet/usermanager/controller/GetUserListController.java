package com.starnet.usermanager.controller;

import com.alibaba.fastjson.JSONArray;
import com.starnet.usermanager.service.ISysUserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class GetUserListController implements org.springframework.web.servlet.mvc.Controller{
    
    private ISysUserService sysUserService;
    @Resource(name="sysUserService")
    public void setSysUserService(ISysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }
    @RequestMapping(value="/getUserListController.do")
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        arg1.setHeader("Content-type","text/html;charset=UTF-8");
        JSONArray jsonArray=new JSONArray();
         jsonArray.addAll(sysUserService.listAll());
         byte[]retArr=jsonArray.toJSONString().getBytes();
         arg1.getOutputStream().write(retArr);
         return null;

    }
    
}
