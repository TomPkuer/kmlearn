package com.starnet.devmanager.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.starnet.devmanager.dao.DevInfo;

public interface IDevService {
	/*
     *添加设备信息
     * @param devInfo
     * @return 0 成功
     * @exception RuntimeException
     */		
	public int addDevinfo(DevInfo devInfo);
	
	 /*
     *查询设备信息
     * @param all User
     * @exception RuntimeException
     */
    public List<DevInfo>listAll();
    public List<DevInfo>listAll(int type);

    /*
     *删除设备信息
     * @param devIds 设备ID
     * return 0 成功 -1 失败
     *
     */
    public int deleteDevByIds(List<String> devIds);
    
    /*
     *修改设备
     * @param devInfo
     * @return 0 成功
     * @exception RuntimeException
     */
    public int modifyDevByid(DevInfo devInfo);
}
