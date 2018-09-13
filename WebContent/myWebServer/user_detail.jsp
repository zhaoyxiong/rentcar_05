<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</script>
</head>
<body>
	<!-- 引入侧边栏，顶栏 -->
	<%@ include file="/nav/AsideBar.jsp"%>
	<section class="rt_wrap content mCustomScrollbar">
		<div class="page_title">
			<h2 class="fl">会员上传示例</h2>
			<a class="fr top_rt_btn"  href="<%=request.getContextPath()%>/TMember/findAll.do">返回会员列表</a>
		</div>
		<div class="rt_content">
			<!-- enctype="multipart/form-data" 表明表单是二进制流传过来的数据 -->
			<form action="<%=request.getContextPath()%>/TMember/addTMember.do"
				method="post" enctype="multipart/form-data">
				<ul class="ulColumn2">
					<li><span class="item_name" style="width: 120px;">上传头像：</span>
						<label class="uploadImg"> <input type="file" name="file" />
							<span>上传头像</span>
					</label></li>
					<li><span class="item_name" style="width: 120px;">用户名：</span> <input
						type="text" name="member_name" class="textbox textbox_225" value=""
						placeholder="用户名..." /></li>
					<li><span class="item_name" style="width: 120px;">用户登录名：</span>
						<input type="text" class="textbox textbox_225" name="login_name"
						value="DeathGhost" placeholder="用户登录名..." /></li>
					<li><span class="item_name" style="width: 120px;">登陆密码：</span>
						<input type="password" class="textbox textbox_225"
						name="member_pwd" value="" placeholder="会员密码..." /></li>
					<li><span class="item_name" style="width: 120px;">性别：</span> <label
						class="single_selection"> <input type="radio" name="gender"
							checked value="0" />男
					</label> <label class="single_selection"> <input type="radio"
							name="gender" value="1" />女
					</label></li>
					<li><span class="item_name" style="width: 120px;">身份证号：</span>
						<input type="text" class="textbox" name="id_card" value=""
						placeholder="身份证号..." /></li>
					<li><span class="item_name" style="width: 120px;">手机号：</span> <input
						type="text" class="textbox" name="mobile_phone"
						placeholder="手机号..." /></li>
					<li><span class="item_name" style="width: 120px;">会员等级：</span>
						<select class="select" name="member_type">
							<option value="0">会员等级</option>
							<option value="1">普通会员</option>
							<option value="2">高级会员</option>
					</select></li>
					<li><span class="item_name" style="width: 120px;">电子邮箱：</span>
						<input type="email" class="textbox textbox_225" name="email"
						value="DeathGhost@sina.cn" placeholder="电子邮件地址..." /> <span
						class="errorTips">错误提示信息...</span></li>
					<li><span class="item_name" style="width: 120px;">手机号码：</span>
						<input type="tel" class="textbox textbox_225" name="mobile_phone"
						value="18300000000" placeholder="手机号码..." /> <span
						class="errorTips">错误提示信息...</span></li>
					<li><span class="item_name" style="width: 120px;">可用资金：</span>
						<input type="text" class="textbox textbox_225" value="1599.00"
						placeholder="可用资金（单位：元）..." readonly /> <span>元</span></li>
					<li><span class="item_name" style="width: 120px;">地址：</span> <select
						class="select" name="province">
							<option>选择省份</option>
							<option value="陕西省">陕西省</option>
							<option value="山西省">山西省</option>
					</select> <select class="select" name="city">
							<option>选择城市</option>
							<option value="西安市">西安市</option>
							<option value="大同市">大同市</option>
					</select> <select class="select" name="area">
							<option>选择区/县</option>
							<option value="长安县">长安县</option>
							<option value="不晓得">不晓得</option>
					</select></li>
					<li><span class="item_name" style="width: 120px;">详细地址：</span>
						<input type="text" class="textbox textbox_295" name="address"
						value="陕西省西安市未央区凤城五路旺景国际大厦" placeholder="详细地址..." /> <span
						class="errorTips">错误提示信息...</span></li>
					<li><span class="item_name" style="width: 120px;"></span> <input
						type="submit" class="link_btn" value="更新/保存" /></li>
				</ul>
			</form>
		</div>
	</section>
</body>
</html>
