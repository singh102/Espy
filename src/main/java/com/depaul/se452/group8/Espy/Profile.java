package com.depaul.se452.group8.Espy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Profile {

    @RequestMapping("/profile")
    public String profile() {
        return "Profile Page!";
    }
}
