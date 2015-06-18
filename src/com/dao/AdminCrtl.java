package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.model.AdminInfo;

/**
 * AdinCrtl
 * @author zy
 * 2015.06.16
 */
public class AdminCrtl {

	/**
	 * selAdmin
	 * @return
	 */
	public ArrayList<AdminInfo> selAdmin(){
		ArrayList<AdminInfo> al = null;
		Connection conn = ConnDB.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from admin_Info";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				if(al == null)
					al = new ArrayList<AdminInfo>();
					AdminInfo admin = new AdminInfo();
					admin.setAdmin_Id(rs.getInt("admin_Id"));
					admin.setAdmin_name(rs.getString("admin_Name"));
					admin.setAdmin_pwd(rs.getString("admin_Pwd"));
					admin.setAdmin_head_portrait(rs.getString("head_portrait"));
					al.add(admin);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnDB.close(rs, stmt, conn);
		}
		
		return al;
	}
	/**
	 * addAdmin
	 * @param admin
	 * @return
	 */
	public int addAdmin(AdminInfo admin){
		int res =0;
		Connection conn =ConnDB.getConn();
		PreparedStatement stmt =null;
		String sql ="insert into admin_Info values(?,?,?)";
			try {
				stmt =conn.prepareStatement(sql);
				stmt.setString(1, admin.getAdmin_name());
				stmt.setString(2, admin.getAdmin_pwd());
				stmt.setString(3, admin.getAdmin_head_portrait());
				res =stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnDB.close(null, stmt, conn);
			}
		return res;
	}
	/**
	 * updateAdmin
	 * @param admin
	 * @return
	 */
	public int updateAdmin(AdminInfo admin){
		int res = 0;
		Connection conn =ConnDB.getConn();
		PreparedStatement stmt = null;
		String sql = "update admin_Info set admin_Name=?,admin_Pwd=?,head_portrait=?"+" where admin_Id=?";
			try {
				stmt =conn.prepareStatement(sql);
				stmt.setString(1, admin.getAdmin_name());
				stmt.setString(2, admin.getAdmin_pwd());
				stmt.setString(3, admin.getAdmin_head_portrait());
				stmt.setInt(4, admin.getAdmin_Id());
				res = stmt.executeUpdate();				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnDB.close(null, stmt, conn);
			}
		
		return res;
		
	}

	/**
	 * deleteAdmin
	 * @param adminId
	 * @return
	 */
	public int deleteAdmin(int adminId){
		int res = 0;
		String sql = "delete admin_Info where admin_Id=?";
		Connection conn = ConnDB.getConn();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,  adminId);
			res = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnDB.close(null, stmt, conn);
		}
		return res;
	}
	/**
	 * selAdmin2
	 * @param adminId
	 * @return
	 */
	public AdminInfo selAdmin2(int adminId){
		AdminInfo ai = null;
		Connection conn = ConnDB.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from admin_Info where admin_Id=" + adminId;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){				
				ai = new AdminInfo();				
				ai.setAdmin_name(rs.getString("admin_Name"));
				ai.setAdmin_pwd(rs.getString("admin_Pwd"));
				ai.setAdmin_head_portrait(rs.getString("head_portrait"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnDB.close(rs, stmt, conn);
		}		
		return ai;
	}
}
