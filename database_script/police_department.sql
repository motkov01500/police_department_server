CREATE DATABASE police_department;

USE police_department;

CREATE TABLE role(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    PRIMARY KEY(id)
);

CREATE TABLE user(
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(200) NOT NULL,
    email VARCHAR(70) NOT NULL,
    role_id INT,
    PRIMARY KEY(id)
);

CREATE TABLE car(
    id INT NOT NULL AUTO_INCREMENT,
    car_number VARCHAR(10) NOT NULL,
    insurance_end_date DATE,
    model VARCHAR(15) NOT NULL,
    year_of_manufacture DATE NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE vignette(
    id INT NOT NULL AUTO_INCREMENT,
    expiry_date DATE NOT NULL,
    type ENUM("weekly","yearly","monthly"),
    car_id INT,
    PRIMARY KEY(id)
);

CREATE TABLE policeman_about(
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    department VARCHAR(60) NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE violation(
    id CHAR(50) NOT NULL DEFAULT(UUID()),
    type ENUM("electronic_slip", "penal_decree"),
    cause VARCHAR(200) NOT NULL,
    is_handed_to_driver BOOLEAN,
    policeman_about_id INT,
    user_id INT,
    PRIMARY KEY(id)
);

CREATE TABLE driving_license(
    id INT NOT NULL AUTO_INCREMENT,
    license_number INT NOT NULL,
    points INT NOT NULL,
    address VARCHAR(150),
    date_of_creation DATE,
    expiry_date DATE,
    is_verified BOOLEAN,
    pin VARCHAR(10) NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE driving_category(
    id INT NOT NULL AUTO_INCREMENT,
    name CHAR(3) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE category_license(
    driving_category_id INT NOT NULL,
    driving_license_id INT NOT NULL
);

ALTER TABLE user
ADD CONSTRAINT Unique_username
UNIQUE(username);

ALTER TABLE user
ADD CONSTRAINT Unique_email
UNIQUE(email);

ALTER TABLE user
ADD CONSTRAINT FK_user_role
FOREIGN KEY(role_id) REFERENCES role(id);

ALTER TABLE car
ADD CONSTRAINT Unique_car_number
UNIQUE(car_number);

ALTER TABLE car
ADD CONSTRAINT FK_car_user
FOREIGN KEY(user_id) REFERENCES user(id);

ALTER TABLE vignette
ADD CONSTRAINT FK_vignette_car
FOREIGN KEY(car_id) REFERENCES car(id);

ALTER TABLE driving_license
ADD CONSTRAINT Unique_license_number
UNIQUE(license_number);

ALTER TABLE driving_license
ADD CONSTRAINT Unique_pin
UNIQUE(pin);

ALTER TABLE driving_license
ADD CONSTRAINT Unique_user_id
UNIQUE(user_id);

ALTER TABLE driving_license
ADD CONSTRAINT FK_driving_license_user
FOREIGN KEY(user_id) REFERENCES user(id);

ALTER TABLE category_license
ADD CONSTRAINT FK_category_driving_category
FOREIGN KEY(driving_category_id) REFERENCES driving_category(id);

ALTER TABLE category_license
ADD CONSTRAINT FK_category_driving_license
FOREIGN KEY(driving_license_id) REFERENCES driving_license(id);

ALTER TABLE policeman_about
ADD CONSTRAINT Unique_user_id
UNIQUE(user_id);

ALTER TABLE policeman_about
ADD CONSTRAINT FK_policeman_about_user
FOREIGN KEY(id) REFERENCES user(id);

ALTER TABLE violation
ADD CONSTRAINT FK_violation_user
FOREIGN KEY(user_id) REFERENCES user(id);

ALTER TABLE violation
ADD CONSTRAINT FK_violation_policeman_about
FOREIGN KEY(policeman_about_id) REFERENCES policeman_about(id);