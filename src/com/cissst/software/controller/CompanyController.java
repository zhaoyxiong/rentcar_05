package com.cissst.software.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cissst.software.model.Company;
import com.cissst.software.service.impl.ICompany;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 前端控制器--实现用户操作
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
	private static int count = 0;
	List<Company> list = null;
	@Autowired
	private ICompany comservice;

	/**
	 * 获取session
	 * 
	 * @author Administrator
	 *
	 */
	public static HttpSession getSession() {
		HttpSession session = null;
		try {
			session = getRequest().getSession();
		} catch (Exception e) {
		}
		return session;
	}

	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attrs.getRequest();
	}

	@RequestMapping("/list.do")
	public String findAll(@RequestParam(required = false, defaultValue = "1", value = "pn") int pn) {
		PageHelper.startPage(pn, 10);
		list = comservice.findAll();
		PageInfo<Company> pageInfo = new PageInfo<>(list, 5);
		HttpSession session = getSession();
		session.setAttribute("companylist", pageInfo);
		return "redirect:/myWebServer/rent_company_list.jsp";
	}

	@RequestMapping("/add.do")
	public String addCompany(Company company) {
		String id = UUID.randomUUID().toString().trim().replaceAll("-", "");
		company.setId(id);
		count++;
		comservice.addCompany(company);
		// System.out.println(company.getAudit_state());
		// return "redirect:/rent_company_list.jsp";
		return "redirect:/company/list.do";
	}

	@RequestMapping("/dele.do")
	public String delete(String id) {
		comservice.deleteCompanyByID(id);
		/*for (Company company : list) {
			if (company.getId().equals(id)) {
				list.remove(company);
				break;

			}
		}*/
		return "redirect:/company/list.do";
	}

	@RequestMapping("/update.do")
	public String update(Company company) {

		comservice.updateCompany(company);
		return "redirect:/company/list.do";
	}

}
