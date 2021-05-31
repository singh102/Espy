package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.Friends;
import com.depaul.se452.group8.Espy.model.User;

import java.time.LocalDateTime;
import javax.validation.Valid;
import com.depaul.se452.group8.Espy.service.UserDetailsImpl;
import com.depaul.se452.group8.Espy.repository.BlockedRepository;
import com.depaul.se452.group8.Espy.repository.FriendsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.depaul.se452.group8.Espy.model.Requests;
import com.depaul.se452.group8.Espy.repository.RequestsRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FriendSearchController extends BaseController {
    @Autowired
    RequestsRepository requestsRepository;

    @Autowired
    BlockedRepository blockedRepository;

    @Autowired
    FriendsRepository friendsRepository;

    @GetMapping("/friendsearch")
    public ModelAndView friendSearch(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView viewModel = new ModelAndView("friendsearch");
        viewModel.addObject("user", userService.getUserById(userDetails.getId()));
        return viewModel;
    }
    @GetMapping("/friendsearch/search")
    public ModelAndView searchFriends(@AuthenticationPrincipal UserDetailsImpl userDetails,
        @RequestParam String query) {
        ModelAndView viewModel = new ModelAndView("search");
        viewModel.addObject("user", userService.getUserById(userDetails.getId()));
        viewModel.addObject("results", userRepository.findAllByUsernameContaining(query));
        return viewModel;
    }
    @GetMapping("/requests/{id}")
    public Requests getRequestByFriendID(@PathVariable Integer id) {
        return requestsRepository.findById(id).get();
    }
    @PostMapping("/requests{id}")
    public String addFriend(@AuthenticationPrincipal UserDetailsImpl userDetails, @Valid Requests request) {
        Friends friends = new Friends();
        friends.setFriendId(request.getFriendId());
        friends.setUserId(userDetails.getId());
        friends.setCreatedAt(LocalDateTime.now());
        friends.setUpdatedAt(LocalDateTime.now());

        deleteRequest(request.getId());
        friendsRepository.save(friends);
        return "redirect:/friendsearch";
    }

    @PostMapping("/requests")
    public Requests saveRequest(@Valid Requests request) {
        return requestsRepository.save(request);
    }

    @DeleteMapping("/requests/{id}")
    public String deleteRequest(@PathVariable(value = "id")  Integer id) {
        requestsRepository.deleteById(id);
        return "redirect:/friendsearch";
    }

    @DeleteMapping("/friend/{id}")
    public String deleteFriend(@PathVariable(value = "id") Integer id) {
        friendsRepository.deleteById(id);
        return "redirect:/friendsearch";
    }

    @DeleteMapping("/blocked/{id}")
    public String unBlock(@PathVariable(value = "id") Integer id) {
        blockedRepository.deleteById(id);
        return "redirect:/friendsearch";
    }
}
