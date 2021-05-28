package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.User;
import com.depaul.se452.group8.Espy.repository.FavoritesRepository;
import com.depaul.se452.group8.Espy.service.ImageService;
import com.depaul.se452.group8.Espy.service.UserService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class ProfileController {

    @Autowired
    FavoritesRepository favoritesRepository;

    @Autowired
    UserService userService;

    @Autowired
    ImageService imageService;

    @GetMapping("profile/{id}")
    public ModelAndView profile(@PathVariable (value = "id") int id) {
        ModelAndView viewModel = new ModelAndView("profile");
        User user = userService.getUserById(id);
        viewModel.addObject("user", user);
        return viewModel;
    }

    @PostMapping("/saveProfile")
    public String saveProfile(@ModelAttribute("user") User user,
                              @RequestParam("profileAvatar")MultipartFile imageFile) throws IOException {
        user.setAvatarImgBase64(imageService.convertByteArrayToBase64String(imageFile.getBytes()));
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
