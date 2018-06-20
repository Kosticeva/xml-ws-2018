insert into user (username, password, activated, e_mail, first_name, last_name) values ('pera', '$2a$04$6i.cSc1Y1H7BZx.iJQV3GuW0kVyV4xlYEj4jARSk4Qfh747DRMsaC', 'ACTIVATED', 'pera@gmail.com', 'Petar', 'Petrovic');
insert into user (username, password, activated, e_mail, first_name, last_name) values ('mika', '$2a$04$R1JZVD.uIJA4gtYtGX/yXemH9IMq0KORtpmRgDpvyt5zGlrQsOvnm', 'ACTIVATED', 'mika@gmail.com', 'Mika', 'Mikic');
insert into user (username, password, activated, e_mail, first_name, last_name) values ('djoka', '$2a$04$.3rBrwxJBSv2TH68bo6wpusIRSoI6SeEhoHcSJ2swjKmBleeFjqc6', 'PENDING', 'djoka@gmail.com', 'Djordje', 'Djordjevic');
insert into user (username, password, activated, e_mail, first_name, last_name) values ('vlada', '$2a$04$NH4u5f43ADEKgYPClzg4zuB/bOu.oQYmDXiFfHlx8y/EVAKEGsu4W', 'PENDING', 'vlada@gmail.com', 'Vladimir', 'Vladimirovic');

insert into agent (username, password, businessid, first_name, last_name) values ('zoran', 'zoki123', 324, 'Zoran', 'Zoric');
insert into agent (username, password, businessid, first_name, last_name) values ('ivan', 'ika123', 324, 'Ivan', 'Ivancevic');
insert into agent (username, password, businessid, first_name, last_name) values ('laza', 'laza123', 311, 'Lazar', 'Lazarevic');
insert into agent (username, password, businessid, first_name, last_name) values ('toma', 'toma123', 345, 'Tomislav', 'Tomic');





insert into tlocation(id, address, city, country) values (1, "Bulevar Oslobodjenja 26", "Novi Sad", "Srbija");
insert into tlocation(id, address, city, country) values (2, "221b Baker Street", "London", "United Kingdom");
insert into tlocation(id, address, city, country) values (3, "10 Downing Street", "London", "United Kingdom");
insert into tlocation(id, address, city, country) values (4, "1600 Pennsylvania Avenue", "Washington DC", "United States of America");
insert into tlocation(id, address, city, country) values (5, "263 Prinsengracht", "Amsterdam", "The Netherlands");
insert into tlocation(id, address, city, country) values (6, "350 Fifth Avenue", "New York", "United States of America");
insert into tlocation(id, address, city, country) values (7, "4059 Mt Lee Dr.", "Hollywood", "United States of America");
insert into tlocation(id, address, city, country) values (8, "Tour Eiffel Champ de Mars", "Paris", "France");
insert into tlocation(id, address, city, country) values (9, "99 Rue de Rivoli", "Paris", "France");
insert into tlocation(id, address, city, country) values (10, "742 Evergreen Terrace", "Springfield", "United States of America");
insert into tlocation(id, address, city, country) values (11, "4 Privet Drive", "Little Whinging", "United Kingdom");
insert into tlocation(id, address, city, country) values (12, "425 Grove Street", "New York", "United States of America");
insert into tlocation(id, address, city, country) values (13, "Futoska 125", "Novi Sad", "Srbija");
insert into tlocation(id, address, city, country) values (14, "Bulevar Cara Lazara", "Novi Sad", "Srbija");
insert into tlocation(id, address, city, country) values (15, "Trg Dositeja Obradovića 6", "Novi Sad", "Srbija");

insert into accomodation_service(serviceid, service_name) values (1, "TV");
insert into accomodation_service(serviceid, service_name) values (2, "Wi-Fi");
insert into accomodation_service(serviceid, service_name) values (3, "Klima");
insert into accomodation_service(serviceid, service_name) values (4, "Besplatan parking");

insert into accomodation_type(typeid, type_name) values (1, "Hotel");
insert into accomodation_type(typeid, type_name) values (2, "Hostel");
insert into accomodation_type(typeid, type_name) values (3, "Apartman");
insert into accomodation_type(typeid, type_name) values (4, "B&B");

