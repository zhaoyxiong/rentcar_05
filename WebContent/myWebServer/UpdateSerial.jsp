<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<%= request.getContextPath()%>/js/jquery.js"></script>
<script src="<%= request.getContextPath()%>/js/json2.js"></script>
<script >
    $(document).ready(function(){
	  // $("#sele_brand_code").click(function(){
		   $.ajax({ 
			    type: "POST", 
			    url: "<%=request.getContextPath()%>/serial/getBrandsList.do",
			    contentType:"application/json",
			    async: true, 
			    error: function(request) {
			        alert("Connection error"); 
			    }, 
			    success: function(data) { 
			        //接收后台返回的结果 			        
			        var brands = JSON.parse(data);
			        var info;
			        var len=$("#sele_brand_code").find("option").length;
			        
			       // if(len==1)
		        	{
			        	for(var i = 0; i < brands.length; i++){
			                info += "<option value='" + brands[i].brand_code + "'>" + brands[i].brand_name + "</option>";  
				    	}
				    	$("#sele_brand_code").append(info);
		        	} 	
			    }
			  });
	 //  });
   });

</script>
</head>
<body>
    <!-- 引入侧边栏，顶栏 -->
    <%@ include file="/nav/AsideBar.jsp"%>
    
	<form action="<%=request.getContextPath()%>/serial/update.do" method="get">
		  <section class="rt_wrap content mCustomScrollbar">
			 <div class="rt_content">
			      <div class="page_title">
			       <h2 class="fl">车辆车系详情示例</h2>
			       <a href="<%=request.getContextPath()%>/serial/findall.do" class="fr top_rt_btn">返回车辆车系列表</a>
			      </div>
			     <section>
			      <input type="hidden" name="id" value="${serial.id}"/>
				      <ul class="ulColumn2">
				       <li>
				        <span class="item_name" style="width:120px;">品牌：</span>
				        <select id="sele_brand_code" name="brand_code">
				         <option value="${brand.brand_code}">${brand.brand_name}</option>
				        </select>
				       </li>
				       <li>
				        <span class="item_name" style="width:120px;">车系编码：</span>
				        <input type="text" class="textbox textbox_295" name="serial_code" value="${serial.serial_code}"/>
				       </li>
				       <li>
				        <span class="item_name" style="width:120px;">车系名称：</span>
				        <input type="text" class="textbox textbox_295" name="serial_name" value="${serial.serial_name}"/>
				       </li>
				       <li>
				        <span class="item_name" style="width:120px;"></span>
				        <input type="submit" class="link_btn"/>
				       </li>
				      </ul>
			     </section>
			 </div>
		 </section>
    </form>
</body>
</html>