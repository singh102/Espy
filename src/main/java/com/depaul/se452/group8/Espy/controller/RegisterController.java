package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;

@Controller
public class RegisterController extends BaseController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView viewModel = new ModelAndView("register");
        viewModel.addObject("user", new User());
        return viewModel;
    }

    @PostMapping("/registerUser")
    public String registerProfile(@ModelAttribute("user") User user,
                                  @RequestParam("profileAvatar") MultipartFile imageFile) throws IOException {
        if (!imageFile.isEmpty()) {
            user.setAvatarImgBase64(imageService.convertByteArrayToBase64String(imageFile.getBytes()));
        }

        user.setPlainPassword(user.getPassword());
        userService.saveUser(user);
        return "redirect:/profile/" + user.getId();
    }
}
