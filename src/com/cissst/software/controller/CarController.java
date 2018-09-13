package com.cissst.software.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cissst.software.model.Brand;
import com.cissst.software.model.Car;
import com.cissst.software.model.Company;
import com.cissst.software.model.Serial;
import com.cissst.software.service.impl.IBrandService;
import com.cissst.software.service.impl.ICarService;
import com.cissst.software.service.impl.ICompany;
import com.cissst.software.service.impl.ISerialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private ICarService carService;
	@Autowired
	private ICompany companyService;
	@Autowired
	private IBrandService brandService;
	@Autowired
	private ISerialService serialService;
	
	List<Company> companylist;
	
	List<Car> cars;
	Car car;
	
	public static HttpSession getSession(){
		HttpSession session = null;
		try{
			session=getRequest().getSession();
		}catch(Exception e){}
		return session;
	}
	
	public static HttpServletRequest getRequest(){
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attrs.getRequest();
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addCar(Car car,HttpServletRequest req){
		
//		String[] list=(car.getCar_pic()).split("\\\\");
//		car.setCar_pic(list[list.length-1]);
		//����Ψһid
//		long t2 = System.currentTimeMillis();
//		car.setId((int)(t2-t1));
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		car.setId(id);
		//���ô���ʱ��
		car.setCreate_date(new Date(System.currentTimeMillis()));
	
		//��˾���ơ�����Ʒ�ơ���ϵ���
	
		MultipartFile file=car.getFile();
		// �ļ��Ƿ��Ѿ��ϴ�
		if (!file.isEmpty()){
			// ��ȡ�����ļ���·��
			//String path = "F:\\workplace\\spring_springmvc_mybatis\\WebContent\\upload\\";
			String path = req.getServletContext().getRealPath("/upload");
			System.out.println(path);
			// ��ȡ�ϴ��ļ�����
			String filename = file.getOriginalFilename();
             car.setCar_pic(filename);
			// �ϴ��ļ����浽ָ��λ��
			try {
				file.transferTo(new File(path+File.separator+filename));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		carService.addCar(car);
		return "redirect:/car/list.do";
	}
	
	/**
	 * ��ѯ����
	 * @param model
	 * @return
	 */
	
	@RequestMapping("/list")
	public String findAllTables(@RequestParam(required=false,defaultValue="1",value="pn") int pn){
		
		PageHelper.startPage(pn, 10);
		cars = carService.findAllTables();
		PageInfo<Car> pageInfo = new PageInfo<>(cars,5);
		
		HttpSession session = getSession();
		companylist = companyService.findAll();
		session.setAttribute("companylist", companylist);
		
		List<Brand> brandList = brandService.findAll();
		session.setAttribute("brands", brandList);
		
		List<Serial> serialList = serialService.findAll();
		session.setAttribute("serials", serialList);
		
		session.setAttribute("cars", pageInfo);
		return "redirect:/myWebServer/rent_car_list.jsp";
	}
	
	@RequestMapping("/delete")
	public String deleteCar(String id){
		carService.deleteCar(id);
		/*for(Car car : cars){
			if(car.getId().equals(id)){
				cars.remove(car);
				break;
			}
		}*/
		return "redirect:/car/list.do";
	}
	
	@RequestMapping("/updatelist")
	public String updatelist(String id){
		car = carService.findById(id);
		//��˾���ơ�����Ʒ�ơ���ϵ���
		HttpSession session = getSession();
		session.setAttribute("car", car);
		System.out.println(car);
		return "redirect:/myWebServer/rent_car_update.jsp";
	}
	
	@RequestMapping("/updatelist/{id}")
	public String findById(@PathVariable String id,Model model){
		System.out.println("id is " + id);
		model.addAttribute("id",id);
		System.out.println("�ҵ���");
		return "redirect:/myWebServer/rent_car_display.jsp";
	}
	
	@RequestMapping("/update")
	public String updateCar(Car car){
		
		//������Ƭ·��
		String[] list=(car.getCar_pic()).split("\\\\");
		car.setCar_pic(list[list.length-1]);
		
		System.out.println("/n/n/n/n/n/n/n/n/n");
		System.out.println(car);
		carService.updateCar(car);
		return "redirect:/car/list.do";
	}
	
	@RequestMapping(value="/upload.do",method=RequestMethod.POST)
	public ModelAndView upload(Car car,
			           HttpServletRequest req){
		MultipartFile file=car.getFile();
		// �ļ��Ƿ��Ѿ��ϴ�
		if (!file.isEmpty()){
			// ��ȡ�����ļ���·��
			String path = req.getServletContext().getRealPath("/upload");
			
			// ��ȡ�ϴ��ļ�����
			String filename = file.getOriginalFilename();
             car.setCar_pic(filename);
			// �ϴ��ļ����浽ָ��λ��
			try {
				file.transferTo(new File(path+File.separator+filename));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("uploadfile",file);
			mv.addObject("path","/upload/"+filename);
			mv.setViewName("success");
			return mv;
		}
		else{
			
			return null;
		}
	}
	
}
