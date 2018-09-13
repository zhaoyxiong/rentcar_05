package com.cissst.software.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.mapper.DischargeStatisticMapper;
import com.cissst.software.model.DischargeStatistic;
import com.cissst.software.service.impl.IDischargeStatisticService;

@Service
public class DischargeStatisticServiceImpl implements IDischargeStatisticService {

	@Autowired
	private DischargeStatisticMapper dischargeStatisticMapper;
	
	public DischargeStatisticServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ��ӷ��ʼ�¼��Ϣ
	 */
	@Override
	public void addDischargeIStatistic(DischargeStatistic dischargeStatistic) {
		dischargeStatisticMapper.addDischargeStatistic(dischargeStatistic);
	}

	/**
	 * ��ѯ���з��ʼ�¼��Ϣ
	 */
	@Override
	public List<DischargeStatistic> findDischargeIStatistic() {
		return dischargeStatisticMapper.findDischargeStatistic();
	}

	@Override
	public int finddayPV(int day) {
		return dischargeStatisticMapper.finddayPV(day);
	}

}
