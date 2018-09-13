package com.cissst.software.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cissst.software.model.TLeaseHoliday;
import com.cissst.software.model.TMember;
import com.cissst.software.service.impl.ITLeaseHolidayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 前端控制器层--实现用户信息操作--需要实现Service对象,并调用其方法
 * @author 应雄
 */
@Controller
@RequestMapping(value="/TLeaseHoliday")
public class TLeaseHolidayController {

	Logger log = Logger.getLogger(TLeaseHolidayController.class);
	@Autowired
	private ITLeaseHolidayService itlhs;
	
	@RequestMapping(value="/addTLeaseHoliday")
	public String addTLeaseHoliday(TLeaseHoliday tlh,HttpServletRequest request){
		String holidayDate = request.getParameter("holiday");
		//设置date类型属性
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-DD");
		Date date = null;
		try {
			date = sf.parse(holidayDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dateStr = sf.format(date);
		java.sql.Date holiday = java.sql.Date.valueOf(dateStr);
		tlh.setHoliday(holiday);
		//设置Holiday_Type类型
		String holiday_type = request.getParameter("HolidayType");
		tlh.setHoliday_type(Integer.parseInt(holiday_type));
		//设置lease_id属性
		String id = UUID.randomUUID().toString().trim().replaceAll("-", "");
		tlh.setId(id);
		log.debug("The object is " + tlh);
		itlhs.addTLeaseHoliday(tlh);
		return "redirect:/myWebServer/findAll.do";
	};

	@RequestMapping(value="/findAll")
	public String findAll(@RequestParam(required=false,defaultValue="1",value="pn") int pn,
			Model model){
		PageHelper.startPage(pn, 10);
		List<TLeaseHoliday> list = itlhs.findAll();
		PageInfo<TLeaseHoliday> pageInfo = new PageInfo<>(list,5);
		model.addAttribute("holiday_list", pageInfo);
		return "forward:/myWebServer/rent_car_festival_list.jsp";
	};

	/*
	 * @RequestBody表示接收的值不是普通的key=value字符串，而是json字符串
	 * @ResponseBody表示返回为json字符串
	 */
	@RequestMapping(value="/deleteById")
	public String deleteById(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		itlhs.deleteById(id);
		/*response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().println("ok");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return "redirect:/TLeaseHoliday/findAll.do";
	};
	/*@RequestMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id,HttpServletResponse response){
		itlhs.deleteById(id);
		try {
			PrintWriter out = response.getWriter();
			out.println("ok");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/TLeaseHoliday/findAll.do";
	}*/
}