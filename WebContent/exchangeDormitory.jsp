<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>寝室调换</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<div id="tab1" class="tabson">
    
    
    <form name="form1" method="post" action="searchStudent">
    <ul class="forminfo">    
    
    <li><b>*</b>输入需要调换寝室的学生学号：     
    <div class="vacation">
    <input type="text" class="dfinput" name="student_username" id="student_username">
    </div>    
    </li>    
    <li>
    <input type="submit" value="查找" class="btn">
    </li>
    </ul>
    </form>
    </div>

</body>
</html>