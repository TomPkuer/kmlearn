package com.starnet.songmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.extra.spath.SPathFilter;

import com.starnet.usermanager.utils.DBUtils;

public class SongInfoDao {
	private DBUtils dbUtils;
    public void setDbUtils(DBUtils dbUtils) {
        this.dbUtils = dbUtils;
    }
	    //添加设备信息
	    public int addSonginfo(SongInfo songInfo){
	
	        String sql="insert into song_info(songName,title,sort,status)values(?,?,?,?)";
	        Connection conn=dbUtils.getConn();
	         PreparedStatement pstm=null;
	         java.util.Date  date=new java.util.Date();

	         java.sql.Date  data1=new java.sql.Date(date.getTime());
	
	        try {
	            pstm=conn.prepareStatement(sql);
	            pstm.setString(1,songInfo.getSongName());
	            pstm.setString(2,songInfo.getTitle());
	            //pstm.setDate(3, data1);
	            pstm.setInt(3, songInfo.getSort());
	            pstm.setInt(4, songInfo.getStatus());
	            
	
	            pstm.executeUpdate();
	            //logger.info("The info of a new user is inserted！");
	            return 0;
	
	
	        } catch (Exception e) {
	            throw new RuntimeException("DevinfoDao-addDevinfo erro",e);
	
	        }finally {
	            dbUtils.releaseAll(conn,pstm,null);
	        }
	
	    }
    //查询所有歌曲信息
    public List<SongInfo>listAll(){
        List<SongInfo>dataList=new ArrayList<SongInfo>();
        //查询用户sql语句
        String sql ="select * from song_info";
        //获取数据库连接
        Connection conn=dbUtils.getConn();
        PreparedStatement pstm=null;
        ResultSet rs=null;

        try {
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while (rs.next()){
               SongInfo songInfo=new SongInfo();
               songInfo.setId(rs.getLong("id"));
               songInfo.setSongName(rs.getString("songName"));
               //System.out.println(songInfo.getUpDate());
               songInfo.setTitle(rs.getString("title"));
               String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(rs.getTimestamp("upDate"));
               //System.out.println(dateStr);
               songInfo.setUpDate(dateStr);

               
               songInfo.setSort(rs.getInt("sort"));
               songInfo.setStatus(rs.getInt("status"));
                //System.out.print(sysUser.getId()+" "+sysUser.getAddress()+" "+sysUser.getMobilephone());
                dataList.add(songInfo);
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
    
    
    //删除歌曲
    public int deleteSongByIds(List<Long> songIds){
        String sql ="delete from song_info where id in(?)";
        Connection conn=dbUtils.getConn();
        PreparedStatement pstm=null;
        try {
            pstm=conn.prepareStatement(sql);
            for (Long id:songIds){
                pstm.setLong(1,id);
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


//    }
    //修改音乐信息
    public int modifyDevByid(SongInfo songInfo){
    	//System.out.println(devInfo.getDevName());
    	String sql="UPDATE song_info  SET songName=?,title=?,sort=?,status=? WHERE id = ?";

    	//userName,sex,age,mobilephone,address,password)values(?,?,?,?,?,?)
        Connection conn=dbUtils.getConn();
         PreparedStatement pstm=null;
         PreparedStatement pStatement=null;

        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, songInfo.getSongName());
            pstm.setString(2, songInfo.getTitle()); 
            pstm.setInt(3, songInfo.getSort());
            pstm.setInt(4, songInfo.getStatus());
            pstm.setLong(5, songInfo.getId());
            pstm.executeUpdate();
            return 0;


        } catch (Exception e) {
            throw new RuntimeException("DevInfoDao-modifydev erro",e);

        }finally {
            dbUtils.releaseAll(conn,pstm,null);
        }

    	
    }
   
}
