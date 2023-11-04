package com.example.Calendar.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public User(String login, String password, String role) {
        super();
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {
        super();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
