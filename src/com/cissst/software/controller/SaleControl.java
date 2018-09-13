package com.cissst.software.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cissst.software.model.MonthSale;
import com.cissst.software.service.impl.IOrderNewService;
import com.cissst.software.service.impl.IOrderService;

@Controller
@RequestMapping("/sale")
public class SaleControl {

	@Autowired
	private IOrderNewService order;

	@RequestMapping("/byday.do")
	public void getSale(String year, HttpServletResponse response) throws IOException {
		List<MonthSale> list = order.MonthByYear(year);
		String toUser = "";
		for (MonthSale monthSale : list) {
			toUser += monthSale.getMonths() + "-" + monthSale.getSale() + ",";
		}
		// List<Order> list=order.findAll("-01-");
		// Double m1=order.findAll("-01-");
		// Double m2=order.findAll("-02-");
		// Double m3=order.findAll("-03-");
		// Double m4=order.findAll("-04-");
		// Double m5=order.findAll("-05-");
		// Double m6=order.findAll("-06-");
		// Double m7=order.findAll("-07-");
		// Double m8=order.findAll("-08-");
		// Double m9=order.findAll("-09-");
		// Double m10=order.findAll("-10-");
		// Double m11=order.findAll("-11-");
		// Double m12=order.findAll("-12-");

		// System.out.println(d+"***********************************************************");
		// System.out.println(count(list));
		// for (Order order : list) {
		// System.out.println(changeDate(order.getCreate_time())+"-------------"+order.getPay_fee());
		// }
		response.getWriter().write(toUser);
		// response.getWriter().write(m1+","+m2+","+m3+","+m4+","+m5+","+m6+","+m7+","+m8+","+m9+","+m10+","+m11+","+m12);
	}

	public static String changeDate(Date date) {
		String dateString = " ";
		if (date != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dateString = formatter.format(date);
		}
		return dateString;

	}
}
