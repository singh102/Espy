package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.Blocked;
import com.depaul.se452.group8.Espy.model.Friends;
import com.depaul.se452.group8.Espy.model.User;
import com.depaul.se452.group8.Espy.repository.BlockedRepository;
import com.depaul.se452.group8.Espy.repository.FriendsRepository;
import com.depaul.se452.group8.Espy.service.ImageService;
import com.depaul.se452.group8.Espy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Optional;
import javax.validation.Valid;

@Controller
public class FriendsController extends BaseController {

    @Autowired
    private FriendsRepository friendsRepository;

    @Autowired
    private BlockedRepository blockedRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @GetMapping(value = "/friend/{id}")
    public ModelAndView friends(@PathVariable(value = "id")Integer id) {
        ModelAndView viewModel = new ModelAndView("friends");

        Optional<Friends> friend = friendsRepository.findById(id);

        User user = userService.getUserById(friend.get().getUserId());

        viewModel.addObject("user", user);
        viewModel.addObject("posts", imageService.getAllImagesByUserId(user.getId()));
        return viewModel;
    }
}
