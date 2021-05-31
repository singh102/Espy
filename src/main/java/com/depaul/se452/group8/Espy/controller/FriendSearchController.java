package com.depaul.se452.group8.Espy.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import com.depaul.se452.group8.Espy.model.Friends;
import com.depaul.se452.group8.Espy.model.User;
import com.depaul.se452.group8.Espy.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.depaul.se452.group8.Espy.model.Requests;
import com.depaul.se452.group8.Espy.repository.RequestsRepository;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FriendSearchController extends BaseController {
    @Autowired
    FriendsRepository friendsRepository;

    @Autowired
    RequestsRepository requestsRepository;

    @GetMapping("/friendsearch")
    public ModelAndView friendsearch() {
        return getDifferenceInId(getSignedInUser().getId(), "/friendsearch");
    }

    @GetMapping("/friendsearch/{id}")
    public String friendsearch(@PathVariable(value = "id")Integer id) {
        return "redirect:/friendsearch";
    }

    @GetMapping("/requests/{id}")
    public Requests getRequestByFriendID(@PathVariable(value = "id")Integer id) {
        return requestsRepository.findById(id).get();
    }

    @PostMapping("/findFriend")
    public String findFriend() {
        System.out.println("ID IS: " + getSignedInUser().getId());
        return "redirect:/friendsearch";
    }

    public String addRequest(RequestsRepository requestsRepository){
        Requests requests = new Requests();
        requests.setFriendId(4444);
        requests.setUserId(1111);
        requests.setCreatedAt(LocalDateTime.now());
        requests.setUpdatedAt(LocalDateTime.now());

        requests.addRequest(requests.getFriendId());
        requestsRepository.save(requests);

        return requests.toString();
    }
    @PostMapping("/requests")
    public Requests saveRequest(@Valid Requests request) {
        return requestsRepository.save(request);
    }
    @DeleteMapping("/requests/{id}")
    public void deleteRequest(@PathVariable Integer id) {
        requestsRepository.deleteById(id);
    }
}
