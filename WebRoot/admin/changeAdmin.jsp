<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
import="java.util.ArrayList,PO.adminPO,DB.dbAdmin"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>修改管理员信息</title>
    
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
				<a>管理员账户管理</a>
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
				<a>用户信息管理</a>
				<ul>
					<li>
						<a href="" >查看用户信息</a>
						
					</li>
					<li>
						<a href="" >添加用户</a>
						
					</li>
					
				</ul>
			</li>
			
			
			<li>
				<a>图书信息管理</a>
				<ul>
					<li>
						<a href="" >查看图书信息</a>
						
					</li>
					<li>
						<a href="" >图书入库</a>
						
					</li>
					
				</ul>
			</li>
			
			<li>
				<a>查看图书借阅记录</a>
				<ul>
					<!--<li>
						<a href="" >借</a>
						
					</li>
					<li>
						<a href="" >还</a>
						
					</li>
					
				--></ul>
			</li>
			<!--<li><a href="http://www.apple.com/iphone/" target="_blank">iPhone</a></li>
			<li><a href="http://www.apple.com/ipad/" target="_blank">iPad</a></li>
			<li><a href="http://www.apple.com/itunes/" target="_blank">iTunes</a></li>
			<li><a href="http://www.apple.com/support/" target="_blank">Support</a></li>
		-->
		</ul>
		</nav>
		</div>
		<div class="c">
		<center>
		<s:form action="UpdateMessageAction"  method="post">
				<table  align="center"  class="button">
				<%
				String userName=request.getParameter("userName");
				String str=new String(userName.getBytes("ISO-8859-1"),"UTF-8");
				dbAdmin DB=new dbAdmin();
     	        List list=DB.findAdmin("userName",str);
				adminPO info=(adminPO)list.get(0);
				 %>
				<tr>
				   <td>
				   
				   
				  
				账号：&nbsp;&nbsp;<input name="userName" class="xiugai" 
				   readonly="readonly"  value="<%=info.getUserName()%>"/>
				  
				  
				  
				  </td>
 
				  
				</tr>
				
				<tr>
				   <td>
				密码：&nbsp;&nbsp;<input name="password" class="xiugai" value="<%=info.getPassword()%>"/>
				   </td>
				</tr>
				
				
				
				
				<tr>
				   <td colspan="2" align="center">
				
				  
				   用户类别:<input name="type" class="xiugai" value="<%=info.getType()%>"/></td>
				</tr>
				
				
				<tr>
				   <td colspan="2" align="center">
					<center><s:submit  value="修改"/></center>
					</td>
				</tr>
				
				<tr>  <td>&nbsp;&nbsp;</td></tr>
				<tr>
				    <td align="center">
					&nbsp;&nbsp;<a href="LookMessageAction">返回</a>
					</td>
				</tr>
				</table>
			</s:form>
			</center>
  </body>
</html>
