package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.Likes;
import com.depaul.se452.group8.Espy.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
public class HomeController {

    @Autowired
    private LikesRepository likesRepository;

    @RequestMapping("/")
    public String home() {
        likesRepository.findAll();
        return "<h1>Home Page!</h1>" + "\r\n" + addLike(likesRepository);
    }

    public String addLike(LikesRepository likesRepository) {
        Likes likes = new Likes();
        likes.setUpdatedAt(LocalDateTime.now());
        likes.setCreatedAt(LocalDateTime.now());
        likes.setImageId(23244);
        likes.setUserId(24);
        likes.incrementLikes(likes.getImageId());
        System.out.println("Number of likes now: " + likes.getLikes(likes.getImageId()));

        likesRepository.save(likes);

        return likes.toString();
    }
}
