package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.Images;
import com.depaul.se452.group8.Espy.model.Tags;
import com.depaul.se452.group8.Espy.model.User;
import com.depaul.se452.group8.Espy.repository.FavoritesRepository;
import com.depaul.se452.group8.Espy.repository.TagsRepository;
import com.depaul.se452.group8.Espy.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProfileController extends BaseController {
    @Autowired
    FavoritesRepository favoritesRepository;

    @Autowired
    TagsRepository tagsRepository;

    @GetMapping("/profile")
    public ModelAndView profile() {
        return getDifferenceInId(getSignedInUser().getId(), "/profile");
    }

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable(value = "id")Integer id) {
        return "redirect:/profile";
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
                                  @RequestParam("caption")String caption,
                                  @RequestParam("tags")String tags) throws IOException {

        Images image = imageService.addImageAndCaptionToUser(id, imageFile, caption);

        List<String> tagList = Arrays.asList(tags.split(","));

        if (image != null && tagList != null && tagList.size() > 0) {
            for (String tag : tagList) {
                Tags tagModel = new Tags();
                tagModel.setTag(tag);
                tagModel.setImageId(image.getId());
                tagModel.setCreatedAt(LocalDateTime.now());
                tagModel.setUpdatedAt(LocalDateTime.now());
                tagsRepository.save(tagModel);
            }
        }

        return "redirect:/profile";
    }
}
