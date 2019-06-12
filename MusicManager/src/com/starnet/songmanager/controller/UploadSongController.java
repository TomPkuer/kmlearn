package com.starnet.songmanager.controller;

import com.alibaba.fastjson.JSONArray;
import com.starnet.devmanager.service.IDevService;
import com.starnet.songmanager.dao.SongInfo;
import com.starnet.songmanager.service.ISongService;
import com.starnet.usermanager.service.ISysUserService;
import com.starnet.usermanager.utils.StringUtils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.channels.NonWritableChannelException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class UploadSongController extends HttpServlet implements org.springframework.web.servlet.mvc.Controller {
    
	private ISongService songService;
	
    @Resource(name="songService")

	public void setSongService(ISongService songService) {
		this.songService = songService;
	}



	@RequestMapping(value="/UpSongController.do")
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTf-8");
	    //获取tomcat下的up目录的路径   
	    String path = getServletContext().getRealPath("/up");
	    //临时文件目录
	    String tmpPath = getServletContext().getRealPath("/tmp");
	    System.out.println(req.toString());
	    //检查我们是否有文件上传请求
	    boolean isMultipart = ServletFileUpload.isMultipartContent(req);
	    //1,声明DiskFileItemFactory工厂类，用于在指定磁盘上设置一个临时目录
	    DiskFileItemFactory disk = new DiskFileItemFactory(1024*10,new File(tmpPath));
	    //2,声明ServletFileUpload，接收上边的临时文件。也可以默认值
	    ServletFileUpload up = new ServletFileUpload(disk);
	    //3,解析request
	    try {
	        List<FileItem> list = up.parseRequest(req);
	        //如果就一个文件，
	        FileItem file = list.get(0);
	        //获取文件名：
	        String fileName = file.getName();
	        //获取文件的类型：
	        String fileType = file.getContentType();
	        //获取文件的字节码：
	        InputStream in = file.getInputStream();
	        //文件大小
	        int size = file.getInputStream().available();
	        //声明输出字节流
	        OutputStream out = new FileOutputStream(path+"/"+fileName);
	        //文件copy
	        byte[] b = new byte[1024];
	        int len = 0;
	        while((len=in.read(b))!=-1){
	            out.write(b, 0, len);
	        }
	        out.flush(); 
	        out.close();
	        
	        //删除上传生成的临时文件
	        file.delete();
	        
	        //显示数据
	        resp.setContentType("text/html;charset=UTF-8");
	        PrintWriter pw = resp.getWriter();
	        pw.println("文件名："+fileName);
	        pw.println("文件类型："+fileType);
	        pw.println("<br/>文件大小（byte）："+size);
	    } catch (FileUploadException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	  

		
		return null;
		
    }
    
}
