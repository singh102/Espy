package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.Comments;
import com.depaul.se452.group8.Espy.model.Likes;
import com.depaul.se452.group8.Espy.repository.CommentsRepository;
import com.depaul.se452.group8.Espy.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private LikesRepository likesRepository;

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView viewModel = new ModelAndView("home");
        return viewModel;
    }

//    @RequestMapping("/")
//    public String home() {
//        likesRepository.findAll();
//        return "<h1>Home Page!</h1>" + "\r\n" +
//                "<h3>Likes:</h3>" + addLike(likesRepository) + "\r\n" +
//                "<h3>Comments:</h3>" + addComment(commentsRepository);
//    }

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

    public String addComment(CommentsRepository commentsRepository) {
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
