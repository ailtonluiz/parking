insert into kitchen (id, name) values (1, 'Tailandesa');
insert into kitchen (id, name) values (2, 'Indiana');
insert into kitchen (id, name) values (3, 'Argentina');
insert into kitchen (id, name) values (4, 'Brasileira');

insert into state (id, name, short_name) values (1, 'Goiás','GO');
insert into state (id, name, short_name) values (2, 'São Paulo','SP');
insert into state (id, name, short_name) values (3, 'Rio de Janeiro','RJ');
insert into state (id, name, short_name) values (4, 'Mato Grosso','MT');
insert into state (id, name, short_name) values (5, 'Mato Grosso do Sul','MS');
insert into state (id, name, short_name) values (6, 'Acre', 'AC');

insert into city (id, name, state_id) values (1, 'Goiânia', 1);
insert into city (id, name, state_id) values (2, 'São Paulo',2);
insert into city (id, name, state_id) values (3, 'Rio de Janeiro',3);
insert into city (id, name, state_id) values (4, 'Cuiabá',4);
insert into city (id, name, state_id) values (5, 'Campo Grande',5);
insert into city (id, name, state_id) values (6, 'Rio Branco',6);

insert into restaurant (id, name, shipping_fee, kitchen_id, register_date, update_date, address_phone, address_city_id, address_zip_code, address_street, address_number,address_neighborhood ) values (1, 'Thai Gourmet',10,1, utc_timestamp, utc_timestamp,'629999-9999',1,'38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into restaurant (id, name, shipping_fee, kitchen_id, register_date, update_date, address_phone, address_city_id, address_zip_code, address_street, address_number,address_neighborhood ) values (2, 'Thai Delivery',9.50,1, utc_timestamp,utc_timestamp,'629999-9999',1,'38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into restaurant (id, name, shipping_fee, kitchen_id, register_date, update_date, address_phone, address_city_id, address_zip_code, address_street, address_number,address_neighborhood ) values (3, 'Tuk Tuk Comida Indiana',15,2, utc_timestamp,utc_timestamp,'629999-9999',1,'38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into restaurant (id, name, shipping_fee, kitchen_id, register_date, update_date, address_phone, address_city_id, address_zip_code, address_street, address_number,address_neighborhood ) values (4, 'Java Steakhouse',12,3, utc_timestamp,utc_timestamp,'629999-9999',1,'38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into restaurant (id, name, shipping_fee, kitchen_id, register_date, update_date, address_phone, address_city_id, address_zip_code, address_street, address_number,address_neighborhood ) values (5, 'Lanchonete do Tio Sam',11,4, utc_timestamp,utc_timestamp,'629999-9999',1,'38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into restaurant (id, name, shipping_fee, kitchen_id, register_date, update_date, address_phone, address_city_id, address_zip_code, address_street, address_number,address_neighborhood ) values (6, 'Bar da Maria',6,4, utc_timestamp,utc_timestamp,'629999-9999',1,'38400-999', 'Rua João Pinheiro', '1000', 'Centro');


insert into payment_method(id, name) values (1, 'Dinheiro');
insert into payment_method(id, name) values (2, 'Cartão de crédito');
insert into payment_method(id, name) values (3, 'Cartão de débito');
insert into payment_method(id, name) values (4, 'Cheque');
insert into payment_method(id, name) values (5, 'Boleto');
insert into payment_method(id, name) values (6, 'PIX');

insert into permission(name, description) values ('CONSULTAR_COZINHAS','Permite consultar cozinhas');
insert into permission(name, description) values ('EDITAR_COZINHAS','Permite editar cozinhas');

insert into restaurant_payment_method (restaurant_id, payment_method_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3), (4, 1), (4, 2), (5, 1), (5, 2), (6, 3);

insert into product (active, description, name, price, restaurant_id) values (1,'Deliciosa carne suína ao molho especial','Porco com molho agridoce', 78.90,1);
insert into product (active, description, name, price, restaurant_id) values (1,'16 camarões grandes ao molho picante','Camarão tailandês', 129.90,1);
insert into product (active, description, name, price, restaurant_id) values (1,'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha','Salada picante com carne grelhada', 89.90,2);
insert into product (active, description, name, price, restaurant_id) values (1,'Pão tradicional indiano com cobertura de alho','Garlic Naan', 19.90,3);
insert into product (active, description, name, price, restaurant_id) values (1,'Cubos de frango preparados com molho curry e especiarias','Murg Curry', 39.90,3);
insert into product (active, description, name, price, restaurant_id) values (1,'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé','Bife Ancho', 79.90,4);
insert into product (active, description, name, price, restaurant_id) values (1,'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon','T-Bone', 99.90,4);
insert into product (active, description, name, price, restaurant_id) values (1,'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese','Sanduíche X-Tudo', 19.90,5);
insert into product (active, description, name, price, restaurant_id) values (1,'Acompanha farinha, mandioca e vinagrete','Espetinho de Cupim', 6.90,6);