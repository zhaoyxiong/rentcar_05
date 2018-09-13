package com.cissst.software.service.impl;

import java.util.List;

import com.cissst.software.model.Company;

public interface ICompany {
	
	public List<Company> findAll();
	
	//添加公司信息
	public void addCompany(Company company);
	
	//更改公司信息
	public void updateCompany(Company company);
	//删除公司
	public void deleteCompanyByID(String id);
}
