package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.User;

public class UserMapper implements RowMapper<User>{
	
	@Override
	public User mapRow(ResultSet rs,int rowNum) throws SQLException {
		User user = new User();
		String email = rs.getString("email");
		String user_Name = rs.getString("name");
		String password = rs.getString("password");
		Long phone = rs.getLong("phone_number");
		user.setName(user_Name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		return user;
	}
}
