<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<%-- 
<body>
	<!--header-->
	<header>
		<h1>
			<img src="<%=request.getContextPath()%>/images/admin_logo.png" />
		</h1>
	</header>
	<!--aside nav-->
	<aside class="lt_aside_nav content mCustomScrollbar">
		<h2>
			<a href="index.html">网站首页</a>
		</h2>
		<ul>
			<li>
				<dl>
					<dt>基础数据设置</dt>
					<!--当前链接则添加class:active-->
					<dd>
						<a href="<%=request.getContextPath()%>/brand/findall.do" <%if(request.getServletPath().contains("car_brand_list.jsp")){%>class="active"<%}%>>车辆品牌管理</a>
					</dd>
					<dd>
						<a href="<%=request.getContextPath()%>/serial/findall.do" <%if(request.getServletPath().contains("car_serial_list.jsp")){%>class="active"<%}%>>车辆车系管理</a>
					</dd>
					<dd>
						<a href="<%=request.getContextPath()%>/company/list.do" <%if(request.getServletPath().contains("rent_company_list.jsp")){%>class="active"<%}%>>租赁公司管理</a>
					</dd>
					<dd>
						<a href="<%=request.getContextPath()%>/car/list.do" <%if(request.getServletPath().contains("rent_car_list.jsp")){%>class="active"<%}%>>租赁车辆管理</a>
					</dd>
					<dd>
						<a href="<%=request.getContextPath()%>/TLeaseHoliday/findAll.do" <%if(request.getServletPath().contains("rent_car_festival_list.jsp")){%>class="active"<%}%>>租车特殊假日配置</a>
					</dd>
				</dl>
			</li>
			<li>
				<dl>
					<dt>订单信息</dt>
					<dd>
						<a href="<%=request.getContextPath()%>/order/findOrderPages/1.do" <%if(request.getServletPath().contains("order_list.jsp")){%>class="active"<%}%>>订单信息管理</a>
					</dd>
					<dd>
						<a href="<%=request.getContextPath()%>/ordercar/findOrderCarByOrderNo/1.do">订单详情管理</a>
					</dd>
				</dl>
			</li>
			<li>
				<dl>
					<dt>会员管理</dt>
					<dd>
						<a href="<%=request.getContextPath()%>/TMember/findAll.do" <%if(request.getServletPath().contains("user_list.jsp")){%>class="active"<%}%>>会员信息管理</a>
					</dd>
					<dd>
						<a href="<%=request.getContextPath()%>/myWebServer/user_detail.jsp" <%if(request.getServletPath().contains("user_detail.jsp")){%>class="active"<%}%>>添加会员信息</a>
					</dd>
					<dd>
						<a href="<%=request.getContextPath()%>/myWebServer/success.jsp">会员等级管理</a>
					</dd>
				</dl>
			</li>
			<li>
				<dl>
					<dt>在线统计</dt>
					<dd>
						<a href="<%=request.getContextPath()%>/myWebServer/success.jsp">流量统计</a>
					</dd>
					<dd>
						<a href="<%=request.getContextPath()%>/myWebServer/success.jsp">销售额统计</a>
					</dd>
				</dl>
			</li>
			<li>
				<p class="btm_infor">© DeathGhost.cn 版权所有</p>
			</li>
		</ul>
	</aside>
</body>
 --%>
</html>