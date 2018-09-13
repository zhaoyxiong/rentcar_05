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
 * 前端控制器层--实现用户信息操作
 * @author Administrator
 */

@Controller
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private IBrandService brandService;

	/**
	 * 查询全部品牌信息
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
	 * 根据id更新品牌信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateInput/{id}")
	public String updateInput(@PathVariable String id, Model model) {
		// 调用业务逻辑层查询品牌信息
		Brand brand = brandService.findBrandById(id);
		model.addAttribute("brand", brand);
		return "forward:/myWebServer/updatebrand.jsp";
	}

	/**
	 * 根据id删除品牌信息
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
	 * 添加品牌信息
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
		// 文件是否已经上传
		if (!file.isEmpty()) {
			// 获取保存文件的路径
			String path = req.getServletContext().getRealPath("/upload");

			// 获取上传文件名称
			String filename = file.getOriginalFilename();

			Brand brand = new Brand();
			// 生成32位随机字符串id
			String id = UUID.randomUUID().toString().trim().replaceAll("-", "");
			brand.setId(id);
			brand.setBrand_code(brand_code);
			brand.setBrand_name(brand_name);
			brand.setBrand_url(brand_url);
			brand.setBrand_py(brand_py);
			brand.setCreate_date(new Date(System.currentTimeMillis()));
			brand.setBrand_pic(filename);

			System.out.println("brand_name set后获取的brand_name:---------------------------------");
			System.out.println(brand.getBrand_name());
			
			brandService.addBrand(brand);

			System.out.println("brand_name set后并且add至数据库后的brand_name:---------------------------------");
			System.out.println(brand.getBrand_name());
			
			// 上传文件保存到指定位置
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
	 * 更新品牌信息
	 * 
	 * @param brand
	 * @return
	 */
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String update(@RequestParam("file") MultipartFile file, @RequestParam("id") String id,
			@RequestParam("brand_code") String brand_code, @RequestParam("brand_name") String brand_name,
			@RequestParam("brand_url") String brand_url, @RequestParam("brand_py") String brand_py,
			HttpServletRequest req) {

		// 文件是否已经上传
		try {
			if (!file.isEmpty()) {

				// 获取保存文件的路径
				String path = req.getServletContext().getRealPath("/upload");

				// 获取上传文件名称
				String filename = file.getOriginalFilename();

				Brand brand = new Brand();

				brand.setId(id);
				brand.setBrand_code(brand_code);
				brand.setBrand_name(brand_name);
				brand.setBrand_url(brand_url);
				brand.setBrand_py(brand_py);
				brand.setBrand_pic(filename);

				brandService.updateBrand(brand);

				// 上传文件保存到指定位置
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
