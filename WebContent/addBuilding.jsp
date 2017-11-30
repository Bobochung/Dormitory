<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加楼宇</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<div id="tab1" class="tabson">
    
    <div class="formtext"><b>请输入需要添加(修改)的楼宇的信息</b></div>
    <form name="form1" method="post" action="addBuilding">
    <ul class="forminfo">    
    
    <li><label><b>*</b>楼宇名称</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="building_name" id="building_name">
    </div>    
    </li>
    <li><label><b>*</b>楼宇简介</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="building_introduction" id="building_introduction" >
    </div>    
    </li>
    
    <li>
    <input type="submit" value="确认添加" class="btn" >
    </li>
     <li>
    <input type="button" value="返回" class="btn" onclick="javascript:window.location.href='form.jsp'">
    </li>
    </ul>
    </form>
    </div>

</body>
</html>