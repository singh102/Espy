package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.Blocked;
import com.depaul.se452.group8.Espy.model.Friends;
import com.depaul.se452.group8.Espy.repository.BlockedRepository;
import com.depaul.se452.group8.Espy.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import javax.validation.Valid;

@Controller
public class FriendsController extends BaseController {
    @Autowired
    private FriendsRepository friendsRepository;

    @Autowired
    private BlockedRepository blockedRepository;

    @GetMapping(value = "/friends")
    public String friends() {
        // Friends Demonstration
        Friends friend = new Friends();
        friend.setUserId(1);
        friend.setFriendId(2);
        friend.setUpdatedAt(LocalDateTime.now());
        friend.setCreatedAt(LocalDateTime.now());
        friendsRepository.save(friend);

        // Blocked Users Demonstration
        Blocked block = new Blocked();
        block.setUserId(1);
        block.setFriendId(2);
        block.setUpdatedAt(LocalDateTime.now());
        block.setCreatedAt(LocalDateTime.now());
        blockedRepository.save(block);

        return "<h1>Friends Page!</h1>" + "\r\n" +
                "<h3>Friends:</h3>" + friendsRepository.findAll() + "\r\n" +
                "<h3>Blocked Users:</h3>" + blockedRepository.findAll();
    }

    @GetMapping("/friends/{id}")
    public Friends getFriendById(@PathVariable Integer id) {
        return friendsRepository.findById(id).get();
    }

    @PostMapping("/friends")
    public Friends saveFriend(@Valid Friends friend) {
        return friendsRepository.save(friend);
    }

    @DeleteMapping("/friends/{id}")
    public void deleteFriend(@PathVariable Integer id) {
        friendsRepository.deleteById(id);
    }

    @PostMapping("/friends/block")
    public Blocked block(@Valid Blocked blocked) {
        return blockedRepository.save(blocked);
    }

    @DeleteMapping("/friends/block/{id}")
    public void unblock(@PathVariable Integer id) {
        blockedRepository.deleteById(id);
    }
}
