package com.cissst.software.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cissst.software.model.DischargeStatistic;

public interface DischargeStatisticMapper {

	/**
	 * 添加流量统计信息
	 * @param dischargeStatistic
	 */
	public void addDischargeStatistic(DischargeStatistic dischargeStatistic);
	
	/**
	 * 查询所有流量统计信息
	 * @return
	 */
	public List<DischargeStatistic> findDischargeStatistic();
	
	/**
	 * 根据日期查询次日pv量
	 * @param day
	 * @return
	 */
	public int finddayPV(@Param(value="day") int day);
}
