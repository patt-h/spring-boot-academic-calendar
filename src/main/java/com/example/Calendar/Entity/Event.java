package com.example.Calendar.Entity;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Entity
@ConfigurationProperties(prefix = "spring.datasource")
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "tutorFirstName")
    private String tutorFirstName;

    @Column(name = "tutorLastName")
    private String tutorLastName;

    @Column(name = "daysOfWeek")
    private String daysOfWeek;

    @Column(name = "weekType")
    private String weekType;

    @Column(name = "field")
    private String field;

    @Column(name = "description")
    private String description;

    @Column(name = "startTime")
    private String startTime;

    @Column(name = "endTime")
    private String endTime;

    @Column(name = "color")
    private String color;

    @Column(name = "enabled")
    private int enabled;

    @Column(name = "createdBy")
    private String createdBy;

    public Event(Long id, String title, String tutorFirstName, String tutorLastName, String daysOfWeek, String weekType, String field, String description, String startTime, String endTime, String color, int enabled, String createdBy) {
        this.id = id;
        this.title = title;
        this.tutorFirstName = tutorFirstName;
        this.tutorLastName = tutorLastName;
        this.daysOfWeek = daysOfWeek;
        this.weekType = weekType;
        this.field = field;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.color = color;
        this.enabled = enabled;
        this.createdBy = createdBy;
    }

    public Event() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTutorFirstName() {
        return tutorFirstName;
    }

    public void setTutorFirstName(String tutorFirstName) {
        this.tutorFirstName = tutorFirstName;
    }

    public String getTutorLastName() {
        return tutorLastName;
    }

    public void setTutorLastName(String tutorLastName) {
        this.tutorLastName = tutorLastName;
    }

    public String getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public String getWeekType() {
        return weekType;
    }

    public void setWeekType(String weekType) {
        this.weekType = weekType;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tutorFirstName='" + tutorFirstName + '\'' +
                ", tutorLastName='" + tutorLastName + '\'' +
                ", daysOfWeek='" + daysOfWeek + '\'' +
                ", weekType='" + weekType + '\'' +
                ", field='" + field + '\'' +
                ", description='" + description + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", color='" + color + '\'' +
                ", enabled=" + enabled +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
