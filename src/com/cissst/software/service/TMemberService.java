package com.cissst.software.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cissst.software.mapper.TMemberMapper;
import com.cissst.software.model.TMember;
import com.cissst.software.service.impl.ITMemberService;

@Service
public class TMemberService implements ITMemberService{

	@Autowired
	private TMemberMapper tMemberMapper;
	
	@Transactional
	@Override
	public void addTMember(TMember tm) {
		tMemberMapper.addTMember(tm);
	}

	@Override
	public void deleteById(String id) {
		tMemberMapper.deleteById(id);
	}

	@Override
	public void updateTMember(TMember tm) {
		tMemberMapper.updateTMember(tm);
	}

	@Override
	public List<TMember> findAll() {
		List<TMember> list = tMemberMapper.findAll();
		return list;
	}

	@Override
	public TMember findTMemberById(String id) {
		TMember tMember = tMemberMapper.findTMemberById(id);
		return tMember;
	}
}