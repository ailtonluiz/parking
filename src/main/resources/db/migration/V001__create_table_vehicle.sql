CREATE TABLE vehicle
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    color VARCHAR(60)           NOT NULL,
    model VARCHAR(60)           NOT NULL,
    brand VARCHAR(60)           NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;