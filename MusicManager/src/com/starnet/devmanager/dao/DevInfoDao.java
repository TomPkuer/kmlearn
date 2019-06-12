package com.starnet.devmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Soundbank;

import com.starnet.usermanager.utils.DBUtils;

public class DevInfoDao {
	private DBUtils dbUtils;
    public void setDbUtils(DBUtils dbUtils) {
        this.dbUtils = dbUtils;
    }
    
//    public  int findByID(String deviceID)
//    {
//        //sql语句根据用户名密码查询用户信息
//        String sql="select * from dev_info  where deviceID=?";
//
//        Connection conn= dbUtils.getConn();
//         PreparedStatement pstm=null;
//         ResultSet rs=null;
//
//        try {
//            pstm=conn.prepareStatement(sql);
//            pstm.setString(1,deviceID);
//            rs=pstm.executeQuery();
//            if (rs.next())
//            	return 1; //id已存在
//        } catch (Exception e) {
//            throw new RuntimeException("SysUserDao-findByUserNameAndPwderro",e);
//        }finally {
//            dbUtils.releaseAll(conn,pstm,rs);
//        }
//        return 0; //验证失败
//
//    }
    //添加设备信息
    public int addDevinfo(DevInfo devInfo){
     String sql="insert into dev_info(deviceID,deviceName,deviceType,type)values(?,?,?,?)";
        Connection conn=dbUtils.getConn();
         PreparedStatement pstm=null;

        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,devInfo.getDeviceID());
            pstm.setString(2,devInfo.getDeviceName());
            pstm.setInt(3, devInfo.getDeviceType());
            pstm.setInt(4, devInfo.getType());
            

            pstm.executeUpdate();
            //logger.info("The info of a new user is inserted！");
            return 0;


        } catch (Exception e) {
            throw new RuntimeException("DevinfoDao-addDevinfo erro",e);

        }finally {
            dbUtils.releaseAll(conn,pstm,null);
        }

    }
    //查询所有设备信息
    public List<DevInfo>listAll(){
        List<DevInfo>dataList=new ArrayList<DevInfo>();
        //查询用户sql语句
        String sql ="select * from dev_info";
        //获取数据库连接
        Connection conn=dbUtils.getConn();
        PreparedStatement pstm=null;
        ResultSet rs=null;

        try {
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while (rs.next()){
                DevInfo devInfo=new DevInfo();
                devInfo.setDeviceID(rs.getString("deviceID"));
                devInfo.setDeviceName(rs.getString("deviceName"));
                devInfo.setDeviceType(rs.getInt("deviceType"));
                String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("time"));
                devInfo.setTime(dateStr);
                devInfo.setType(rs.getInt("type"));
                //System.out.print(sysUser.getId()+" "+sysUser.getAddress()+" "+sysUser.getMobilephone());
                dataList.add(devInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            //释放数据库连接
            dbUtils.releaseAll(conn,pstm,rs);
        }
        return dataList;
    }
    //根据设备类型获取设备信息
    public List<DevInfo>listAll(int type){
        List<DevInfo>dataList=new ArrayList<DevInfo>();
        //查询用户sql语句
        String sql ="select * from dev_info where deviceType=?";
        //获取数据库连接
        Connection conn=dbUtils.getConn();
        PreparedStatement pstm=null;
        ResultSet rs=null;

        try {
        	
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1, type);
            rs=pstm.executeQuery();
            while (rs.next()){
                DevInfo devInfo=new DevInfo();
                devInfo.setDeviceID(rs.getString("deviceID"));
                devInfo.setDeviceName(rs.getString("deviceName"));
                devInfo.setDeviceType(rs.getInt("deviceType"));
                String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("time"));
                devInfo.setTime(dateStr);
                devInfo.setType(rs.getInt("type"));
                //System.out.print(sysUser.getId()+" "+sysUser.getAddress()+" "+sysUser.getMobilephone());
                dataList.add(devInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            //释放数据库连接
            dbUtils.releaseAll(conn,pstm,rs);
        }
        return dataList;
    }
    
    //删除设备
    public int deleteDevByIds(List<String> devIds){
        String sql ="delete from dev_info where deviceID in(?)";
        Connection conn=dbUtils.getConn();
        PreparedStatement pstm=null;
        try {
            pstm=conn.prepareStatement(sql);
            for (String id:devIds){
                pstm.setString(1,id);
                pstm.addBatch();
                //logger.info("The info of "+id+"  "+"has been deleted!");
            }
            int[]ret=pstm.executeBatch();
            
            return 0;
        } catch (Exception e) {
            throw new RuntimeException("DevInfoDao-deleteDevByIdserro",e);
        }finally {
            dbUtils.releaseAll(conn,pstm,null);
        }


    }
    //修改设备信息
    public int modifyDevByid(DevInfo devInfo){
    	System.out.println("111");
    	String sql="UPDATE dev_info  SET deviceName=?,deviceType=?,type=? WHERE deviceID = ?";

    	//userName,sex,age,mobilephone,address,password)values(?,?,?,?,?,?)
        Connection conn=dbUtils.getConn();
         PreparedStatement pstm=null;
         PreparedStatement pStatement=null;

        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, devInfo.getDeviceName());
            pstm.setInt(2, devInfo.getDeviceType()); 
            pstm.setInt(3, devInfo.getType());
            pstm.setString(4, devInfo.getDeviceID());
            pstm.executeUpdate();
            return 0;


        } catch (Exception e) {
            throw new RuntimeException("DevInfoDao-modifydev erro",e);

        }finally {
            dbUtils.releaseAll(conn,pstm,null);
        }

    	
    }
   
}