insert into category(categoryid, category_name) values (1, "1 zvezdica");
insert into category(categoryid, category_name) values (2, "2 zvezdice");
insert into category(categoryid, category_name) values (3, "3 zvezdice");
insert into category(categoryid, category_name) values (4, "4 zvezdice");
insert into category(categoryid, category_name) values (5, "5 zvezdica");
insert into category(categoryid, category_name) values (6, "Nekategorisan");

insert into agent(username, businessid, first_name, last_name, password) values ("agent", "123agent", "Agent", "Agent", "ads");

insert into accomodation(accommodation_id, description, max_persons, name, accomodation_type_typeid, agent_username, category_categoryid, location_id) values (1, "Bez opisa bla bla", 20, "Novosadski hotel", 1, "zoran", 2, 1);
insert into accommodation_accomservice(accommodation_id, service_id) values (1, 1);
insert into accommodation_accomservice(accommodation_id, service_id) values (1, 2);
insert into accommodation_accomservice(accommodation_id, service_id) values (1, 3);
insert into accommodation_accomservice(accommodation_id, service_id) values (1, 4);
insert into tprice(id, start_date, end_date, value) values (1, "2018-01-01", "2018-06-30", 2010);
insert into tprice(id, start_date, end_date, value) values (2, "2018-07-01", "2018-12-31", 2510);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (1, 1);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (1, 2);

insert into accomodation(accommodation_id, description, max_persons, name, accomodation_type_typeid, agent_username, category_categoryid, location_id) values (2, "Bez opisa bla bla", 5, "Sherlock Holmes Apartment", 3, "ivan", 3, 2);
insert into accommodation_accomservice(accommodation_id, service_id) values (2, 1);
insert into accommodation_accomservice(accommodation_id, service_id) values (2, 2);
insert into accommodation_accomservice(accommodation_id, service_id) values (2, 3);
insert into tprice(id, start_date, end_date, value) values (3, "2018-01-01", "2018-06-30", 3010);
insert into tprice(id, start_date, end_date, value) values (4, "2018-07-01", "2018-12-31", 3510);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (2, 3);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (2, 4);

insert into accomodation(accommodation_id, description, max_persons, name, accomodation_type_typeid, agent_username, category_categoryid, location_id) values (3, "Bez opisa bla bla", 5, "Prime Minister Apartment", 3, "zoran", 5, 3);
insert into tprice(id, start_date, end_date, value) values (5, "2018-01-01", "2018-06-30", 5010);
insert into tprice(id, start_date, end_date, value) values (6, "2018-07-01", "2018-12-31", 5510);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (3, 5);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (3, 6);
insert into accommodation_accomservice(accommodation_id, service_id) values (3, 1);
insert into accommodation_accomservice(accommodation_id, service_id) values (3, 2);
insert into accommodation_accomservice(accommodation_id, service_id) values (3, 3);

insert into accomodation(accommodation_id, description, max_persons, name, accomodation_type_typeid, agent_username, category_categoryid, location_id) values (4, "Bez opisa bla bla", 10, "The White House Hostel", 2, "agent", 5, 4);
insert into tprice(id, start_date, end_date, value) values (7, "2018-01-01", "2018-06-30", 5020);
insert into tprice(id, start_date, end_date, value) values (8, "2018-07-01", "2018-12-31", 5520);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (4, 7);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (4, 8);
insert into accommodation_accomservice(accommodation_id, service_id) values (4, 2);
insert into accommodation_accomservice(accommodation_id, service_id) values (4, 3);

insert into accomodation(accommodation_id, description, max_persons, name, accomodation_type_typeid, agent_username, category_categoryid, location_id) values (5, "Bez opisa bla bla", 10, "Anne Frank Hostel", 2, "agent", 3, 5);
insert into tprice(id, start_date, end_date, value) values (9, "2018-01-01", "2018-06-30", 3020);
insert into tprice(id, start_date, end_date, value) values (10, "2018-07-01", "2018-12-31", 3520);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (5, 9);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (5, 10);
insert into accommodation_accomservice(accommodation_id, service_id) values (5, 2);
insert into accommodation_accomservice(accommodation_id, service_id) values (5, 3);

