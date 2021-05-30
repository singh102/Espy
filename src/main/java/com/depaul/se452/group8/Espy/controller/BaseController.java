package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.User;
import com.depaul.se452.group8.Espy.service.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BaseController {

    @ModelAttribute("SignedInUser")
    public User getSignedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl)auth.getPrincipal();
        return userDetails.getUserDetails();
    }

}
