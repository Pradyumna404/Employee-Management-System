package com.demo.controller;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.model.Employee;
import com.demo.model.password;
import com.demo.service.EmployeeServiceImpl;
import com.demo.service.PasswordServiceImpl;

@Controller
public class MyController {

    @Autowired
    private EmployeeServiceImpl mc;
    
    @Autowired
    private PasswordServiceImpl ps;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/Login")
    public String m1(@RequestParam("username") String username, @RequestParam("password") String password, RedirectAttributes redirectAttributes, String t1, Model model) {
        if ("Login".equalsIgnoreCase(t1)) {
            password p = ps.findById(1);
            if (p.getUsername().equalsIgnoreCase(username) && p.getPassword().equals(password)) {
                redirectAttributes.addFlashAttribute("successMessage", "Login successfully.");
                return "redirect:/index2";
            } else {
            	redirectAttributes.addFlashAttribute("errorMessage", "Invalid username or password");
            }
        } else if ("Change Password".equalsIgnoreCase(t1)) {
            return "password";
        }
        return "redirect:/";
    }
    
   
    
    

    @GetMapping("/index2")
    public String showIndex2Page(Model model) {
        model.addAttribute("employees", mc.findAll());
        return "employees"; 
    }

    @PostMapping("/req2")
    public String processFormSubmission(@RequestParam("b1") String action, Employee employee, int id, RedirectAttributes redirectAttributes) {
        try {
            if ("Add Employee".equalsIgnoreCase(action)) {
                mc.add(employee);
                redirectAttributes.addFlashAttribute("successMessage", "Employee added successfully.");
            } else if ("Update Employee".equalsIgnoreCase(action)) {
                mc.update(id, employee);
                redirectAttributes.addFlashAttribute("successMessage", "Employee updated successfully.");
            } else if ("Delete Employee".equalsIgnoreCase(action)) {
                mc.deleteById(id);
                redirectAttributes.addFlashAttribute("successMessage", "Employee deleted successfully.");
            } else if ("Delete All Employees".equalsIgnoreCase(action)) {
                mc.deleteAll();
                redirectAttributes.addFlashAttribute("successMessage", "All employees deleted successfully.");
            } else if ("Search Employee".equalsIgnoreCase(action)) {
                return "search";
            }
        } catch (NoSuchElementException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "No employee found with id: " + id);
        }
        return "redirect:/index2";
    }
    
    @PostMapping("/ChangePassword")
    public String changePassword(@RequestParam("username") String username, @RequestParam("currentPassword") String currentPassword, @RequestParam("newPassword") String newPassword, RedirectAttributes redirectAttributes, @RequestParam("t1") String action) {
        if("Change Password".equalsIgnoreCase(action)) {
    	password p = ps.findById(1); 
        if (p.getUsername().equalsIgnoreCase(username) && p.getPassword().equals(currentPassword)) {
            p.setPassword(newPassword);
            ps.update(1, p);
            redirectAttributes.addFlashAttribute("successMessage", "Password changed successfully.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage1", "Wrong username or password.");
        }}
        else if("Back".equalsIgnoreCase(action)) {
        	return "index";
        }
        return "redirect:/"; 
    }
    
    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, @RequestParam("t1") String action, Model model) {
        if ("Search".equalsIgnoreCase(action)) {
            List<Employee> employees = mc.search(keyword);
            model.addAttribute("employees", employees);
            return "employees";
        }
        return "employees";
    }
}
