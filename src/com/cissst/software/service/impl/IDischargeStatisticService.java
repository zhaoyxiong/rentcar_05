package com.cissst.software.service.impl;

import java.util.List;

import com.cissst.software.model.DischargeStatistic;

public interface IDischargeStatisticService {

	/**
	 * ���������¼��Ϣ
	 * @param dischargeStatistic
	 */
	public void addDischargeIStatistic(DischargeStatistic dischargeStatistic);
	
	/**
	 * ��ѯ����������¼��Ϣ
	 * @return
	 */
	public List<DischargeStatistic> findDischargeIStatistic();
	
	/**
	 * �������ڲ�ѯ����pv��
	 * @param day
	 * @return
	 */
	public int finddayPV(int day);
}
