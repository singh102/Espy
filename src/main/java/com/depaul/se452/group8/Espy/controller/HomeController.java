package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.Comments;
import com.depaul.se452.group8.Espy.model.Likes;
import com.depaul.se452.group8.Espy.repository.CommentsRepository;
import com.depaul.se452.group8.Espy.repository.LikesRepository;
import com.depaul.se452.group8.Espy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HomeController extends BaseController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private LikesRepository likesRepository;

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView viewModel = new ModelAndView("home");
        return viewModel;
    }

    @GetMapping("/")
    public ModelAndView home2() {
        ModelAndView viewModel = new ModelAndView("home");
        return viewModel;
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
