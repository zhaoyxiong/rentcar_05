<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- 引入侧边栏，顶栏 -->
    <%@ include file="/nav/AsideBar.jsp"%>
	<form action="<%= request.getContextPath()%>/brand/upload.do" method="post" enctype="multipart/form-data">
	    <section class="rt_wrap content mCustomScrollbar">
			<div class="rt_content">
			      <div class="page_title">
				       <h2 class="fl">车辆品牌详情示例</h2>
				       <a href="<%=request.getContextPath()%>/brand/findall.do" class="fr top_rt_btn">返回车辆品牌列表</a>
			      </div>
			     <section>
			      <ul class="ulColumn2">
				       <li>
					   		<span class="item_name" style="width:120px;">品牌编码：</span>
					        <input type="text" class="textbox textbox_295" name="brand_code" placeholder="品牌编码..."/>
				       </li>
				       <li>
					        <span class="item_name" style="width:120px;">品牌名称：</span>
					        <input type="text" class="textbox" name="brand_name" placeholder="品牌名称..."/>
				       </li>
				       <li>
					        <span class="item_name" style="width:120px;">上传图片：</span>
					        <label class="uploadImg">
						         <input type="file" name="file"/>
						         <span>上传图片</span>
					        </label>
				       </li>
				       <li>
					        <span class="item_name" style="width:120px;">品牌网址：</span>
					        <input type="text" class="textbox" name="brand_url" placeholder="品牌网址..."/>
				       </li>
				       <li>
					        <span class="item_name" style="width:120px;">品牌简称：</span>
					        <input type="text" class="textbox" name="brand_py" placeholder="品牌简称..."/>
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