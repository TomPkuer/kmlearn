package com.starnet.usermanager.utils;

import com.starnet.usermanager.dao.SysUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StringUtils {
	
	public static final boolean isEmpty(String str){
		return (null == str)?true:false;
	}
	
	//检查字符串对象是否非空
	public static final boolean isNotEmpty(String str){
		return !StringUtils.isEmpty(str);
	}

}
