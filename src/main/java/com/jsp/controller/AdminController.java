package com.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jsp.dao.UserDao;

@Controller
public class AdminController {

    @Autowired
    private UserDao userDao;

//    @GetMapping("/admin/dashboard")
//    public String adminDashboard(Model model) {
//        model.addAttribute("users", userDao.findAll());
//        return "admin-dashboard";
//    }
}
