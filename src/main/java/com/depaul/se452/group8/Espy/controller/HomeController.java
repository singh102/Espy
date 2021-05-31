package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.Comments;
import com.depaul.se452.group8.Espy.model.Images;
import com.depaul.se452.group8.Espy.model.Likes;
import com.depaul.se452.group8.Espy.model.User;
import com.depaul.se452.group8.Espy.repository.*;
import com.depaul.se452.group8.Espy.service.ImageService;
import com.depaul.se452.group8.Espy.service.UserDetailsImpl;
import com.depaul.se452.group8.Espy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    ImageService imageService;

    @Autowired
    FriendsRepository friendsRepository;

    @Autowired
    ImagesRepository imagesRepository;

    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    LikesRepository likesRepository;

    @GetMapping("/")
    public ModelAndView home(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView viewModel = new ModelAndView("home");
        viewModel.addObject("user", userDetails.getUserDetails());
        viewModel.addObject("posts", imageService.getAllImagesByUserId(userDetails.getId()));

        return viewModel;
    }

    @PostMapping("/posts/{id}/comment")
    public String addComment(@AuthenticationPrincipal UserDetailsImpl userDetails,
                             @PathVariable(value = "id") Integer id,
                             @RequestParam("comment") String comment) {
        if (comment != "") {
            Comments comments = new Comments();
            comments.setComment(comment);
            comments.setImageId(id);
            comments.setUserId(userDetails.getId());
            comments.setUpdatedAt(LocalDateTime.now());
            comments.setCreatedAt(LocalDateTime.now());
            commentsRepository.save(comments);
        }

        return "redirect:/";
    }

    @PostMapping("/posts/{id}/like")
    public String addLike(@AuthenticationPrincipal UserDetailsImpl userDetails,
                          @PathVariable(value = "id") Integer id) {
        Likes like = new Likes();
        like.setUserId(userDetails.getId());
        like.setImageId(id);
        like.setUpdatedAt(LocalDateTime.now());
        like.setCreatedAt(LocalDateTime.now());
        likesRepository.save(like);

        return "redirect:/";
    }
}
