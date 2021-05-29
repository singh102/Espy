package com.depaul.se452.group8.Espy.controller;

import com.depaul.se452.group8.Espy.model.Friends;
import com.depaul.se452.group8.Espy.model.User;
import com.depaul.se452.group8.Espy.repository.FriendsRepository;
import com.depaul.se452.group8.Espy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public ModelAndView loginPage() {
        ModelAndView viewModel = new ModelAndView("signIn");
        return viewModel;
    }

    @GetMapping("/register")
    public ModelAndView registerPage() {
        ModelAndView viewModel = new ModelAndView("register");
        return viewModel;
    }

    @PostMapping("/userLogin")
    public Map<String,Object> userLogin(String userName,String password) {
        Map<String,Object> map = new HashMap<>();
        if(null == userName || userName.equals("") || null == password || password.equals("")){
            map.put("code","00");
            map.put("message","User name and password cannot be empty!");
            return map;
        }
        User user = userRepository.findByUsername(userName);
        if(user == null || !user.getPassword().equals(password)){
            map.put("code","00");
            map.put("message","Wrong user name or password!");
            return map;
        }
        map.put("code","01");
        map.put("message","Login successful!");
        return map;
    }

    @PostMapping("/userRegister")
    public Map<String,Object> userRegister(User user) {
        Map<String,Object> map = new HashMap<>();
        try{
            if(null == user.getUsername() || user.getUsername().equals("") ||
                    null == user.getPassword() || user.getPassword().equals("") ||
                    null == user.getEmail() || user.getEmail().equals("") ||
                    null == user.getGender() || user.getGender().equals("") ||
                    null == user.getFullName() || user.getFullName().equals("")){
                map.put("code","00");
                map.put("message","User information cannot be empty!");
                return map;
            }
            User user1 = userRepository.findByUsername(user.getUsername());
            if(user1 != null){
                map.put("code","00");
                map.put("message","The user already exists!");
                return map;
            }
            user.setCreatedAt(LocalDateTime.now());
            user.setUpdatedAt(LocalDateTime.now());
            userRepository.save(user);
            map.put("code","01");
            map.put("message","Register successful!");
        } catch (Exception e){
            e.printStackTrace();
            map.put("code","01");
            map.put("message","Register failed!");
        }
        return map;
    }

}
