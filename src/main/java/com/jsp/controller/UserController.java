
package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsp.entity.User;
import com.jsp.service.ExamService;
import com.jsp.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private ExamService examService;

	@GetMapping("/loginpage")
	public String getLoginPage() {
		return "loginpage";
	}

	@GetMapping("/register")
	public String getRegPage() {
		return "register";
	}

	@GetMapping("/student/dashboard")
	public String getStudentDashboard(Model model) {
	    model.addAttribute("exams", examService.getPublishedExams());
	    return "student-dashboard";
	}

	@PostMapping("/register")
	public String reg(@RequestParam String email, @RequestParam String pass) {

		User user = new User();
		user.setEmail(email);
		user.setPassword(pass);

		service.saveUser(user);

		return "register";
	}

	@GetMapping("/admin/dashboard")
	public String getAdminDashboard(@RequestParam(required = false) String search, Model model) {

		List<User> allUsers = service.getAllUsers();
		List<User> users = allUsers;

		if (search != null && !search.trim().isEmpty()) {
			String keyword = search.trim().toLowerCase();

			users = allUsers.stream()
					.filter(user -> user.getEmail() != null && user.getEmail().toLowerCase().contains(keyword))
					.toList();
		}

		model.addAttribute("users", users);
		model.addAttribute("search", search);
		model.addAttribute("totalUsers", allUsers.size());
		model.addAttribute("studentCount", countByRole(allUsers, "STUDENT"));
		model.addAttribute("teacherCount", countByRole(allUsers, "TEACHER"));
		model.addAttribute("adminCount", countByRole(allUsers, "ADMIN"));

		return "admin-dashboard";
	}

	private long countByRole(List<User> users, String role) {
		return users.stream().filter(user -> user.getRole() != null).filter(
				user -> user.getRole().equalsIgnoreCase(role) || user.getRole().equalsIgnoreCase("ROLE_" + role))
				.count();
	}

	@PostMapping("/admin/users/add")
	public String addUser(@RequestParam String email, @RequestParam String pass, @RequestParam String role,
			RedirectAttributes redirectAttributes) {

		try {
			User user = new User();
			user.setEmail(email.trim());
			user.setPassword(pass);

			service.createUser(user, role);

			redirectAttributes.addFlashAttribute("message", "User created successfully.");

		} catch (IllegalArgumentException e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
		}

		return "redirect:/admin/dashboard";
	}

	@PostMapping("/admin/users/{id}/role")
	public String changeUserRole(@PathVariable int id, @RequestParam String role,
			RedirectAttributes redirectAttributes) {

		try {
			service.updateUserRole(id, role);

			redirectAttributes.addFlashAttribute("message", "User role updated successfully.");

		} catch (IllegalArgumentException e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
		}

		return "redirect:/admin/dashboard";
	}

	@PostMapping("/admin/users/{id}/delete")
	public String deleteUser(@PathVariable int id, Authentication authentication,
			RedirectAttributes redirectAttributes) {

		try {
			service.deleteUser(id, authentication.getName());

			redirectAttributes.addFlashAttribute("message", "User deleted successfully.");

		} catch (IllegalArgumentException e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
		}

		return "redirect:/admin/dashboard";
	}
}
