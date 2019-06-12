package com.starnet.usermanager.controller;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController implements org.springframework.web.servlet.mvc.Controller{
    @Override
    public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        return new ModelAndView("sup_manager_content");//跳转至userList.jsp页面

    }
}
