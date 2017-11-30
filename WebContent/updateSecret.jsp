<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<div id="tab1" class="tabson">
    
    
    <form name="form1" method="post" action="">
    <ul class="forminfo">    
    
    <li><label><b>*</b>输入原密码：</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="admin_id" id="admin_id" value="${admin.admin_id}">
    </div>    
    </li>
    <li><label><b>*</b>输入新密码：</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="admin_username" id="admin_username" value="${admin.admin_username}">
    </div>    
    </li>
    <li><label><b>*</b>确认密码：</label>     
    <div class="vacation">
    <input type="text" class="dfinput" name="admin_name" id="admin_name" value="${admin.admin_password}">
    </div>    
    </li>   
    <li>
    <input type="submit" value="确认修改" class="btn">
    </li>
    </ul>
    </form>
    </div>

</body>
</html>