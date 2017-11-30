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
    
    <div class="formtext"><b>当前用户个人信息(若表单项为空则是待添加数据)</b></div>
    <form name="form1" method="post" action="">
    <ul class="forminfo">    
    
    <li><label><b>*</b>楼宇</label>     
    <div class="vacation">
     <select class="dfinput" name="Domitory_BuildingID" id="Domitory_BuildingID" style="height: 25px">
                <option value="">请选择</option>
                <c:forEach items="${buildingList}" var="building" varStatus="bl" >
                <option value="${building.building_id}">${building.building_name}</option>
                </c:forEach>
                </select>
    </div>    
    </li>
    <li><label><b>*</b>寝室号：</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="dormitory_name" id="dormitory_name" >
    </div>    
    </li>
    <li><label><b>*</b>寝室类型：</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="dormitory_type" id="dormitory_type">
    </div>    
    </li>
    <li><label><b>*</b>人数</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="dormitory_number" id="dormitory_number">
    </div>    
    </li>
    <li><label><b>*</b>电话</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="dormitory_tel" id="dormitory_tel" value="${admin.admin_tel}">
    </div>    
    </li>
    <li>
    <input type="submit" value="添加宿舍" class="btn" >
    </li>
    <li>
    <input type="button" value="返回上一页" class="btn" onclick="window.history.back(-1);">
    </li>
    </ul>
    </form>
    </div>

</body>
</html>