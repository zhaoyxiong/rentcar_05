package com.cissst.software.mapper;

import java.util.List;

import com.cissst.software.model.TLeaseHoliday;

public interface TLeaseHolidayMapper {

	/**
	 * 添加节假日
	 * @param tlh
	 */
	public void addTLeaseHoliday(TLeaseHoliday tlh);
	
	/**
	 * 取出所有节假日对象
	 * @return
	 */
	public List<TLeaseHoliday> findAll();
	
	/**
	 * 删除操作
	 * @param id
	 */
	public void deleteById(String id);
	
}