CREATE TABLE position
(
    id   INTEGER,
    name VARCHAR,
    PRIMARY KEY (id)
);

CREATE TABLE employee
(
    id          INTEGER,
    salary      DOUBLE,
    name        VARCHAR,
    last_name   VARCHAR,
    address     VARCHAR,
    cellphone   VARCHAR,
    city_name   VARCHAR,
    person_id   VARCHAR,
    position_id INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (position_id) REFERENCES position (id)
);
