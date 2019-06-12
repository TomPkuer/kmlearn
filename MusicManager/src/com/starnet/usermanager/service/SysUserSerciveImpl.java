package com.starnet.usermanager.service;

import com.starnet.usermanager.dao.SysUser;
import com.starnet.usermanager.dao.SysUserDao;

import java.util.List;

public class SysUserSerciveImpl implements ISysUserService {
    private SysUserDao sysUserDao;

    public void setSysUserDao(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

    @Override
    public int addSysUser(SysUser sysUser) {
        return sysUserDao.addSysUser(sysUser);
    }

    @Override
    public List<SysUser> listAll() {
        return sysUserDao.listAll();
    }

    @Override
    public int login(String userName, String pwd) {
        return sysUserDao.findByUserNameAndPwd(userName,pwd);
    }

    @Override
    public int deleteUser(List<Long> userIds) {
        return sysUserDao.deleteUserByIds(userIds);
    }

	@Override
	public int modifyUserByid(SysUser sysUser) {
		// TODO Auto-generated method stub
		return sysUserDao.modifyUserByid(sysUser);
	}
    
    
}
