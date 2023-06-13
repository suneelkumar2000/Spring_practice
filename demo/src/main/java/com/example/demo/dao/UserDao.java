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

		String userList = listUsers.toString();
		String email = saveUser.getEmail();
		boolean emailContains = userList.contains(email);
		System.out.println(emailContains);

		if (emailContains == true) {
			System.out.println("Email Already Exist");
			return 0;
		} else {
			String sql = "insert into user(email,phone_number,name,password) values(?,?,?,?)";
			Object[] params = { saveUser.getEmail(), saveUser.getPhone(), saveUser.getName(), saveUser.getPassword() };
			boolean emailval = val.emailValidation(saveUser.getEmail());
			boolean phoneval = val.phoneNumberValidation(saveUser.getPhone());
			boolean nameval = val.nameValidation(saveUser.getName());
			if (emailval == true && phoneval == true && nameval == true) {

				int noOfRows = jdbcTemplate.update(sql, params);
				System.out.println(noOfRows + "Saved");
				return 1;
			} else {
				System.out.println("Incorrect value");
				return 0;
			}
		}

	}

	public int update(User updateUser) {
		Validation val = new Validation();
		List<User> listUsers = listUsers();

		String sql = "update user set name=? where email=?";
		Object[] params = { updateUser.getName(), updateUser.getEmail() };

		String userList = listUsers.toString();
		String email = updateUser.getEmail();
		boolean emailContains = userList.contains(email);
		System.out.println(emailContains);

		if (emailContains == true) {
			boolean emailval = val.emailValidation(updateUser.getEmail());
			boolean nameval = val.nameValidation(updateUser.getName());
			if (emailval == true && nameval == true) {

				int noOfRows = jdbcTemplate.update(sql, params);
				System.out.println(noOfRows + "updated");
				return 1;
			} else {
				System.out.println("Incorrect value");
				return 0;
			}
		} else {
			System.out.println("Email Does't Exist");
			return 2;
		}
	}

	public int delete(User deleteUser) {
		Validation val = new Validation();
		List<User> listUsers = listUsers();

		String sql = "delete from user where email=?";
		Object[] params = { deleteUser.getEmail() };

		String userList = listUsers.toString();
		String email = deleteUser.getEmail();
		boolean emailContains = userList.contains(email);
		System.out.println(emailContains);

		if (emailContains == true) {
			boolean nameval = val.emailValidation(deleteUser.getEmail());
			if (nameval == true) {
				int noOfRows = jdbcTemplate.update(sql, params);
				System.out.println(noOfRows + "deleted");
				return 1;
			} else {
				System.out.println("Incorrect value");
				return 0;
			}
		}else {
			System.out.println("Email Does't Exist");
			return 2;
		}
	}

	public List<User> listUsers() {
		String sql = "select email,phone_number,name,password from user";
		List<User> userList = jdbcTemplate.query(sql, new UserMapper());
		System.out.println(userList);
		return userList;
	}
	
	public User findOne(String email) {
		String sql = "select email,phone_number,name,password from user where email = ?";
		User userRecord = jdbcTemplate.queryForObject(sql,new UserMapper(), email);
		System.out.println(userRecord);
		return userRecord;
	}
}
