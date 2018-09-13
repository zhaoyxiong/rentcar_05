package com.cissst.software.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cissst.software.mapper.CompanyMapper;
import com.cissst.software.model.Company;
import com.cissst.software.service.impl.ICompany;
@Service
public class CompanyServiceImpl implements ICompany {

	@Autowired
	private CompanyMapper companymapper;
	
	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return companymapper.findAll();
	}
	@Transactional
	@Override
	public void addCompany(Company company) {
		// TODO Auto-generated method stub
		 companymapper.addCompany(company);
	}
	@Transactional
	@Override
	public void updateCompany(Company company) {
		// TODO Auto-generated method stub
		 companymapper.updateCompany(company);
	}
	@Transactional
	@Override
	public void deleteCompanyByID(String id) {
		// TODO Auto-generated method stub
		 companymapper.deleteCompanyByID(id);
	}

}
