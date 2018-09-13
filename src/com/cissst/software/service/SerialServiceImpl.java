package com.cissst.software.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.mapper.SerialMapper;
import com.cissst.software.model.Serial;
import com.cissst.software.service.impl.ISerialService;

@Service
public class SerialServiceImpl implements ISerialService {

	@Autowired
	private SerialMapper serialmapper;
	
	public SerialServiceImpl() {
	}

	/**
	 * 添加系列信息
	 */
	@Override
	public void addSerial(Serial serial) {
		serialmapper.addSerial(serial);
	}

	/**
	 * 根据id查询系列信息
	 */
	@Override
	public Serial findSerialById(String id) {
		return serialmapper.findSerialById(id);
	}

	/**
	 * 更新系列信息
	 */
	@Override
	public void updateSerial(Serial serial) {
		serialmapper.updateSerial(serial);
	}

	/**
	 * 根据id删除系列信息
	 */
	@Override
	public void deleteById(String id) {
		serialmapper.deleteById(id);
	}

	/**
	 * 查询所有系列信息
	 */
	@Override
	public List<Serial> findAll() {
		return serialmapper.findAll();
	}

}
