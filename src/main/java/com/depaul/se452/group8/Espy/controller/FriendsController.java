package com.depaul.se452.group8.Espy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendsController {

    @RequestMapping("/friends")
    public String friends() {
        return "Friends Page!";
    }
}
