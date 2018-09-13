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
<script src="/js/html5.js"></script>
<![endif]-->
<script src="/js/jquery.js"></script>
<script src="/js/jquery.mCustomScrollbar.concat.min.js"></script>
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
	<section class="rt_wrap content mCustomScrollbar">
		<div class="rt_content">
			<div class="page_title">
				<h2 class="fl">租赁公司列表示例</h2>
				<a href="<%=request.getContextPath()%>/myWebServer/rent_company_add.jsp" class="fr top_rt_btn add_icon">添加租赁公司</a>
			</div>
			<section class="mtb">
				<input type="text" class="textbox textbox_225"
					placeholder="输入公司名称或商家地址..." /> <input type="button" value="查询"
					class="group_btn" />
			</section>
			<table class="table">
				<tr>
					<th>编号</th>
					<th>公司名称</th>
					<th>联系人</th>
					<th>联系电话</th>
					<th>联系手机</th>
					<th>商家地址</th>
					<th>邮箱地址</th>
					<th>商家开户行</th>
					<th>商家银行账号</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${companylist.list}" var="company">
					<tr>
						<td class="center">${company.id}</td>
						<td>${company.company_name}</td>
						<td class="center">${company.lease_name}</td>
						<td class="center">${company.telephone}</td>
						<td class="center">${company.mobile_phone}</td>
						<td class="center">${company.address}</td>
						<td class="center">${company.mail}</td>
						<td class="center">${company.open_bank}</td>
						<td class="center">${company.bank_account}</td>
						<td class="center"><a href="#" title="预览" class="link_icon"
							target="_blank">&#118;</a> <a
							href="<%=request.getContextPath()%>/myWebServer/update_company.jsp?id=${company.id}" title="编辑"
							class="link_icon">&#101;</a> <a
							href="<%=request.getContextPath()%>/company/dele.do?id=${company.id}" title="删除"
							class="link_icon">&#100;</a></td>
					</tr>
				</c:forEach>
			</table>
			<!--显示分页信息-->
		    <div class="row">
		        <!--文字信息-->
		        <div class="col-md-6">
		            当前第 ${companylist.pageNum} 页.总共 ${companylist.pages} 页.一共 ${companylist.total} 条记录
		        </div>
		        <!--点击分页-->
		        <div class="col-md-6">
		            <nav aria-label="Page navigation">
		                <ul class="pagination" style="float: right;">
		                    <li style="float: left;width: 30px;height: 20px;"><a href="<%=request.getContextPath()%>/company/list.do?pn=1">首页</a></li>
		                    <!--上一页-->
		                    <li style="float: left;width: 30px;height: 20px;">
		                        <c:if test="${companylist.hasPreviousPage}">
		                            <a href="<%=request.getContextPath()%>/company/list.do?pn=${companylist.pageNum-1}" aria-label="Previous">
		                                <span aria-hidden="true">«</span>
		                            </a>
		                        </c:if>
		                    </li>
		                    <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
		                    <c:forEach items="${companylist.navigatepageNums}" var="page_num">
		                        <c:if test="${page_num == companylist.pageNum}">
		                            <li class="active" style="float: left;width: 30px;height: 20px;"><a href="#">${page_num}</a></li>
		                        </c:if>
		                        <c:if test="${page_num != companylist.pageNum}">
		                            <li style="float: left;width: 30px;height: 20px;"><a href="<%=request.getContextPath()%>/company/list.do?pn=${page_num}">${page_num}</a></li>
		                        </c:if>
		                    </c:forEach>
		                    <!--下一页-->
		                    <li style="float: left;width: 30px;height: 20px;">
		                        <c:if test="${companylist.hasNextPage}">
		                            <a href="<%=request.getContextPath()%>/company/list.do?pn=${companylist.pageNum+1}"
		                               aria-label="Next">
		                                <span aria-hidden="true">»</span>
		                            </a>
		                        </c:if>
		                    </li>
		                    <li style="float: left;width: 30px;height: 20px;"><a href="<%=request.getContextPath()%>/company/list.do?pn=${companylist.pages}">尾页</a></li>
		                </ul>
		            </nav>
		        </div>
		    </div>
		</div>
	</section>
</body>
</html>
