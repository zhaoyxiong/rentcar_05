package com.cissst.software.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cissst.software.model.Order;

public interface OrderMapper {

	/**
	 * 添加订单信息
	 * @param order
	 */
	void addOrder(Order order);

	/**
	 * 根据id删除订单信息
	 * @param id
	 */
	void deleteOrderById(String id);

	/**
	 * 查询所有订单信息
	 * @return
	 */
	List<Order> findAll();
	
	/**
	 * 查询订单条数
	 * @return
	 */
	int findOrderQuantity();

	/**
	 * 分页查询订单信息
	 * @param offset
	 * @param length
	 * @return
	 */
	List<Order> findOrderPages(@Param(value="offset") int offset,@Param(value="length") int length);
	
	/**
	 * 根据id查询订单信息
	 * @param id
	 * @return
	 */
	Order findOrderById(String id);

	/**
	 * 根据id更新订单信息
	 * @param id
	 */
	void updateOrderById(String id);

	List MonthByYear(String year);
}
