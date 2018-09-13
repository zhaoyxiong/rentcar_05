package com.cissst.software.mapper;

import java.util.List;

import com.cissst.software.model.Brand;

public interface BrandMapper {

	/**
	 * 添加品牌信息
	 * @param brand
	 */
	void addBrand(Brand brand);

	/**
	 * 根据id查询品牌信息
	 * @param id
	 * @return
	 */
	Brand findBrandById(String id);

	/**
	 * 更新品牌信息
	 * @param brand
	 */
	void updateBrand(Brand brand);

	/**
	 * 根据id删除品牌信息
	 * @param id
	 */
	void deleteById(String id);

	/**
	 * 查询全部的品牌信息
	 * @return
	 */
	List<Brand> findAll();

	/**
	 * 根据brand_code查询brand
	 * @return
	 */
	Brand findBrandByBrandCode(String brand_code);
}
