<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>后台管理系统</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="../css/style.css">
<!--[if lt IE 9]>
<script src="../js/html5.js"></script>
<![endif]-->
<script src="../js/jquery.js"></script>
<script src="../js/jquery.mCustomScrollbar.concat.min.js"></script>
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
	<%@ include file="../nav/AsideBar.jsp"%>
	
	<section class="rt_wrap content mCustomScrollbar">
		<div class="rt_content">
			<div class="page_title">
				<h2 class="fl">数据信息统计</h2>
				<p id="load">正在加载，请稍后.......</p>
			</div>
			<div class="dataStatistic">
				<div id="cylindrical"></div>
			</div>
		</div>
	</section>
	<script src="js/amcharts.js" type="text/javascript"></script>
	<script src="js/serial.js" type="text/javascript"></script>
	<script src="js/pie.js" type="text/javascript"></script>
	<script type="text/javascript">
    $(document).ready(function (e) {
    	var date='';
    	$.ajax({
			   type: "POST",
			   url: "<%=request.getContextPath()%>/sale/byday.do",
				//data: "name=John&location=Boston",
				success : function(msg) {

					$("#load").remove();
					var list = msg.split(",");
					console.info(list)
					var json = [ {
						"name" : "一月",
						"value" : list[0]
					}, {
						"name" : "二月",
						"value" : list[1]
					}, {
						"name" : "三月",
						"value" : list[2]
					}, {
						"name" : "四月",
						"value" : list[3]
					}, {
						"name" : "五月",
						"value" : list[4]
					}, {
						"name" : "六月",
						"value" : list[5]
					}, {
						"name" : "七月",
						"value" : list[6]
					}, {
						"name" : "八月",
						"value" : list[7]
					}, {
						"name" : "九月",
						"value" : list[8]
					}, {
						"name" : "十月",
						"value" : list[9]
					}, {
						"name" : "十一月",
						"value" : list[10]
					}, {
						"name" : "十二月",
						"value" : list[11]
					},
					]
					GetSerialChart(json);
					MakeChart();
				}
			});
		});
		//柱状图  
		function GetSerialChart(json) {

			chart = new AmCharts.AmSerialChart();
			chart.dataProvider = json;
			//json数据的key  
			chart.categoryField = "name";
			//不选择      
			chart.rotate = false;
			//值越大柱状图面积越大  
			chart.depth3D = 20;
			//柱子旋转角度角度
			chart.angle = 30;
			var mCtCategoryAxis = chart.categoryAxis;
			mCtCategoryAxis.axisColor = "#efefef";
			//背景颜色透明度
			mCtCategoryAxis.fillAlpha = 0.5;
			//背景边框线透明度
			mCtCategoryAxis.gridAlpha = 0;
			mCtCategoryAxis.fillColor = "#efefef";
			var valueAxis = new AmCharts.ValueAxis();
			//左边刻度线颜色  
			valueAxis.axisColor = "#ccc";
			//标题
			valueAxis.title = "各月销售额";
			//刻度线透明度
			valueAxis.gridAlpha = 0.2;
			chart.addValueAxis(valueAxis);
			var graph = new AmCharts.AmGraph();
			graph.title = "value";
			graph.valueField = "value";
			graph.type = "column";
			//鼠标移入提示信息
			graph.balloonText = "2018年[[category]] [[value]]";
			//边框透明度
			graph.lineAlpha = 0.3;
			//填充颜色 
			graph.fillColors = "#b9121b";
			graph.fillAlphas = 1;

			chart.addGraph(graph);
			
			// CURSOR
			var chartCursor = new AmCharts.ChartCursor();
			chartCursor.cursorAlpha = 0;
			chartCursor.zoomable = false;
			chartCursor.categoryBalloonEnabled = false;
			chart.addChartCursor(chartCursor);

			chart.creditsPosition = "top-right";

			//显示在Main div中
			chart.write("cylindrical");
		}
	</script>
</body>
</html>
