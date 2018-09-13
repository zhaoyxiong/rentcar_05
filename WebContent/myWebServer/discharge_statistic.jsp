<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>后台管理系统</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="<%= request.getContextPath()%>/js/jquery.js"></script>
<script src="<%= request.getContextPath()%>/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="../js/amcharts.js" type="text/javascript"></script>
<script src="../js/serial.js" type="text/javascript"></script>
<script src="../js/pie.js" type="text/javascript"></script>

<script>
//在折线图中显示的竖区数量
var json = [{ "name": "数据1", "value": "35" },
	{ "name": "数据1", "value": "35" },
	{ "name": "数据1", "value": "35" },
	{ "name": "数据1", "value": "35" },
	{ "name": "数据1", "value": "35" }]
//初始化折线图控件
AmCharts.ready(function () {
});

$(function() {
    $( "#submit" ).click(function() {
      $("#noticepic").show();
      var begindate = $("#from").val();
      var enddate = $("#to").val();
      var begindatedays = new Date(begindate).getTime();
      var enddatedays = new Date(enddate).getTime();
  	  /* 开始日期和结束日期距离1970-01-01的天数（和mysql语句同一天对照参数已设置符合 */
      var daysbegin = begindatedays/(1000*3600*24);
      var daysend = enddatedays/(1000*3600*24);
      
      $.ajax({
          type: "POST", 
          url: "${pageContext.request.contextPath}/dischargestatistic/find.do?daysbegin="+daysbegin+"&daysend="+daysend,
          contentType:"application/json",
          dateType:"application/json",
          async: true,
          error: function(request) {
              alert("连接错误，请检查输入是否有误！");
          }, 
          success: function(data) {
              //接收后台返回的结果 
              $("#noticepic").hide();
              var PVs = JSON.parse(data);
              var chart = new AmCharts.AmSerialChart();
              chart.dataProvider = PVs;
              chart.categoryField = "name";
              chart.angle = 30;
              chart.depth3D = 20;
              //标题
              //chart.addTitle("3D折线图Demo", 15);  
              var graph = new AmCharts.AmGraph();
              chart.addGraph(graph);
              graph.valueField = "value";
              //背景颜色透明度
              graph.fillAlphas = 0.3;
              //类型
              graph.type = "line";
              //圆角
              graph.bullet = "round";
              //线颜色
              graph.lineColor = "#8e3e1f";
              //提示信息
              graph.balloonText = "[[name]]: [[value]]";
              var categoryAxis = chart.categoryAxis;
              categoryAxis.autoGridCount = false;
              categoryAxis.gridCount = json.length;
              categoryAxis.gridPosition = "start";
              chart.write("line");
          }
      });
    });
  });
</script>

<script>
  $(function() {
	  $("#from").datepicker({
		  dateFormat: 'yy-mm-dd',
	      defaultDate: "+1w",
	      changeMonth: true,
	      numberOfMonths: 1,
	      maxDate: 0,
	      onClose: function( selectedDate ) {
	        $( "#to" ).datepicker( "option", "minDate", selectedDate );
	      }
	    });
	    $( "#to" ).datepicker({
	    	dateFormat: 'yy-mm-dd',
	      defaultDate: "+1w",
	      changeMonth: true,
	      numberOfMonths: 1,
	      maxDate: 0,
	      onClose: function( selectedDate ) {
	        $( "#from" ).datepicker( "option", "maxDate", selectedDate);
	      }
	    });
  });
  </script>
<link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
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
<style type="text/css">
.loading{
    -webkit-animation:rotateImg 1s linear infinite;
    width: 80px ;
    height: 80px;
    border: 1px solid #ccc;
    vertical-align: middle;
}

@keyframes rotateImg {
  0% {transform : rotate(0deg);}
  100% {transform : rotate(360deg);}
}

@-webkit-keyframes rotateImg {
    0%{-webkit-transform : rotate(0deg);}
  100%{-webkit-transform : rotate(360deg);}
}
</style>
</head>

<body>

<header>
 <h1><img src="../images/admin_logo.png"/></h1>
</header>
aside nav
<aside class="lt_aside_nav content mCustomScrollbar">
 <h2><a href="index.html">网站首页</a></h2>
 <ul>
   <li>
   <dl>
    <dt>基础数据设置</dt>
    <!-- 当前链接则添加class:active -->
    <dd><a href="car_brand_list.html">车辆品牌管理</a></dd>
    <dd><a href="car_serial_list.html" class="active">车辆车系管理</a></dd>
    
    <dd><a href="rent_company_list.html">租赁公司管理</a></dd>
	<dd><a href="rent_car_list.html">租赁车辆管理</a></dd>
    <dd><a href="rent_car_festival_list.html">租车特殊假日配置</a></dd>	
   </dl>
  </li>
  <li>
   <dl>
    <dt>订单信息</dt>
    <dd><a href="order_list.html">订单信息管理</a></dd>
    <dd><a href="order_detail.html">订单详情管理</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>会员管理</dt>
    <dd><a href="user_list.html">会员信息管理</a></dd>
    <dd><a href="user_detail.html">添加会员信息</a></dd>
    <dd><a href="user_rank.html">会员等级管理</a></dd>
    <dd><a href="adjust_funding.html">会员资金管理</a></dd>
   </dl>
  </li>
 
  <li>
   <dl>
    <dt>配送与支付管理</dt>
    <dd><a href="express_list.html">配送方式</a></dd>
    <dd><a href="pay_list.html">支付方式</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>在线统计</dt>
    <dd><a href="discharge_statistic.html">流量统计</a></dd>
    <dd><a href="sales_volume.html">销售额统计</a></dd>
   </dl>
  </li>
  <li>
   <p class="btm_infor">© DeathGhost.cn 版权所有</p>
  </li>
 </ul>
</aside>

<!-- 正文显示区域 -->
<section class="rt_wrap content mCustomScrollbar">
	<div class="rt_content">
		<div class="page_title">
			<h2 class="fl">数据信息统计</h2>
		</div>
		<!-- 条件查询 -->
		<div style="width:700px;margin:0 auto;">
			<label for="from">查询从</label>
			<input type="text" id="from" name="from">
			<label for="to">到</label>
			<input type="text" id="to" name="to">
			<label>的访问趋势折线图</label>
			<input type="button" id="submit" value="查询"/>
			<img id="noticepic" class="loading" src="../images/loading.png" style="border:none;height:15px;width:15px;display:none"/>
		</div>
		<!-- 折线图显示区域 -->
		<div class="dataStatistic">
		    <div id="line">
		    </div>
		</div>
	</div>
</section>
</body>
</html>
