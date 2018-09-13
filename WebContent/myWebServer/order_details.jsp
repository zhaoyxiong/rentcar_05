<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>后台管理系统</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css">
<script src="<%= request.getContextPath()%>/js/jquery.js"></script>
<script src="<%= request.getContextPath()%>/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>
	(function($){
		$(window).load(function(){
			
			$("a[rel='load-content']").click(function(e){
				e.preventDefault();
				var url=$(this).attr("href");
				$.get(url,function(data){
					$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
					//scroll-to appended content 
					$(".content").mCustomScrollbar("scrollTo","h2:last");
				});
			});
			
			$(".content").delegate("a[href='top']","click",function(e){
				e.preventDefault();
				$(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
			});
			
		});
	})(jQuery);
</script>
</head>
<body>

<!-- 引入侧边栏，顶栏 -->
<%@ include file="/nav/AsideBar.jsp"%>

<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
 
      <div class="page_title">
       <h2 class="fl">订单详情</h2>
      </div>
      <table class="table">
       <tr>
        <td>用户名称</td>
        <td>联系电话</td>  
       </tr>
       <tr>
        <td>订单编号：<c:out value="${order.order_no}"/></td>
        <td>订单状态：<c:out value="${order.base_state}"/></td>
       </tr>
       <tr>
        <td>订单费用：<c:out value="${order.rental_fee}"/></td>
        <td>付款时间：<c:out value="${order.pay_time}"/></td>
        </tr>
      </table>
      
      <table class="table">
       <tr>
        <td class="center">图片</td>
        <td>车辆编号</td>
        <td class="center">品牌</td>
        <td class="center">租车价格</td>
        <td class="center">取车时间</td>
        <td class="center">取车地点</td>
        <td class="center">还车地点</td>
        <td class="center">状态</td>
       </tr>
       
       <c:choose>
				<c:when test="${empty orderCars}">
					<tr>
						<td>查无数据!</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${orderCars}" var="v">				 
				       <tr>
				        <td class="center"><img src="<%=request.getContextPath()%>/upload/${v.car_pic}" width="50" height="50"/></td>
				        <td>${v.car_no}</td>
				        <td class="center">${v.car_brand_name}</td>
				        <td class="center">${v.normal_price}</td>
				        <td class="center">取车时间</td>
				        <td class="center">${v.tack_address}</td>
				        <td class="center">${v.return_address}</td>
				        <td class="center">车辆状态</td>
				       </tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>      
      </table>
      
      <aside class="mtb" style="text-align:right;">
       <label>管理员操作：</label>
       <input type="text" class="textbox textbox_295" placeholder="管理员操作备注"/>
       <input type="button" value="打印订单" class="group_btn"/>
       <input type="button" value="确认订单" class="group_btn"/>
       <input type="button" value="确认还车" class="group_btn"/>
      </aside>
 </div>
</section>
</body>
</html>
