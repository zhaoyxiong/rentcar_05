package com.cissst.software.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cissst.software.model.Order;
import com.cissst.software.model.OrderCar;
import com.cissst.software.service.impl.IOrderCarService;
import com.cissst.software.service.impl.IOrderService;

@Controller
@RequestMapping("/ordercar")
public class OrderCarController {

	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IOrderCarService orderCarService;

	
	public OrderCarController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ����order_no��ѯ����_������Ϣ
	 * @param order_no
	 * @return
	 */
	@RequestMapping("/findOrderCarByOrderNo/{id}")
	public String findOrderCarByOrderNo(@PathVariable String id,Model model){
		//����id��ѯ�������ж�����Ϣ
		Order order = orderService.findOrderById(id);
		model.addAttribute("order", order);
		//����id�Ӷ������л�ȡorder_no
		String order_no = order.getOrder_no();
		//����order_no��ѯ����_�������д˶������ж���_������Ϣ
		List<OrderCar> orderCars = orderCarService.findOrderCarByOrderNo(order_no);
		model.addAttribute("orderCars", orderCars);
		//����member_id��ѯ�û����д˶����û���Ϣ
		
		
		return "forward:/myWebServer/order_details.jsp";
	}
}
