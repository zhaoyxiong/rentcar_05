package com.cissst.software.mapper;

import java.util.List;

import com.cissst.software.model.Brand;

public interface BrandMapper {

	/**
	 * ���Ʒ����Ϣ
	 * @param brand
	 */
	void addBrand(Brand brand);

	/**
	 * ����id��ѯƷ����Ϣ
	 * @param id
	 * @return
	 */
	Brand findBrandById(String id);

	/**
	 * ����Ʒ����Ϣ
	 * @param brand
	 */
	void updateBrand(Brand brand);

	/**
	 * ����idɾ��Ʒ����Ϣ
	 * @param id
	 */
	void deleteById(String id);

	/**
	 * ��ѯȫ����Ʒ����Ϣ
	 * @return
	 */
	List<Brand> findAll();

	/**
	 * ����brand_code��ѯbrand
	 * @return
	 */
	Brand findBrandByBrandCode(String brand_code);
}
