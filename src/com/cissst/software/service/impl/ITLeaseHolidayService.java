package com.cissst.software.service.impl;

import java.util.List;

import com.cissst.software.model.TLeaseHoliday;

public interface ITLeaseHolidayService {

	/**
	 * 添加对象
	 * @param tlh
	 */
	public void addTLeaseHoliday(TLeaseHoliday tlh);
	
	/**
	 * 查询用户全部信息
	 * @return
	 */
	public List<TLeaseHoliday> findAll();
	
	/**
	 * 根据用户编号删除用户记录
	 * @param id
	 */
	public void deleteById(String id);
}
