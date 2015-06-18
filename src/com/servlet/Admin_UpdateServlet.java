package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import java.io.*;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.dao.AdminCrtl;
import com.model.AdminInfo;

public class Admin_UpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8272684420813629689L;

	/**
	 * Constructor of the object.
	 */
	public Admin_UpdateServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//初始化上传
		SmartUpload smartupload=new SmartUpload();
		JspFactory fac=JspFactory.getDefaultFactory();
		PageContext pageContext=fac.getPageContext(this, request, response, null, false,JspWriter.DEFAULT_BUFFER, true);
		smartupload.initialize(pageContext) ; // 初始化上传
		try {
			smartupload.upload() ;
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 准备上传
		
		//管理员用例
		AdminInfo ai = new AdminInfo();
		AdminCrtl ac =new AdminCrtl();
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		int userid =Integer.parseInt(smartupload.getRequest().getParameter("adminId"));
		//获得相关 parameter
		String username =smartupload.getRequest().getParameter("admin_Name");
		String userpwd =smartupload.getRequest().getParameter("admin_Pwd");
		
		//命名文件所属文件夹
		String head_portrait_folder="head_portrait";
		//命名文件名
		String head_portrait=username+"_"+"head_portrait"+"."+smartupload.getFiles().getFile(0).getFileExt();
		//下面是判断文件夹是否存在,不存在就建立
		String Save_location="";
		String Save_package="";
		Save_package=head_portrait_folder;//以 head_portrait作为为文件夹名
		Save_package=Save_package.trim(); //去除空格
		Save_location=this.getServletContext().getRealPath("/")+"upload_images/"+Save_package; //文件夹的具体路径
		File ml = new File(Save_location); 
		if(ml.exists()) 
		{}else{ 
		ml.mkdir(); 
		}
		//具体的上传工作
		String file_path=Save_location+"/"+head_portrait;
		try {
			smartupload.getFiles().getFile(0).saveAs(file_path) ;
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		String file_path2=null;
		file_path2="upload_images/"+head_portrait_folder+"/"+head_portrait;		
		ai=ac.selAdmin2(userid);
		//获得此id下的产品图片路径
		String portrait_imgTemp=ai.getAdmin_head_portrait();
		portrait_imgTemp=portrait_imgTemp.trim();
		String temp[]=portrait_imgTemp.replaceAll("////","/").split("/");
		if(temp.length>1){
			portrait_imgTemp=temp[temp.length-1];
		}
		portrait_imgTemp=portrait_imgTemp.substring(0,portrait_imgTemp.lastIndexOf("."))+".";
		//产品图片、产品图赏图片均未修改
		//头像上传路径
		String head_portrait_img=null;		
		if(portrait_imgTemp.equals(head_portrait)){
			head_portrait_img=ai.getAdmin_head_portrait();
		}else{
			head_portrait_img =file_path2;
		}
		
		
		ai.setAdmin_name(username);
		ai.setAdmin_pwd(userpwd);
		ai.setAdmin_Id(userid);
		ai.setAdmin_head_portrait(head_portrait_img);
		int res =ac.updateAdmin(ai);
		if(res>0){
			out.print("<script>alert('update success');window.location.href='../jsp/adminmanage.jsp';</script>");
		}else{
			out.print("<script>alert('update failed');window.history.back();</script>");
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
