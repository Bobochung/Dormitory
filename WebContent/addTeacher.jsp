<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加教师</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<div id="tab1" class="tabson">
    
    <div class="formtext"><b>请输入需要添加(修改)的教师的个人信息</b></div>
    <form name="form1" method="post" action="">
    <ul class="forminfo">    
    
    <li><label><b>*</b>教师用户名</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="teacher_id" id="teacher_id">
    </div>    
    </li>
    <li><label><b>*</b>教师密码</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="teacher_username" id="teacher_username" >
    </div>    
    </li>
    <li><label><b>*</b>教师姓名</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="teacher_name" id="teacher_name" >
    </div>    
    </li>
    <li><label><b>*</b>性别</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="teacher_sex" id="teacher_sex">
    </div>    
    </li>
    <li><label><b>*</b>电话</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="teacher_tel" id="teacher_tel">
    </div>    
    </li>
    <li>
    <input type="submit" value="确认添加" class="btn" >
    </li>
     <li>
    <input type="button" value="返回" class="btn" onclick="javascript:window.location.href='right.jsp'">
    </li>
    </ul>
    </form>
    </div>

</body>
</html>