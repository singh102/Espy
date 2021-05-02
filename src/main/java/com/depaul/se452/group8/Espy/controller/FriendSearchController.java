package com.depaul.se452.group8.Espy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendSearchController {

    @RequestMapping("/friend-search")
    public String friendsSearch() {
        return "<h1>Friends Search Page!</h1>";
    }
}
