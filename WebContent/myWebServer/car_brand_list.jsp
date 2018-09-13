<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>车辆品牌管理</title>
<!--[if lt IE 9]>
<script src="/js/html5.js"></script>
<![endif]-->
<script src="/js/jquery.js"></script>
<script src="/js/jquery.mCustomScrollbar.concat.min.js"></script>
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

<!-- 内容显示区域 -->
<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">车辆品牌列表示例</h2>
       <a href="<%=request.getContextPath()%>/myWebServer/AddBrand.jsp" class="fr top_rt_btn add_icon">添加车辆品牌</a>
      </div>
      <section class="mtb">      
       <input type="text" class="textbox textbox_225" placeholder="输入品牌编码或品牌名称..."/>
       <input type="button" value="查询" class="group_btn"/>
      </section>
		<table class="table">
			<tr>
				<th>缩略图</th>
				<th>品牌编码</th>
				<th>品牌名称</th>
				<th>品牌网址</th>
				<th>操作</th>
			</tr>
			<c:choose>
				<c:when test="${empty brands.list}">
					<tr>
						<td>查无数据!</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${brands.list}" var="brand">
						<tr>
							<td class="center"><img src="<%= request.getContextPath()%>/upload/${brand.brand_pic}" width="50"
								height="50" /></td>
							<td class="center">${brand.brand_code}</td>
							<td class="center">${brand.brand_name}</td>
							<td class="center">${brand.brand_url}</td>
							<td><a href="<%= request.getContextPath()%>/brand/updateInput/${brand.id}.do" title="编辑"
								class="link_icon">&#101;</a> <a
								href="<%= request.getContextPath()%>/brand/deleteById/${brand.id}.do" title="删除"
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
	            当前第 ${brands.pageNum} 页.总共 ${brands.pages} 页.一共 ${brands.total} 条记录
	        </div>
	        <!--点击分页-->
	        <div class="col-md-6">
	            <nav aria-label="Page navigation">
	                <ul class="pagination" style="float: right;">
	                    <li style="float: left;width: 30px;height: 20px;"><a href="<%=request.getContextPath()%>/brand/findall.do?pn=1">首页</a></li>
	                    <!--上一页-->
	                    <li style="float: left;width: 30px;height: 20px;">
	                        <c:if test="${brands.hasPreviousPage}">
	                            <a href="<%=request.getContextPath()%>/brand/findall.do?pn=${brands.pageNum-1}" aria-label="Previous">
	                                <span aria-hidden="true">«</span>
	                            </a>
	                        </c:if>
	                    </li>
	                    <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
	                    <c:forEach items="${brands.navigatepageNums}" var="page_num">
	                        <c:if test="${page_num == brands.pageNum}">
	                            <li class="active" style="float: left;width: 30px;height: 20px;"><a href="#">${page_num}</a></li>
	                        </c:if>
	                        <c:if test="${page_num != brands.pageNum}">
	                            <li style="float: left;width: 30px;height: 20px;"><a href="<%=request.getContextPath()%>/brand/findall.do?pn=${page_num}">${page_num}</a></li>
	                        </c:if>
	                    </c:forEach>
	                    <!--下一页-->
	                    <li style="float: left;width: 30px;height: 20px;">
	                        <c:if test="${brands.hasNextPage}">
	                            <a href="<%=request.getContextPath()%>/brand/findall.do?pn=${brands.pageNum+1}"
	                               aria-label="Next">
	                                <span aria-hidden="true">»</span>
	                            </a>
	                        </c:if>
	                    </li>
	                    <li style="float: left;width: 30px;height: 20px;"><a href="<%=request.getContextPath()%>/brand/findall.do?pn=${brands.pages}">尾页</a></li>
	                </ul>
	            </nav>
	        </div>
	    </div>
	</div>
</section>
</body>
</html>
