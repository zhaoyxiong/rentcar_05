package com.cissst.software.service.impl;

import java.util.List;

import com.cissst.software.model.Brand;


/**
 * ҵ���߼���
 * @author Administrator
 *
 */
public interface IBrandService {
	
	/**
	 * ���Ʒ����Ϣ
	 * @param Brand
	 */
	public void addBrand(Brand brand);
	
	/**
	 * ����Ʒ�Ʊ�Ų�ѯƷ����Ϣ
	 * @param id
	 * @return
	 */
	public Brand findBrandById(String id);
	
	/**
	 * ����Ʒ�Ʊ���޸�Ʒ����Ϣ
	 * @param Brand
	 */
	public void updateBrand(Brand brand);
	
	/**
	 * ����Ʒ�Ʊ��ɾ��Ʒ����Ϣ
	 * @param id
	 */
	public void deleteById(String id);
	
	/**
	 * ��ѯȫ��Ʒ����Ϣ
	 * @return
	 */
	public List<Brand> findAll();
	
	/**
	 * ����brand_code��ѯbrand
	 * @param brand_code
	 * @return
	 */
	public Brand findBrandByBrandCode(String brand_code);
}
