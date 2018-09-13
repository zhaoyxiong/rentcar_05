<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%String path=request.getContextPath(); 
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>后台管理系统</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css">
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery.js"></script>
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
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
<!--header-->
<header>
 <h1><img src="images/admin_logo.png"/></h1>

</header>
<!--aside nav-->
<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
 <h2><a href="index.html">网站首页</a></h2>
 <ul>
   <li>
   <dl>
    <dt>基础数据设置</dt>
    <!--当前链接则添加class:active-->
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
<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">数据信息统计</h2>
       
       
      </div>
      <label>年份:</label>
       <select id="year">
          <option value="-">-</option>
       <option value="2018">2018</option>
       <option value="2017">2017</option>
       <option value="2016">2016</option>
         <option value="2015">2015</option>
       </select>
    <div class="dataStatistic">
     <p id="load">正在加载，请稍后.......</p>
        <div id="cylindrical">
       
        </div>
    </div>
 </div>
</section>
<script src="js/amcharts.js" type="text/javascript"></script>
<script src="js/serial.js" type="text/javascript"></script>
<script src="js/pie.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function (e) {
    	$("#year").change(function(){
    		$("#year option[value='-']").remove(); 
    		showchart();
    		
    	});
    	
    	
    	function showchart(){   	
    		var year='';
    	$.ajax({
			   type: "POST",
			   url: "<%=path%>/sale/byday.do",
			   data: "year="+$("#year").val(),
			   success: function(msg){
				   console.log(msg);
				   $("#load").remove();
				   var alist=msg.split(",");
				   var list=[0,0,0,0,0,0,0,0,0,0,0,0];
				   for(var i=0;i<alist.length;i++){
					   switch((alist[i].split('-'))[0]){
					   case '01':list[0]=(alist[i].split('-'))[1];break;
					   case '02':list[1]=(alist[i].split('-'))[1];break;
					   case '03':list[2]=(alist[i].split('-'))[1];break;
					   case '04':list[3]=(alist[i].split('-'))[1];break;
					   case '05':list[4]=(alist[i].split('-'))[1];break;
					   case '06':list[5]=(alist[i].split('-'))[1];break;
					   case '07':list[6]=(alist[i].split('-'))[1];break;
					   case '08':list[7]=(alist[i].split('-'))[1];break;
					   case '09':list[8]=(alist[i].split('-'))[1];break;
					   case '10':list[9]=(alist[i].split('-'))[1];break;
					   case '11':list[10]=(alist[i].split('-'))[1];break;
					   case '12':list[11]=(alist[i].split('-'))[1];break;
					   }
					   
					   
				   }
			    	console.info(list)
			    	var json = [
			                    { "name": "一月", "value": list[0] },
			                    { "name": "二月", "value": list[1] },
			                    { "name": "三月", "value": list[2] },
			                    { "name": "四月", "value": list[3] },
			                    { "name": "五月", "value": list[4] },
			                    { "name": "六月", "value": list[5] },
			                    { "name": "七月", "value": list[6] },
			                    { "name": "八月", "value": list[7] },
			                    { "name": "九月", "value": list[8] },
			                    { "name": "十月", "value": list[9] },
			                    { "name": "十一月", "value": list[10]},
			                    { "name": "十二月", "value": list[11]},
			      ]
			        GetSerialChart(json);
			       MakeChart();
				  // console.info(msg)
			    // alert( "Data Saved: " + msg );
				  
			   }
			});}
 
    	
    	
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
    