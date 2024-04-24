package com.yourcompany.vehiclerentalsystem.controller;

import com.yourcompany.vehiclerentalsystem.model.DriverLogin;
import com.yourcompany.vehiclerentalsystem.model.User;
import com.yourcompany.vehiclerentalsystem.service.DriverLoginService;
import com.yourcompany.vehiclerentalsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DriverLoginService driverLoginService;

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(User user) {
        userService.signup(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(User user) {
        // Authenticate user against MongoDB database
        if (userService.login(user.getUsername(), user.getPassword()) != null) {
            return "redirect:/home"; // Redirect to the vehicles API
        } else {
            // Handle authentication failure, perhaps return to login page with an error message
            return "redirect:/login?error";
        }
    }

    @PostMapping("/home1")
    public String home1(Model model) {
        return "redirect:/home";
    }

    @GetMapping("/driverlogin")
    public String driverLoginForm() {
        return "driverlogin";
    }
    @PostMapping("/driverlogin")
    public String driverLogin(DriverLogin user, RedirectAttributes redirectAttributes) {
        // Authenticate user against MongoDB database
        if (driverLoginService.login(user.getUsername(), user.getPassword()) != null) {
            redirectAttributes.addAttribute("username", user.getUsername());
            return "redirect:/driverhome";
        } else {
            // Handle authentication failure, perhaps return to login page with an error message
            return "redirect:/driverlogin?error";
        }
    }


    @GetMapping("/driversignup")
    public String driverSignupForm(Model model) {
        model.addAttribute("driver", new DriverLogin());
        return "driversignup";
    }

    @PostMapping("/driversignup")
    public String driversignup(DriverLogin user) {
        driverLoginService.signup(user);
        return "redirect:/driverlogin";
    }
}
