DROP DATABASE IF EXISTS AirTest;
CREATE DATABASE AirTest;
USE AirTest;

CREATE TABLE roles (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(15) UNIQUE NOT NULL
);
CREATE TABLE users (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	login VARCHAR(16) UNIQUE NOT NULL,
    password VARCHAR(16) UNIQUE NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
	role_id INTEGER NOT NULL REFERENCES roles(id)
    
);

CREATE TABLE flights (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    number VARCHAR(30) UNIQUE NOT NULL,
    name VARCHAR(40) NOT NULL,
    from_city VARCHAR(30) NOT NULL,
    to_city VARCHAR(30) NOT NULL,
    flight_date VARCHAR(30) NOT NULL
    );
    
CREATE TABLE pilots (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    gender VARCHAR(20) NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL
);
CREATE TABLE statuses (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(20) UNIQUE NOT NULL
);
CREATE TABLE flights_managing (
	id INT AUTO_INCREMENT PRIMARY KEY  NOT NULL,
    flight_id INT REFERENCES flights(id),
    pilots_id INT REFERENCES pilots(id),
    status_id INT REFERENCES statuses(id),
    FOREIGN KEY (flight_id) REFERENCES flights(id),
    FOREIGN KEY (pilots_id) REFERENCES pilots(id)
    ON DELETE CASCADE 
    ON UPDATE RESTRICT
    );
    
INSERT INTO roles VALUES(DEFAULT, 'administrator');
INSERT INTO roles VALUES(DEFAULT, 'dispatcher');
INSERT INTO users VALUES(DEFAULT, '1111', '1111pass', 'Ivan', 'Ivanov', 1);
INSERT INTO users VALUES(DEFAULT, '12', '123', 'Ivan', 'Ivanovich', 2);
INSERT INTO flights VALUES(DEFAULT, 'P314', 'Kharkiv-Kiev', 'Kharkiv', 'Kiev', '20:10:2018');
INSERT INTO flights VALUES(DEFAULT, 'SW15', 'Lviv-Gdynia', 'Lviv', 'Gdynia', '20:10:2018');
INSERT INTO pilots VALUES(DEFAULT, 'pilot', 'Petr', 'Petrov');
INSERT INTO statuses VALUES(DEFAULT, 'Complited');

SELECT * FROM roles;
SELECT * FROM flights_managing;
SELECT * FROM flights WHERE from_city='Lviv'and to_city='Gdynia' and flight_date='20:10:2018';
