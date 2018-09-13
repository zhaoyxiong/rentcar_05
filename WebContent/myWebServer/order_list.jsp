<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>订单管理</title>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/js/jquery.mCustomScrollbar.concat.min.js"></script>
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
	<%@ include file="/nav/AsideBar.jsp"%>

	<!-- 内容显示区域 -->
	<section class="rt_wrap content mCustomScrollbar">
		<div class="rt_content">
			<div class="page_title">
				<h2 class="fl">订单列表示例</h2>
				<!--待扩展的功能-->
				<a class="fr top_rt_btn add_icon">添加租车信息</a>
			</div>
			<section class="mtb">
				<input type="text" class="textbox textbox_225" placeholder="输入订单编号或租车人姓名/电话..." /> 
				<input type="button" value="查询" class="group_btn" />
			</section>
			<table class="table">
				<tr>
					<th>订单编号</th>
					<th>会员编号</th>
					<th>公司名称</th>
					<th>租车费</th>
					<th>保险费</th>
					<th>订单生成时间</th>
					<th>操作</th>
				</tr>
				<c:choose>
					<c:when test="${empty orders}">
						<tr>
							<td>查无数据!</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${orders}" var="v">
							<tr>
								<td class="center">${v.order_no}</td>
								<td class="center">${v.lease_id}</td>
								<td class="center">${v.company_name}</td>
								<td class="center">${v.rental_fee}</td>
								<td class="center">${v.insurance_fee}</td>
								<td class="center">${v.create_time}</td>
								<td><a
									href="<%= request.getContextPath()%>/ordercar/findOrderCarByOrderNo/${v.id}.do"
									title="查询订单详情" class="link_icon">&#101;</a> <a
									href="<%= request.getContextPath()%>/order/deleteById/${v.id}.do"
									title="删除订单" class="link_icon">&#100;</a></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>

			<!-- 页面索引 -->
			<aside class="paging">
				<!--   若订单页面数为N页（N<=10），直接显示页面1-页面N的索引 -->
				<c:if test="${pageQuantity < 11}">
					<c:forEach begin="1" end="${page_no-1}" step="1"
						var="pageCode_before_currentPage">
						<a
							href="<%= request.getContextPath()%>/order/findOrderPages/<c:out value="${pageCode_before_currentPage}"/>.do"><c:out
								value="${pageCode_before_currentPage}" /></a>
					</c:forEach>
					<a
						href="<%= request.getContextPath()%>/order/findOrderPages/<c:out value="${page_no}"/>.do"><c:out
							value="${page_no}" /></a>
					<c:forEach begin="${page_no+1}" end="${page_no-1}" step="1"
						var="pageCode_after_currentPage">
						<a
							href="<%= request.getContextPath()%>/order/findOrderPages/<c:out value="${pageCode_after_currentPage}"/>.do"><c:out
								value="${pageCode_after_currentPage}" /></a>
					</c:forEach>
				</c:if>
				<!--   若订单页面数多于10页，显示10个页面索引，具体规则如下: -->
				<c:if test="${pageQuantity > 10}">
					<!-- 若订单页面数多于10页,且当前页面为1-5，显示页面1-10的索引 -->
					<c:if test="${page_no < 6}">
						<a href="<%=request.getContextPath()%>/order/findOrderPages/1.do">第一页</a>
						<c:forEach begin="1" end="${page_no-1}" step="1"
							var="pageCode_before_currentPage">
							<a
								href="<%= request.getContextPath()%>/order/findOrderPages/<c:out value="${pageCode_before_currentPage}"/>.do"><c:out
									value="${pageCode_before_currentPage}" /></a>
						</c:forEach>
						<a style="background: white; color: black;"
							href="<%= request.getContextPath()%>/order/findOrderPages/<c:out value="${page_no}"/>.do"><c:out
								value="${page_no}" /></a>
						<c:forEach begin="${page_no+1}" end="10" step="1"
							var="pageCode_after_currentPage">
							<a
								href="<%= request.getContextPath()%>/order/findOrderPages/<c:out value="${pageCode_after_currentPage}"/>.do"><c:out
									value="${pageCode_after_currentPage}" /></a>
						</c:forEach>
						<a
							href="<%= request.getContextPath()%>/order/findOrderPages/${pageQuantity}.do">最后一页</a>
					</c:if>
					<!-- 若订单页面数多于10页,且当前页面为第6页及其后页面，分为两种情况： -->
					<c:if test="${page_no > 5}">
						<!-- 若订单页面数多于10页,且当前页面为页面6及其后页面，且当前页面为倒数第6页及其以前页面，显示当前页面前四页、当前、当前页后五页，共10页索引 -->
						<c:if test="${page_no < pageQuantity-4}">
							<a
								href="<%=request.getContextPath()%>/order/findOrderPages/1.do">第一页</a>
							<c:forEach begin="${page_no-4}" end="${page_no-1}" step="1"
								var="pageCode_before_currentPage">
								<a
									href="<%= request.getContextPath()%>/order/findOrderPages/<c:out value="${pageCode_before_currentPage}"/>.do"><c:out
										value="${pageCode_before_currentPage}" /></a>
							</c:forEach>
							<a style="background: white; color: black;"
								href="<%= request.getContextPath()%>/order/findOrderPages/<c:out value="${page_no}"/>.do"><c:out
									value="${page_no}" /></a>
							<c:forEach begin="${page_no+1}" end="${page_no+5}" step="1"
								var="pageCode_after_currentPage">
								<a
									href="<%= request.getContextPath()%>/order/findOrderPages/<c:out value="${pageCode_after_currentPage}"/>.do"><c:out
										value="${pageCode_after_currentPage}" /></a>
							</c:forEach>
							<a
								href="<%= request.getContextPath()%>/order/findOrderPages/${pageQuantity}.do">最后一页</a>
						</c:if>
						<!-- 若订单页面数多于10页,且当前页面为页面6及其后页面，且当前页面为倒数第6页（不含）之后页面，显示倒数后10页索引 -->
						<c:if test="${page_no > pageQuantity-5}">
							<a
								href="<%=request.getContextPath()%>/order/findOrderPages/1.do">第一页</a>
							<c:forEach begin="${pageQuantity-9}" end="${page_no-1}" step="1"
								var="pageCode_before_currentPage">
								<a
									href="<%= request.getContextPath()%>/order/findOrderPages/<c:out value="${pageCode_before_currentPage}"/>.do"><c:out
										value="${pageCode_before_currentPage}" /></a>
							</c:forEach>
							<a style="background: white; color: black;"
								href="<%= request.getContextPath()%>/order/findOrderPages/<c:out value="${page_no}"/>.do"><c:out
									value="${page_no}" /></a>
							<c:forEach begin="${page_no+1}" end="${pageQuantity}" step="1"
								var="pageCode_after_currentPage">
								<a
									href="<%= request.getContextPath()%>/order/findOrderPages/<c:out value="${pageCode_after_currentPage}"/>.do"><c:out
										value="${pageCode_after_currentPage}" /></a>
							</c:forEach>
							<a
								href="<%= request.getContextPath()%>/order/findOrderPages/${pageQuantity}.do">最后一页</a>
						</c:if>
					</c:if>
				</c:if>
			</aside>

		</div>
	</section>

</body>
</html>
