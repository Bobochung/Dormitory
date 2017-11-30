<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    
    <li><label><b>*</b>管理员id</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="admin_id" id="admin_id" value="${admin.admin_id}">
    </div>    
    </li>
    <li><label><b>*</b>管理员用户名</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="admin_username" id="admin_username" value="${admin.admin_username}">
    </div>    
    </li>
    <li><label><b>*</b>管理员姓名</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="admin_name" id="admin_name" value="${admin.admin_name}">
    </div>    
    </li>
    <li><label><b>*</b>管理员性别</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="admin_sex" id="admin_sex" value="${admin.admin_sex}">
    </div>    
    </li>
    <li><label><b>*</b>管理员电话</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="admin_tel" id="admin_tel" value="${admin.admin_tel}">
    </div>    
    </li>
    <li>
    <input type="submit" value="确认修改" class="btn" >
    </li>
    </ul>
    </form>
    </div>

</body>
</html>