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
	 * ��ӷ�����Ϣ��¼
	 * @param dischargeStatistic
	 */
	@RequestMapping("/add")
	public void addDischargeStatistic(DischargeStatistic dischargeStatistic) {
		
		dischargeStatisticService.addDischargeIStatistic(dischargeStatistic);
	}
	
	/**
	 * ���ҷ��ʼ�¼��Ϣ
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@RequestMapping("/find")
	public void findDischargestatistic(HttpServletResponse response,
									   @RequestParam("daysbegin") String daysbegin,
									   @RequestParam("daysend") String daysend) throws JsonGenerationException, JsonMappingException, IOException{
		//����ǰ�˴�����ȡ��¼��Χ����ʼ���ںͽ������ڣ��˴����þ���1970������ʾ��
		int begindays = Integer.parseInt(daysbegin);
		int enddays = Integer.parseInt(daysend);
		
		List<PV> PVs = new ArrayList<PV>();
		for(int day = begindays; day <= enddays; day++) {
			PV pv = new PV();
			long timeStamp = (long)day*(long)3600*(long)24*(long)1000;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//�������Ҫת�ɺ��ʱ��ĸ�ʽ
			String date = sdf.format(new Date(timeStamp));   // ʱ���ת����ʱ��
			
			pv.setName(date);
			pv.setValue(dischargeStatisticService.finddayPV(day));
			PVs.add(pv);
		
			System.err.println(pv.getName()+"��һ���pv�ǣ�"+pv.getValue());
		}
		
		for(PV p:PVs) {
			System.err.println("��ʱlist�д�ŵ����ݣ�");
			System.err.println(p.getValue());
		}
		ObjectMapper objectMapper = new ObjectMapper();
		
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().println(objectMapper.writeValueAsString(PVs));
	}
}
