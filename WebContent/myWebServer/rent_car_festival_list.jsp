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
	
	<%-- $(".link_icon").click(function(){
		$(this).parent().parent().remove();
		var id = $(this).val();
		deleteFestival(id);
	});
	function deleteFestival(id){
	/* 一部ajax提交删除的id */
		$.ajax({
			url:"<%=request.getContextPath()%>/TLeaseHoliday/deleteById.do",
			//编码格式，接收格式
			dataType:"text",
			type:"post",
			//发送到服务器的格式
			contentType:"application/json",
			data:JSON.stringify({"id" : id}),
			async:true,
			success:function(data){
				console.log(data);
			},
			error:function(){
				console.log("error");
			}
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
			<h2 class="fl">节假日列表示例</h2>
			<a
				href="<%=request.getContextPath()%>/myWebServer/addTLeaseHoliday.jsp"
				class="fr top_rt_btn add_icon">添加节假日信息</a>
		</div>
		<table class="table">
			<tr>
				<th>节假日日期</th>
				<th>节假日类型</th>
				<th>操作</th>
			</tr>
			<c:choose>
				<c:when test="${empty holiday_list.list}">
					<tr>
						<td colspan="3">查无数据!</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${holiday_list.list}" var="festival">
						<tr >
							<td class="festival_date">${festival.holiday}</td>
							<td class="festival_type">${festival.holiday_type}</td>
							<td class="festival_operation"><a
								href="<%=request.getContextPath()%>/TLeaseHoliday/deleteById.do?id=${festival.id}" title="删除" class="link_icon">#</a>
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<!--显示分页信息-->
	    <div class="row">
	        <!--文字信息-->
	        <div class="col-md-6">
	            当前第 ${holiday_list.pageNum} 页.总共 ${holiday_list.pages} 页.一共 ${holiday_list.total} 条记录
	        </div>
	        <!--点击分页-->
	        <div class="col-md-6">
	            <nav aria-label="Page navigation">
	                <ul class="pagination" style="float: right;">
	                    <li style="float: left;width: 30px;height: 20px;"><a href="<%=request.getContextPath()%>/TLeaseHoliday/findAll.do?pn=1">首页</a></li>
	                    <!--上一页-->
	                    <li style="float: left;width: 30px;height: 20px;">
	                        <c:if test="${holiday_list.hasPreviousPage}">
	                            <a href="<%=request.getContextPath()%>/TLeaseHoliday/findAll.do?pn=${holiday_list.pageNum-1}" aria-label="Previous">
	                                <span aria-hidden="true">«</span>
	                            </a>
	                        </c:if>
	                    </li>
	                    <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
	                    <c:forEach items="${holiday_list.navigatepageNums}" var="page_num">
	                        <c:if test="${page_num == holiday_list.pageNum}">
	                            <li class="active" style="float: left;width: 30px;height: 20px;"><a href="#">${page_num}</a></li>
	                        </c:if>
	                        <c:if test="${page_num != holiday_list.pageNum}">
	                            <li style="float: left;width: 30px;height: 20px;"><a href="<%=request.getContextPath()%>/TLeaseHoliday/findAll.do?pn=${page_num}">${page_num}</a></li>
	                        </c:if>
	                    </c:forEach>
	                    <!--下一页-->
	                    <li style="float: left;width: 30px;height: 20px;">
	                        <c:if test="${holiday_list.hasNextPage}">
	                            <a href="<%=request.getContextPath()%>/TLeaseHoliday/findAll.do?pn=${holiday_list.pageNum+1}"
	                               aria-label="Next">
	                                <span aria-hidden="true">»</span>
	                            </a>
	                        </c:if>
	                    </li>
	                    <li style="float: left;width: 30px;height: 20px;"><a href="<%=request.getContextPath()%>/TLeaseHoliday/findAll.do?pn=${holiday_list.pages}">尾页</a></li>
	                </ul>
	            </nav>
	        </div>
	    </div>
	</div>
	</section>
</body>
</html>