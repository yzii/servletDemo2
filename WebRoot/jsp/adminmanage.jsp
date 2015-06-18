<%@ page language="java" import="java.util.*,com.dao.*,com.model.*,com.servlet.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>adminmanage page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="admin/css/adminIndex.css">
  </head>
  <body>	
		<div id="container">
	   	 <div id="right">
	    	<div class="content">
	       	  <div class="rtbd">
	           	<div class="jyjl">
	              <h2>>后台主页</a>>管理员列表</h2>
	            </div>
	        	<table class="tblist" width="100%" cellspacing="0" cellpadding="0">                       
	              <%
                     AdminCrtl ac =new AdminCrtl();
                     ArrayList<AdminInfo> al = ac.selAdmin();
                     for(AdminInfo ai : al){
                   %>
	              <tr>
	                <td align="right">
	                <input type="hidden" name="adminId" id="adminId" value="<%=ai.getAdmin_Id()%>"/>
	                                                        管理员：
	                <input type="text" style="width: 70px;" name="admin_Name" id="admin_Name" value="<%=ai.getAdmin_name() %>"/></td>
	                <td align="left">&nbsp;密码：<input type="password" style="width: 70px;" name="admin_Pwd" id="admin_Pwd" value="<%=ai.getAdmin_pwd() %>"></td>
	                <td align="left">&nbsp;头像：<input type="text" style="width: 150px;" name="head_portrait" id="head_portrait" value="<%=ai.getAdmin_head_portrait()%>"></td>
	                <td align="center"><a href="jsp/adminedit.jsp?adminId=<%=ai.getAdmin_Id() %>">修改</a>&nbsp;&nbsp;<a href="servlet/Admin_deleteServlet?adminId=<%=ai.getAdmin_Id() %>" onclick="return confirm('确定要删除吗？')">删除</a></td>
	              </tr>
	              
	              <%} %>
	            </table>
	            <p><center><a href="jsp/adminadd.jsp">添加管理员</a></center>
		       	  </div>
		        </div>
		    </div>
		</div>
  </body>
</html>
