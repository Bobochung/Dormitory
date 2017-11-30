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

</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">基本内容</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span><a href="addDormitory.jsp">添加</a></li>
<!--    <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><span><img src="images/t04.png" /></span>统计</li> -->
        <li>
        <form name="form1" method="get" action="DormitoryManager">
       		 查询：
       		 <select name="Domitory_BuildingID" id="Domitory_BuildingID" style="height: 25px">
              	<option value="">全部楼宇</option>
                <c:forEach items="${buildingList}" var="building" varStatus="bl" >
                <option value="${building.building_id}">${building.building_name}</option>
                </c:forEach>
                </select>
                      <select name="SearchRow" id="SearchRow" style="height: 25px">
                        <option value="Domitory_Name">寝室号</option>
                        <option value="Domitory_Tel">电话</option>
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
        <th>楼宇</th>
        <th>寝室号</th>
        <th>寝室类型</th>
        <th>人数</th>
        <th>电话</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
       <c:forEach items="${dormitorylist}" var="dormitory" varStatus="st">
        <tr>
            <td>${dormitory.building_name}</td>
            <td>${dormitory.domitory_name}</td>
            <td>${dormitory.domitory_type}</td>
            <td>${dormitory.domitory_number}</td>
            <td>${dormitory.domitory_tel}</td>
            <td><a href="updateDormitory?dormitoryid=${dormitory.domitory_id}" class="tablelink">修改</a>     <a href="deleteDormitory?dormitoryid=${dormitory.domitory_id}" class="tablelink">删除</a></td>             
        </tr>
    </c:forEach>             
        </tbody>
    </table>
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">${dormitoryNumber}</i>条记录，当前显示第&nbsp;<i class="blue"><fmt:formatNumber type="number" value="${currerntPage}" maxFractionDigits="0"/>&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="?start=0"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="?start=${pre}">pre</a></li>
        <li class="paginItem"><a href="?start=${next}">next</a></li>
        <li class="paginItem"><a href="?start=${last}"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
      
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>