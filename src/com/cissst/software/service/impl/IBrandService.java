package com.cissst.software.service.impl;

import java.util.List;

import com.cissst.software.model.Brand;


/**
 * 业务逻辑层
 * @author Administrator
 *
 */
public interface IBrandService {
	
	/**
	 * 添加品牌信息
	 * @param Brand
	 */
	public void addBrand(Brand brand);
	
	/**
	 * 根据品牌编号查询品牌信息
	 * @param id
	 * @return
	 */
	public Brand findBrandById(String id);
	
	/**
	 * 根据品牌编号修改品牌信息
	 * @param Brand
	 */
	public void updateBrand(Brand brand);
	
	/**
	 * 根据品牌编号删除品牌信息
	 * @param id
	 */
	public void deleteById(String id);
	
	/**
	 * 查询全部品牌信息
	 * @return
	 */
	public List<Brand> findAll();
	
	/**
	 * 根据brand_code查询brand
	 * @param brand_code
	 * @return
	 */
	public Brand findBrandByBrandCode(String brand_code);
}
