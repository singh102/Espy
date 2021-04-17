package com.depaul.se452.group8.Espy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Friends {

    @RequestMapping("/friends")
    public String friends() {
        return "Friends Page!";
    }
}
