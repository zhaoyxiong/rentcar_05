package com.cissst.software.service.impl;

import java.util.List;

import com.cissst.software.model.MonthSale;
import com.cissst.software.model.Order;

/**
 * 业务逻辑层
 * @author fengy
 *
 */
public interface IOrderService {

	/**
	 * 添加订单信息
	 * @param order
	 */
	public void addOrder(Order order);
	
	/**
	 * 根据id删除订单信息
	 * @param id
	 */
	public void deleteOrderById(String id);
	
	/**
	 * 查询所有订单信息
	 * @return
	 */
	public List<Order> findAll();
	
	/**
	 * 根据订单id查询订单信息
	 * @param id
	 * @return
	 */
	public Order findOrderById(String id);
	
	/**
	 * 根据id更新订单信息
	 * @param id
	 */
	public void updateOrderById(String id);
	
	/**
	 * 查询订单条数
	 * @return
	 */
	public int findOrderQuantity();
	
	/**
	 * 分页查询订单信息
	 * @param offset
	 * @param length
	 * @return
	 */
	public List<Order> findOrderPages(int offset,int length);
	
	public List<MonthSale> MonthByYear(String year);
	
}
