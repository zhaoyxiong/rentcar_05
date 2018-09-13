package com.cissst.software.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cissst.software.model.TMember;
import com.cissst.software.service.impl.ITMemberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value="/TMember")
public class TMemberController {
	
	Logger log = Logger.getLogger(getClass());
	
	@Autowired
	private ITMemberService tMemberService;
	
	@RequestMapping(value="/addTMember",method=RequestMethod.POST)
	public String addTMember(@RequestParam("file") MultipartFile file,
			TMember tMember, HttpServletRequest request){
		Logger log = Logger.getLogger(getClass());
		/*
		 * 文件上传，获取文件路径
		 */
		if(!file.isEmpty()){
			//存放路径
			String path = request.getServletContext().getRealPath("/uploadMember");
			log.debug("The upload path is " + path);
			String fileName = file.getOriginalFilename();
			log.debug("The file name is " + fileName);
			File uploadFile = new File(path,fileName);
			log.debug("The new File path is " + uploadFile.getPath());
			
			//测试文件“目录”是否存在，不存在则加容错机制
			if(!uploadFile.getParentFile().exists()){
				uploadFile.getParentFile().mkdirs();
			}
			
			//上传的核心功能,主要实现方法
			try {
				file.transferTo(new File(path+File.separator+fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				log.debug("file fails at use transeferTo method");
				e.printStackTrace();
			}
			log.debug("UploadTMember success");
			tMember.setIcon(fileName);
			String id = UUID.randomUUID().toString().trim().replaceAll("-", "");
			tMember.setId(id);
			log.debug("The TMember is " + tMember);
			tMemberService.addTMember(tMember);
			return "redirect:/myWebServer/user_detail.jsp";
		}else{
			log.info("文件不存在");
			return null;
		}
	}
	
	@RequestMapping(value="/findAll")
	public String findAll(@RequestParam(required = false,defaultValue = "1",value = "pn")int pn,
			Model model){
		PageHelper.startPage(pn, 10);
		List<TMember> list = tMemberService.findAll();
		PageInfo<TMember> pageInfo = new PageInfo<>(list,5);
		log.debug("PageInfo is " + pageInfo);
		model.addAttribute("user_list",pageInfo);
		return "forward:/myWebServer/user_list.jsp";
	}
	
	@RequestMapping(value="/deleteById")
	public String deleteById(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		tMemberService.deleteById(id);
		/*response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().println("ok");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return "redirect:/TMember/findAll.do";
	}
}