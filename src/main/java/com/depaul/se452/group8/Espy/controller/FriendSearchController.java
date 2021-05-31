package com.depaul.se452.group8.Espy.controller;


import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import com.depaul.se452.group8.Espy.model.User;
import com.depaul.se452.group8.Espy.service.UserDetailsImpl;
import com.depaul.se452.group8.Espy.repository.BlockedRepository;
import com.depaul.se452.group8.Espy.repository.FriendsRepository;
import com.depaul.se452.group8.Espy.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.depaul.se452.group8.Espy.model.Requests;
import com.depaul.se452.group8.Espy.repository.RequestsRepository;
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
    public ModelAndView home(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView viewModel = new ModelAndView("friendsearch");
        viewModel.addObject("user", userService.getUserById(userDetails.getId()));
        return viewModel;
    }
    @GetMapping("/requests/{id}")
    public Requests getRequestByFriendID(@PathVariable Integer id) {
        return requestsRepository.findById(id).get();
    }
    @PostMapping("/requests")
    public Requests saveRequest(@Valid Requests request) {
        return requestsRepository.save(request);
    }
    @DeleteMapping("/requests/{id}")
    public void deleteRequest(@PathVariable Integer id) {
        requestsRepository.deleteById(id);
    }

    @GetMapping("/friendsearch/search")
    public ModelAndView searchFriends(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                      @RequestParam String query) {
        ModelAndView viewModel = new ModelAndView("search");
        viewModel.addObject("user", userService.getUserById(userDetails.getId()));
        viewModel.addObject("results", userRepository.findAllByUsernameContaining(query));
        return viewModel;
    }
}
