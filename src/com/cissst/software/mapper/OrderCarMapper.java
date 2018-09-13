package com.cissst.software.mapper;

import java.util.List;

import com.cissst.software.model.OrderCar;

public interface OrderCarMapper {

	/**
	 * 添加订单_车辆信息
	 * @param orderCar
	 */
	void addOrderCar(OrderCar orderCar);

	
	/**
	 * 根据order_no删除一个订单的所有订单_车辆信息
	 * @param order_no
	 */
	void deleteOrderCarByOrderNo(String order_no);
	
	/**
	 * 根据id删除订单_车辆信息
	 * @param id
	 */
	void deleteOrderCarById(String id);

	/**
	 * 根据order_no查询一个订单的所有订单_车辆信息
	 * @param order_no
	 * @return
	 */
	List<OrderCar> findOrderCarByOrderNo(String order_no);
	
	
	/**
	 * 根据id查询订单_车辆信息
	 * @param id
	 * @return
	 */
	OrderCar findOrderCarById(String id);

	/**
	 * 根据id更新订单_车辆信息
	 * @param orderCar
	 */
	void updateOrderCarById(OrderCar orderCar);

}
