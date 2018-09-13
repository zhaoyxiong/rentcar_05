package com.cissst.software.service.impl;

import java.util.List;

import com.cissst.software.model.Company;

public interface ICompany {
	
	public List<Company> findAll();
	
	//��ӹ�˾��Ϣ
	public void addCompany(Company company);
	
	//���Ĺ�˾��Ϣ
	public void updateCompany(Company company);
	//ɾ����˾
	public void deleteCompanyByID(String id);
}
