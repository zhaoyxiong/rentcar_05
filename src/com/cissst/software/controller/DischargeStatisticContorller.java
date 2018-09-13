package com.cissst.software.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cissst.software.model.DischargeStatistic;
import com.cissst.software.model.PV;
import com.cissst.software.service.impl.IDischargeStatisticService;

@Controller
@RequestMapping("/dischargestatistic")
public class DischargeStatisticContorller {

	@Autowired
	private IDischargeStatisticService dischargeStatisticService;
	
	public DischargeStatisticContorller() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 添加访问信息记录
	 * @param dischargeStatistic
	 */
	@RequestMapping("/add")
	public void addDischargeStatistic(DischargeStatistic dischargeStatistic) {
		
		dischargeStatisticService.addDischargeIStatistic(dischargeStatistic);
	}
	
	/**
	 * 查找访问记录信息
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@RequestMapping("/find")
	public void findDischargestatistic(HttpServletResponse response,
									   @RequestParam("daysbegin") String daysbegin,
									   @RequestParam("daysend") String daysend) throws JsonGenerationException, JsonMappingException, IOException{
		//接收前端传来的取记录范围（开始日期和结束日期，此处皆用距离1970天数表示）
		int begindays = Integer.parseInt(daysbegin);
		int enddays = Integer.parseInt(daysend);
		
		List<PV> PVs = new ArrayList<PV>();
		for(int day = begindays; day <= enddays; day++) {
			PV pv = new PV();
			long timeStamp = (long)day*(long)3600*(long)24*(long)1000;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//这个是你要转成后的时间的格式
			String date = sdf.format(new Date(timeStamp));   // 时间戳转换成时间
			
			pv.setName(date);
			pv.setValue(dischargeStatisticService.finddayPV(day));
			PVs.add(pv);
		
			System.err.println(pv.getName()+"这一天的pv是："+pv.getValue());
		}
		
		for(PV p:PVs) {
			System.err.println("此时list中存放的数据：");
			System.err.println(p.getValue());
		}
		ObjectMapper objectMapper = new ObjectMapper();
		
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().println(objectMapper.writeValueAsString(PVs));
	}
}
