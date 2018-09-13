package com.cissst.software.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.mapper.BrandMapper;
import com.cissst.software.model.Brand;
import com.cissst.software.service.impl.IBrandService;

@Service
public class BrandServiceImpl implements IBrandService {

	@Autowired
	private BrandMapper brandmapper;
	
	@Override
	public void addBrand(Brand brand) {
		brandmapper.addBrand(brand);
	}
	
	@Override
	public Brand findBrandById(String id) {
		return brandmapper.findBrandById(id);
	}

	@Override
	public void updateBrand(Brand brand) {
		brandmapper.updateBrand(brand);
	}

	@Override
	public void deleteById(String id) {
		brandmapper.deleteById(id);
	}

	@Override
	public List<Brand> findAll() {
		return brandmapper.findAll();
	}

	@Override
	public Brand findBrandByBrandCode(String brand_code) {
		// TODO Auto-generated method stub
		return brandmapper.findBrandByBrandCode(brand_code);
	}
}
