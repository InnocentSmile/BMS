<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>用户添加</title>
    
	<link rel="stylesheet" href="../css/1.css" type="text/css"/ >

  </head>
  
  <body class="body">
    <div class="a"><p class="p">图书管理系统</p></div>
		<div class="b">
			<nav>
			<ul>
						
			<li>
				<a >用户信息管理</a>
				<ul>
					<li>
						<a href="LookPeopleAction" >查看用户信息</a>
						
					</li>
					<li>
						<a href="http://127.0.0.1:8080/pzl/people/addPeople.jsp" >添加用户</a>
						
					</li>
					
				</ul>
			</li>
			
			<li>
				<a >图书信息管理</a>
				<ul>
					<li>
						<a href="LookBookAction" >查看图书信息</a>
						
					</li>
					<li>
						<a href="http://127.0.0.1:8080/pzl/book/addBook.jsp" >图书入库</a>
						
					</li>
					
				</ul>
			</li>
			
			<li>
				<a href="LookRecordAction">查看图书借阅记录</a>
				<ul>
					<!--<li>
						<a href="" >借</a>
						
					</li>					
					
				--></ul>
			</li>
					
		</ul>
		</nav>
		</div>
		<div class="c">
		<center>
		<s:form action="AddpeopleAction"  method="post">
				<table  align="center"  class="button">
				<tr>
				   <td>
				<s:textfield name="id"  label="借书卡号" cssClass="addpeople" size="30"  /><br/>
				
				   </td>
				</tr>
				
				<tr>
				   <td>
				<s:textfield name="name"  label="姓名" cssClass="addpeople" size="30"  /><br/>
				   </td>
				</tr>
				
				
				<tr>
				   <td>
				<s:select name="sex"  label="性别" list="{'男','女'}"   /><br/>
				   </td>
				</tr>
				
				<tr>
				   
				<s:textfield name="phone"  label="电话" cssClass="addpeople"  size="30"  /><br/>
			
				   </td>
				</tr>
				
					<tr>
				   
				<s:textfield name="address"  label="地址" cssClass="addpeople" size="30"  /><br/>
			
				   </td>
				</tr>
				<tr>
				   <td colspan="2"  align="center">
					<input type="submit" class="button1"  value="确定"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" class="button1" value="清空"/>
					</td>
				</tr>
				</table>
			</s:form>
			</center>
		</div>
  </body>
</html>
