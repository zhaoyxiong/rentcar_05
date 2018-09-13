package com.cissst.software.mapper;

import java.util.List;

import com.cissst.software.model.Serial;

public interface SerialMapper {

	/**
	 * 添加系列信息
	 * @param serial
	 */
	void addSerial(Serial serial);

	/**
	 * 根据id查询系列信息
	 * @param id
	 * @return
	 */
	Serial findSerialById(String id);

	/**
	 * 修改系列信息
	 * @param serial
	 */
	void updateSerial(Serial serial);

	/**
	 * 根据id删除系列信息
	 * @param id
	 */
	void deleteById(String id);

	/**
	 * 查询所有系列信息
	 * @return
	 */
	List<Serial> findAll();

}
