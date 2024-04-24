// HomeController.java
package com.yourcompany.vehiclerentalsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Confirmation {
    @GetMapping("/confirmation")
    public String home(Model model) {

        return "confirmation";
    }

    @PostMapping("/confirmation")
    public String confirm(Model model) {
        return "redirect:/login";
    }
}
