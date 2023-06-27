INSERT INTO role(name)
VALUES('USER');
INSERT INTO role(name)
VALUES('POLICEMAN');
INSERT INTO role(name)
VALUES('ADMIN');

INSERT INTO user(username, password, email, role_id)
VALUES('admin','admin','admin@gmail.com',3);
INSERT INTO user(username, password, email, role_id)
VALUES('vankataI','vankatapass','ivanivanov@gmail.com',2);
INSERT INTO user(username, password, email, role_id)
VALUES('hristoKrot','hristopass','hristooo@gmail.com',2);
INSERT INTO user(username, password, email, role_id)
VALUES('georgiGv','geogivi123','georgiVT@gmail.com',1);
INSERT INTO user(username, password, email, role_id)
VALUES('liubakapower','liubakaPass','liuboslavAD@gmail.com',1);

INSERT INTO car(car_number, insurance_end_date, model, year_of_manufacture, user_id)
VALUES('8DHL240', '2023-08-20', 'Hyundai', '2005-05-05',2);
INSERT INTO car(car_number, insurance_end_date, model, year_of_manufacture, user_id)
VALUES('7U23335', '2023-10-15', 'Toyota', '2002-02-10',2);
INSERT INTO car(car_number, insurance_end_date, model, year_of_manufacture, user_id)
VALUES('7U2456', '2023-08-10', 'Chevrolet', '1999-03-25',3);
INSERT INTO car(car_number, insurance_end_date, model, year_of_manufacture, user_id)
VALUES('EGH3287', '2023-06-30', 'Honda', '2011-10-05',3);
INSERT INTO car(car_number, insurance_end_date, model, year_of_manufacture, user_id)
VALUES('402JRM', '2023-06-28', 'Buik', '2004-06-21', 4);

INSERT INTO vignette(expiry_date, type, car_id)
VALUES('2024-02-10', 'yearly', 1);
INSERT INTO vignette(expiry_date, type, car_id)
VALUES('2023-06-30', 'weekly', 2);
INSERT INTO vignette(expiry_date, type, car_id)
VALUES('2023-07-21', 'monthly', 3);
INSERT INTO vignette(expiry_date, type, car_id)
VALUES('2024-03-25', 'yearly', 4);
INSERT INTO vignette(expiry_date, type, car_id)
VALUES('2024-06-25', 'yearly', 5);

INSERT INTO policeman_about(first_name, last_name, department, user_id)
VALUES("Ivan", "Ivanov", "California", 2);
INSERT INTO policeman_about(first_name, last_name, department, user_id)
VALUES("Hristo", "Georgiev", "Lovech", 3);

INSERT INTO violation(type, cause, is_handed_to_driver, policeman_about_id, user_id)
VALUES('electronic slip', 'high speed', 0, 1, 4);
INSERT INTO violation(type, cause, is_handed_to_driver, policeman_about_id, user_id)
VALUES('electronic slip', 'high speed', 1, 1, 4);
INSERT INTO violation(type, cause, is_handed_to_driver, policeman_about_id, user_id)
VALUES('electronic slip', 'turn off headlights', 1, 2, 5);
INSERT INTO violation(type, cause, is_handed_to_driver, policeman_about_id, user_id)
VALUES('penal decree', 'without a belt', 1, 2, 5);

INSERT INTO driving_license(license_number, points, address, date_of_creation, expiry_date, is_verified, pin, user_id)
VALUES(95315723, 30, '524 Cummings Groves Apt. 507, Lake Brandyport', '2022-05-10', '2027-05-10', 0, '0103154929', 2);
INSERT INTO driving_license(license_number, points, address, date_of_creation, expiry_date, is_verified, pin, user_id)
VALUES(462549846, 25, '504 Genevieve Orchard, Robbiehaven', '2022-12-28', '2027-12-28', 1, '0841097681', 3);
INSERT INTO driving_license(license_number, points, address, date_of_creation, expiry_date, is_verified, pin, user_id)
VALUES(9887727, 30, '76073 Jaylin Club, Port Joannieberg', '2023-05-16', '2028-05-16', 1, '6610165124', 4);
INSERT INTO driving_license(license_number, points, address, date_of_creation, expiry_date, is_verified, pin, user_id)
VALUES(19427768, 30, '3893 Delia Pass Apt. 333, Domenicaville', '2022-11-13', '2027-11-13', 1, '7809231682', 5);

INSERT INTO driving_category(name)
VALUES('A');
INSERT INTO driving_category(name)
VALUES('A1');
INSERT INTO driving_category(name)
VALUES('A2');
INSERT INTO driving_category(name)
VALUES('B');
INSERT INTO driving_category(name)
VALUES('B1');
INSERT INTO driving_category(name)
VALUES('B+E');
INSERT INTO driving_category(name)
VALUES('C');
INSERT INTO driving_category(name)
VALUES('C+E');
INSERT INTO driving_category(name)
VALUES('D');
INSERT INTO driving_category(name)
VALUES('D+E');

INSERT INTO category_license(driving_category_id, driving_license_id)
VALUES(4, 1);
INSERT INTO category_license(driving_category_id, driving_license_id)
VALUES(4, 2);
INSERT INTO category_license(driving_category_id, driving_license_id)
VALUES(4, 3);
INSERT INTO category_license(driving_category_id, driving_license_id)
VALUES(4, 4);
INSERT INTO category_license(driving_category_id, driving_license_id)
VALUES(1, 3);
INSERT INTO category_license(driving_category_id, driving_license_id)
VALUES(8, 4);
INSERT INTO category_license(driving_category_id, driving_license_id)
VALUES(8, 4);