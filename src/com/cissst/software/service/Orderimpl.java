package com.cissst.software.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.mapper.OrderMapper;
import com.cissst.software.model.Order;
import com.cissst.software.service.impl.IOrderNewService;

@Service
public class Orderimpl implements IOrderNewService {
	@Autowired
	private OrderMapper mapper;
	
	@Override
	public List MonthByYear(String year) {
		return mapper.MonthByYear(year);
		
	}
	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteOrderById(String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Order findOrderById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateOrderById(String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int findOrderQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Order> findOrderPages(int offset, int length) {
		// TODO Auto-generated method stub
		return null;
	}


}
