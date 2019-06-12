package com.starnet.usermanager.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.starnet.usermanager.dao.SysUser;
import com.starnet.usermanager.service.ISysUserService;
import com.starnet.usermanager.utils.StringUtils;
@org.springframework.stereotype.Controller
public class ModifyUserController implements Controller {
	private ISysUserService sysUserService;
	@Resource(name="sysUserService")
    public void setSysUserService(ISysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

	@RequestMapping(value="/modifyUserController.do")
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		arg1.setHeader("Content-type","text/html;charset=UTF-8");
		String id=arg0.getParameter("id");
		String userName=arg0.getParameter("userName");
        String password=arg0.getParameter("password");
        String age=arg0.getParameter("age");
        String sex=arg0.getParameter("sex");
        String mobilePhone=arg0.getParameter("mobilePhone");
        String address=arg0.getParameter("address");
        
        if (StringUtils.isEmpty(userName))
        {
            arg1.getOutputStream().write("-2".getBytes());
            return null;
        }
        if (StringUtils.isEmpty(password)){
            arg1.getOutputStream().write("-2".getBytes());
            return null;
        }

        SysUser sysUser=new SysUser();
        sysUser.setId(Long.parseLong(id));
        sysUser.setUserName(userName);
        sysUser.setPassword(password);
        if(StringUtils.isEmpty(age)){
			//年龄为空，则设置为默认值 0
			sysUser.setAge(0);
		}else{
			//否则设置为对应的年龄ֵ
			sysUser.setAge(Integer.parseInt(age));
		}

        if(StringUtils.isEmpty(sex)){
			//性别为空，则设置为默认值 0
			sysUser.setSex(0);
		}else{
			//否则设置为对应的性别ֵ
			sysUser.setSex(Integer.parseInt(sex));
		}

        sysUser.setMobilephone(mobilePhone);
        sysUser.setAddress(address);
        int ret=sysUserService.modifyUserByid(sysUser);
        arg1.getOutputStream().write(String.valueOf(ret).getBytes());
		return null;
	}

}
