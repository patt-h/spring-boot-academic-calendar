package com.example.Calendar.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeekController {

    @RequestMapping(value = "/api/week/{weekNumber}", method = RequestMethod.GET)
    public String week(@PathVariable(value = "weekNumber") String weekNumber) {
        String url = "https://jakitydzien.pl/api/?type=json&api_key=cb01cde96fa2e2ddd437656a92c2da98&w=" + weekNumber;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}