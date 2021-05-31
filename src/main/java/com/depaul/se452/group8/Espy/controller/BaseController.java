package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.DirectMessages;
import com.depaul.se452.group8.Espy.model.Friends;
import com.depaul.se452.group8.Espy.model.User;
import com.depaul.se452.group8.Espy.repository.DirectMessagesRepository;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

@Controller
public class BaseController {
    @Autowired
    UserService userService;

    @Autowired
    ImageService imageService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DirectMessagesRepository directMessagesRepository;

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
    public ModelAndView getDifferenceInId(Integer id, String path) {
        ModelAndView viewModel = new ModelAndView(path);
        if (!getSignedInUser().getId().equals(id)) {
            User user = userService.getUserById(getSignedInUser().getId());
            viewModel.addObject("user", user);
            viewModel.addObject("posts", imageService.getAllImagesByUserId(getSignedInUser().getId()));
            return viewModel;
        } else {

            User user = userService.getUserById(id);
            List<DirectMessages> directMessages = directMessagesRepository.findByUserIds(id);

            viewModel.addObject("user", user);
            viewModel.addObject("posts", imageService.getAllImagesByUserId(id));

            if (directMessages != null && directMessages.size() > 0)
                viewModel.addObject("directMessages", directMessages);

            return viewModel;
        }
    }
}
