package com.cissst.software.service.impl;

import java.util.List;

import com.cissst.software.model.TLeaseHoliday;

public interface ITLeaseHolidayService {

	/**
	 * ��Ӷ���
	 * @param tlh
	 */
	public void addTLeaseHoliday(TLeaseHoliday tlh);
	
	/**
	 * ��ѯ�û�ȫ����Ϣ
	 * @return
	 */
	public List<TLeaseHoliday> findAll();
	
	/**
	 * �����û����ɾ���û���¼
	 * @param id
	 */
	public void deleteById(String id);
}
