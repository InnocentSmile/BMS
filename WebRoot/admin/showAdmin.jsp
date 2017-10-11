 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
    import="java.util.ArrayList,PO.adminPO"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>查看管理员</title>
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
				<a >用户信息管理</a>
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
				<a >图书信息管理</a>
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
				<a >查看图书借阅管理</a>
				<ul>
					
					
				</ul>
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
		<span class="renshuzi">你要查询的数据表中共有<%=request.getSession().getAttribute("count")%>个管理员</span>
		<table align="center" width="80%" border="3">
		  <tr>
		    <th>记录条数</th>
		    <th>用户名</th>
		    <th>密码</th>
		    <th>用户类别  </th>
		    <th>用户操作  </th>
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
		          for(int i=1;i<list.size();i++){
		            adminPO aPo=(adminPO)list.get(i);	
		            %>
		            <tr>
		              <td align="center"><%=i%></td>
		              <td><%=aPo.getUserName()%></td>
		              <td><%=aPo.getPassword()%></td>
		              <td><%=aPo.getType()%></td>
		              <td><a href="http://127.0.0.1:8080/pzl/admin/changeAdmin.jsp?userName=<%=aPo.getUserName()%>">修改</a>
		              <a href="DeleteMessageAction?id=<%=aPo.getId()%>" onClick="return confirm('确定删除?');">删除</a></td>
		            
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
