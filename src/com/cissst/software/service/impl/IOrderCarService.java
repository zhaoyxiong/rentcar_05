package com.cissst.software.service.impl;

import java.util.List;

import com.cissst.software.model.OrderCar;

/**
 * ҵ���߼���
 * @author fengy
 *
 */
public interface IOrderCarService {

	/**
	 * ��Ӷ���_������Ϣ
	 * @param orderCar
	 */
	public void addOrderCar(OrderCar orderCar);
	
	/**
	 * ����idɾ������_������Ϣ
	 * @param id
	 */
	public void deleteOrderCarById(String id);
	
	/**
	 * ����order_noɾ��һ�����������ж���_������Ϣ
	 * @param order_no
	 */
	public void deleteOrderCarByOrderNo(String order_no);
	
	/**
	 * ����order_no��ѯһ�����������ж���_������Ϣ
	 * @return
	 */
	public List<OrderCar> findOrderCarByOrderNo(String order_no);
	
	/**
	 * ���ݶ���id��ѯ����_������Ϣ
	 * @param id
	 * @return
	 */
	public OrderCar findOrderCarById(String id);
	
	/**
	 * ����id���¶���_������Ϣ
	 * @param orderCar
	 */
	public void updateOrderCarById(OrderCar orderCar);
	
}
