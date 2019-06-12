package com.starnet.devmanager.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.Resource;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import javax.xml.crypto.Data;

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
public class SendAdvertisementController implements org.springframework.web.servlet.mvc.Controller{

	private IDevService iDevService;
	@Resource(name="devService")
   
	public void setiDevService(IDevService iDevService) {
		this.iDevService = iDevService;
	}

	@RequestMapping(value="/sendAdvertisementController.do")
    //模拟发送广告的功能
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String adv=arg0.getParameter("advertisement");
		String id=arg0.getParameter("id");
		StringBuffer str = new StringBuffer();
		HttpURLConnection conn = null;
	    String urlPath = "http://192.168.112.172:8080/MusicManager/getAdvertisementController.do";
	    try {
	    	JSONObject body = new JSONObject();
	    	body.put("adv",adv);
	    	body.put("id", id);
	        URL url = new URL(urlPath);
	        conn = (HttpURLConnection) url.openConnection();
	        //是否打开输入流 ， 此方法默认为true
	        conn.setDoInput(true);
	        //是否打开输出流， 此方法默认为false
	        conn.setDoOutput(true);
	        //POST或者GET
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json");
	        //GET支持缓存，POST不支持
	        conn.setUseCaches(false);
	        //连接超时时间 10s
	        conn.setConnectTimeout(10000);
	        //read超时时间 120s
	        conn.setReadTimeout(120000);
	        //表示连接
	        conn.connect();

	        //写入发送的数据（POST请求的时候才需要）
	        DataOutputStream os = new DataOutputStream( conn.getOutputStream());
	        String content = String.valueOf(body);
	       // System.out.println(content);
	        os.write(body.toString().getBytes("utf-8"));
	        
	        os.flush();
	        os.close();

	        //判断请求返回的状态
	        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {

	            //读取返回的数据
	            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

	            String temp = null;

	            while ((temp = in.readLine()) != null) {
	                str.append(temp);
	            }

	            in.close();
	        }

	    } catch (Exception e) {
	        
	    } finally {
	        if (null != conn) {
	            conn.disconnect();
	        }
	    }
		return null;

			
      
	}

}
