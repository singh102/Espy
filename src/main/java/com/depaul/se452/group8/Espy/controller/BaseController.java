package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.User;
import com.depaul.se452.group8.Espy.repository.ImagesRepository;
import com.depaul.se452.group8.Espy.repository.UserRepository;
import com.depaul.se452.group8.Espy.service.ImageService;
import com.depaul.se452.group8.Espy.service.UserDetailsImpl;
import com.depaul.se452.group8.Espy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {
    @Autowired
    UserService userService;

    @Autowired
    ImageService imageService;

    @Autowired
    ImagesRepository imagesRepository;

    @Autowired
    UserRepository userRepository;

    @ModelAttribute("SignedInUser")
    public User getSignedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetailsImpl) {
            UserDetailsImpl userDetails = (UserDetailsImpl)auth.getPrincipal();
            return userDetails.getUserDetails();
        } else {
            return null;
        }
    }

    @ModelAttribute("SignedInUser")
    public ModelAndView getDifferenceInId(Integer id, String path, UserDetailsImpl details) {
        ModelAndView viewModel = new ModelAndView(path);
        if (!getSignedInUser().getId().equals(id)) {
            viewModel.addObject("user", userService.getUserById(details.getId()));
            viewModel.addObject("posts", imagesRepository.findByUserIds(details.getId()));
            return viewModel;
        } else {
            viewModel.addObject("user", userService.getUserById(details.getId()));
            viewModel.addObject("posts", imagesRepository.findByUserIds(details.getId()));
            return viewModel;
        }
    }
}
