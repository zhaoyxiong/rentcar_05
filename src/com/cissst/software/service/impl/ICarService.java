package com.cissst.software.service.impl;

import java.util.List;

import com.cissst.software.model.Car;

public interface ICarService {
	
	public void addCar(Car car);
	
	/**
	 * 查询用户全部信息
	 * @return
	 */
	public List<Car> findAll();
	
	/**
	 * 多表之间的联合查询(多对一)
	 * @return
	 */
	public List<Car> findAllTables();
	
	public void deleteCar(String carid);
	
	public void updateCar(Car car);
	
	public Car findById(String carid);
	
	public String findBrandName(String id);
}
