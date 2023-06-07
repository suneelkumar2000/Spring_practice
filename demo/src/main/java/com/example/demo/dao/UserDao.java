package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.validation.Validation;

@Repository
public class UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public int save(User saveUser) {
		Validation val = new Validation();
		List<User> listUsers = listUsers();
		System.out.println(listUsers);
		String sql = "insert into user(email,phone_number,name,password) values(?,?,?,?)";
		Object[] params = { saveUser.getEmail(), saveUser.getPhone(), saveUser.getName(), saveUser.getPassword() };
		boolean emailval = val.emailValidation(saveUser.getEmail());
		boolean phoneval = val.phoneNumberValidation(saveUser.getPhone());
		boolean nameval = val.nameValidation(saveUser.getName());
		if (emailval == true && phoneval == true && nameval == true) {
			String email = saveUser.getEmail();
			boolean contains = listUsers.contains(email);
			System.out.println(contains);
			if (contains == true) {
				System.out.println("already exist");
				return 0;
			} else {
				int noOfRows = jdbcTemplate.update(sql, params);
				System.out.println(noOfRows + "Saved");
				return 1;
			}
		} else {
			System.out.println("incorrect value");
			return 0;
		}

	}

	public int update(User updateUser) {
		Validation val = new Validation();
		String sql = "update user set email=? where name=?";
		Object[] params = { updateUser.getEmail(), updateUser.getName() };

		boolean emailval = val.emailValidation(updateUser.getEmail());
		boolean nameval = val.nameValidation(updateUser.getName());
		if (emailval == true && nameval == true) {
			int noOfRows = jdbcTemplate.update(sql, params);
			System.out.println(noOfRows + "updated");
			return 1;
		} else {
			System.out.println("incorrect value");
			return 0;
		}
	}

	public int delete(User deleteUser) {
		Validation val = new Validation();
		String sql = "delete from user where name=?";
		Object[] params = { deleteUser.getName() };

		boolean nameval = val.nameValidation(deleteUser.getName());
		if (nameval == true) {
			int noOfRows = jdbcTemplate.update(sql, params);
			System.out.println(noOfRows + "deleted");
			return 1;
		} else {
			System.out.println("incorrect value");
			return 0;
		}
	}

	public List<User> listUsers() {
		String sql = "select * from user";
		List<User> userList = jdbcTemplate.query(sql, new UserMapper());
		return userList;
	}
}
