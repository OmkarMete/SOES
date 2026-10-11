package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jsp.dao.UserDao;
import com.jsp.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public void saveUser(User user) {
		user.setRole("STUDENT");
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public void createUser(User user, String role) {
		String normalizedRole = validateRole(role);

		if (user.getEmail() == null || user.getEmail().isBlank()) {
			throw new IllegalArgumentException("Email is required.");
		}

		user.setEmail(user.getEmail().trim());

		if (user.getPassword() == null || user.getPassword().isBlank()) {
			throw new IllegalArgumentException("Password is required.");
		}

		if (userDao.findByEmail(user.getEmail()).isPresent()) {
			throw new IllegalArgumentException("Email already registered.");
		}
		
		if (userDao.findByEmail(user.getEmail()).isPresent()) {
		    throw new IllegalArgumentException("Email already registered.");
		}

		user.setRole(normalizedRole);
		user.setPassword(encoder.encode(user.getPassword()));

		userDao.save(user);
	}

	@Override
	public void updateUserRole(int id, String role) {
		String normalizedRole = validateRole(role);

		User user = userDao.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found."));

		user.setRole(normalizedRole);
		userDao.save(user);
	}

	@Override
	public void deleteUser(int id, String currentEmail) {
		User user = userDao.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found."));

		if (currentEmail != null && user.getEmail().equalsIgnoreCase(currentEmail)) {
			throw new IllegalArgumentException("You cannot delete your own account.");
		}

		userDao.delete(user);
	}

	private String validateRole(String role) {
		if (role == null) {
			throw new IllegalArgumentException("Select a valid role.");
		}

		String normalizedRole = role.trim().toUpperCase();

		if (!normalizedRole.equals("STUDENT") && !normalizedRole.equals("TEACHER")) {
			throw new IllegalArgumentException("Only STUDENT or TEACHER roles are allowed.");
		}
		
		return normalizedRole;
	}
}