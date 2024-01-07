package com.example.Calendar.Controller;

import com.example.Calendar.DAO.EventRepository;
import com.example.Calendar.Entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/events/{tutorFirstName}+{tutorLastName}", method = RequestMethod.GET)
    public List<Event> findByTutor(@PathVariable(value = "tutorFirstName") String tutorFirstName, @PathVariable(value = "tutorLastName") String tutorLastName) {
        return eventRepository.findByTutor(tutorFirstName, tutorLastName);
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> events() {
        return eventRepository.findAll();
    }

    @RequestMapping(value="/events", method = RequestMethod.POST)
    public Event saveEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @RequestMapping(value="/events", method = RequestMethod.DELETE)
    public void removeEvent(@RequestBody Event event) {
        eventRepository.delete(event);
    }

    @RequestMapping(value="/download/{field}", method = RequestMethod.GET)
    public StringBuilder calendarExport(@PathVariable(value = "field") String field) {
        List<Event> events = eventRepository.findByField(field);

        StringBuilder calendarExport = new StringBuilder();
        calendarExport.append("BEGIN:VCALENDAR\n" +
                "PRODID:-//Google Inc//Google Calendar 70.9054//EN\n" +
                "VERSION:2.0\n" +
                "CALSCALE:GREGORIAN\n" +
                "METHOD:PUBLISH\n" +
                "X-WR-TIMEZONE:Europe/Warsaw\n" +
                "BEGIN:VTIMEZONE\n" +
                "TZID:Europe/Warsaw\n" +
                "X-LIC-LOCATION:Europe/Warsaw\n" +
                "BEGIN:DAYLIGHT\n" +
                "TZOFFSETFROM:+0100\n" +
                "TZOFFSETTO:+0200\n" +
                "TZNAME:CEST\n" +
                "DTSTART:19700329T020000\n" +
                "RRULE:FREQ=YEARLY;BYMONTH=3;BYDAY=-1SU\n" +
                "END:DAYLIGHT\n" +
                "BEGIN:STANDARD\n" +
                "TZOFFSETFROM:+0200\n" +
                "TZOFFSETTO:+0100\n" +
                "TZNAME:CET\n" +
                "DTSTART:19701025T030000\n" +
                "RRULE:FREQ=YEARLY;BYMONTH=10;BYDAY=-1SU\n" +
                "END:STANDARD\n" +
                "END:VTIMEZONE\n");

        for (Event e : events) {
            calendarExport.append("BEGIN:VEVENT\n");
            switch (e.getDaysOfWeek()) {
                case "1" -> {
                    if (e.getWeekType().equals("EW") || e.getWeekType().equals("TP")) {
                        calendarExport.append("DTSTART;TZID=Europe/Warsaw:20231002T").append(e.getStartTime().replace(":", "")).append("00\n");
                        calendarExport.append("DTEND;TZID=Europe/Warsaw:20231002T").append(e.getEndTime().replace(":", "")).append("00\n");
                        if (e.getWeekType().equals("EW")) {
                            calendarExport.append("RRULE:FREQ=WEEKLY;WKST=SU;COUNT=14;BYDAY=MO\n");
                        }
                        else {
                            calendarExport.append("RRULE:FREQ=WEEKLY;WKST=SU;COUNT=7;INTERVAL=2;BYDAY=MO\n");
                        }
                    }
                    else {
                        calendarExport.append("DTSTART;TZID=Europe/Warsaw:20231009T").append(e.getStartTime().replace(":", "")).append("00\n");
                        calendarExport.append("DTEND;TZID=Europe/Warsaw:20231009T").append(e.getEndTime().replace(":", "")).append("00\n");
                        calendarExport.append("RRULE:FREQ=WEEKLY;WKST=SU;COUNT=7;INTERVAL=2;BYDAY=MO\n");
                    }
                }
                case "2" -> {
                    if (e.getWeekType().equals("EW") || e.getWeekType().equals("TP")) {
                        calendarExport.append("DTSTART;TZID=Europe/Warsaw:20231003T").append(e.getStartTime().replace(":", "")).append("00\n");
                        calendarExport.append("DTEND;TZID=Europe/Warsaw:20231003T").append(e.getEndTime().replace(":", "")).append("00\n");
                        if (e.getWeekType().equals("EW")) {
                            calendarExport.append("RRULE:FREQ=WEEKLY;WKST=SU;COUNT=14;BYDAY=TU\n");
                        }
                        else {
                            calendarExport.append("RRULE:FREQ=WEEKLY;WKST=SU;COUNT=7;INTERVAL=2;BYDAY=TU\n");
                        }
                    }
                    else {
                        calendarExport.append("DTSTART;TZID=Europe/Warsaw:20231010T").append(e.getStartTime().replace(":", "")).append("00\n");
                        calendarExport.append("DTEND;TZID=Europe/Warsaw:20231010T").append(e.getEndTime().replace(":", "")).append("00\n");
                        calendarExport.append("RRULE:FREQ=WEEKLY;WKST=SU;COUNT=7;INTERVAL=2;BYDAY=TU\n");
                    }
                }
                case "3" -> {
                    if (e.getWeekType().equals("EW") || e.getWeekType().equals("TP")) {
                        calendarExport.append("DTSTART;TZID=Europe/Warsaw:20231004T").append(e.getStartTime().replace(":", "")).append("00\n");
                        calendarExport.append("DTEND;TZID=Europe/Warsaw:20231004T").append(e.getEndTime().replace(":", "")).append("00\n");
                        if (e.getWeekType().equals("EW")) {
                            calendarExport.append("RRULE:FREQ=WEEKLY;WKST=SU;COUNT=14;BYDAY=WE\n");
                        }
                        else {
                            calendarExport.append("RRULE:FREQ=WEEKLY;WKST=SU;COUNT=7;INTERVAL=2;BYDAY=WE\n");
                        }
                    }
                    else {
                        calendarExport.append("DTSTART;TZID=Europe/Warsaw:20231011T").append(e.getStartTime().replace(":", "")).append("00\n");
                        calendarExport.append("DTEND;TZID=Europe/Warsaw:20231011T").append(e.getEndTime().replace(":", "")).append("00\n");
                        calendarExport.append("RRULE:FREQ=WEEKLY;WKST=SU;COUNT=7;INTERVAL=2;BYDAY=WE\n");
                    }
                }
                case "4" -> {
                    if (e.getWeekType().equals("EW") || e.getWeekType().equals("TP")) {
                        calendarExport.append("DTSTART;TZID=Europe/Warsaw:20231005T").append(e.getStartTime().replace(":", "")).append("00\n");
                        calendarExport.append("DTEND;TZID=Europe/Warsaw:20231005T").append(e.getEndTime().replace(":", "")).append("00\n");
                        if (e.getWeekType().equals("EW")) {
                            calendarExport.append("RRULE:FREQ=WEEKLY;WKST=SU;COUNT=14;BYDAY=TH\n");
                        }
                        else {
                            calendarExport.append("RRULE:FREQ=WEEKLY;WKST=SU;COUNT=7;INTERVAL=2;BYDAY=TH\n");
                        }
                    }
                    else {
                        calendarExport.append("DTSTART;TZID=Europe/Warsaw:20231012T").append(e.getStartTime().replace(":", "")).append("00\n");
                        calendarExport.append("DTEND;TZID=Europe/Warsaw:20231012T").append(e.getEndTime().replace(":", "")).append("00\n");
                        calendarExport.append("RRULE:FREQ=WEEKLY;WKST=SU;COUNT=7;INTERVAL=2;BYDAY=TH\n");
                    }
                }
                case "5" -> {
                    if (e.getWeekType().equals("EW") || e.getWeekType().equals("TP")) {
                        calendarExport.append("DTSTART;TZID=Europe/Warsaw:20231006T").append(e.getStartTime().replace(":", "")).append("00\n");
                        calendarExport.append("DTEND;TZID=Europe/Warsaw:20231006T").append(e.getEndTime().replace(":", "")).append("00\n");
                        if (e.getWeekType().equals("EW")) {
                            calendarExport.append("RRULE:FREQ=WEEKLY;WKST=SU;COUNT=14;BYDAY=FR\n");
                        }
                        else {
                            calendarExport.append("RRULE:FREQ=WEEKLY;WKST=SU;COUNT=7;INTERVAL=2;BYDAY=FR\n");
                        }
                    }
                    else {
                        calendarExport.append("DTSTART;TZID=Europe/Warsaw:20231013T").append(e.getStartTime().replace(":", "")).append("00\n");
                        calendarExport.append("DTEND;TZID=Europe/Warsaw:20231013T").append(e.getEndTime().replace(":", "")).append("00\n");
                        calendarExport.append("RRULE:FREQ=WEEKLY;WKST=SU;COUNT=7;INTERVAL=2;BYDAY=FR\n");
                    }
                }
                default -> calendarExport.append("\n");
            }
            calendarExport.append("LOCATION:").append(e.getDescription()).append("\n");
            calendarExport.append("STATUS:CONFIRMED\n");
            calendarExport.append("SUMMARY:").append(e.getTitle()).append("\n");
            calendarExport.append("TRANSP:OPAQUE\n");
            calendarExport.append("END:VEVENT\n");
        }
        calendarExport.append("END:VCALENDAR");
        return calendarExport;
    }
}
