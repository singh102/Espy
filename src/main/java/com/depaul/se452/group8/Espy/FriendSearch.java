package com.depaul.se452.group8.Espy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendSearch {

    @RequestMapping("/friend-search")
    public String friendsSearch() {
        return "Friends Search Page!";
    }
}
