CREATE TABLE city
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(100)          NOT NULL,
    zip_code VARCHAR(5)            NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;