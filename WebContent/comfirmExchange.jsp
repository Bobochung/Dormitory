<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<div id="tab1" class="tabson">
    
    <div class="formtext"><b>当前用户个人信息</b></div>
    <form name="form1" method="post" action="">
    <ul class="forminfo">    
    
    <li><label><b>*</b>学生学号</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="admin_id" id="admin_id" value="${admin.admin_id}">
    </div>    
    </li>
    <li><label><b>*</b>学生姓名</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="admin_username" id="admin_username" value="${admin.admin_username}">
    </div>    
    </li>
    <li><label><b>*</b>目前楼宇</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="admin_name" id="admin_name" value="${admin.admin_name}">
    </div>    
    </li>
    <li><label><b>*</b>目前寝室</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="admin_sex" id="admin_sex" value="${admin.admin_sex}">
    </div>    
    </li>
    <li><label><b>*</b>调换到楼宇</label>     
    <div class="vacation">
    <select class="dfinput" name="Domitory_BuildingID" id="Domitory_BuildingID" style="height: 25px">
                <option value="">请选择</option>
                <c:forEach items="${buildingList}" var="building" varStatus="bl" >
                <option value="${building.building_id}">${building.building_name}</option>
                </c:forEach>
                </select>
    </div>    
    </li>
    <li><label><b>*</b>调换到寝室</label> 
    <div class="vacation">
    <select class="dfinput" name="Domitory_BuildingID" id="Domitory_BuildingID" style="height: 25px">
                <option value="">请选择</option>
                <c:forEach items="${buildingList}" var="building" varStatus="bl" >
                <option value="${building.building_id}">${building.building_name}</option>
                </c:forEach>
                </select>
    </div>    
    </li>
    <li>
    <input type="submit" value="确认调换" class="btn" >
    </li>
     <li>
    <input type="button" value="返回上一页" class="btn" onclick="window.history.back(-1);">
    </li>
    </ul>
    </form>
    </div>

</body>
</html>