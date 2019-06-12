package com.starnet.usermanager.controller;

import com.alibaba.fastjson.JSONArray;

import com.starnet.usermanager.service.ISysUserService;
import com.starnet.usermanager.utils.StringUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
@Controller
public class DeleteUsersController implements org.springframework.web.servlet.mvc.Controller {
    private ISysUserService sysUserService;
	@Resource(name="sysUserService")
    public void setSysUserService(ISysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }
	@RequestMapping(value="/deleteUsersController.do")
	@Override
    public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        String userIds=arg0.getParameter("userIds");
        if (StringUtils.isEmpty(userIds)){
            return null;
        }
        String[]userIdArr=userIds.split(",");
        if (userIdArr==null){
            return null;

        }
        List<Long>userIdList=new ArrayList<Long>();
        for (String userId:userIdArr){
            userIdList.add(Long.valueOf(userId));
        }
        try {
            int ret=sysUserService.deleteUser(userIdList);
            arg1.getOutputStream().write(String.valueOf(ret).getBytes());

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
