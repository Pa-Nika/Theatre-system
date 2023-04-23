--DROP view IF EXISTS public.clients;

--CREATE TABLE IF NOT EXISTS clients
--(
--    id    SERIAL PRIMARY KEY ,
--    user_name  VARCHAR(200) NOT NULL ,
--    email VARCHAR(254) NOT NULL ,
--    phone VARCHAR(50)  NOT NULL
--);
--
--CREATE TABLE IF NOT EXISTS a1
--(
--    id    SERIAL PRIMARY KEY ,
--    users  VARCHAR(200) NOT NULL ,
--    home VARCHAR(254) NOT NULL ,
--    family VARCHAR(50)  NOT NULL
--);


CREATE TABLE IF NOT EXISTS Start (
    id BIGINT PRIMARY KEY,
    start_work_theatre_date DATE NOT NULL
);

CREATE TABLE Gender (
    id BIGINT PRIMARY KEY,
    type VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS Genre (
    id BIGINT  PRIMARY KEY,
    genre_class VARCHAR
);

CREATE TABLE IF NOT EXISTS Author (
    id BIGINT PRIMARY KEY,
    country VARCHAR NOT NULL,
    age_during_writing SMALLINT,
    user_name VARCHAR,
    title varchar NOT NULL,
    genre_id BIGINT NOT NULL REFERENCES Genre,
    date_of_birth DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS Employee_type (
    id BIGINT PRIMARY KEY,
    type VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS Employee (
    id BIGINT PRIMARY KEY,
    type_id BIGINT NOT NULL REFERENCES Employee_type,
    date_of_birth DATE NOT NULL,
    age INTERVAL NOT NULL,
    gender_id BIGINT NOT NULL REFERENCES Gender,
    start_work_date DATE,
    children_count SMALLINT,
    salary NUMERIC(10, 2),
    user_name VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS Subscription (
      id BIGINT PRIMARY KEY,
      author_id BIGINT REFERENCES Author(id),
      genre_id BIGINT REFERENCES Genre(id)
);


CREATE TABLE IF NOT EXISTS Director (
    id BIGINT PRIMARY KEY,
    employee_id BIGINT NOT NULL REFERENCES Employee
);
