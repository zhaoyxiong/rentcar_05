<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<form action="<%= request.getContextPath()%>/brand/update.do" method="post" enctype="multipart/form-data">
		<section class="rt_wrap content mCustomScrollbar">
			<div class="rt_content">
			      <div class="page_title">
				       <h2 class="fl">车辆品牌详情示例</h2>
				       <a href="<%=request.getContextPath()%>/brand/findall.do" class="fr top_rt_btn">返回车辆品牌列表</a>
			      </div>
			     <section>
			      <ul class="ulColumn2">
			           <li>
					        <input type="hidden" value="${brand.id}" name="id"/>
				       </li>
				       <li>
					        <span class="item_name" style="width:120px;">品牌编码：</span>
					        <input type="text" class="textbox textbox_295" value="${brand.brand_code}" name="brand_code" />
				       </li>
				       
				       <li>
					        <span class="item_name" style="width:120px;">品牌名称：</span>
					        <input type="text" class="textbox" value="${brand.brand_name}" name="brand_name"/>
				       </li>
				       <li>
					        <span class="item_name" style="width:120px;">上传图片：</span>
					        
					        <label class="uploadImg">
					             <%-- <img src="<%= request.getContextPath()%>/upload/${v.brand_pic}" width="50" height="50"/> --%>
						         <input type="file" name="file" value="${brand.brand_pic}" />
						         <span>上传图片</span>
					        </label>
				       </li>
				       
				       <li>
					        <span class="item_name" style="width:120px;">品牌网址：</span>
					        <input type="text" class="textbox" value="${brand.brand_url}" name="brand_url" />
				       </li>
				       
				       <li>
					        <span class="item_name" style="width:120px;">品牌简称：</span>
					        <input type="text" class="textbox" value="${brand.brand_py}" name="brand_py" />
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