package com.example.Calendar.Controller;

import com.example.Calendar.DAO.UserRepository;
import com.example.Calendar.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> users() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/security/user", method = RequestMethod.GET)
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }
}
