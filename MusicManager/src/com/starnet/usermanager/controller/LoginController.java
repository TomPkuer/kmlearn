package com.starnet.usermanager.controller;
import com.starnet.usermanager.service.ISysUserService;
import com.starnet.usermanager.utils.StringUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Controller
public class LoginController  {
    private ISysUserService sysUserService;
    @Resource(name="sysUserService")
    public void setSysUserService(ISysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }
    
    @RequestMapping(value="/loginController.do")
    
    public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        arg1.setHeader("Content-type","text/html;charset=UTF-8");
        String userName=arg0.getParameter("username");
        String password=arg0.getParameter("password");
        System.out.println(userName+password);
        if (StringUtils.isEmpty(userName))
        {
            arg1.getOutputStream().write("-2".getBytes());
            return null;
        }
        if (StringUtils.isEmpty(password)){
            arg1.getOutputStream().write("-2".getBytes());
            return null;
        }
        int ret=sysUserService.login(userName,password);
        arg1.getOutputStream().write(String.valueOf(ret).getBytes());
        //httpSession.setAttribute("islogin", 1);
        return null;
    }
    

}
