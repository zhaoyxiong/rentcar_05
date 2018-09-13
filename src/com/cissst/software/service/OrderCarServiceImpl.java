package com.cissst.software.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.mapper.OrderCarMapper;
import com.cissst.software.model.OrderCar;
import com.cissst.software.service.impl.IOrderCarService;

@Service
public class OrderCarServiceImpl implements IOrderCarService {

	@Autowired
	private OrderCarMapper orderCarMapper;
	
	public OrderCarServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 添加订单_车辆信息
	 */
	@Override
	public void addOrderCar(OrderCar orderCar) {
		orderCarMapper.addOrderCar(orderCar);
	}

	/**
	 * 根据id删除订单_车辆信息
	 */
	@Override
	public void deleteOrderCarById(String id) {
		orderCarMapper.deleteOrderCarById(id);
	}

	/**
	 * 根据order_no删除一个订单的所有订单_车辆信息
	 */
	@Override
	public void deleteOrderCarByOrderNo(String order_no) {
		orderCarMapper.deleteOrderCarByOrderNo(order_no);
	}

	/**
	 * 根据order_no删除一个订单的所有订单_车辆信息
	 */
	@Override
	public List<OrderCar> findOrderCarByOrderNo(String order_no) {
		return orderCarMapper.findOrderCarByOrderNo(order_no);
	}

	/**
	 * 根据id查询订单_车辆信息
	 */
	@Override
	public OrderCar findOrderCarById(String id) {
		return orderCarMapper.findOrderCarById(id);
	}

	/**
	 * 根据id修改订单_车辆信息
	 */
	@Override
	public void updateOrderCarById(OrderCar orderCar) {
		orderCarMapper.updateOrderCarById(orderCar);
	}

}
