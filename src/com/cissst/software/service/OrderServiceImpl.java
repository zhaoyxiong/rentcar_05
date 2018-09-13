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
	 * ��Ӷ�����Ϣ
	 */
	@Override
	public void addOrder(Order order) {
		orderMapper.addOrder(order);
	}

	/**
	 * ����idɾ��������Ϣ
	 */
	@Override
	public void deleteOrderById(String id) {
		orderMapper.deleteOrderById(id);
	}
	
	/**
	 * ��ѯ���ж�����Ϣ
	 */
	@Override
	public List<Order> findAll() {
		return orderMapper.findAll();
	}

	/**
	 * ����id��ѯ������Ϣ
	 */
	@Override
	public Order findOrderById(String id) {
		return orderMapper.findOrderById(id);
	}

	/**
	 * ����id���¶�����Ϣ
	 */
	@Override
	public void updateOrderById(String id) {
		orderMapper.updateOrderById(id);
	}

	/**
	 * ��ҳ��ѯ������Ϣ
	 */
	@Override
	public List<Order> findOrderPages(int offset, int length) {
		return orderMapper.findOrderPages(offset, length);
	}

	/**
	 * ��ѯ��������
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
