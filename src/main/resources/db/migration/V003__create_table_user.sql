CREATE TABLE user
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    name            VARCHAR(150)          NOT NULL,
    password        VARCHAR(255)          NOT NULL,
    email           VARCHAR(150)          NOT NULL,
    phone           VARCHAR(6)            NOT NULL,
    register_date   datetime              NOT NULL,
    update_date     datetime              NOT NULL,
    street          VARCHAR(100)          NOT NULL,
    number          VARCHAR(5)            NOT NULL,
    complement      VARCHAR(150)          NULL,
    address_city_id BIGINT                NOT NULL,
    CONSTRAINT PK_USER PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;
ALTER TABLE user
    ADD CONSTRAINT FK_USER_ON_ADDRESS_CITY FOREIGN KEY (address_city_id) REFERENCES city (id);