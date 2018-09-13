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
	 * ��Ӷ���_������Ϣ
	 */
	@Override
	public void addOrderCar(OrderCar orderCar) {
		orderCarMapper.addOrderCar(orderCar);
	}

	/**
	 * ����idɾ������_������Ϣ
	 */
	@Override
	public void deleteOrderCarById(String id) {
		orderCarMapper.deleteOrderCarById(id);
	}

	/**
	 * ����order_noɾ��һ�����������ж���_������Ϣ
	 */
	@Override
	public void deleteOrderCarByOrderNo(String order_no) {
		orderCarMapper.deleteOrderCarByOrderNo(order_no);
	}

	/**
	 * ����order_noɾ��һ�����������ж���_������Ϣ
	 */
	@Override
	public List<OrderCar> findOrderCarByOrderNo(String order_no) {
		return orderCarMapper.findOrderCarByOrderNo(order_no);
	}

	/**
	 * ����id��ѯ����_������Ϣ
	 */
	@Override
	public OrderCar findOrderCarById(String id) {
		return orderCarMapper.findOrderCarById(id);
	}

	/**
	 * ����id�޸Ķ���_������Ϣ
	 */
	@Override
	public void updateOrderCarById(OrderCar orderCar) {
		orderCarMapper.updateOrderCarById(orderCar);
	}

}
