CREATE TABLE client
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    first_name      VARCHAR(150)          NOT NULL,
    last_name       VARCHAR(150)          NOT NULL,
    email           VARCHAR(150)          NOT NULL,
    dni             VARCHAR(10)           NOT NULL,
    vehicle_id      BIGINT                NOT NULL,
    street          VARCHAR(150)          NOT NULL,
    number          VARCHAR(5)            NOT NULL,
    complement      VARCHAR(255)          NULL,
    address_city_id BIGINT                NOT NULL,
    CONSTRAINT PK_CLIENT PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;

ALTER TABLE client
    ADD CONSTRAINT FK_CLIENT_ON_ADDRESS_CITY FOREIGN KEY (address_city_id) REFERENCES city (id);

ALTER TABLE client
    ADD CONSTRAINT FK_CLIENT_ON_VEHICLE FOREIGN KEY (vehicle_id) REFERENCES vehicle (id);