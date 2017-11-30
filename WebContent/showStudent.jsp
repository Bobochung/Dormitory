<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<div id="tab1" class="tabson">
    
    <div class="formtext"><b>该学生的个人信息</b></div>
    <form name="form1" method="post" action="">
    <ul class="forminfo">    
    
    <li><label><b>*</b>楼宇id</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="student_id" id="student_id" value="${studentitem.student_id}">
    </div>    
    </li>
    <li><label><b>*</b>学生用户名</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="student_username" id="student_username" value="${studentitem.student_username}">
    </div>    
    </li>
    <li><label><b>*</b>学生姓名</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="student_name" id="student_name" value="${studentitem.student_name}">
    </div>    
    </li>
    <li><label><b>*</b>性别</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="student_sex" id="student_sex" value="${studentitem.student_sex}">
    </div>    
    </li>
    <li><label><b>*</b>入住状态</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="student_state" id="student_state" value="${studentitem.student_state}">
    </div> 
    <li><label><b>*</b>班级</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="student_class" id="student_class" value="${studentitem.student_class}">
    </div>    
    </li>    
    <li>
    <input type="submit" value="确认" class="btn" >
    </li>
     <li>
    <input type="button" value="返回" class="btn" onclick="javascript:window.location.href='imatable.jsp'">
    </li>
    </ul>
    </form>
    </div>

</body>
</html>