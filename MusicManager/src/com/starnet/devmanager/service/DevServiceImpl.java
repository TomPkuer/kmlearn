package com.starnet.devmanager.service;

import java.util.List;

import com.starnet.devmanager.dao.DevInfo;
import com.starnet.devmanager.dao.DevInfoDao;
public class DevServiceImpl implements IDevService {
	private DevInfoDao devInfoDao;
	
	
	public void setDevInfoDao(DevInfoDao devInfoDao) {
		this.devInfoDao = devInfoDao;
	}
	
//	@Override
//	public int addDevinfo(DevInfo devInfo) {
//		// TODO Auto-generated method stub
//		return devInfoDao.addDevinfo(devInfo);
//	}

	@Override
	public List<DevInfo> listAll() {
		// TODO Auto-generated method stub
		return devInfoDao.listAll();
	}
	

	@Override
	public int deleteDevByIds(List<String> devIds) {
		// TODO Auto-generated method stub
		return devInfoDao.deleteDevByIds(devIds);
	}

	@Override
	public int addDevinfo(DevInfo devInfo) {
		// TODO Auto-generated method stub
		return devInfoDao.addDevinfo(devInfo);
	}

	@Override
	public int modifyDevByid(DevInfo devInfo) {
		// TODO Auto-generated method stub
		return devInfoDao.modifyDevByid(devInfo);
	}

	@Override
	public List<DevInfo> listAll(int type) {
		// TODO Auto-generated method stub
		return devInfoDao.listAll(type);
	}

//	@Override
//	public int modifyDevByid(DevInfo devInfo) {
//		// TODO Auto-generated method stub
//		return devInfoDao.modifyDevByid(devInfo);
//	}

}
