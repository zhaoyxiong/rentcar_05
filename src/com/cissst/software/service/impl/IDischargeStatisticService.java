package com.cissst.software.service.impl;

import java.util.List;

import com.cissst.software.model.DischargeStatistic;

public interface IDischargeStatisticService {

	/**
	 * 添加流量记录信息
	 * @param dischargeStatistic
	 */
	public void addDischargeIStatistic(DischargeStatistic dischargeStatistic);
	
	/**
	 * 查询所有流量记录信息
	 * @return
	 */
	public List<DischargeStatistic> findDischargeIStatistic();
	
	/**
	 * 根据日期查询次日pv量
	 * @param day
	 * @return
	 */
	public int finddayPV(int day);
}
