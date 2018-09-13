package com.cissst.software.controller;


import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cissst.software.model.Brand;
import com.cissst.software.model.Serial;
import com.cissst.software.service.impl.IBrandService;
import com.cissst.software.service.impl.ISerialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



/**
 * ǰ�˿�������--ʵ��ϵ�в���
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/serial")
public class SerialController {

	@Autowired
	private ISerialService serialService;
	@Autowired
	private IBrandService brandService;
	
	/**
	 * ����ϵ����Ϣ
	 * @param serial
	 * @return
	 */
	@RequestMapping("/add")
	public String addserial(Serial serial){
		//����32λ����ַ���id
		String id = UUID.randomUUID().toString().trim().replaceAll("-", "");
		serial.setId(id);
		serial.setCreate_date(new Date(System.currentTimeMillis()));
		serialService.addSerial(serial);
		return "redirect:/myWebServer/success.jsp";
	}
	
	
	/**
	 * ��ѯȫ��ϵ����Ϣ
	 * @param model
	 * @return
	 */
	@RequestMapping("/findall")
	public String findAll(@RequestParam(required=false,defaultValue="1",value="pn")int pn,
			Model model){	
		PageHelper.startPage(pn, 10);
		List<Serial> serials = serialService.findAll();
		PageInfo<Serial> pageInfo = new PageInfo<>(serials,5);
		model.addAttribute("serials", pageInfo);
		return "forward:/myWebServer/car_serial_list.jsp";
	}
	
	/**
	 * ����id����ϵ����Ϣ
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateInput/{id}")
	public String updateInput(@PathVariable String id,Model model){
		//����ҵ���߼����ѯϵ����Ϣ
		Serial serial = serialService.findSerialById(id);
		model.addAttribute("serial", serial);
		System.out.println("����Ϊserial_code���ݣ�----------------------------------");
		System.out.println(serial.getBrand_code());
		Brand brand = brandService.findBrandByBrandCode(serial.getBrand_code());
		System.out.println("����Ϊbrand���ݣ�----------------------------------");
		System.out.println(brand);
		model.addAttribute("brand",brand);
		return "forward:/myWebServer/UpdateSerial.jsp";
	}
	/**
	 * ����ϵ����Ϣ
	 * @param serial
	 * @return
	 */
	@RequestMapping("/update")
	public String update(Serial serial){
		serialService.updateSerial(serial);
		return "redirect:/serial/findall.do";
	}
	
	/**
	 * ����idɾ��ϵ����Ϣ
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById/{id}")
	public String deleteById(@PathVariable String id){
		serialService.deleteById(id);
		return "redirect:/serial/findall.do";
	}
	
	/**
	 * ��̬����brands�б�����
	 */
	@RequestMapping("/getBrandsList")
	@ResponseBody
	public void getBrands(HttpServletResponse response) throws IOException{
		List<Brand> brands = brandService.findAll();
		ObjectMapper objectMapper = new ObjectMapper();
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().println(objectMapper.writeValueAsString(brands));
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}