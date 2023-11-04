package com.example.Calendar.DAO;

import com.example.Calendar.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {

}
