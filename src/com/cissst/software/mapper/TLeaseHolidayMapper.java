package com.cissst.software.mapper;

import java.util.List;

import com.cissst.software.model.TLeaseHoliday;

public interface TLeaseHolidayMapper {

	/**
	 * ��ӽڼ���
	 * @param tlh
	 */
	public void addTLeaseHoliday(TLeaseHoliday tlh);
	
	/**
	 * ȡ�����нڼ��ն���
	 * @return
	 */
	public List<TLeaseHoliday> findAll();
	
	/**
	 * ɾ������
	 * @param id
	 */
	public void deleteById(String id);
	
}