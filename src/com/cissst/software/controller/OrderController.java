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
 * ǰ�˿�������--ʵ�ֶ�����Ϣ����
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
	 * ���Ӷ�����Ϣ
	 * @param order
	 * @return
	 */
	@RequestMapping("/add")
	public String addOrder(Order order){
		
		return null;
	}
	
	
	/**
	 * ��ѯȫ��������Ϣ
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
	 * ��ҳ��ѯ������Ϣ
	 * @param page_no
	 * @param model
	 * @return
	 */
	@RequestMapping("/findOrderPages/{page_no}")
	public String findOrderPages(@PathVariable int page_no,Model model) {
		
		//��������
		int orderQuantity = orderService.findOrderQuantity();
		//����ҳ��
		int pageQuantity = orderQuantity/10 + 1;
		//���һҳ��������
		int lastPageOrderQuantity = orderQuantity%10;
		//��Ϊ���һҳ��length����ΪlastPageOrderQuantity,����length����Ϊ10
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
	 * ����id���¶�����Ϣ
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateInput/{id}")
	public String updateInput(@PathVariable String id,Model model){
		return null;
	}
	/**
	 * ���¶�����Ϣ
	 * @param order
	 * @return
	 */
	@RequestMapping("/update")
	public String update(Order order){
		return null;
	}
	
	/**
	 * ����idɾ��ϵ����Ϣ
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById/{id}")
	public String deleteById(@PathVariable String id){
		return null;
	}
	
}
