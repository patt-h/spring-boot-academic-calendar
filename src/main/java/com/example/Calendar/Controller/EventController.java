package com.example.Calendar.Controller;

import com.example.Calendar.DAO.EventRepository;
import com.example.Calendar.Entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value = "/events/{field}/{weekType}", method = RequestMethod.GET)
    public List<Event> findByField(@PathVariable(value = "field") String field, @PathVariable(value = "weekType") String weekType) {
        if (Objects.equals(field, "W4") && Objects.equals(weekType, "EW")) {
            return eventRepository.findAll();
        }
        else if (Objects.equals(field, "W4") && !Objects.equals(weekType, "EW")) {
            return eventRepository.findByWeekType(weekType);
        }
        else if (!Objects.equals(field, "W4") && Objects.equals(weekType, "EW")) {
            return eventRepository.findByField(field);
        }
        else {
            return eventRepository.findByFieldAndWeek(field, weekType);
        }
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> events() {
        return eventRepository.findAll();
    }

    @RequestMapping(value="/events", method=RequestMethod.POST)
    public Event saveEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @RequestMapping(value="/events", method=RequestMethod.DELETE)
    public void removeEvent(@RequestBody Event event) {
        eventRepository.delete(event);
    }
}
