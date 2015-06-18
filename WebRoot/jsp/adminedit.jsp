<%@ page language="java" import="java.util.*,com.dao.*,com.model.*,com.servlet.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	int adminId =Integer.parseInt(request.getParameter("adminId"));
	AdminInfo ai = new AdminInfo();
	AdminCrtl ac = new AdminCrtl();
	ai =ac.selAdmin2(adminId);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>adminedit page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>  
  <body>
	<form action="servlet/Admin_UpdateServlet" method="post" enctype="multipart/form-data">
		<div id="container">
	   	 <div id="right">
	    	<div class="content">
	       	  <div class="rtbd">
	           	<div class="jyjl">
	              <h2>修改管理员</h2>
	            </div>
	        	<table class="tblist" width="100%" cellspacing="0" cellpadding="0">                      
	              <tr>
	                <td align="right">管理员：<input type="hidden" name="adminId" id="adminId" value="<%=adminId%>"/></td>
	                <td><input type="text" name="admin_Name" id="admin_Name" value="<%=ai.getAdmin_name() %>"/></td>
	              </tr>
	              <tr>
	              	<td align="right">密码：</td>
	              	<td><input type="password" style="width: 155px;" name="admin_Pwd" id="admin_Pwd" value="<%=ai.getAdmin_pwd() %>"></td>
	              </tr>
	              <tr>
	              	<td align="right">头像：</td>
	              	<td><input type="file" style="width: 155px;" name="head_portrait" id="head_portrait" value="<%=ai.getAdmin_head_portrait() %>"></td>
	              </tr>
	              <tr>
	              	<td align="right">头像预览：</td>
	              	<td><img style="height: 330px;width: 250px;" id="head_portrait_img" alt="" src="<%=ai.getAdmin_head_portrait() %>"></td>
	              </tr>
	              <tr>
	              	<td></td>
	                <td><input type="submit" class="btnbg" value="确认修改"></td>
	              </tr>
	            </table>
		       	  </div>
		        </div>
		    </div>
		</div>
	</form>
  </body>
</html>
