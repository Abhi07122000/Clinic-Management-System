package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Doctor;

public class DoctorDao {
	private Connection conn;

	public DoctorDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addDoctorDetais(Doctor d) {
		boolean f = false;

		try {
			String sql = "insert into doc_details(name,age,specialisation,experience,availability) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, d.getName());
			ps.setInt(2, d.getAge());
			ps.setString(3, d.getSpecialisation());
			ps.setInt(4, d.getExperience());
			ps.setString(5, d.getAvailability());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Doctor> getAllDoctor() {
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor d = null;

		try {
			String sql = "select * from doc_details order by id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setAge(rs.getInt(3));
				d.setSpecialisation(rs.getString(4));
				d.setExperience(rs.getInt(5));
				d.setAvailability(rs.getString(6));
				list.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Doctor getDoctorById(int id) {
		Doctor d = null;

		try {
			String sql = "select * from doc_details where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setAge(rs.getInt(3));
				d.setSpecialisation(rs.getString(4));
				d.setExperience(rs.getInt(5));
				d.setAvailability(rs.getString(6));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public boolean updateDoctorDetais(Doctor d) {
		boolean f = false;

		try {
			String sql = "update doc_details set name=?,age=?,specialisation=?,experience=?,availability=? where id =? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, d.getName());
			ps.setInt(2, d.getAge());
			ps.setString(3, d.getSpecialisation());
			ps.setInt(4, d.getExperience());
			ps.setString(5, d.getAvailability());
			ps.setInt(6, d.getId());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteDoctor(int id) {
		boolean f = false;

		try {
			String sql = "delete from doc_details where id =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
