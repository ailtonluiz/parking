CREATE TABLE parking
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    parking    VARCHAR(5)            NOT NULL,
    vehicle_id BIGINT                NOT NULL,
    CONSTRAINT PK_PARKING PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;

ALTER TABLE parking
    ADD CONSTRAINT FK_PARKING_ON_VEHICLE FOREIGN KEY (vehicle_id) REFERENCES vehicle (id);