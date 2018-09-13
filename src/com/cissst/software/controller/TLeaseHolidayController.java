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
 * ǰ�˿�������--ʵ���û���Ϣ����--��Ҫʵ��Service����,�������䷽��
 * @author Ӧ��
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
		//����date��������
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
		//����Holiday_Type����
		String holiday_type = request.getParameter("HolidayType");
		tlh.setHoliday_type(Integer.parseInt(holiday_type));
		//����lease_id����
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
	 * @RequestBody��ʾ���յ�ֵ������ͨ��key=value�ַ���������json�ַ���
	 * @ResponseBody��ʾ����Ϊjson�ַ���
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