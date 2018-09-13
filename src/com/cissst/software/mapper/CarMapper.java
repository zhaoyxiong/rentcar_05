package com.cissst.software.mapper;

import java.util.List;

import com.cissst.software.model.Car;

public interface CarMapper {

	public void addCar(Car car);
	
	public List<Car> findAll();
	
	/**
	 * ���֮������ϲ�ѯ
	 * @return
	 */
	public List<Car> findAllTables();
	
	public void deleteCar(String carid);
	
	public void updateCar(Car car);
	
	public Car findById(String carid);
	
	public String findBrandName(String id);
}
