<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生入住</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
function mycheck() {

	if (isNull(form1.building_name.value)) {
		alert("请选择楼宇！");
		return false;
	}
	if (isNull(form1.dormitory_name.value)) {
		alert("请选择寝室！");
		return false;
	}
	if (isNull(form1.student_id.value)) {
		alert("请输入学生学号！");
		return false;
	}
	if (isNull(form1.student_name.value)) {
		alert("请输入学生姓名！");
		return false;
	}
	if (isNull(form1.student_class.value)) {
		alert("请输入学生班级！");
		return false;
	}

}

function isNull(str) {
	if (str == "")
		return true;
	var regu = "^[ ]+$";
	var re = new RegExp(regu);
	return re.test(str);
}

</script>

</head>
<body>
<div id="tab1" class="tabson">
    
    <div class="formtext"><b>欢迎使用学生入住登记</b></div>
    <form name="form1" method="post" action="StudentIN"
	onSubmit="return mycheck()">
    <ul class="forminfo">
    <li><label><b>*</b>楼宇</label>  
    

    <div class="vocation">
    <select class="dfinput" name="building_name" id="building_name">
    <c:forEach items="${buildingList}" var="building" varStatus="bl" >
                <option value="${building.building_id}">${building.building_name}</option>
    </c:forEach>
    </select>
    </div>   
    </li>
    
    <li><label><b>*</b>寝室</label>
    
    <div class="vocation">
    <input type="text" class="dfinput" name="dormitory_name" id="dormitory_name">
    </div> 
    </li>   
    
    <li><label><b>*</b>学生学号</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="student_id" placeHolder="请输入学生学号" id="student_id">
    </div>    
    </li>
    <li><label><b>*</b>学生姓名</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="student_name" placeHolder="请输入学生姓名" id="student_name">
    </div>    
    </li>
    <li><label><b>*</b>学生性别</label>     
    <div class="vacation">
    <select class="dfinput" name="student_sex" id="student_sex">
    	<option value="男">男</option>
     	<option value="女">女</option>
    </select>
    </div>    
    </li>
    <li><label><b>*</b>学生班级</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="student_class" placeHolder="请输入学生班级" id="student_class">
    </div>    
    </li>
    <li>
    <input type="submit" value="确认入住" class="btn" >
    </li>
    </ul>
    </form>
    </div>
	

</body>
</html>