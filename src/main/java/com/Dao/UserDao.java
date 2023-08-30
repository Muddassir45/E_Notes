package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.User.UserDeatails;

public class UserDao {
	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addUser(UserDeatails us) {
		boolean f = false;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into user(name,email,password) values(?,?,?)");
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPasssword());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public UserDeatails loginUser(UserDeatails us) {
		UserDeatails user = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from user where email=? and password=?");
			ps.setString(1, us.getEmail());
			ps.setString(2, us.getPasssword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new UserDeatails();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPasssword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}
}
