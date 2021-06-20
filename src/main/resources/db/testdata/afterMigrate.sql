set foreign_key_checks = 0;

delete from city;
delete from client;
delete from company;
delete from parking;
delete from user;
delete from vehicle;

set foreign_key_checks = 1;

alter table city auto_increment = 1;
alter table client auto_increment = 1;
alter table company auto_increment = 1;
alter  table parking auto_increment = 1;
alter table user auto_increment = 1;
alter table vehicle auto_increment = 1;

insert into city (id, name, zip_code) values (1,'Canillo', 'AD100');
insert into city (id, name, zip_code) values (2,'Encamp', 'AD200');
insert into city (id, name, zip_code) values (3,'Ordino', 'AD300');
insert into city (id, name, zip_code) values (4,'La Massana', 'AD400');
insert into city (id, name, zip_code) values (5,'Andorra la Vella', 'AD500');
insert into city (id, name, zip_code) values (6,'Sant Julià de Lòria', 'AD600');
insert into city (id, name, zip_code) values (7,'Escaldes-Engordany', 'AD700');

insert into vehicle (id, color, model, brand, register_date, update_date) values (1, 'Branco', 'Vectra','Opel', utc_timestamp, utc_timestamp);
insert into vehicle (id, color, model, brand, register_date, update_date) values (2, 'Azul', 'Leon','Seat', utc_timestamp, utc_timestamp);
insert into vehicle (id, color, model, brand, register_date, update_date) values (3, 'Preto', 'C63','Mercedes Benz', utc_timestamp, utc_timestamp);
insert into vehicle (id, color, model, brand, register_date, update_date) values (4, 'Vermelho', 'Fiesta','Ford', utc_timestamp, utc_timestamp);
insert into vehicle (id, color, model, brand, register_date, update_date) values (5, 'Branco', 'Panda','Fiat', utc_timestamp, utc_timestamp);
insert into vehicle (id, color, model, brand, register_date, update_date) values (6, 'Azul', 'A4','Audi', utc_timestamp, utc_timestamp);

insert into client (id, first_name, last_name, email, dni, vehicle_id, phone, street, number, complement, address_city_id, register_date, update_date) values (1,'Ailton Luiz', 'Lima dos Santos','ailtonluiz@icloud.com','351720J',1,'610-680','Carrer Major','17','2 er 5',2, utc_timestamp, utc_timestamp);

insert into company (id, company_name, phone, email, street, number, complement, address_city_id, register_date, update_date) values (1, 'Parking Poli','855-233','parking@parking.com','Carrer','12','teste',2, utc_timestamp, utc_timestamp);

insert into user (id, name, password, email, phone, register_date, update_date, street, number, complement, address_city_id) values (1,'Ailton','123456','ailtonluiz@icloud.com','610-680',utc_timestamp,utc_timestamp, 'Carrer', '12','123132',2);

insert into parking (id, parking, vehicle_id, company_id) values (1, '001', 1,1);
insert into parking (id, parking, vehicle_id, company_id) values (2, '002', 2,1);
insert into parking (id, parking, vehicle_id, company_id) values (3, '003', 3,1);
insert into parking (id, parking, vehicle_id, company_id) values (4, '004', 4,1);
insert into parking (id, parking, vehicle_id, company_id) values (5, '005', 5,1);
insert into parking (id, parking, vehicle_id, company_id) values (6, '006', 6,1);