insert into accomodation(accommodation_id, description, max_persons, name, accomodation_type_typeid, agent_username, category_categoryid, location_id) values (6, "Bez opisa bla bla", 10, "Empire State of Hostel", 2, "agent", 4, 6);
insert into tprice(id, start_date, end_date, value) values (11, "2018-01-01", "2018-06-30", 4010);
insert into tprice(id, start_date, end_date, value) values (12, "2018-07-01", "2018-12-31", 4510);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (6, 11);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (6, 12);
insert into accommodation_accomservice(accommodation_id, service_id) values (6, 2);
insert into accommodation_accomservice(accommodation_id, service_id) values (6, 3);

insert into accomodation(accommodation_id, description, max_persons, name, accomodation_type_typeid, agent_username, category_categoryid, location_id) values (7, "Bez opisa bla bla", 5, "Hollywood Breakfast", 4, "agent", 2, 7);
insert into tprice(id, start_date, end_date, value) values (13, "2018-01-01", "2018-06-30", 2020);
insert into tprice(id, start_date, end_date, value) values (14, "2018-07-01", "2018-12-31", 2520);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (7, 13);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (7, 14);
insert into accommodation_accomservice(accommodation_id, service_id) values (7, 2);

insert into accomodation(accommodation_id, description, max_persons, name, accomodation_type_typeid, agent_username, category_categoryid, location_id) values (8, "Bez opisa bla bla", 5, "At Eiffel's", 4, "agent", 1, 8);
insert into tprice(id, start_date, end_date, value) values (15, "2018-01-01", "2018-06-30", 1010);
insert into tprice(id, start_date, end_date, value) values (16, "2018-07-01", "2018-12-31", 1510);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (8, 15);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (8, 16);
insert into accommodation_accomservice(accommodation_id, service_id) values (7, 3);

insert into accomodation(accommodation_id, description, max_persons, name, accomodation_type_typeid, agent_username, category_categoryid, location_id) values (9, "Bez opisa bla bla", 5, "The Mona Lisa Hostel", 3, "agent", 1, 9);
insert into tprice(id, start_date, end_date, value) values (17, "2018-01-01", "2018-06-30", 1020);
insert into tprice(id, start_date, end_date, value) values (18, "2018-07-01", "2018-12-31", 1520);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (9, 17);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (9, 18);
insert into accommodation_accomservice(accommodation_id, service_id) values (9, 1);
insert into accommodation_accomservice(accommodation_id, service_id) values (9, 3);

insert into accomodation(accommodation_id, description, max_persons, name, accomodation_type_typeid, agent_username, category_categoryid, location_id) values (10, "Bez opisa bla bla", 5, "Stay At Homer's", 4, "agent", 1, 10);
insert into tprice(id, start_date, end_date, value) values (19, "2018-01-01", "2018-06-30", 1030);
insert into tprice(id, start_date, end_date, value) values (20, "2018-07-01", "2018-12-31", 1530);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (10, 19);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (10, 20);
insert into accommodation_accomservice(accommodation_id, service_id) values (10, 2);
insert into accommodation_accomservice(accommodation_id, service_id) values (10, 1);

insert into accomodation(accommodation_id, description, max_persons, name, accomodation_type_typeid, agent_username, category_categoryid, location_id) values (11, "Bez opisa bla bla", 5, "The Dursley Bed & Breakfast", 4, "agent", 2, 11);
insert into tprice(id, start_date, end_date, value) values (21, "2018-01-01", "2018-06-30", 2030);
insert into tprice(id, start_date, end_date, value) values (22, "2018-07-01", "2018-12-31", 2530);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (11, 21);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (11, 22);
insert into accommodation_accomservice(accommodation_id, service_id) values (11, 1);

