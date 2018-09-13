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
	 * ���ϵ����Ϣ
	 */
	@Override
	public void addSerial(Serial serial) {
		serialmapper.addSerial(serial);
	}

	/**
	 * ����id��ѯϵ����Ϣ
	 */
	@Override
	public Serial findSerialById(String id) {
		return serialmapper.findSerialById(id);
	}

	/**
	 * ����ϵ����Ϣ
	 */
	@Override
	public void updateSerial(Serial serial) {
		serialmapper.updateSerial(serial);
	}

	/**
	 * ����idɾ��ϵ����Ϣ
	 */
	@Override
	public void deleteById(String id) {
		serialmapper.deleteById(id);
	}

	/**
	 * ��ѯ����ϵ����Ϣ
	 */
	@Override
	public List<Serial> findAll() {
		return serialmapper.findAll();
	}

}
