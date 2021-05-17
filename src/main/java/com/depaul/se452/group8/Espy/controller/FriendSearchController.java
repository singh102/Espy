package com.depaul.se452.group8.Espy.controller;

import java.time.LocalDateTime;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.depaul.se452.group8.Espy.model.Requests;
import com.depaul.se452.group8.Espy.repository.RequestsRepository;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FriendSearchController {
    @Autowired
    RequestsRepository requestsRepository;
    @GetMapping("/friendsearch")
    public ModelAndView friendsearch() {
        ModelAndView viewModel = new ModelAndView("friendsearch");
        return viewModel;
    }
    @GetMapping("/requests/{id}")
    public Requests getRequestByFriendID(@PathVariable Integer id) {
        return requestsRepository.findById(id).get();
    }

    public String addRequest(RequestsRepository requestsRepository){
        Requests requests = new Requests();
        requests.setFriendId(4444);
        requests.setUserId(1111);
        requests.setCreatedAt(LocalDateTime.now());
        requests.setUpdatedAt(LocalDateTime.now());

        requests.addRequest(requests.getFriendId());
        requestsRepository.save(requests);

        return requests.toString();
    }
    @PostMapping("/requests")
    public Requests saveRequest(@Valid Requests request) {
        return requestsRepository.save(request);
    }
    @DeleteMapping("/requests/{id}")
    public void deleteRequest(@PathVariable Integer id) {
        requestsRepository.deleteById(id);
    }
}
