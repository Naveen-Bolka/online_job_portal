package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDAO {

	private Connection con;

	public UserDAO(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean addUSer(User user) {
		boolean f=false;
		try {
			String sql="insert into user_job(name,qualification,email,password,role) values (?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getQualification());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getPassword());
			pst.setString(5, "user");
			
			int i=pst.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public User login(String em,String ps) {
		User u=null;
		try {
			String sql="select * from user_job where email=? and password=?";
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setString(1, em);
			pst.setString(2, ps);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setQualification(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
				u.setRole(rs.getString(6));
			}
			
		} catch (Exception e) {
			
		}
		
		return u;
	}
	
	public boolean updateUser(User user) {
		boolean b=false;
		
		try {
			
			String sql="update user_job set name=?,qualification=?,email=?,password=? where id=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,user.getName());
			pst.setString(2, user.getQualification());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getPassword());
			pst.setInt(5, user.getId());
			
			int i=pst.executeUpdate();
			
			if(i==1) {
				b=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}

}
