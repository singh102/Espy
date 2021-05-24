package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.Favorites;
import com.depaul.se452.group8.Espy.repository.FavoritesRepository;
import com.depaul.se452.group8.Espy.model.User;
import com.depaul.se452.group8.Espy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@RestController
public class ProfileController {

    @Autowired
    FavoritesRepository favoritesRepository;
    UserRepository userRepository;

    @GetMapping("/profile")
    public ModelAndView profile() {
        ModelAndView viewModel = new ModelAndView("profile");
        viewModel.addObject("user", new User());
        return viewModel;
    }

    @PostMapping("/saveProfile")
    public String saveProfile(@ModelAttribute("user") User user) {
        return "";
    }

//    @GetMapping("/user/{id}")
//    public User getUserByID(@PathVariable Integer id) {
//        return userRepository.findById(id).get();
//    }

    public String addFavorite(FavoritesRepository favoritesRepository) {
        Favorites favs = new Favorites();
        favs.setImageId(44524);
        favs.setCreatedAt(LocalDateTime.now());
        favs.setUpdatedAt(LocalDateTime.now());
        favs.addFavorite(favs.getImageId());
        favs.addFavorite(135432);
        favs.addFavorite(846486890);
        System.out.println("List of favs: " + favs.getFavorites());

        favoritesRepository.save(favs);

        return favs.toString();
    }
}
