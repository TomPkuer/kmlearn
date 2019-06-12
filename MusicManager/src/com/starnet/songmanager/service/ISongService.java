package com.starnet.songmanager.service;

import com.starnet.songmanager.dao.SongInfo;
import com.starnet.usermanager.dao.SysUser;

import java.util.List;

public interface ISongService {
//    /*
//     *添加用户
//     * @param sysUser
//     * @return 0 成功
//     * @exception RuntimeException
//     */
//    public int addSysUser(SysUser sysUser);
//
//    /*
//     *查询用户
//     * @param all User
//     * @exception RuntimeException
//     */
	public int addSong(SongInfo songInfo);
    public List<SongInfo>listAll();

    /*
     *用户登录
     * @param userName 用户�?
     * @param pwd 密码
     * return 0 成功 -1 失败
     * @exception RuntimeException
     */


//    public int login(String userName,String pwd);
//
    /*
     *删除用户
     * @param userIds 用户ID
     * return 0 成功 -1 失败
     *
     */
    public int deleteSong(List<Long>songIds);
//    
//    /*
//     *修改用户
//     * @param sysUser
//     * @return 0 成功
//     * @exception RuntimeException
//     */
   public int modifySongrByid(SongInfo songInfo);
}
