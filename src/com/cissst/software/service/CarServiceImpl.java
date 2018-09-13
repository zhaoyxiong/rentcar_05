package com.cissst.software.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cissst.software.mapper.CarMapper;
import com.cissst.software.model.Car;
import com.cissst.software.service.impl.ICarService;

@Service
public class CarServiceImpl implements ICarService {
	
	@Autowired
	private CarMapper carmapper;
	
	@Transactional
	@Override
	public void addCar(Car car) {
		carmapper.addCar(car);
	}

	@Override
	public List<Car> findAll() {		
		return carmapper.findAll();
	}

	@Override
	public List<Car> findAllTables() {
		
		return carmapper.findAllTables();
	}
	@Override
	public void deleteCar(String carid){
		carmapper.deleteCar(carid);
	}
	@Override
	public void updateCar(Car car){
		carmapper.updateCar(car);
	}
	@Override
	public Car findById(String carid){
		return carmapper.findById(carid);
	}

	@Override
	public String findBrandName(String id) {
		return carmapper.findBrandName(id);
	}
}
