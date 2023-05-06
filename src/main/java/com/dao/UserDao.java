package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDao {
	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean register(User u) {
		boolean f = false;
		
		try {
			String sql="insert into user_details(role,full_name,email,password) values(?,?,?,?) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getRole());
			ps.setString(2, u.getFullname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public User login(String em, String psw) {
		User u = null;
		try {
			String sql = "select * from user_details where email = ? and password = ? and role = 'admin'";
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, psw);
			//ps.setString(3, rl);
			
			ResultSet rs = ps.executeQuery();	
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setRole(rs.getString(2));
				u.setFullname(rs.getString(3));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return u;
	}
	
	public User Rlogin(String em, String psw) {
		User u = null;
		try {
			String sql = "select * from user_details where email = ? and password = ? and role = 'reporter'";
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, psw);
			//ps.setString(3, rl);
			
			ResultSet rs = ps.executeQuery();	
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setRole(rs.getString(2));
				u.setFullname(rs.getString(3));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return u;
	}
	
	public User Plogin(String em, String psw) {
		User u = null;
		try {
			String sql = "select * from user_details where email = ? and password = ? and role = 'patient'";
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, psw);
			//ps.setString(3, rl);
			
			ResultSet rs = ps.executeQuery();	
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setRole(rs.getString(2));
				u.setFullname(rs.getString(3));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return u;
	}
	
	
}
