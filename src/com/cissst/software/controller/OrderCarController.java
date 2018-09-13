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
	 * 根据order_no查询订单_车辆信息
	 * @param order_no
	 * @return
	 */
	@RequestMapping("/findOrderCarByOrderNo/{id}")
	public String findOrderCarByOrderNo(@PathVariable String id,Model model){
		//根据id查询订单表中订单信息
		Order order = orderService.findOrderById(id);
		model.addAttribute("order", order);
		//根据id从订单表中获取order_no
		String order_no = order.getOrder_no();
		//根据order_no查询订单_车辆表中此订单所有订单_车辆信息
		List<OrderCar> orderCars = orderCarService.findOrderCarByOrderNo(order_no);
		model.addAttribute("orderCars", orderCars);
		//根据member_id查询用户表中此订单用户信息
		
		
		return "forward:/myWebServer/order_details.jsp";
	}
}
