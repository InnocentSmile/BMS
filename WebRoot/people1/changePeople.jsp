<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
import="java.util.ArrayList,PO.peoplePO,DB.dbPeople" %>
<%@taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>修改people</title>
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
		<s:form action="updatepeopleAction"  method="post">
				<table  align="center"  class="button">
				<%
				String id=request.getParameter("id");
				String str=new String(id.getBytes("ISO-8859-1"),"UTF-8");
				dbPeople DB=new dbPeople();
     	        List list=DB.findInfo("id",str);
				peoplePO info=(peoplePO)list.get(0);
				 %>
				
				<tr>
				   <td>
				借书卡号：<input name="id"  readonly="readonly" class="addpeople"  size="30" value="<%=info.getId()%>" />
				
				   </td>
				</tr>
				
				<tr>
				   <td>
				姓名：&nbsp;&nbsp;<input name="name" class="addpeople"   size="30" value=<%=info.getName()%> />
				   </td>
				</tr>
				
				
				<tr>
				   <td>
				性别：&nbsp;&nbsp;<input name="sex" class="addpeople"     size="30" value=<%=info.getSex()%> />
				   </td>
				</tr>
				
				<tr>
					<td>		   
				电话:&nbsp;&nbsp;<input name="phone"  class="addpeople"    size="30" value=<%=info.getPhone()%> />			
				   </td>
				</tr>
				
					<tr>
				   <td>
				地址：&nbsp;&nbsp;<input name="address"  class="addpeople"   size="30" value=<%=info.getAddress() %>  />
			
				   </td>
				</tr>
				<tr>
				   <td colspan="2" align="center">
					<center><s:submit  value="修改"/></center>
					</td>
				</tr>
				
				<tr>  <td>&nbsp;&nbsp;</td></tr>
				<tr>
				    <td align="center">
					&nbsp;&nbsp;<a href="LookPeopleAction">返回</a>
					</td>
				</tr>
				</table>
			</s:form>
			</center>
		</div>
  </body>
</html>
