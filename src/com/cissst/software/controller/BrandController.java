package com.cissst.software.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cissst.software.model.Brand;
import com.cissst.software.service.impl.IBrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * ǰ�˿�������--ʵ���û���Ϣ����
 * @author Administrator
 */

@Controller
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private IBrandService brandService;

	/**
	 * ��ѯȫ��Ʒ����Ϣ
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/findall")
	public String findAll(@RequestParam(required=false,defaultValue="1",value="pn")int pn,
			Model model) {
		PageHelper.startPage(pn, 10);
		List<Brand> brands = brandService.findAll();
		PageInfo<Brand> pageInfo = new PageInfo<>(brands,5);
		System.out.println("The brand is " + pageInfo.getList());
		model.addAttribute("brands", pageInfo);
		return "forward:/myWebServer/car_brand_list.jsp";
	}
	/**
	 * ����id����Ʒ����Ϣ
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateInput/{id}")
	public String updateInput(@PathVariable String id, Model model) {
		// ����ҵ���߼����ѯƷ����Ϣ
		Brand brand = brandService.findBrandById(id);
		model.addAttribute("brand", brand);
		return "forward:/myWebServer/updatebrand.jsp";
	}

	/**
	 * ����idɾ��Ʒ����Ϣ
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById/{id}")
	public String deleteById(@PathVariable String id) {
		brandService.deleteById(id);
		return "redirect:/brand/findall.do";
	}

	/**
	 * ���Ʒ����Ϣ
	 * 
	 * @param file
	 * @param brand_code
	 * @param brand_name
	 * @param brand_url
	 * @param brand_py
	 * @param req
	 * @return
	 */
	
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("brand_code") String brand_code,
			@RequestParam("brand_name") String brand_name, @RequestParam("brand_url") String brand_url,
			@RequestParam("brand_py") String brand_py, HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// �ļ��Ƿ��Ѿ��ϴ�
		if (!file.isEmpty()) {
			// ��ȡ�����ļ���·��
			String path = req.getServletContext().getRealPath("/upload");

			// ��ȡ�ϴ��ļ�����
			String filename = file.getOriginalFilename();

			Brand brand = new Brand();
			// ����32λ����ַ���id
			String id = UUID.randomUUID().toString().trim().replaceAll("-", "");
			brand.setId(id);
			brand.setBrand_code(brand_code);
			brand.setBrand_name(brand_name);
			brand.setBrand_url(brand_url);
			brand.setBrand_py(brand_py);
			brand.setCreate_date(new Date(System.currentTimeMillis()));
			brand.setBrand_pic(filename);

			System.out.println("brand_name set���ȡ��brand_name:---------------------------------");
			System.out.println(brand.getBrand_name());
			
			brandService.addBrand(brand);

			System.out.println("brand_name set����add�����ݿ���brand_name:---------------------------------");
			System.out.println(brand.getBrand_name());
			
			// �ϴ��ļ����浽ָ��λ��
			try {
				file.transferTo(new File(path + File.separator + filename));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "redirect:/myWebServer/success.jsp";
		} else {
			return "redirect:/myWebServer/opfailed.jsp";
		}
	}
	/**
	 * ����Ʒ����Ϣ
	 * 
	 * @param brand
	 * @return
	 */
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String update(@RequestParam("file") MultipartFile file, @RequestParam("id") String id,
			@RequestParam("brand_code") String brand_code, @RequestParam("brand_name") String brand_name,
			@RequestParam("brand_url") String brand_url, @RequestParam("brand_py") String brand_py,
			HttpServletRequest req) {

		// �ļ��Ƿ��Ѿ��ϴ�
		try {
			if (!file.isEmpty()) {

				// ��ȡ�����ļ���·��
				String path = req.getServletContext().getRealPath("/upload");

				// ��ȡ�ϴ��ļ�����
				String filename = file.getOriginalFilename();

				Brand brand = new Brand();

				brand.setId(id);
				brand.setBrand_code(brand_code);
				brand.setBrand_name(brand_name);
				brand.setBrand_url(brand_url);
				brand.setBrand_py(brand_py);
				brand.setBrand_pic(filename);

				brandService.updateBrand(brand);

				// �ϴ��ļ����浽ָ��λ��
				try {
					file.transferTo(new File(path + File.separator + filename));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return "redirect:/myWebServer/success.jsp";
			} else {
				return "redirect:/myWebServer/opfailed.jsp";
			}
		} catch (Exception e) {

			e.printStackTrace();
			return "redirect:/myWebServer/opfailed.jsp";
		}
	}
}
