package com.cissst.software.service.impl;

import java.util.List;

import com.cissst.software.model.Car;

public interface ICarService {
	
	public void addCar(Car car);
	
	/**
	 * ��ѯ�û�ȫ����Ϣ
	 * @return
	 */
	public List<Car> findAll();
	
	/**
	 * ���֮������ϲ�ѯ(���һ)
	 * @return
	 */
	public List<Car> findAllTables();
	
	public void deleteCar(String carid);
	
	public void updateCar(Car car);
	
	public Car findById(String carid);
	
	public String findBrandName(String id);
}
