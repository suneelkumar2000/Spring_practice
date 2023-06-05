package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void save(User saveUser) {
		String sql = "insert into user(email ,phone_number,name ,password) values(?,?,?,?)";
		Object[] params = {saveUser.getEmail(),saveUser.getPhone(),saveUser.getName(),saveUser.getPassword()};
		
		int noOfRows = jdbcTemplate.update(sql, params);
		System.out.println(noOfRows+"Saved");
	}
	
	public void update(User updateUser) {
		String sql = "update user set email=? where name=?";
		Object[] params = {updateUser.getEmail(),updateUser.getName()};
		
		int noOfRows = jdbcTemplate.update(sql, params);
		System.out.println(noOfRows+"updated");
	}
	public void delete(User deleteUser) {
		String sql = "delete from user where name=?";
		Object[] params = {deleteUser.getName()};
		int noOfRows = jdbcTemplate.update(sql, params);
		System.out.println(noOfRows+"deleted");
	}
}
