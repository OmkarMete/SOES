package com.jsp.service;

import java.util.List;

import com.jsp.entity.User;

public interface UserService {

	public void saveUser(User user);

	public List<User> getAllUsers();

	void createUser(User user, String role);

	void updateUserRole(int id, String role);

	void deleteUser(int id, String currentEmail);

}
