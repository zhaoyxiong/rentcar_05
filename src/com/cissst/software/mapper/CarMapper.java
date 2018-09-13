package com.cissst.software.mapper;

import java.util.List;

import com.cissst.software.model.Car;

public interface CarMapper {

	public void addCar(Car car);
	
	public List<Car> findAll();
	
	/**
	 * 多表之间的联合查询
	 * @return
	 */
	public List<Car> findAllTables();
	
	public void deleteCar(String carid);
	
	public void updateCar(Car car);
	
	public Car findById(String carid);
	
	public String findBrandName(String id);
}
