package com.example.Calendar.Controller;

import com.example.Calendar.DAO.UserRepository;
import com.example.Calendar.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> users() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/sorting/{username}", method = RequestMethod.GET)
    public List<User> findByUsername(@PathVariable(value = "username") String username, Authentication authentication) {
        if (Objects.equals(username, "self")) {
            username = authentication.getName();
        }
        return userRepository.findTutorByUsername(username);
    }
}
