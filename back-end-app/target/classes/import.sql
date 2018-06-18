insert into user (username, password, activated, e_mail, first_name, last_name) values ('pera', '$2a$04$6i.cSc1Y1H7BZx.iJQV3GuW0kVyV4xlYEj4jARSk4Qfh747DRMsaC', 'ACTIVATED', 'pera@gmail.com', 'Petar', 'Petrovic');
insert into user (username, password, activated, e_mail, first_name, last_name) values ('mika', '$2a$04$R1JZVD.uIJA4gtYtGX/yXemH9IMq0KORtpmRgDpvyt5zGlrQsOvnm', 'ACTIVATED', 'mika@gmail.com', 'Mika', 'Mikic');
insert into user (username, password, activated, e_mail, first_name, last_name) values ('djoka', '$2a$04$.3rBrwxJBSv2TH68bo6wpusIRSoI6SeEhoHcSJ2swjKmBleeFjqc6', 'PENDING', 'djoka@gmail.com', 'Djordje', 'Djordjevic');
insert into user (username, password, activated, e_mail, first_name, last_name) values ('vlada', '$2a$04$NH4u5f43ADEKgYPClzg4zuB/bOu.oQYmDXiFfHlx8y/EVAKEGsu4W', 'PENDING', 'vlada@gmail.com', 'Vladimir', 'Vladimirovic');

--test
insert into agent values ('zoran', 324, 'Zoran', 'Zoric', 'zoki123');
insert into accomodation_type values (1, 'neki tip');
insert into category values (1, 'neka kategorija');
insert into tlocation values ('1', 'Ive Lole Ribara 1', 'Novi Sad', 'Srbija');
insert into accomodation (description, max_persons, name, accomodation_type_typeid, agent_username, category_categoryid, location_id) values ('opis ovog smestaja bla bla', 4, 'Naziv Smestaja', 1, 'zoran', 1, 1);


insert into reservation (user_username, accomodation_accommodation_id, start_date, end_date, final_price, num_persons, realized, active) values ('pera', 1, '2016-08-12', '2016-08-15', 3211.99, 2, 0, 1);

insert into message values (1, 'cao sta ima', 0, 'USER', '2015-07-10 13:28:59', 'zoran', 'pera');
insert into message values (2, 'nista, kod tebe?', 0, 'AGENT', '2015-07-10 13:31:20', 'zoran', 'pera');
insert into message values (3, 'asdf', 0, 'USER', '2015-07-10 13:32:01', 'zoran', 'pera');
--end test