<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>后台管理系统</title>
<meta name="author" content="DeathGhost" />
<!--[if lt IE 9]>
<script src="../js/html5.js"></script>
<![endif]-->
<script src="../js/jquery.js"></script>
<script src="../js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>
	(function($) {
		$(window).load(
				function() {
					$("a[rel='load-content']").click(
							function(e) {
								e.preventDefault();
								var url = $(this).attr("href");
								$.get(url, function(data) {
									$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
									//scroll-to appended content 
									$(".content").mCustomScrollbar("scrollTo",
											"h2:last");
								});
							});
					$(".content").delegate(
							"a[href='top']",
							"click",
							function(e) {
								e.preventDefault();
								$(".content").mCustomScrollbar("scrollTo",
										$(this).attr("href"));
							});

				});
	})(jQuery);
</script>
</head>
<body>
	<!-- 引入侧边栏，顶栏 -->
	<%@ include file="/nav/AsideBar.jsp" %>

	<section class="rt_wrap content mCustomScrollbar">
		<div class="rt_content">
			<div class="page_title">
				<h2 class="fl">租赁车辆列表示例</h2>
				<a href="<%=request.getContextPath()%>/myWebServer/rent_car_add.jsp" class="fr top_rt_btn add_icon">添加租赁车辆</a>
			</div>
			<section class="mtb">
				<input type="text" class="textbox textbox_225"
					placeholder="输入公司名称或车辆名称..." /> <input type="button" value="查询"
					class="group_btn" />
			</section>
			<table class="table">
				<tr>
					<th>缩略图</th>
					<th>租赁公司</th>
					<th>车辆编号</th>
					<th>车辆名称</th>
					<th>车辆品牌</th>
					<th>车系编号</th>
					<th>车辆普通价</th>
					<th>车辆假日价</th>
					<th>车辆特殊价</th>
					<th>操作</th>
				</tr>
				<c:choose>
					<c:when test="${empty cars.list}">
						<tr>
							<td colspan="10">查无数据！</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${cars.list}" var="car">
							<tr>
								<td class="center"><img src="<%=request.getContextPath()%>/upload/${car.car_pic }"
									width="50" height="50" /></td>
								<td>${car.company.company_name}</td>
								<td class="center">${car.car_no}</td>
								<td class="center">${car.car_name}</td>
								<td class="center">${car.car_brand}</td>
								<td class="center">${car.car_serial}</td>
								<td class="center">${car.normal_price}</td>
								<td class="center">${car.holiday_price}</td>
								<td class="center">${car.special_price}</td>
								<td class="center"><a
									href="<%=request.getContextPath()%>/car/updatelist/${car.id}.do" title="预览"
									class="link_icon">&#118;</a> <a
									href="<%=request.getContextPath()%>/car/updatelist.do?id=${car.id}" title="编辑"
									class="link_icon">&#101;</a> <a
									href="<%=request.getContextPath()%>/car/delete.do?id=${car.id}" title="删除"
									class="link_icon">&#100;</a></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
			<!--显示分页信息-->
		    <div class="row">
		        <!--文字信息-->
		        <div class="col-md-6">
		            当前第 ${cars.pageNum} 页.总共 ${cars.pages} 页.一共 ${cars.total} 条记录
		        </div>
		        <!--点击分页-->
		        <div class="col-md-6">
		            <nav aria-label="Page navigation">
		                <ul class="pagination" style="float: right;">
		                    <li style="float: left;width: 30px;height: 20px;"><a href="<%=request.getContextPath()%>/car/list.do?pn=1">首页</a></li>
		                    <!--上一页-->
		                    <li style="float: left;width: 30px;height: 20px;">
		                        <c:if test="${cars.hasPreviousPage}">
		                            <a href="<%=request.getContextPath()%>/car/list.do?pn=${cars.pageNum-1}" aria-label="Previous">
		                                <span aria-hidden="true">«</span>
		                            </a>
		                        </c:if>
		                    </li>
		                    <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
		                    <c:forEach items="${cars.navigatepageNums}" var="page_num">
		                        <c:if test="${page_num == cars.pageNum}">
		                            <li class="active" style="float: left;width: 30px;height: 20px;"><a href="#">${page_num}</a></li>
		                        </c:if>
		                        <c:if test="${page_num != cars.pageNum}">
		                            <li style="float: left;width: 30px;height: 20px;"><a href="<%=request.getContextPath()%>/car/list.do?pn=${page_num}">${page_num}</a></li>
		                        </c:if>
		                    </c:forEach>
		                    <!--下一页-->
		                    <li style="float: left;width: 30px;height: 20px;">
		                        <c:if test="${cars.hasNextPage}">
		                            <a href="<%=request.getContextPath()%>/car/list.do?pn=${cars.pageNum+1}"
		                               aria-label="Next">
		                                <span aria-hidden="true">»</span>
		                            </a>
		                        </c:if>
		                    </li>
		                    <li style="float: left;width: 30px;height: 20px;"><a href="<%=request.getContextPath()%>/car/list.do?pn=${cars.pages}">尾页</a></li>
		                </ul>
		            </nav>
		        </div>
		    </div>
		</div>
	</section>
</body>
</html>
