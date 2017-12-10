<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统管理员登录</title>
<link rel="stylesheet" href="resourses/css/logincss.css">
</head>
<body>
<div id="header">
	<div class="header_title">
		<span class="title_con">体操赛事管理系统</span>
	</div>
</div>
<div id="content">
	<div class="con">
		<div class="con_title">
			<span class="con_title_sp">欢迎登录</span>
		</div>
		<div class="con_panel">
			<form action="Logincheck" mothod="get">
				<div class="con_input">
					<span>用户名：</span><input type="text" name="name" placeholder="请输入账号"/>
				</div>
				<div class="con_input">
					<span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span><input type="password" name="psw" placeholder="请输入密码"/>
				</div>
				<input type="submit" value="登    录" class="submit-btn"/>
			</form>
		</div>
	</div>
</div>
</body>
</html>