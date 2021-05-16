package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.Favorites;
import com.depaul.se452.group8.Espy.repository.FavoritesRepository;
import com.depaul.se452.group8.Espy.model.User;
import com.depaul.se452.group8.Espy.repository.UserRepository;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        return viewModel;
    }
    public String addUser(UserRepository userRepository){
        User usr = new User();
        usr.setBio("Bio here");
        usr.setAvatar("123456");
        usr.setCreatedAt(LocalDateTime.now());
        usr.setUpdatedAt(LocalDateTime.now());
        usr.setUsername("testUsEr");
        usr.setPassword("123");
        userRepository.save(usr);

        return usr.toString();
    }

    @GetMapping("/user/{id}")
    public User getUserByID(@PathVariable Integer id) {
        return userRepository.findById(id).get();
    }
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
