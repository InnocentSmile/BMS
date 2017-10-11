<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书信息管理系统</title>
    
	<link rel="stylesheet" href="css/style.css" />

  </head>
  
  <body>
    <header id="header">
			<div class="center">
				<h1 class="logo">图书管理系统</h1>
			</div>
		</header>
		
		<div id="login">
			<div class="box">
				<div>
					<center><h1>管理员登录</h1></center>
				</div>
				<s:form action="loginAction"  method="post">
				<table  align="center"  class="button">
				<tr>
				   <td>
				<s:textfield name="userName"   label="账号"  size="30" placeholder="请输入管理员账号"/>
				   </td>
				</tr>
				
				<tr>
				   <td>
				<s:password name="password"  label="密码" size="30" placeholder="请输入密码"/>
				   </td>
				</tr>
				
				<tr>
				   <td colspan="2"  align="center">
					<input type="submit" class="button1"  value="确定"/>
					&nbsp;&nbsp;
					<input type="reset" class="button1" value="重置"/>
					</td>
				</tr>
				</table>
			</s:form>
			
			</div>
			
		</div>
		
	
  </body>
</html>