insert into accomodation(accommodation_id, description, max_persons, name, accomodation_type_typeid, agent_username, category_categoryid, location_id) values (12, "Bez opisa bla bla", 5, "Monika's Apartment", 3, "agent", 5, 12);
insert into tprice(id, start_date, end_date, value) values (23, "2018-01-01", "2018-06-30", 5030);
insert into tprice(id, start_date, end_date, value) values (24, "2018-07-01", "2018-12-31", 5530);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (12, 23);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (12, 24);
insert into accommodation_accomservice(accommodation_id, service_id) values (12, 1);
insert into accommodation_accomservice(accommodation_id, service_id) values (12, 2);
insert into accommodation_accomservice(accommodation_id, service_id) values (12, 3);

insert into accomodation(accommodation_id, description, max_persons, name, accomodation_type_typeid, agent_username, category_categoryid, location_id) values (13, "Bez opisa bla bla", 20, "Hotel Park", 1, "agent", 3, 13);
insert into tprice(id, start_date, end_date, value) values (25, "2018-01-01", "2018-06-30", 3030);
insert into tprice(id, start_date, end_date, value) values (26, "2018-07-01", "2018-12-31", 3530);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (13, 25);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (13, 26);
insert into accommodation_accomservice(accommodation_id, service_id) values (13, 1);
insert into accommodation_accomservice(accommodation_id, service_id) values (13, 2);
insert into accommodation_accomservice(accommodation_id, service_id) values (13, 3);
insert into accommodation_accomservice(accommodation_id, service_id) values (13, 4);

insert into accomodation(accommodation_id, description, max_persons, name, accomodation_type_typeid, agent_username, category_categoryid, location_id) values (14, "Bez opisa bla bla", 20, "Hotel Ambasador", 1, "agent", 4, 14);
insert into tprice(id, start_date, end_date, value) values (27, "2018-01-01", "2018-06-30", 4020);
insert into tprice(id, start_date, end_date, value) values (28, "2018-07-01", "2018-12-31", 4520);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (14, 27);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (14, 28);
insert into accommodation_accomservice(accommodation_id, service_id) values (14, 1);
insert into accommodation_accomservice(accommodation_id, service_id) values (14, 2);
insert into accommodation_accomservice(accommodation_id, service_id) values (14, 3);
insert into accommodation_accomservice(accommodation_id, service_id) values (14, 4);

insert into accomodation(accommodation_id, description, max_persons, name, accomodation_type_typeid, agent_username, category_categoryid, location_id) values (15, "Bez opisa bla bla", 20, "Hotel Stratus", 1, "agent", 4, 15);
insert into tprice(id, start_date, end_date, value) values (29, "2018-01-01", "2018-06-30", 4030);
insert into tprice(id, start_date, end_date, value) values (30, "2018-07-01", "2018-12-31", 4530);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (15, 29);
insert into accomodation_prices(accomodation_accommodation_id, prices_id) values (15, 30);
insert into accommodation_accomservice(accommodation_id, service_id) values (15, 1);
insert into accommodation_accomservice(accommodation_id, service_id) values (15, 2);
insert into accommodation_accomservice(accommodation_id, service_id) values (15, 3);
insert into accommodation_accomservice(accommodation_id, service_id) values (15, 4);

insert into reservation (user_username, accomodation_accommodation_id, start_date, end_date, final_price, num_persons, realized, active) values ('pera', 1, '2018-08-12', '2018-08-15', 3211.99, 2, 0, 1);
insert into reservation (user_username, accomodation_accommodation_id, start_date, end_date, final_price, num_persons, realized, active) values ('pera', 2, '2017-01-17', '2017-01-21', 5110.00, 1, 0, 1);
insert into reservation (user_username, accomodation_accommodation_id, start_date, end_date, final_price, num_persons, realized, active) values ('mika', 3, '2017-06-23', '2017-07-4', 600.67, 5, 0, 1);
insert into message values (1, 'cao sta ima', 0, 'USER', '2018-07-10 13:28:59', 'zoran', 'pera');
insert into message values (2, 'nista, kod tebe?', 0, 'AGENT', '2018-07-10 13:31:20', 'zoran', 'pera');
insert into message values (3, 'treca poruka asdf', 0, 'USER', '2018-07-10 13:32:01', 'zoran', 'pera');

