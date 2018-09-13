package com.cissst.software.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cissst.software.model.DischargeStatistic;

public interface DischargeStatisticMapper {

	/**
	 * �������ͳ����Ϣ
	 * @param dischargeStatistic
	 */
	public void addDischargeStatistic(DischargeStatistic dischargeStatistic);
	
	/**
	 * ��ѯ��������ͳ����Ϣ
	 * @return
	 */
	public List<DischargeStatistic> findDischargeStatistic();
	
	/**
	 * �������ڲ�ѯ����pv��
	 * @param day
	 * @return
	 */
	public int finddayPV(@Param(value="day") int day);
}
