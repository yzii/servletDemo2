<%@ page language="java" import="java.util.*,com.dao.*,com.servlet.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>adminadd page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="admin/css/adminIndex.css">
  </head>  
  <body>
	<form action="servlet/Admin_AddServlet" method="post" enctype="multipart/form-data" onsubmit="return checkForm()">
		<div id="container">
	   	 <div id="right">
	    	<div class="content">
	       	  <div class="rtbd">
	           	<div class="jyjl">
	              <h2>新增管理员</h2>
	            </div>
	        	<table class="tblist" width="100%" cellspacing="0" cellpadding="0">                       
	              <tr>
	                <td align="right" >管理员：<input type="text" style="width: 70px;" name="admin_Name" id="admin_Name"/></td>
	                <td align="left">&nbsp;密码：<input type="password" style="width: 70px;" name="admin_Pwd" id="admin_Pwd"></td>
	                <td align="left">&nbsp;头像：<input type="file" style="width: 150px;" name="head_portrait" id="head_portrait"></td>
	                <td align="center"><input type="submit" class="btnbg" value="确认添加"></td>
	              </tr>
	            </table>
		       	  </div>
		        </div>
		    </div>
		</div>
	</form>
  </body>
</html>
