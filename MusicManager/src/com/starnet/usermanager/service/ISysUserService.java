package com.starnet.usermanager.service;

import com.starnet.usermanager.dao.SysUser;

import java.util.List;

public interface ISysUserService {
    /*
     *添加用户
     * @param sysUser
     * @return 0 成功
     * @exception RuntimeException
     */
    public int addSysUser(SysUser sysUser);

    /*
     *查询用户
     * @param all User
     * @exception RuntimeException
     */
    public List<SysUser>listAll();

    /*
     *用户登录
     * @param userName 用户�?
     * @param pwd 密码
     * return 0 成功 -1 失败
     * @exception RuntimeException
     */


    public int login(String userName,String pwd);

    /*
     *删除用户
     * @param userIds 用户ID
     * return 0 成功 -1 失败
     *
     */
    public int deleteUser(List<Long>userIds);
    
    /*
     *修改用户
     * @param sysUser
     * @return 0 成功
     * @exception RuntimeException
     */
    public int modifyUserByid(SysUser sysUser);
}
