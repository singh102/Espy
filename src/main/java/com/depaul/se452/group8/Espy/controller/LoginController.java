package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController extends BaseController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        if (getSignedInUser() != null) {
            return "redirect:/profile/" + userRepository.getUserByUsername(getSignedInUser().getUsername()).getId();
        } else {
            return "/login";
        }
    }
}
