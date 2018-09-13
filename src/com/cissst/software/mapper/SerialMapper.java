package com.cissst.software.mapper;

import java.util.List;

import com.cissst.software.model.Serial;

public interface SerialMapper {

	/**
	 * ���ϵ����Ϣ
	 * @param serial
	 */
	void addSerial(Serial serial);

	/**
	 * ����id��ѯϵ����Ϣ
	 * @param id
	 * @return
	 */
	Serial findSerialById(String id);

	/**
	 * �޸�ϵ����Ϣ
	 * @param serial
	 */
	void updateSerial(Serial serial);

	/**
	 * ����idɾ��ϵ����Ϣ
	 * @param id
	 */
	void deleteById(String id);

	/**
	 * ��ѯ����ϵ����Ϣ
	 * @return
	 */
	List<Serial> findAll();

}
