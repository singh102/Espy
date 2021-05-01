package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.Comments;
import com.depaul.se452.group8.Espy.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class FriendsController {

    @Autowired
    private CommentsRepository commentsRepository;

    @RequestMapping("/friends")
    public String friends() {
        Comments comments = new Comments();
        comments.setComment("Test First Comment, woo!");
        comments.setImageId(1);
        comments.setUserId(1);
        comments.setUpdatedAt(LocalDateTime.now());
        comments.setCreatedAt(LocalDateTime.now());

        commentsRepository.save(comments);

        List<Comments> allComments = commentsRepository.findAll();

        return allComments.toString();
    }
}
