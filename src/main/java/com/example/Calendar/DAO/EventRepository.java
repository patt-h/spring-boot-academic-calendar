package com.example.Calendar.DAO;

import com.example.Calendar.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, String> {

    @Query(value = "SELECT * FROM events e WHERE (e.field = ? AND (e.weekType = ? OR e.weekType = \"EW\"))", nativeQuery = true)
    List<Event> findByFieldAndWeek(String field, String weekType);

    @Query(value = "SELECT * FROM events e WHERE (e.weekType = ? OR e.weekType = \"EW\")", nativeQuery = true)
    List<Event> findByWeekType(String weekType);

    @Query(value = "SELECT * FROM events e WHERE (e.tutorFirstName = ? AND e.tutorLastName = ?)", nativeQuery = true)
    List<Event> findByTutor(String tutorFirstName, String tutorLastName);

    List<Event> findByField(String field);
}
