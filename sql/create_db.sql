DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `events`;
DROP TABLE IF EXISTS `names`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
	`username` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `enabled` tinyint NOT NULL,
    PRIMARY KEY (username)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `authorities` (
	`username` varchar(255) NOT NULL,
    `authority` varchar(255) NOT NULL,
    UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
    FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `names` (
	`username` VARCHAR(255) NOT NULL,
    `firstName` VARCHAR(255) NOT NULL,
    `lastName` VARCHAR(255) NOT NULL,
	UNIQUE KEY `authorities_idx_1` (`username`),
    INDEX idx_names_first_last (firstName, lastName),
    FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `events` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(255),
    `tutorFirstName` VARCHAR(255),
    `tutorLastName` VARCHAR(255),
    `daysOfWeek` INT,
    `weekType` VARCHAR(255),
    `field` VARCHAR(255),
    `description` VARCHAR(255),
    `startTime` VARCHAR(255),
    `endTime` VARCHAR(255),
    `color` VARCHAR(255),
    `enabled` tinyint NOT NULL,
    `createdBy` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`tutorFirstName`, `tutorLastName`) REFERENCES `names` (`firstName`, `lastName`),
    FOREIGN KEY (`createdBy`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;