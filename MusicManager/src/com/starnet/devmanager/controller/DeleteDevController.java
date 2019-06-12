package com.starnet.devmanager.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.starnet.devmanager.service.IDevService;
import com.starnet.usermanager.utils.StringUtils;
@Controller
public class DeleteDevController implements org.springframework.web.servlet.mvc.Controller{
	private IDevService iDevService;
	@Resource(name="devService")
   
	public void setiDevService(IDevService iDevService) {
		this.iDevService = iDevService;
	}

	@RequestMapping(value="/deleteDevController.do")
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//从请求中获取选中的id字符串
        String devIds=arg0.getParameter("devIds");
        if (StringUtils.isEmpty(devIds)){
            return null;
        }
        //切割id字符串为devIdArr数组
        String[]devIdArr=devIds.split(",");
        if (devIdArr==null){
            return null;

        }
        
        List<String>devIdList=new ArrayList<String>();
        for (String Id:devIdArr){
            devIdList.add(Id);
        }
        try {
            int ret=iDevService.deleteDevByIds(devIdList);
            arg1.getOutputStream().write(String.valueOf(ret).getBytes());

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
