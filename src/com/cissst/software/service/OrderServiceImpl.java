package com.cissst.software.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.mapper.OrderMapper;
import com.cissst.software.model.MonthSale;
import com.cissst.software.model.Order;
import com.cissst.software.service.impl.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	public OrderServiceImpl() {
	}

	/**
	 * 添加订单信息
	 */
	@Override
	public void addOrder(Order order) {
		orderMapper.addOrder(order);
	}

	/**
	 * 根据id删除订单信息
	 */
	@Override
	public void deleteOrderById(String id) {
		orderMapper.deleteOrderById(id);
	}
	
	/**
	 * 查询所有订单信息
	 */
	@Override
	public List<Order> findAll() {
		return orderMapper.findAll();
	}

	/**
	 * 根据id查询订单信息
	 */
	@Override
	public Order findOrderById(String id) {
		return orderMapper.findOrderById(id);
	}

	/**
	 * 根据id更新订单信息
	 */
	@Override
	public void updateOrderById(String id) {
		orderMapper.updateOrderById(id);
	}

	/**
	 * 分页查询订单信息
	 */
	@Override
	public List<Order> findOrderPages(int offset, int length) {
		return orderMapper.findOrderPages(offset, length);
	}

	/**
	 * 查询订单条数
	 */
	@Override
	public int findOrderQuantity() {
		return orderMapper.findOrderQuantity();
	}

	@Override
	public List<MonthSale> MonthByYear(String year) {
		// TODO Auto-generated method stub
		return null;
	}

}
