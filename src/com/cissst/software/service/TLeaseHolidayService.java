package com.cissst.software.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cissst.software.mapper.TLeaseHolidayMapper;
import com.cissst.software.model.TLeaseHoliday;
import com.cissst.software.service.impl.ITLeaseHolidayService;
/**
 * 业务逻辑实现子类
 * @author 应雄
 *
 */
@Service
public class TLeaseHolidayService implements ITLeaseHolidayService{

	@Autowired
	private TLeaseHolidayMapper tlhmapper; 
	
	@Transactional
	@Override
	public void addTLeaseHoliday(TLeaseHoliday tlh) {
		tlhmapper.addTLeaseHoliday(tlh);
	}

	@Override
	public List<TLeaseHoliday> findAll() {
		List<TLeaseHoliday> list = tlhmapper.findAll();
		return list;
	}

	@Override
	public void deleteById(String id) {
		tlhmapper.deleteById(id);
	}
}