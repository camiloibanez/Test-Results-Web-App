drop database if exists prelim_task_test_results_web_app;

create database prelim_task_test_results_web_appcustomers;
use prelim_task_test_results_web_app;

create table clients (
	clientId INT AUTO_INCREMENT,
    email VARCHAR(200) NOT NULL,
	username VARCHAR(255) NOT NULL UNIQUE,
	pwd VARCHAR(255) NOT NULL,
	addressLine1 VARCHAR(200),
	addressLine2 VARCHAR(200),
	city VARCHAR(100),
	state VARCHAR(50),
	zipCode VARCHAR(20),
	insuranceNo VARCHAR(100),
	phone VARCHAR(30),
	firstName VARCHAR(100) NOT NULL,
	lastName VARCHAR(200) NOT NULL,
	cardNo VARCHAR(100),
	expMonth INT,
	expYear INT,
	securityCode INT,
    PRIMARY KEY (clientId)
);

insert into clients(clientId, email, username, pwd, addressLine1, addressLine2, city, state, zipCode, insuranceNo, phone, firstName, lastName, cardNo, expMonth, expYear, securityCode)
values(101, "mike.hill@example.com", "mikehill", "1234", "1234 Chester Rd.", "Apt 3D", "Milwaukee", "Wisconsin", "53201", "GG1237M0DA9W", "635-645-7896", "Mike", "Hill", "6482 6452 8996 1612", 6, 2023, 543),
(102, "susan.grey@example.com", "susangrey", "1234", "532 Walnut Ave.", "Apt 4B", "Newark", "New Jersey", "07101", "GG12FDSAU901", "532-626-9767", "Susan", "Grey", "9898 9321 4326 5435", 7, 2024, 332),
(103, "allison.hargreeves@example.com", "allyhargreeves", "1234", "662 Willow St.", "", "Newark", "Jersey", "07105", "GG7R4327A8F3", "711-282-3477", "Allison", "Hargreeves", "4372 1894 3981 1975", 2, 2027, 611);

CREATE TABLE labTechs (
	employeeId INT AUTO_INCREMENT,
	email VARCHAR(200) NOT NULL,
	username VARCHAR(255) NOT NULL UNIQUE,
	pwd VARCHAR(255) NOT NULL,
    PRIMARY KEY (employeeId)
);

insert into labTechs(employeeId, email, username, pwd)
VALUES(3003, "jess.Simons@example.com", "jesssimons", "1234"),
(3004, "Les.chesterfield@example.com", "leschester", "1234"),
(3005, "gary.austen@example.com", "garyausten", "1234");

CREATE TABLE tests(
	testId INT AUTO_INCREMENT,
	testdate DATE,
	clientId INT,
	result VARCHAR(200),
    PRIMARY KEY (testId),
    FOREIGN KEY (clientId) REFERENCES clients(clientId)
);

insert into tests(testId, testdate, clientId, result)
values(1001, '2022-03-20', 101, "NEGATIVE"),
(1002, '2022-03-22', 102, "NEGATIVE"),
(1003, '2022-03-27', 101, "POSITIVE"),
(1004, '2022-04-21', 101, "Pending"),
(1005, '2022-03-23', 103, "NEGATIVE");