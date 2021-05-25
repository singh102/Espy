package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.User;
import com.depaul.se452.group8.Espy.repository.FavoritesRepository;
import com.depaul.se452.group8.Espy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    @Autowired
    FavoritesRepository favoritesRepository;

    @Autowired
    UserService userService;

    @GetMapping("profile/{id}")
    public ModelAndView profile(@PathVariable (value = "id") int id) {
        ModelAndView viewModel = new ModelAndView("profile");
        User user = userService.getUserById(id);
        viewModel.addObject("user", user);
        return viewModel;
    }

    @PostMapping("/saveProfile")
    public String saveProfile(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/profile/" + user.getId();
    }

//    public String addFavorite(FavoritesRepository favoritesRepository) {
//        Favorites favs = new Favorites();
//        favs.setImageId(44524);
//        favs.setCreatedAt(LocalDateTime.now());
//        favs.setUpdatedAt(LocalDateTime.now());
//        favs.addFavorite(favs.getImageId());
//        favs.addFavorite(135432);
//        favs.addFavorite(846486890);
//        System.out.println("List of favs: " + favs.getFavorites());
//
//        favoritesRepository.save(favs);
//
//        return favs.toString();
//    }
}
