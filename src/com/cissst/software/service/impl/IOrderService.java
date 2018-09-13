package com.cissst.software.service.impl;

import java.util.List;

import com.cissst.software.model.MonthSale;
import com.cissst.software.model.Order;

/**
 * ҵ���߼���
 * @author fengy
 *
 */
public interface IOrderService {

	/**
	 * ��Ӷ�����Ϣ
	 * @param order
	 */
	public void addOrder(Order order);
	
	/**
	 * ����idɾ��������Ϣ
	 * @param id
	 */
	public void deleteOrderById(String id);
	
	/**
	 * ��ѯ���ж�����Ϣ
	 * @return
	 */
	public List<Order> findAll();
	
	/**
	 * ���ݶ���id��ѯ������Ϣ
	 * @param id
	 * @return
	 */
	public Order findOrderById(String id);
	
	/**
	 * ����id���¶�����Ϣ
	 * @param id
	 */
	public void updateOrderById(String id);
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	public int findOrderQuantity();
	
	/**
	 * ��ҳ��ѯ������Ϣ
	 * @param offset
	 * @param length
	 * @return
	 */
	public List<Order> findOrderPages(int offset,int length);
	
	public List<MonthSale> MonthByYear(String year);
	
}
