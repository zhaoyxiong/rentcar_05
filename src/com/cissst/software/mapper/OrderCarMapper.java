package com.cissst.software.mapper;

import java.util.List;

import com.cissst.software.model.OrderCar;

public interface OrderCarMapper {

	/**
	 * ��Ӷ���_������Ϣ
	 * @param orderCar
	 */
	void addOrderCar(OrderCar orderCar);

	
	/**
	 * ����order_noɾ��һ�����������ж���_������Ϣ
	 * @param order_no
	 */
	void deleteOrderCarByOrderNo(String order_no);
	
	/**
	 * ����idɾ������_������Ϣ
	 * @param id
	 */
	void deleteOrderCarById(String id);

	/**
	 * ����order_no��ѯһ�����������ж���_������Ϣ
	 * @param order_no
	 * @return
	 */
	List<OrderCar> findOrderCarByOrderNo(String order_no);
	
	
	/**
	 * ����id��ѯ����_������Ϣ
	 * @param id
	 * @return
	 */
	OrderCar findOrderCarById(String id);

	/**
	 * ����id���¶���_������Ϣ
	 * @param orderCar
	 */
	void updateOrderCarById(OrderCar orderCar);

}
