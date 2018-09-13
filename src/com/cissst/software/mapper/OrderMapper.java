package com.cissst.software.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cissst.software.model.Order;

public interface OrderMapper {

	/**
	 * ��Ӷ�����Ϣ
	 * @param order
	 */
	void addOrder(Order order);

	/**
	 * ����idɾ��������Ϣ
	 * @param id
	 */
	void deleteOrderById(String id);

	/**
	 * ��ѯ���ж�����Ϣ
	 * @return
	 */
	List<Order> findAll();
	
	/**
	 * ��ѯ��������
	 * @return
	 */
	int findOrderQuantity();

	/**
	 * ��ҳ��ѯ������Ϣ
	 * @param offset
	 * @param length
	 * @return
	 */
	List<Order> findOrderPages(@Param(value="offset") int offset,@Param(value="length") int length);
	
	/**
	 * ����id��ѯ������Ϣ
	 * @param id
	 * @return
	 */
	Order findOrderById(String id);

	/**
	 * ����id���¶�����Ϣ
	 * @param id
	 */
	void updateOrderById(String id);

	List MonthByYear(String year);
}
