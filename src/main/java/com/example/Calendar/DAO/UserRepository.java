package com.example.Calendar.DAO;

import com.example.Calendar.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT * FROM names n WHERE n.username = ?", nativeQuery = true)
    List<User> findTutorByUsername(String username);

}
