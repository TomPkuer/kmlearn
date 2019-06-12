package com.starnet.devmanager.dao;

import java.sql.Date;

public class DevInfo {
	private String deviceID; //设备id，唯一
	private String deviceName;//设备名
	private int deviceType;//设备类型，0代表安卓，1代表开发板设备
	private String time;//操作时间
	private int type;//设备状态，0代表下线，1代表上线
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public int getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
	

}
