package com.cissst.software.filter;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cissst.software.model.DischargeStatistic;
import com.cissst.software.service.impl.IDischargeStatisticService;

public class PVRecorderInterceptor implements HandlerInterceptor {

	@Autowired
	private IDischargeStatisticService dischargeStatisticService;
	
	public PVRecorderInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		//生成32位随机字符串id
		DischargeStatistic dischargeStatistic = new DischargeStatistic();
		String id = UUID.randomUUID().toString().trim().replaceAll("-", "");
		dischargeStatistic.setId(id);
		dischargeStatistic.setIp(request.getRemoteAddr());
		
		dischargeStatisticService.addDischargeIStatistic(dischargeStatistic);
		
		return true;
	}
}
