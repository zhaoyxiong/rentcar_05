package com.cissst.software.service.impl;

import java.util.List;

import com.cissst.software.model.Serial;

public interface ISerialService {

	/**
	 * 添加系列信息
	 * @param Serial
	 */
	public void addSerial(Serial serial);
	
	/**
	 * 根据系列编号查询系列信息
	 * @param id
	 * @return
	 */
	public Serial findSerialById(String id);
	
	/**
	 * 根据系列编号修改系列信息
	 * @param Serial
	 */
	public void updateSerial(Serial serial);
	
	/**
	 * 根据系列编号删除系列信息
	 * @param id
	 */
	public void deleteById(String id);
	
	/**
	 * 查询全部系列信息
	 * @return
	 */
	public List<Serial> findAll();
}
