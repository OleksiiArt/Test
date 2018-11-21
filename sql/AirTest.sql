DROP DATABASE IF EXISTS testDB;
CREATE DATABASE testDB;
USE testDB;

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
    
    CREATE TABLE positions (
    id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(15) UNIQUE NOT NULL
    );
    
CREATE TABLE workers (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    positions_id INTEGER NOT NULL REFERENCES positions(id),
     FOREIGN KEY (positions_id) REFERENCES positions(id)
    ON DELETE CASCADE
 ON UPDATE CASCADE
);


CREATE TABLE statuses (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE crew (
id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
flight int NOT NULL,
pilot1 int NOT NULL,
pilot2 int NOT NULL,
navigator int NOT NULL,
radio_operator int NOT NULL,
stewardess1 int NOT NULL,
stewardess2 int NOT NULL,
stewardess3 int NOT NULL,
stewardess4 int NOT NULL,
stewardess5 int NOT NULL,
statuses_id INTEGER NOT NULL REFERENCES statuses(id),
 FOREIGN KEY(flight) REFERENCES flights(id),
 FOREIGN KEY (pilot1) REFERENCES workers(id)
    ON DELETE CASCADE
 ON UPDATE CASCADE

);





CREATE TABLE flights_workers (
    flights_id INT REFERENCES flights(id),
    workers_id INT REFERENCES workers(id),
    PRIMARY KEY(flights_id, workers_id),
    FOREIGN KEY(flights_id) REFERENCES flights(id),
    FOREIGN KEY (workers_id) REFERENCES workers(id)
    ON DELETE CASCADE
 ON UPDATE CASCADE
    );
    
INSERT INTO roles VALUES(DEFAULT, 'administrator');
INSERT INTO roles VALUES(DEFAULT, 'dispatcher');
INSERT INTO users VALUES(DEFAULT, '1111', '1111pass', 'Ivan', 'Ivanov', 1);
INSERT INTO users VALUES(DEFAULT, '12', '123', 'Ivan', 'Ivanovich', 2);
INSERT INTO flights VALUES(DEFAULT, 'P314', 'Kharkiv-Kiev', 'Kharkiv', 'Kiev', '20:10:2018');
INSERT INTO flights VALUES(DEFAULT, 'SW15', 'Lviv-Gdynia', 'Lviv', 'Gdynia', '20:10:2018');
INSERT INTO positions VALUES(DEFAULT, 'pilot');
INSERT INTO positions VALUES(DEFAULT, 'navigator');
INSERT INTO positions VALUES(DEFAULT, 'radio_operator');
INSERT INTO positions VALUES(DEFAULT, 'stewardess');

INSERT INTO workers VALUES(DEFAULT, 'Ivan', 'Ivanov', 2);

INSERT INTO statuses VALUES(DEFAULT, 'Formed');
INSERT INTO statuses VALUES(DEFAULT, 'Preparing');
INSERT INTO statuses VALUES(DEFAULT, 'Ready');
INSERT INTO statuses VALUES(DEFAULT, 'Took off');
INSERT INTO statuses VALUES(DEFAULT, 'Flying');
INSERT INTO statuses VALUES(DEFAULT, 'Landed');


SELECT * FROM roles;
SELECT * FROM flights WHERE from_city='Lviv'and to_city='Gdynia' and flight_date='20:10:2018';
