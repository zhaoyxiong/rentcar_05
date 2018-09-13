package com.cissst.software.mapper;

import java.util.List;

import com.cissst.software.model.TMember;

public interface TMemberMapper {

	/**
	 * 添加对象
	 * @param tm
	 */
	public void addTMember(TMember tm);
	
	/**
	 * 根据id删除用户
	 * @param id
	 */
	public void deleteById(String id);
	
	/**
	 * 根据用户编号修改用户信息
	 * @param user
	 */
	public void updateTMember(TMember tm);
	
	/**
	 * 查询全部用户
	 * @return
	 */
	public List<TMember> findAll();
	
	/**
	 * 根据用户编号查询用户信息
	 * @param userid
	 * @return
	 */
	public TMember findTMemberById(String id);

}
