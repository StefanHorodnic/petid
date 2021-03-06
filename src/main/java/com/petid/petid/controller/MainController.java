package com.petid.petid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    // Login form
    @RequestMapping(value = {"/login"})
    public String login() {
        return "/login";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "/login";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        return "redirect:/animals";
    }
    @RequestMapping("/")
    public String indexEmpty(Model model) {
        return "redirect:/animals";
    }
}
