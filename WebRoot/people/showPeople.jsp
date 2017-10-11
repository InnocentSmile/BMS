<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
import="java.util.ArrayList,PO.peoplePO"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>查看people</title>
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
		<span class="renshuzi">你要查询的数据表中共有<%=request.getSession().getAttribute("count")%>人</span>
		<table align="center" width="80%" border="3">
		  <tr>
		    <th>记录条数</th>
		    <th>借书卡号</th>
		    <th>姓名</th>
		    <th>性别</th>
		    <th>电话</th>
		    <th>地址</th>
		    <th>用户操作</th>
		  </tr>
		
		<%
		  ArrayList list=(ArrayList)session.getAttribute("allinfo");
		  if(list.isEmpty()){
		        %>
		        <tr>
		            <td align="center"><span>暂无管理员信息！</span></td>
		        </tr>
		        <%
		        }else{
		          for(int i=0;i<list.size();i++){
		            peoplePO pPo=(peoplePO)list.get(i);	
		            %>
		            <tr>
		              <td align="center"><%=i+1%></td>
		              <td><%=pPo.getId()%></td>
		              <td><%=pPo.getName()%></td>
		              <td><%=pPo.getSex()%></td>
		              <td><%=pPo.getPhone()%></td>
		              <td><%=pPo.getAddress()%></td>
		              <td><a href="http://127.0.0.1:8080/pzl/people/changePeople.jsp?id=<%=pPo.getId()%>">修改</a>
		              <a href="DeletePeopleAction?id=<%=pPo.getId()%>" onClick="return confirm('确定删除?');">删除</a></td>
		            
		             </tr>
		             <%
		             }
		          }
		      %>       
		</table> 
		</center>
		</div>
		</body>
</html>
