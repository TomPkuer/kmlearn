package com.starnet.songmanager.dao;

import java.util.Date;

public class SongInfo {
	private Long id;
	private String songName;
	private String title;
	private String upDate;
	private int sort;
	private int status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUpDate() {
		return upDate;
	}
	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
