CREATE TABLE company
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    company_name    VARCHAR(200)          NOT NULL,
    phone           VARCHAR(10)           NOT NULL,
    email           VARCHAR(150)          NOT NULL,
    street          VARCHAR(150)          NOT NULL,
    number          VARCHAR(5)            NOT NULL,
    complement      VARCHAR(255)          NULL,
    address_city_id BIGINT                NOT NULL,
    CONSTRAINT PK_COMPANY PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;

ALTER TABLE company
    ADD CONSTRAINT FK_COMPANY_ON_ADDRESS_CITY FOREIGN KEY (address_city_id) REFERENCES city (id);