# Academic calendar for W4N faculty at Wroclaw University of Science and Technology
Project for Mobile Apps course that provides fully functional academic calendar

## Built with
- Java / Spring Boot
- JavaScript
- MySQL
- [FullCalendar](https://fullcalendar.io)
- [JakiTydzien API](https://jakitydzien.pl/)

### Setup
To run this project: 
1. Make sure that you're using Java 17 (you can check it e.g. by writing `java --version` in cmd)
2. Clone project from GitHub
3. Create DATABASE `event` in MySQL and create tables using `create_db.sql` file from [SQL](sql/create_db.sql)
4. Fill tables with sample user details using `fill_db.sql` file from [SQL](sql/fill_db.sql)
5. Edit username and password to yours MySQL in [`appliaction.properties`](src/main/resources/application.properties)

#### Adding new events to calendar
If app has started successfully, it should is hosted at `localhost:8080`

<p align="center">
  <img src="https://i.imgur.com/UAFGSEW.png">
</p>

To add new events, login to admin account (or any other user with `ROLE_ADMIN` authority if you added new users) and click `Dodaj przedmiot` button.
Alternatively you can add new events directly in MySQL.
