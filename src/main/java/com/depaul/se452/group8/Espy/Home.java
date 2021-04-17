package com.depaul.se452.group8.Espy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @RequestMapping("/")
    public String home() {
        return "Home Page!";
    }
}
