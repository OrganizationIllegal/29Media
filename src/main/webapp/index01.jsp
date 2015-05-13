<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <title>HouseSale</title>
   <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
 <!-- 绘制圆形 -->
   <script type="text/javascript">
$(function(){
    var can = document.getElementById("can");
    var ctx = can.getContext("2d");   
    ctx.beginPath(); 
    ctx.fillStyle="#CDC9C9";  
    ctx.arc(75,75,60,0,Math.PI*2); // context.arc(x,y,r,sAngle,eAngle,counterclockwise)
    ctx.fill();　　　　　　//使用ctx.fill();就是填充色；                 
})
$(function(){
    var can = document.getElementById("canleft");
    var ctx = can.getContext("2d");   
    ctx.beginPath(); 
    ctx.fillStyle="#A52A2A";  
    ctx.arc(20,20,10,0,Math.PI*2); // context.arc(x,y,r,sAngle,eAngle,counterclockwise)
    ctx.fill();　　　　　　//使用ctx.fill();就是填充色；                 
})
$(function(){
    var can = document.getElementById("canright");
    var ctx = can.getContext("2d");   
    ctx.beginPath(); 
    ctx.fillStyle="#A52A2A";  
    ctx.arc(20,20,10,0,Math.PI*2); // context.arc(x,y,r,sAngle,eAngle,counterclockwise)
    ctx.fill();　　　　　　//使用ctx.fill();就是填充色；                 
})
</script>
<style style="text/css">
     select{
        height: auto !important;
        padding: 0px 0px !important;
     }
     .btn{
     	padding:9px 12px !important;
     	width:auto !important;
		margin:auto auto !important;
		display:auto !important;
		margin-top:auto !important;
		margin-bottom:auto !important;
     }
</style>
</head>
<body style="padding-top: 105px;">
 <jsp:include page="head.jsp" />
 <div class="container">
 <!--搜索-->
 <div style="">
        <div class="col-lg-12" style="height:400px;background:url(pic/indexsearch1.jpg);background-repeat:no-repeat;background-size: contain;">
            <div style="padding-top:70px;" class="col-lg-10 col-lg-offset-1">
                <div class="row" style="margin-bottom:5px;">
                    <div class="input-group" class="col-lg-12">
                        <div style="margin-left:20px;float:left;">
                        <select id="territory">
                        <option value ="austrilia">澳洲</option>
                        <option value ="america">美洲</option>
                        <option value ="asia">亚洲</option>
                        <option value ="africa">非洲</option>
                        <option value ="europe">欧洲</option>
                        </select>
                        </div>
                        
                        <div style="float:left;">
                            <ul style="list-style-type:none;text-align:left;padding-left:10px;" id="cities">
                                <li style="float:left;padding-left:8px;"><a style="color:white">墨尔本</a></li>
                                <li style="float:left;padding-left:8px;"><a style="color:white">悉尼</a></li>
                                <li style="float:left;padding-left:8px;"><a style="color:white">布里斯班</a></li>
                                <li style="float:left;padding-left:8px;"><a style="color:white">阿德莱德</a></li>
                                <li style="float:left;padding-left:8px;"><a style="color:white">珀斯</a></li>
                            </ul>
                        </div>
                    </div>
        
            </div>
            <form role="form" action="" method="post" >
                 <div class="row" style="margin-bottom:5px;">
                  <div class="col-lg-6">
                    <div class="input-group">
                      <input type="text" class="form-control" id="searchTerritory" name="searchcity">
                      <span class="input-group-btn">
                        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                      </span>
                    </div><!-- /input-group -->
                  </div><!-- /.col-lg-6 -->

                </div><!-- /.row -->
                <div class="row">
                    <div class="input-group" class="col-lg-3">
                        <div style="margin-left:20px;float:left;">
                        <select id="territory" class="form-control input-sm" name="type">
                        <option value ="">房屋类型</option>
                        <option value ="america">一居室</option>
                        <option value ="asia">二居室</option>
                        <option value ="africa">三居室</option>
                        <option value ="europe">四居室</option>
                        </select>
                        </div>
                        <div style="margin-left:20px;float:left;">
                        <select id="territory" class="form-control input-sm" name="minimumprice">
                        <option value ="">最小价格</option>
                        <option value ="10000">10,000</option>
                        <option value ="20000">20,000</option>
                        <option value ="30000">30,000</option>
                        <option value ="40000">40,000</option>
                        </select>
                        </div>
                        <div style="margin-left:20px;float:left;">
                        <select id="territory" class="form-control input-sm" name="maximumprice">
                        <option value ="">最大价格</option>
                        <option value ="70000">70,000</option>
                        <option value ="80000">80,000</option>
                        <option value ="90000">90,000</option>
                        <option value ="100000">100,000</option>
                        </select>
                        </div>
                    </div>
                </div>
            </form>
        </div>
            
    </div>
    
</div>
 
 <!--搜索end-->
 <!--空白-->
 <div style="height:20px;"></div>
 <!--end空白-->
 <!--我们重新定义-->
 <div style="background-color:rgba(21, 63, 101, 1);height:120px;margin-top:380px;padding-left:-20px;padding-right:-20px">
 	<div>
		<div class="col-md-offset-4 col-md-3">
		<img src="pic/jt.jpg">
		</div>
	</div>
 </div>

 
 <!--我们重新定义-->
 
 
 
 
 <!-- 轮播-->
