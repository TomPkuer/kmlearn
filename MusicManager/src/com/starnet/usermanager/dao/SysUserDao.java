package com.starnet.usermanager.dao;

import com.starnet.usermanager.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class SysUserDao {
	private static Logger logger = Logger.getLogger(SysUserDao.class); //对数据库操作生成日志文件
    private DBUtils dbUtils;
    public void setDbUtils(DBUtils dbUtils) {
        this.dbUtils = dbUtils;
    }
    
    //添加用户
    public int addSysUser(SysUser sysUser){

        String sql="insert into sys_user(userName,sex,age,mobilephone,address,password)values(?,?,?,?,?,?)";
        Connection conn=dbUtils.getConn();
         PreparedStatement pstm=null;

        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,sysUser.getUserName());
            pstm.setInt(2,sysUser.getSex());
            pstm.setInt(3,sysUser.getAge());
            pstm.setString(4,sysUser.getMobilephone());
            pstm.setString(5,sysUser.getAddress());
            pstm.setString(6,sysUser.getPassword());

            pstm.executeUpdate();
            logger.info("The info of a new user is inserted！");
            return 0;


        } catch (Exception e) {
            throw new RuntimeException("SysUserDao-addSysUser erro",e);

        }finally {
            dbUtils.releaseAll(conn,pstm,null);
        }

    }
    
    //查询所有用户信息
    public List<SysUser>listAll(){
        List<SysUser>dataList=new ArrayList<SysUser>();
        //查询用户sql语句
        String sql ="select * from sys_user";
        //获取数据库连接
        Connection conn=dbUtils.getConn();
        PreparedStatement pstm=null;
        ResultSet rs=null;

        try {
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while (rs.next()){
                SysUser sysUser=new SysUser();
                sysUser.setId(rs.getLong("id"));
                sysUser.setUserName(rs.getString("userName"));
                sysUser.setSex(rs.getInt("sex"));
                sysUser.setAge(rs.getInt("age"));
                sysUser.setMobilephone(rs.getString("mobilephone"));
                //System.out.print(rs.getString("mobile_phone"));
                sysUser.setAddress(rs.getString("address"));
                //System.out.print(sysUser.getId()+" "+sysUser.getAddress()+" "+sysUser.getMobilephone());
                dataList.add(sysUser);
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
    
    //根据用户名密码返回登陆指令
    //0 普通管理员 ，1 超级管理员 ，-1失败
    public int findByUserNameAndPwd(String userName,String password)
    {
        //sql语句根据用户名密码查询用户信息
        String sql="select * from sys_manager t where t.userName=? and t.password=?";

        Connection conn= dbUtils.getConn();
         PreparedStatement pstm=null;
         ResultSet rs=null;

        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,userName);
            pstm.setString(2,password);
            rs=pstm.executeQuery();
            if (rs.next()){
            	logger.info(userName+"  "+"is online!");
            	if (rs.getInt("root")==0) { //判断管理员权限
            		
					return 0; //普通管理员
				}else {
					return 1; //超级管理员
				}
                
            }
        } catch (Exception e) {
            throw new RuntimeException("SysUserDao-findByUserNameAndPwderro",e);
        }finally {
            dbUtils.releaseAll(conn,pstm,rs);
        }
        return -1; //验证失败

    }
    //删除用户
    public int deleteUserByIds(List<Long> userIds){
        String sql ="delete from sys_user where id in(?)";
        Connection conn=dbUtils.getConn();
        PreparedStatement pstm=null;
        try {
            pstm=conn.prepareStatement(sql);
            for (Long id:userIds){
                pstm.setLong(1,id);
                pstm.addBatch();
                logger.info("The info of "+id+"  "+"has been deleted!");
            }
            int[]ret=pstm.executeBatch();
            
            return 0;
        } catch (Exception e) {
            throw new RuntimeException("SysUserDao-deleteUserByIdserro",e);
        }finally {
            dbUtils.releaseAll(conn,pstm,null);
        }


    }
    
    //根据用户id修改信息
    public int modifyUserByid(SysUser sysUser){
    	String sql="UPDATE sys_user  SET userName=?,sex=?,age=?,mobilephone=?,address=? WHERE id = ?";
    	//userName,sex,age,mobilephone,address,password)values(?,?,?,?,?,?)
        Connection conn=dbUtils.getConn();
         PreparedStatement pstm=null;
         PreparedStatement pStatement=null;

        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, sysUser.getUserName());
            pstm.setInt(2, sysUser.getSex());
            pstm.setInt(3, sysUser.getAge());
            pstm.setString(4, sysUser.getMobilephone());
            pstm.setString(5, sysUser.getAddress());
            //System.out.println(sysUser.getPassword());
            if(!sysUser.getPassword().equals("")){
            	String sql2="UPDATE sys_user  SET password=? WHERE id = ?";
            	Connection conn2=dbUtils.getConn();
            	pStatement=conn2.prepareStatement(sql2);
            	pStatement.setString(1, sysUser.getPassword());
            	pStatement.setLong(2, sysUser.getId());
            	pStatement.executeUpdate();
            	dbUtils.releaseAll(conn2, pStatement, null);
            	
            	
            }
            
            pstm.setLong(6, sysUser.getId());
            pstm.executeUpdate();
            logger.info("The info of "+sysUser.getId()+"  "+"has been modified!");
            return 0;


        } catch (Exception e) {
            throw new RuntimeException("SysUserDao-modifySysUser erro",e);

        }finally {
            dbUtils.releaseAll(conn,pstm,null);
        }

    	
    }


}
