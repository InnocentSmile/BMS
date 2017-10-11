<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
import="java.util.ArrayList,PO.adminPO"%>
<%@taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书管理系统</title>
  <link rel="stylesheet" href="../css/1.css" type="text/css"/ >
  
  </head>
  <body class="body">
  <div class="a"><p class="p">图书管理系统</p></div>
		<div class="b">
			<nav>
			<ul>
			<!--<li><a href="http://127.0.0.1:8080/pzl/admin/addAdmin.jsp">Home</a></li>
			<li><a href="http://store.apple.com/" target="_blank">Store</a></li>
			-->
			<li>
				<a >管理员账户管理</a>
				<ul>
					<li>
						<a href="LookMessageAction" >查看管理员</a>
						
					</li>
					<li>
						<a href="http://127.0.0.1:8080/pzl/admin/addAdmin.jsp" >添加管理员</a>
						
					</li>
					
				</ul>
			</li>
			
			
			<li>
				<a >用户信息管理</a>
				<ul>
					<li>
						<a href="LookPeopleAction1" >查看用户信息</a>
						
					</li>
					<li>
						<a href="http://127.0.0.1:8080/pzl/people1/addPeople.jsp" >添加用户</a>
						
					</li>
					
				</ul>
			</li>
			
			<li>
				<a >图书信息管理</a>
				<ul>
					<li>
						<a href="LookBookAction1" >查看图书信息</a>
						
					</li>
					<li>
						<a href="http://127.0.0.1:8080/pzl/book1/addBook.jsp" >图书入库</a>
						
					</li>
					
				</ul>
			</li>
			
			<li>
				<a href="LookRecordAction1">查看图书借阅记录</a>
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
		<center><table boder="1" align="center" bgcolor="#AABBCCDD" width="501" height="89">
   
    
    <tr>
        <td> 
          欢迎  ${userName}  超级管理员,登陆成功!有管理员账号管理，学生基本信息管理，图书信息管理，办理借书还书等权限。
        </td>
    </tr>
    </table>
    </center>
    </div>
  
    
     
    
  </body>
</html>