<div>
<div id="myCarousel" class="carousel slide">
   <!-- 轮播（Carousel）指标 -->
   <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active" style="background-color:#8E8E8E"></li>
      <li data-target="#myCarousel" data-slide-to="1" style="background-color:#8E8E8E"></li>
      <li data-target="#myCarousel" data-slide-to="2" style="background-color:#8E8E8E"></li>
   </ol>   
   <!-- 轮播（Carousel）项目 -->
   <div class="carousel-inner">
      <div class="item active">
         <img src="pic/a.jpg" alt="First slide">
         <div class="carousel-caption"></div>
      </div>
      <div class="item">
         <img src="pic/a.jpg" alt="Second slide">
         <div class="carousel-caption"></div>
      </div>
      <div class="item">
         <img src="pic/a.jpg" alt="Third slide">
         <div class="carousel-caption"></div>
      </div>
   </div>
   </div>
   
   </div>
<!-- 轮播-->
 
 
 <!--why-->

 <div style="background-color:rgba(234, 234, 234, 1)">
		
		
		<div class="row" >
				<div class="col-md-4 col-md-offset-4" style="Margin-top:40px;">
					<span style="font-size:20px;color:Black;">Why work with TheRedpln</span>
			</div>
		
		<div class="col-md-4">
			</div>
 		</div>
    
    <div class="row">
    	<div class="col-md-8 col-md-offset-2" style="Margin-top:40px;Margin-bottom:40px;">
    		<img src="pic/sss.jpg" >
    		</div>
    		
    	<div clss="col-md-2" style="Margin-bottom:40px;">
    		</div>
    	
    	</div>
    </div>
 <!--why-->
 
 
 <!--郭瑞-->
 <div>
 <div class="row" style="padding-top:50px;">
 <div class="col-md-5"></div>
 <div class="col-md-2">
 <div style="color:#000000;font-weight:900;font-size:20px;text-align:center;font-family:SimHei;margin-bottom: 10px;">购买立即返还现金</div>
 <div style="position:absolute;z-index:-1"><canvas id="can" width="150" height="150"></canvas></div>
 <div style="width:150;height:150;padding-top:40px;">
 <div style="color:#A52A2A;font-weight:bolder;font-size:45px;text-align:center;font-family:SimHei;">${returnmoney}</div>
 <div style="color:#000000;font-size:15px;text-align:center;font-family:SimHei;">买卖返还现金</div>
 </div>
 </div>
 <div class="col-md-5"></div>
 </div>
 <div class="row">
 <div class="col-md-2"></div>
 <div class="col-md-8" style="margin-top:-30px;height:60px;">
 <canvas id="canleft" width="40" height="40"></canvas>
 <hr style=" height:2px;border:none;border-top:2px dotted #185598;position:relative;left:25;top:-30;" />
 <div style="position:relative;left:760;top:-80;"><canvas id="canright" width="40" height="40"></canvas></div>
 </div>
 <div class="col-md-2"></div>
 </div>
 <div class="row" style="padding-bottom: 80px;">
 <div class="col-md-4"></div>
  <div class="col-md-4">酒驾女司机遇交警拍照取证赶忙摆POSE&nbsp;3月24日讯&nbsp;3月21日下午15时许，济南历下交警在浆水泉路巡逻酒后驾驶黑色奔驰轿车沿浆水泉路由南向北行驶，
  </div>
 <div class="col-md-4"></div>
 </div>
</div>
<!--郭瑞-->
 <!--start 墨尔本-->
<div id="Molbourne">
<div id="left" class="col-xs-2">
</div>
<div style="margin-top:20px;" class="col-xs-8">
  <div class="panel panel-default">
  	<div class="panel-heading" style="background-color:white;">墨尔本</div>
  	 <div class="panel-body">
  	       <div class="col-xs-4" >
  	     		<img alt="image" class="img-responsive" src="pic/house2.jpg">
  	     	</div>
  	     	<div class="col-xs-4">
  	     		<img alt="image" class="img-responsive" src="pic/house2.jpg">
  	     	</div>
  	     	<div class="col-xs-4">
  	     		<img alt="image" class="img-responsive" src="pic/house2.jpg">
  	     	</div>
     </div>
  </div>
</div>
<div id="right" class="col-xs-2">
</div>
</div>
<!--end 墨尔本-->

<!--last-->
<div>
  	<div class="row">
  		<div class="col-md-4 col-md-offset-5" >
  			<span style="font-size:22px;color:Black;">Our latest blog posts</span>
  			</div>
  		
  		<div class="col-md-3"></div>
  		
  		
  		</div>
  		
  	<div class="row">
  		<div class="col-md-6 col-md-offset-4" style="Margin-top:10px;">
  			<span style="font-size:20px;color:Black;">From Toronto's real estate market to home staging tips</span>
  			</div>
  		
  		<div class="col-md-2"></div>
  		
  		</div>
  		
  	<div class="row" style="margin-top:40px;margin-bottom:40px;">
  		<div class="col-md-2 col-md-offset-2">
  			
  			<div>
  				<img src="pic/last.jpg">
  				<span></span>
  				
  				</div>
  		</div>
  		
  		<div class="col-md-2 col-md-offset-1">
  				<div>
  				<img src="pic/last.jpg">
  				<span> </span>
  				
  				</div>
  		</div>
  		
  		<div class="col-md-2 col-md-offset-1">
  				<div>
  				<img src="pic/last.jpg">
  				<span> </span>
  				
  				</div>
  		</div>
  		
  		</div>





    </div>
<!--last-->

</div>
<!-- 妯℃�妗�-->
   <jsp:include page="foot.jsp" />
   <script type="text/javascript" src="js/houseinfosearch.js"></script>
</body>

</html>