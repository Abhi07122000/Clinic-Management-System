package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Appointment;

public class AppointmentDao {
	private Connection conn;

	public AppointmentDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addAppointment(Appointment ap) {
		boolean f = false;

		try {
			String sql = "insert into appointment(userID,name,age,gender,address,ailment,doctorID,date,contactno,status) values(?,?,?,?,?,?,?,?,?,?) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, ap.getUserID());
			ps.setString(2, ap.getName());
			ps.setInt(3, ap.getAge());
			ps.setString(4, ap.getGender());
			ps.setString(5, ap.getAddress());
			ps.setString(6, ap.getAilment());
			ps.setInt(7, ap.getDoctorID());
			ps.setString(8, ap.getDate());
			ps.setInt(9, ap.getContactno());
			ps.setString(10 , ap.getStatus());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Appointment> getAllAppointmentById(int UserID){
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;
		
		try {
			String sql = "select * from appointment where userID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, UserID);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserID(rs.getInt(2));
				ap.setName(rs.getString(3));
				ap.setAge(rs.getInt(4));
				ap.setGender(rs.getString(5));
				ap.setAddress(rs.getString(6));
				ap.setAilment(rs.getString(7));
				ap.setDoctorID(rs.getInt(8));
				ap.setDate(rs.getString(9));
				ap.setContactno(rs.getInt(10));
				ap.setStatus(rs.getString(11));
				list.add(ap);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Appointment> getAllAppointment(){
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;
		
		try {
			String sql = "select * from appointment order by id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserID(rs.getInt(2));
				ap.setName(rs.getString(3));
				ap.setAge(rs.getInt(4));
				ap.setGender(rs.getString(5));
				ap.setAddress(rs.getString(6));
				ap.setAilment(rs.getString(7));
				ap.setDoctorID(rs.getInt(8));
				ap.setDate(rs.getString(9));
				ap.setContactno(rs.getInt(10));
				ap.setStatus(rs.getString(11));
				list.add(ap);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Appointment getAppointmentById(int id){
		
		Appointment ap = null;
		
		try {
			String sql = "select * from appointment where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserID(rs.getInt(2));
				ap.setName(rs.getString(3));
				ap.setAge(rs.getInt(4));
				ap.setGender(rs.getString(5));
				ap.setAddress(rs.getString(6));
				ap.setAilment(rs.getString(7));
				ap.setDoctorID(rs.getInt(8));
				ap.setDate(rs.getString(9));
				ap.setContactno(rs.getInt(10));
				ap.setStatus(rs.getString(11));
				 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ap;
	}
	
	public boolean updateCommentStatus(int id, int doctorID, String comment) {
		boolean f = false;
		try {
			String sql = "update appointment set status = ? where id = ? and doctorID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, comment);
			ps.setInt(2, id);
			ps.setInt(3, doctorID);
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
}