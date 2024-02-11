# Academic calendar for W4N faculty at Wroclaw University of Science and Technology

## Table of contents
* [Introduction](#introduction)
* [Built with](#built-with)
* [Setup](#setup)
* [Adding new events](#adding-new-events)

## Introduction
This project was made for Mobile Apps course and provides fully functional academic calendar.

App is used to display classes schedule for every field of study at W4N faculty.
- Guests can see schedule for their field and export it to iCalendar format. They can also click on events to display event details, and there they can click on lecturer to see other lectures connected with him.
- Lecturers can add, edit and delete their consultations
- Admin can add, edit and delete events

Every single type of class has it's own color on schedule:
- Lecture - Green
- Laboratory - Blue
- Exercise - Orange
- Project - Yellow
- Seminary - Purple

App uses API from `jakitydzien.pl` to check if current week is even or odd and display correct events that occur only in specyfic week.

Thanks to `FullCalendar` and its documentation, process of writing this project was much easier.


## Built with
- Java / Spring Boot
- JavaScript
- MySQL
- [FullCalendar](https://fullcalendar.io)
- [JakiTydzien API](https://jakitydzien.pl/)

## Setup
To run this project: 
1. Make sure that you're using Java 17 (you can check it e.g. by writing `java --version` in cmd)
2. Clone project from GitHub
3. Create DATABASE `event` in MySQL and create tables using `create_db.sql` file from [SQL](sql/create_db.sql)
4. Fill tables with sample user details using `fill_db.sql` file from [SQL](sql/fill_db.sql)
5. Edit username and password to yours MySQL in [`application.properties`](src/main/resources/application.properties)

## Adding new events
If app has started successfully, it should be available at `localhost:8080`

<p align="center">
  <img src="https://i.imgur.com/UAFGSEW.png">
</p>

To add new events, login to admin account (or any other user with `ROLE_ADMIN` authority if you added new users in database) and click `Dodaj przedmiot` button.
Alternatively you can add new events directly in MySQL.
Keep in mind that first and last name of lecturer has to be in database - you can't add event with employee that not exists in database.

To delete or edit an event, just click directly on it. You can change every detail, then click `Edytuj` button, or click `Usuń` button to delete event from database. This app has drag-and-drop support, so if you want to change time when event occurs, just click on it and drag anywhere you want.

Non-admin users (employees) can add, edit and delete their consultations. It works the same as adding events for admins.

Last but not least, you can export event schedule of every single field (e.g. TIN) in iCalendar format `.ics`. It means schedule can be used in apps such as Google Calendar or your system calendar if it supports iCalendar format. Just click share icon in the lower left corner.

### How calendar looks when filled with events
<p align="center">
  <img src="https://i.imgur.com/JBmsdT1.png">
</p>
