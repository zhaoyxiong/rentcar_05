package com.cissst.software.model;

import java.sql.Date;

/**
 * 流量统计类
 * @author fengy
 *
 */
public class DischargeStatistic {

	private String id;
	private String user_id;
	private Date time;
	private String ip;
	
	public DischargeStatistic() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "DischargeStatistic [id=" + id + ", user_id=" + user_id + ", time=" + time + ", ip=" + ip + "]";
	}

	
}
