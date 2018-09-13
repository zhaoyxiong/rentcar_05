package com.cissst.software.mapper;

import java.util.List;

import com.cissst.software.model.TMember;

public interface TMemberMapper {

	/**
	 * ��Ӷ���
	 * @param tm
	 */
	public void addTMember(TMember tm);
	
	/**
	 * ����idɾ���û�
	 * @param id
	 */
	public void deleteById(String id);
	
	/**
	 * �����û�����޸��û���Ϣ
	 * @param user
	 */
	public void updateTMember(TMember tm);
	
	/**
	 * ��ѯȫ���û�
	 * @return
	 */
	public List<TMember> findAll();
	
	/**
	 * �����û���Ų�ѯ�û���Ϣ
	 * @param userid
	 * @return
	 */
	public TMember findTMemberById(String id);

}
