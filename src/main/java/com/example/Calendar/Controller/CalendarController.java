package com.example.Calendar.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CalendarController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "sort", required = false) List<String> urlParam) {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/user")
    public String userPanel() {
        return "user";
    }

    @RequestMapping("/admin")
    public String adminPanel() {
        return "admin";
    }
}
