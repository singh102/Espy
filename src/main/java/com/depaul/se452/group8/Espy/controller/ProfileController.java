package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.User;
import com.depaul.se452.group8.Espy.repository.FavoritesRepository;
import com.depaul.se452.group8.Espy.service.ImageService;
import com.depaul.se452.group8.Espy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;

@Controller
public class ProfileController extends BaseController {

    @Autowired
    FavoritesRepository favoritesRepository;

    @Autowired
    UserService userService;

    @Autowired
    ImageService imageService;

    @GetMapping("profile/{id}")
    public ModelAndView profile(@PathVariable(value = "id")Integer id) {
        ModelAndView viewModel = new ModelAndView("profile");
        User user = userService.getUserById(id);
        if (getSignedInUser().getId() != id) {
            viewModel.addObject("user", getSignedInUser());
            viewModel.addObject("posts", imageService.getAllImagesByUserId(getSignedInUser().getId()));
        }
        else {
            viewModel.addObject("user", user);
            viewModel.addObject("posts", imageService.getAllImagesByUserId(id));
        }
        return viewModel;
    }

    @PostMapping("/saveProfile")
    public String saveProfile(@ModelAttribute("user") User user,
                              @RequestParam("profileAvatar")MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            user.setAvatarImgBase64(imageService.convertByteArrayToBase64String(imageFile.getBytes()));
        } else {
            User existingUser = userService.getUserById(user.getId());
            user.setAvatarImgBase64(existingUser.getAvatarImgBase64());
        }

        userService.saveUser(user);
        return "redirect:/profile/" + user.getId();
    }

    @PostMapping("/addImageComment")
    public String addImageComment(@RequestParam("id")Integer id,
                                  @RequestParam("imagePost")MultipartFile imageFile,
                                  @RequestParam("caption")String caption) throws IOException {
        imageService.addImageAndCaptionToUser(id, imageFile, caption);
        return "redirect:/profile/" + id;
    }
}
