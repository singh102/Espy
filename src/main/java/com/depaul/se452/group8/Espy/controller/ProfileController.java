package com.depaul.se452.group8.Espy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @RequestMapping("/profile")
    public String profile() {
        return "Profile Page!";
    }
}
