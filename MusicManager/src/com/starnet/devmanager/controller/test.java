package com.starnet.devmanager.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;

public class test {
	public static void main(String[]args) throws Exception{
		//System.out.println("111111");
		test rTest=new test();
		rTest.connect("hello");
		
	}
	
	public void connect(String message) throws Exception{
		StringBuffer str = new StringBuffer();

	    HttpURLConnection conn = null;
	    String urlPath = "http://192.168.112.172:8080/MusicManager/accessDevController.do";
	    try {
	    	JSONObject body = new JSONObject();
	    	body.put("type","在家");
	    	body.put("time", "2019-10-9");
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
	        os.writeBytes(content);
	        
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

	    

	    
		
	}

}
