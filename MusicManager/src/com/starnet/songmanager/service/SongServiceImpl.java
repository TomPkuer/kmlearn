package com.starnet.songmanager.service;

import com.starnet.songmanager.dao.SongInfo;
import com.starnet.songmanager.dao.SongInfoDao;
import com.starnet.usermanager.dao.SysUser;
import com.starnet.usermanager.dao.SysUserDao;

import java.util.List;

public class SongServiceImpl implements ISongService {
    private SongInfoDao songInfoDao;

    
  
    




	public void setSongInfoDao(SongInfoDao songInfoDao) {
		this.songInfoDao = songInfoDao;
	}








	@Override
    public List<SongInfo> listAll() {
        return songInfoDao.listAll();
    }








	@Override
	public int addSong(SongInfo songInfo) {
		// TODO Auto-generated method stub
		return songInfoDao.addSonginfo(songInfo);
	}








	@Override
	public int deleteSong(List<Long> songIds) {
		// TODO Auto-generated method stub
		return songInfoDao.deleteSongByIds(songIds);
	}








	@Override
	public int modifySongrByid(SongInfo songInfo) {
		// TODO Auto-generated method stub
		return songInfoDao.modifyDevByid(songInfo);
	}








	}








	

    
    
    

