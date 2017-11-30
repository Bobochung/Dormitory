<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生管理</title>
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
    <li><a href="imgtable.jsp">学生管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span><a href="addStudent.jsp">添加</a></li>
<!--         <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><span><img src="images/t04.png" /></span>统计</li> -->
        <li>
        <form name="form1" method="get" action="StudentManager">
       		 查询：
       		 <select name="State" id="State" style="height: 25px">
       		 			<option value="">所有入住状态</option>
                        <option value="入住">入住</option>
                        <option value="未入住">未入住</option>
                        <option value="迁出">迁出</option>
                      </select>
              <select name="SearchRow" id="SearchRow" style="height: 25px">
                        <option value="Student_Name">姓名</option>
                        <option value="Student_ID">电话</option>
                        <option value="Student_Class">用户名</option>
                      </select>
                      <input name="SearchKey" type="text" class="text1" id="SearchKey" style="height: 25px">
                      <input type="submit" name="button" id="button" value="点击查询" class="btn">
         </form></li>
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>   
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>班级</th>
        <th>状态</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
       <c:forEach items="${studentlist}" var="student" varStatus="st">
        <tr>
            <td>${student.student_id}</td>
            <td>${student.student_name}</td>
            <td>${student.student_sex}</td>
            <td>${student.student_class}</td>
            <td>${student.student_state}</td>
            <td><a href="showStudent?studentid=${student.student_id}" class="tablelink">查看</a>     <a href="deleteStudent?studentid=${student.student_id}" class="tablelink" onclick="return del()">删除</a></td>             
        </tr>
    </c:forEach>             
        </tbody>
    </table>
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">${studentNumber}</i>条记录，当前显示第&nbsp;<i class="blue"><fmt:formatNumber type="number" value="${currerntPage}" maxFractionDigits="0"/>&nbsp;</i>页</div>
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