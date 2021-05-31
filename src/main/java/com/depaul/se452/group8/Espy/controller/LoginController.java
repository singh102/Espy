package com.depaul.se452.group8.Espy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController extends BaseController {
    @GetMapping("/")
    public String redirectAfterLogin() {
        return "redirect:/home/" + getSignedInUser().getId();
    }

    @GetMapping("/login")
    public String checkLogin() {
        if (getSignedInUser() == null) {
            return "/login";
        } else {
            return redirectLogin(getSignedInUser().getId());
        }
    }

    @PostMapping("/profile/{id}")
    public String redirectLogin(@PathVariable(value = "id")Integer id) {
        return "redirect:/profile/" + id;
    }
}
