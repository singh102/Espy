package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.Favorites;
import com.depaul.se452.group8.Espy.repository.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ProfileController {

    @Autowired
    FavoritesRepository favoritesRepository;

    @RequestMapping("/profile")
    public String profile() {
        return "<h1>Profile Page!</h1>" + "\r\n" + addFavorite(favoritesRepository);
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
