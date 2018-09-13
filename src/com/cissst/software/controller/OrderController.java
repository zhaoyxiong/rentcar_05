package com.cissst.software.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cissst.software.model.Order;
import com.cissst.software.service.impl.IOrderNewService;

/**
 * 前端控制器层--实现订单信息操作
 * @author fengy
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private IOrderNewService orderService;
	
	public OrderController() {
	
	}

	/**
	 * 增加订单信息
	 * @param order
	 * @return
	 */
	@RequestMapping("/add")
	public String addOrder(Order order){
		
		return null;
	}
	
	
	/**
	 * 查询全部订单信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/findall")
	public String findAll(Model model){	
		List<Order> orders = orderService.findAll();
		model.addAttribute("orders", orders);
		return "forward:/myWebServer/order_list.jsp";
	}
	
	/**
	 * 分页查询订单信息
	 * @param page_no
	 * @param model
	 * @return
	 */
	@RequestMapping("/findOrderPages/{page_no}")
	public String findOrderPages(@PathVariable int page_no,Model model) {
		
		//订单条数
		int orderQuantity = orderService.findOrderQuantity();
		//订单页数
		int pageQuantity = orderQuantity/10 + 1;
		//最后一页订单条数
		int lastPageOrderQuantity = orderQuantity%10;
		//若为最后一页，length设置为lastPageOrderQuantity,否则length设置为10
		int length = 0;
		if(page_no == pageQuantity) {
			length = lastPageOrderQuantity;
		}
		else {
			length = 10;
		}
		List<Order> orders = orderService.findOrderPages((page_no-1)*10, length);
		model.addAttribute("orders", orders);
		model.addAttribute("pageQuantity",pageQuantity);
		model.addAttribute("page_no",page_no);
		return "forward:/myWebServer/order_list.jsp";
	}
	
	/**
	 * 根据id更新订单信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateInput/{id}")
	public String updateInput(@PathVariable String id,Model model){
		return null;
	}
	/**
	 * 更新订单信息
	 * @param order
	 * @return
	 */
	@RequestMapping("/update")
	public String update(Order order){
		return null;
	}
	
	/**
	 * 根据id删除系列信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById/{id}")
	public String deleteById(@PathVariable String id){
		return null;
	}
	
}
