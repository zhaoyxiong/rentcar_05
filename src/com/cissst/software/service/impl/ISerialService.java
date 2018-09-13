package com.cissst.software.service.impl;

import java.util.List;

import com.cissst.software.model.Serial;

public interface ISerialService {

	/**
	 * ���ϵ����Ϣ
	 * @param Serial
	 */
	public void addSerial(Serial serial);
	
	/**
	 * ����ϵ�б�Ų�ѯϵ����Ϣ
	 * @param id
	 * @return
	 */
	public Serial findSerialById(String id);
	
	/**
	 * ����ϵ�б���޸�ϵ����Ϣ
	 * @param Serial
	 */
	public void updateSerial(Serial serial);
	
	/**
	 * ����ϵ�б��ɾ��ϵ����Ϣ
	 * @param id
	 */
	public void deleteById(String id);
	
	/**
	 * ��ѯȫ��ϵ����Ϣ
	 * @return
	 */
	public List<Serial> findAll();
}
