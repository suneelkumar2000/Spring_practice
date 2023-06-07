package com.example.demo.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@Controller
public class HomeController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	UserDao userDao;

	@RequestMapping("/index")
	public String home() {
		System.out.println("in home page");
		return "home.jsp";
	}

	@GetMapping("register")
	public String saveUser(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("phone") Long phone, @RequestParam("password") String password) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		System.out.println(user.getName() + user.getEmail() + user.getPhone() + user.getPassword());
		int value = userDao.save(user);
		if (value == 1) {
			return "success.jsp";
		} else
			return "home.jsp";
	}

	@GetMapping("update")
	public String updateEmail(@RequestParam("name") String name, @RequestParam("email") String email) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		int value = userDao.update(user);
		if (value == 1) {
			return "success.jsp";
		} else
			return "home.jsp";
	}

	@GetMapping("delete")
	public String deleteUser(@RequestParam("name") String name) {
		User user = new User();
		user.setName(name);
		int value = userDao.delete(user);
		if (value == 1) {
			return "success.jsp";
		} else
			return "home.jsp";
	}

	@GetMapping("listofusers")
	public String getAllUser(Model model) {
		System.out.println("getting datas");
		List<User> users = userDao.listUsers();
		model.addAttribute("USER_LIST", users);
		return "listusers.jsp";
	}
}
