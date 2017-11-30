<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>教师管理</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function del(){
	if(confirm("真的要删除该条记录吗?")){
	return true;
	}else{
	return false;
	}
	}
</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.html">首页</a></li>
    <li><a href="right.jsp">基本内容</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span><a href="addTeacher.jsp">添加教师</a></li>
       
        <li>
        <form name="form1" method="get" action="TeacherManager" >
       		 查询：
                      <select name="SearchRow" id="SearchRow" style="height: 25px">
                      	 <option value="">查询所有</option>
                        <option value="Teacher_Name">姓名</option>
                        <option value="Teacher_Tel">电话</option>
                        <option value="Teacher_Username">用户名</option>
                      </select>
                      <input name="SearchKey" type="text" class="text1" id="SearchKey" style="height: 25px">
                      <input type="submit" name="button" id="button" value="点击查询" class="btn">
         </form></li>
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span><a href="tab.html">设置</a></li>
        </ul>
    
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>   
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>电话</th>
        <th>用户名</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
       <c:forEach items="${teacherlist}" var="teacher" varStatus="st">
        <tr>
            <td>${teacher.teacher_id}</td>
            <td>${teacher.teacher_name}</td>
            <td>${teacher.teacher_sex}</td>
            <td>${teacher.teacher_tel}</td>
            <td>${teacher.teacher_username}</td>
            <td><a href="showTeacher?teacherid=${teacher.teacher_id}" class="tablelink">查看</a>     <a href="deleteTeacher?teacherid=${teacher.teacher_id}" class="tablelink" onclick="return del()">删除</a></td>             
        </tr>
    </c:forEach>             
        </tbody>
    </table>
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">${teacherNumber}</i>条记录，当前显示第&nbsp;<i class="blue"><fmt:formatNumber type="number" value="${currerntPage}" maxFractionDigits="0"/>&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="?start=0"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="?start=${pre}">pre</a></li>
        <li class="paginItem"><a href="?start=${next}">next</a></li>
        <li class="paginItem"><a href="?start=${last}"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
      
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>