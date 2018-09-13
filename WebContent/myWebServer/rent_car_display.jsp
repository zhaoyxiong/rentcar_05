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
	<%@ include file="../nav/AsideBar.jsp" %>
	
	<section class="rt_wrap content mCustomScrollbar">
		<form action="<%=request.getContextPath()%>/car/add.do" method="post"
			enctype="multipart/form-data">
			<div class="rt_content">
				<div class="page_title">
					<h2 class="fl">租赁车辆详情示例</h2>
					<a class="fr top_rt_btn" href="<%=request.getContextPath()%>/myWebServer/rent_car_list.jsp">返回租赁车辆列表</a>
				</div>
				<section>
					<c:forEach var="v" items="${car}">
						<c:if test="${v.id==param.id}">
							<ul class="ulColumn2">
								<li><span class="item_name" style="width: 120px;">公司名称：</span>
									${v.company.company_name}</li>
								<li><span class="item_name" style="width: 120px;">车辆编号：</span>
									${v.car_no }</li>
								<li><span class="item_name" style="width: 120px;">车辆品牌：</span>
									${v.car_brand }</li>
								<li><span class="item_name" style="width: 120px;">车系编号：</span>
									${v.car_serial }</li>
								<li><span class="item_name" style="width: 120px;">车辆普通价：</span>
									${v.normal_price }元</li>
								<li><span class="item_name" style="width: 120px;">车辆假日价：</span>
									${v.holiday_price }元</li>
								<li><span class="item_name" style="width: 120px;">车辆特殊价：</span>
									${v.special_price }元</li>
								<li><span class="item_name" style="width: 120px;">座位数：</span>
									${v.seating }个</li>
								<li><span class="item_name" style="width: 120px;">状态：</span>
									<c:choose>
										<c:when test="${v.audit_state==1 }">已审核</c:when>
										<c:otherwise>未审核</c:otherwise>
									</c:choose> <c:choose>
										<c:when test="${v.updown_state==1 }">已上下架</c:when>
										<c:otherwise>未上下架
									</c:otherwise>
									</c:choose> <c:choose>
										<c:when test="${v.has_navigat==1 }">有导航</c:when>
										<c:otherwise>无导航</c:otherwise>
									</c:choose></li>
								<li><span class="item_name" style="width: 120px;">车辆描述：</span>
									${v.car_desc }</li>
							</ul>
						</c:if>
					</c:forEach>
				</section>
			</div>
		</form>
	</section>
	<script src="../js/ueditor.config.js"></script>
	<script src="../js/ueditor.all.min.js">
		
	</script>
	<script type="text/javascript">
		//实例化编辑器
		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
		var ue = UE.getEditor('editor');

		function isFocus(e) {
			alert(UE.getEditor('editor').isFocus());
			UE.dom.domUtils.preventDefault(e)
		}
		function setblur(e) {
			UE.getEditor('editor').blur();
			UE.dom.domUtils.preventDefault(e)
		}
		function insertHtml() {
			var value = prompt('插入html代码', '');
			UE.getEditor('editor').execCommand('insertHtml', value)
		}
		function createEditor() {
			enableBtn();
			UE.getEditor('editor');
		}
		function getAllHtml() {
			alert(UE.getEditor('editor').getAllHtml())
		}
		function getContent() {
			var arr = [];
			arr.push("使用editor.getContent()方法可以获得编辑器的内容");
			arr.push("内容为：");
			arr.push(UE.getEditor('editor').getContent());
			alert(arr.join("\n"));
		}
		function getPlainTxt() {
			var arr = [];
			arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
			arr.push("内容为：");
			arr.push(UE.getEditor('editor').getPlainTxt());
			alert(arr.join('\n'))
		}
		function setContent(isAppendTo) {
			var arr = [];
			arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
			UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
			alert(arr.join("\n"));
		}
		function setDisabled() {
			UE.getEditor('editor').setDisabled('fullscreen');
			disableBtn("enable");
		}

		function setEnabled() {
			UE.getEditor('editor').setEnabled();
			enableBtn();
		}

		function getText() {
			//当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
			var range = UE.getEditor('editor').selection.getRange();
			range.select();
			var txt = UE.getEditor('editor').selection.getText();
			alert(txt)
		}

		function getContentTxt() {
			var arr = [];
			arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
			arr.push("编辑器的纯文本内容为：");
			arr.push(UE.getEditor('editor').getContentTxt());
			alert(arr.join("\n"));
		}
		function hasContent() {
			var arr = [];
			arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
			arr.push("判断结果为：");
			arr.push(UE.getEditor('editor').hasContents());
			alert(arr.join("\n"));
		}
		function setFocus() {
			UE.getEditor('editor').focus();
		}
		function deleteEditor() {
			disableBtn();
			UE.getEditor('editor').destroy();
		}
		function disableBtn(str) {
			var div = document.getElementById('btns');
			var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
			for (var i = 0, btn; btn = btns[i++];) {
				if (btn.id == str) {
					UE.dom.domUtils.removeAttributes(btn, [ "disabled" ]);
				} else {
					btn.setAttribute("disabled", "true");
				}
			}
		}
		function enableBtn() {
			var div = document.getElementById('btns');
			var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
			for (var i = 0, btn; btn = btns[i++];) {
				UE.dom.domUtils.removeAttributes(btn, [ "disabled" ]);
			}
		}

		function getLocalData() {
			alert(UE.getEditor('editor').execCommand("getlocaldata"));
		}

		function clearLocalData() {
			UE.getEditor('editor').execCommand("clearlocaldata");
			alert("已清空草稿箱")
		}
	</script>
</body>
</html>
