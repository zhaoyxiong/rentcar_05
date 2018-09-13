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
	
	function doCkeck(){  
    	var phone = document.getElementById('mobile_phone').value;
    	if(phone==""){
    		alert("手机号不能为空");
    		return false;
    	}
        if(!(/^1[34578]\d{9}$/.test(phone))){ 
            alert("手机号码格式有误，请重填");  
            return false; 
        }
        
        var tel = document.getElementById('telephone').value;
        if(!/^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/.test(tel)){
        	alert('固定电话有误，请重填');
        	return false;
        }
        
        var account = document.getElementById('bank_account').value;
        if(!/^\d{19}$/g.test(account)){
        	alert('银行卡号有误，请重填');
        	return false;
        }
    	
        for(var i=0;i<document.myform.elements.length-1;i++)
        {
           if(document.myform.elements[i].value=="")
           {
              alert("当前表单不能有空项");
              document.myform.elements[i].focus();
              return false;
           }
        }
        return true;
      
    } 
	
</script>
</head>
<body>
	<!-- 引入侧边栏，顶栏 -->
	<%@ include file="/nav/AsideBar.jsp"%>
	
	<section class="rt_wrap content mCustomScrollbar">
		<div class="rt_content">
			<div class="page_title">
				<h2 class="fl">租赁公司信息修改</h2>
				<a class="fr top_rt_btn" href="<%=request.getContextPath()%>/myWebServer/rent_company_list.jsp">返回租赁公司列表</a>
			</div>
			<section>
				<form name="myform" action="<%=request.getContextPath()%>/company/update.do" method="post" onsubmit="return doCkeck();">
					<c:forEach var="v" items="${companylist.list}">
						<c:if test="${v.id==param.id}">
							<ul class="ulColumn2">
								<li><span class="item_name" style="width: 120px;">公司id：</span>
									<input type="text" class="textbox textbox_295" value="${v.id}"
									readonly name="id" /></li>
								<li><span class="item_name" style="width: 120px;">公司名称：</span>
									<input type="text" class="textbox textbox_295"
									value="${v.company_name}" placeholder="公司名称..."
									name="company_name" /></li>
								<li><span class="item_name" style="width: 120px;">联系人：</span>
									<input type="text" class="textbox  textbox_295"
									value="${v.lease_name}" placeholder="联系人..." name="lease_name" />

								</li>

								<li><span class="item_name" style="width: 120px;">联系电话：</span>
									<input id="telephone" type="text" class="textbox textbox_295"
									value="${v.telephone}" placeholder="联系电话..." name="telephone" />
								</li>
								<li><span class="item_name" style="width: 120px;">联系手机：</span>
									<input id="mobile_phone" type="text" class="textbox textbox_295"
									value="${v.mobile_phone}" placeholder="联系手机..."
									name="mobile_phone" /></li>
								<li><span class="item_name" style="width: 120px;">商家地址：</span>
									<input type="text" class="textbox textbox_295"
									value="${v.address}" placeholder="商家地址..." name="address" /></li>
								<li><span class="item_name" style="width: 120px;">邮箱地址：</span>
									<input type="text" class="textbox textbox_295"
									value="${v.mail}" placeholder="邮箱地址..." name="mail" /></li>
								<li><span class="item_name" style="width: 120px;">商家开户行：</span>
									<input type="text" class="textbox textbox_295"
									value="${v.open_bank}" placeholder="商家开户行..." name="open_bank" />
								</li>
								<li><span class="item_name" style="width: 120px;">商家银行账号：</span>
									<input id="bank_account" type="text" class="textbox textbox_295"
									value="${v.bank_account}" placeholder="商家银行账号..."
									name="bank_account" /></li>
								<li><span class="item_name" style="width: 120px;">商家简介：</span>
									<input type="text" width="200px" class="textbox textbox_295"
									value="${v.remark}" placeholder="商家简介..." name="remark" /></li>
								<li>
								<li><span class="item_name" style="width: 120px;">审核状态：</span>
									<label class="single_selection"><input id="w1" type="checkbox"
										name="audit_state" value="1" />是否审核</label>
										<script	type="text/javascript">
									  console.info("${v.audit_state}")
									  console.info("${v.audit_state}" == '1')
									  console.info("${v.audit_state}" == 1)
									if ("${v.audit_state}" == '1') {
										$("#w1").attr("checked", true);
									}
								</script></li>
																		
								<li><span class="item_name" style="width: 120px;"></span> <input
									type="submit" class="link_btn" /></li>
							</ul>
						</c:if>
					</c:forEach>
				</form>
			</section>
		</div>
	</section>
	<script src="/js/ueditor.config.js"></script>
	<script src="/js/ueditor.all.min.js">
		
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