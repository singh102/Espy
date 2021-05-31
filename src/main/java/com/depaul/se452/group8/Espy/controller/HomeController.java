package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.Comments;
import com.depaul.se452.group8.Espy.model.Favorites;
import com.depaul.se452.group8.Espy.model.Likes;
import com.depaul.se452.group8.Espy.repository.*;
import com.depaul.se452.group8.Espy.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDateTime;

@Controller
public class HomeController extends BaseController {
    @Autowired
    FriendsRepository friendsRepository;

    @Autowired
    ImagesRepository imagesRepository;

    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    LikesRepository likesRepository;

    @Autowired
    FavoritesRepository favoritesRepository;

    @GetMapping("/home")
    public ModelAndView home(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        ModelAndView viewModel = new ModelAndView("home");
        viewModel.addObject("user", userService.getUserById(userDetails.getId()));
        viewModel.addObject("posts", imagesRepository.findByUserIds(userDetails.getId()));
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

        return "redirect:/home";
    }

    @PostMapping("/posts/{id}/like")
    public String addLike(@AuthenticationPrincipal UserDetailsImpl userDetails,
                          @PathVariable(value = "id") Integer id) {
        if (likesRepository.findLikeByUserIdAndImageId(userDetails.getId(), id) == null) {
            Likes like = new Likes();
            like.setUserId(userDetails.getId());
            like.setImageId(id);
            like.setUpdatedAt(LocalDateTime.now());
            like.setCreatedAt(LocalDateTime.now());
            likesRepository.save(like);
        }

        return "redirect:/home";
    }

    @PostMapping("/posts/{id}/favorite")
    public String addFavorite(@AuthenticationPrincipal UserDetailsImpl userDetails,
                          @PathVariable(value = "id") Integer id) {
        if (favoritesRepository.findFavoriteByUserIdAndImageId(userDetails.getId(), id) == null) {
            Favorites favorite = new Favorites();
            favorite.setUserId(userDetails.getId());
            favorite.setImageId(id);
            favorite.setUpdatedAt(LocalDateTime.now());
            favorite.setCreatedAt(LocalDateTime.now());
            favoritesRepository.save(favorite);
        }

        return "redirect:/home";
    }
}
