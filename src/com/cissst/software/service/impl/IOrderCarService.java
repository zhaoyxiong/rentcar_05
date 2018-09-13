package com.cissst.software.service.impl;

import java.util.List;

import com.cissst.software.model.OrderCar;

/**
 * 业务逻辑层
 * @author fengy
 *
 */
public interface IOrderCarService {

	/**
	 * 添加订单_车辆信息
	 * @param orderCar
	 */
	public void addOrderCar(OrderCar orderCar);
	
	/**
	 * 根据id删除订单_车辆信息
	 * @param id
	 */
	public void deleteOrderCarById(String id);
	
	/**
	 * 根据order_no删除一个订单的所有订单_车辆信息
	 * @param order_no
	 */
	public void deleteOrderCarByOrderNo(String order_no);
	
	/**
	 * 根据order_no查询一个订单的所有订单_车辆信息
	 * @return
	 */
	public List<OrderCar> findOrderCarByOrderNo(String order_no);
	
	/**
	 * 根据订单id查询订单_车辆信息
	 * @param id
	 * @return
	 */
	public OrderCar findOrderCarById(String id);
	
	/**
	 * 根据id更新订单_车辆信息
	 * @param orderCar
	 */
	public void updateOrderCarById(OrderCar orderCar);
	
}
