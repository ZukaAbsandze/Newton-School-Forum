package com.example.demo;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner createAdminUser() {
		return args -> {
			String username = "admin";
			String firstname = "Admin";
			String lastname = "User";
			String email = "admin@example.com";
			String dateOfBirth = "1980-01-01";
			String password = "password";

			Date birthday;
			try {
				birthday = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
			} catch (ParseException e) {
				throw new RuntimeException("Invalid date format for birthday", e);
			}

			User adminUser = new User();
			adminUser.setUsername(username);
			adminUser.setFirstname(firstname);
			adminUser.setLastname(lastname);
			adminUser.setEmail(email);
			adminUser.setBirthday(birthday);
			adminUser.setPassword(password);
			adminUser.setIsAdmin(true);

			userService.createUser(adminUser);
			System.out.println("Admin user created successfully");
		};
	}
}
