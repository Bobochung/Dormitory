<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
	
});	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>主页</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>系统选项
    </div>
    	<ul class="menuson">
        <li class="active"><cite></cite><a href="index.html" target="rightFrame">后台首页</a><i></i></li>
        <li><cite></cite><a href="right.jsp" target="rightFrame">楼宇管理员管理</a><i></i></li>
        <li><cite></cite><a href="imgtable.jsp" target="rightFrame">学生管理</a><i></i></li>
        <li><cite></cite><a href="form.jsp" target="rightFrame">楼宇管理</a><i></i></li>
        <li><cite></cite><a href="imglist.jsp" target="rightFrame">宿舍管理</a><i></i></li>
        <li><cite></cite><a href="studentIN.jsp" target="rightFrame">学生入住登记</a><i></i></li>
        <li><cite></cite><a href="exchangeDormitory.jsp" target="rightFrame">学生寝室调换</a><i></i></li>
        <li><cite></cite><a href="filelist.html" target="rightFrame">学生迁出登记</a><i></i></li>
        <li><cite></cite><a href="tab.html" target="rightFrame">学生缺寝记录</a><i></i></li>
        <li><cite></cite><a href="error.html" target="rightFrame">迁出记录</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>个人中心
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="updateSecret.jsp" target="rightFrame">修改密码</a><i></i></li>
        <li><cite></cite><a href="info.jsp" target="rightFrame">个人信息</a><i></i></li>
        <li><cite></cite><a href="exit.jsp" target="rightFrame">注销登录</a><i></i></li>
        </ul>     
    </dd>  
    
    
   <!--  <dd><div class="title"><span><img src="images/leftico04.png" /></span>待开发</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">自定义</a><i></i></li>
        <li><cite></cite><a href="#">常用资料</a><i></i></li>
        <li><cite></cite><a href="#">信息列表</a><i></i></li>
        <li><cite></cite><a href="#">其他</a><i></i></li>
    </ul>
    
    </dd> -->   
    
    </dl>
</body>
</html>