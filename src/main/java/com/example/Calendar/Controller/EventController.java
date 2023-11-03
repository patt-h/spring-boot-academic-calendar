package com.example.Calendar.Controller;

import com.example.Calendar.DAO.EventRepository;
import com.example.Calendar.Entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> events() {
        return eventRepository.findAll();
    }
}
