<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<%-- function deleteFestival(id){
		$(".link_icon").click(function(){
			$(this).parent().parent().remove();
			/* 一部ajax提交删除的id */
			$.post("<%=request.getContextPath()%>/Tmember/deleteById.do",{id:id},function(data){
				console.log("deleteTMember return message is " + data);
			});
		});
	} --%>
</script>
</head>
<body>
	<!-- 引入侧边栏，顶栏 -->
	<%@ include file="/nav/AsideBar.jsp"%>

	<section class="rt_wrap content mCustomScrollbar">
		<div class="rt_content">
			<div class="page_title">
				<h2 class="fl">会员列表</h2>
				<a href="<%=request.getContextPath()%>/myWebServer/user_detail.jsp"
					class="fr top_rt_btn add_icon">添加新会员</a>
			</div>
			<section class="mtb">
				<select class="select">
					<option>会员等级</option>
					<option>普通会员</option>
					<option>高级会员</option>
				</select> <input type="text" class="textbox textbox_225"
					placeholder="输入会员号/手机/电子邮件查询..." /> <input type="button"
					value="查询" class="group_btn" />
			</section>
			<table class="table">
				<tr>
					<th>Id</th>
					<th>会员头像</th>
					<th>会员账号</th>
					<th>手机号码</th>
					<th>电子邮件</th>
					<th>验证</th>
					<th>会员等级</th>
					<th>操作</th>
				</tr>
				<c:choose>
					<c:when test="${empty user_list.list}">
						<tr>
							<td colspan="7">查无数据</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${user_list.list}" var="tMember">
							<tr>
								<td class="center" style="">${tMember.id}</td>
								<td class="center"><img src="uploadMember/${tMember.icon}"
									width="50" height="50" /></td>
								<td>${tMember.login_name}</td>
								<td class="center">${tMember.mobile_phone}</td>
								<td class="center">${tMember.email}</td>
								<td class="center"><a title="已验证" class="link_icon">&#89;</a></td>
								<td class="center">${tMember.member_type}</td>
								<td class="center"><a href="user_detail.html" title="编辑"
									class="link_icon">&#101;</a> <a
									href="<%=request.getContextPath()%>/TMember/deleteById.do?id=${tMember.id}"
									title="删除" class="link_icon">&#100;</a></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
			<!--显示分页信息-->
			<div class="row">
				<!--文字信息-->
				<div class="col-md-6">当前第 ${user_list.pageNum} 页.总共
					${user_list.pages} 页.一共 ${user_list.total} 条记录</div>
				<!--点击分页-->
				<div class="col-md-6">
					<nav aria-label="Page navigation">
						<ul class="pagination" style="float: right;">
							<li style="float: left; width: 30px; height: 20px;"><a
								href="<%=request.getContextPath()%>/TMember/findAll.do?pn=1">首页</a></li>
							<!--上一页-->
							<li style="float: left; width: 30px; height: 20px;"><c:if
									test="${user_list.hasPreviousPage}">
									<a
										href="<%=request.getContextPath()%>/TMember/findAll.do?pn=${user_list.pageNum-1}"
										aria-label="Previous"> <span aria-hidden="true">«</span>
									</a>
								</c:if></li>
							<!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
							<c:forEach items="${user_list.navigatepageNums}" var="page_num">
								<c:if test="${page_num == user_list.pageNum}">
									<li class="active"
										style="float: left; width: 30px; height: 20px;"><a
										href="#">${page_num}</a></li>
								</c:if>
								<c:if test="${page_num != user_list.pageNum}">
									<li style="float: left; width: 30px; height: 20px;"><a
										href="<%=request.getContextPath()%>/TMember/findAll.do?pn=${page_num}">${page_num}</a></li>
								</c:if>
							</c:forEach>
							<!--下一页-->
							<li style="float: left; width: 30px; height: 20px;"><c:if
									test="${user_list.hasNextPage}">
									<a
										href="<%=request.getContextPath()%>/TMember/findAll.do?pn=${user_list.pageNum+1}"
										aria-label="Next"> <span aria-hidden="true">»</span>
									</a>
								</c:if></li>
							<li style="float: left; width: 30px; height: 20px;"><a
								href="<%=request.getContextPath()%>/TMember/findAll.do?pn=${user_list.pages}">尾页</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</section>
</body>
</html>