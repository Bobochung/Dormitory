<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>
<script language="JavaScript">
$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});

function mycheck(){
   if(isNull(form1.Type.value)){  
   alert("请选择身份！"); 
   return false;
   }
   if(isNull(form1.Username.value)){  
   alert("请输入用户名！"); 
   return false;
   }
   if(isNull(form1.Password.value)){
   alert("请输入密码！");
   return false;
   }
      
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
   
</script>
</head>
 

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理平台</span>    
    <ul>
    <li><a href="register.jsp">注册</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span>        
    <div class="loginbox">
    <ul>
    <form action="login" method="post" name="form1" onSubmit="return mycheck();">   
    <select name="Type" id="Type" class="logintype" style="width: 343px">
                    <option value="">请选择</option>
                    <option value="系统管理员">系统管理员</option>
                    <option value="楼宇管理员">楼宇管理员</option>
                    <option value="学生">学生</option>
    </select>
    <input type="text" name="username" class="loginuser" id="Username"value="" placeHolder="请输入用户名"/>
    <input type="password" name="password" class="loginpwd"id="Password" value=""  placeHolder="请输入密码"/>
    <input type="submit" class="loginbtn" value="登录" />     
    </form> 
    </ul>   
    </div>
    
    </div>
    
    
    
    <div class="loginbm">仅供学习交流</div>
</body>
</html>