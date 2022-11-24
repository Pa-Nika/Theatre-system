DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE Gender (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    type VARCHAR NOT NULL
);

CREATE TABLE Author (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    country VARCHAR NOT NULL,
    age_during_writing SMALLINT,
    name VARCHAR
);

CREATE TABLE Genre (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    genre_class VARCHAR
);

CREATE TABLE Subscription (
      id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
      author_id BIGINT REFERENCES Author(id),
      genre_id BIGINT REFERENCES Genre(id)
);


CREATE TABLE Director (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    age SMALLINT NOT NULL,
    gender_id BIGINT NOT NULL REFERENCES Gender,
    date_of_birth DATE NOT NULL,
    start_work_date DATE,
    children_count SMALLINT,
    salary NUMERIC(10, 2),
    name VARCHAR NOT NULL
    --tour_date DATE[]
);

CREATE TABLE Actor (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    age SMALLINT NOT NULL,
    gender_id BIGINT NOT NULL REFERENCES Gender,
    height SMALLINT NOT NULL,
    date_of_birth DATE NOT NULL,
    start_work_date DATE,
    children_count SMALLINT,
    salary NUMERIC(10, 2),
    name VARCHAR NOT NULL,
    is_student BOOLEAN NOT NULL
    --tour_date_id BIGINT REFERENCES Actor_tour
);

CREATE TABLE Date_of_tour (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    date_start DATE NOT NULL,
    date_end DATE NOT NULL
);

CREATE TABLE Actor_tour (
    actor_id  BIGINT REFERENCES Actor(id) NOT NULL,
    date_of_tour_id BIGINT REFERENCES Date_of_tour(id) NOT NULL,
    PRIMARY KEY (actor_id, date_of_tour_id)
);

CREATE TABLE Achievement (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    date_of_competition DATE,
    title VARCHAR,
    actor_id BIGINT NOT NULL REFERENCES Actor(id)
);

CREATE TABLE Date_of_playing (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    date_of_performance DATE NOT NULL,
    count_of_tickets SMALLINT,
    is_tour BOOLEAN
    -----director_id BIGINT NOT NULL REFERENCES Director(id)-------------------------------
);

CREATE TABLE Performance (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    age_limit SMALLINT NOT NULL,
    premiere_date DATE,
    author_id BIGINT REFERENCES Author,
    genre_id BIGINT NOT NULL REFERENCES Genre,
    time_duration NUMERIC(3)
);

CREATE TABLE Date_Performance (
    date_id BIGINT REFERENCES Date_of_playing(id) NOT NULL,
    performance_id BIGINT REFERENCES Performance(id) NOT NULL,
    PRIMARY KEY (date_id, performance_id)
);

CREATE TABLE Director_Performance (
    director_id BIGINT REFERENCES Director(id) NOT NULL,
    performance_id BIGINT REFERENCES Performance(id) NOT NULL,
    PRIMARY KEY (director_id, performance_id)
);

CREATE TABLE Role (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    performance VARCHAR NOT NULL,
    is_main BOOLEAN NOT NULL,
    main_actor VARCHAR NOT NULL,
    understudy VARCHAR,
    age SMALLINT NOT NULL,
    gender_id BIGINT NOT NULL REFERENCES Gender,
    height SMALLINT,
    performance_id BIGINT NOT NULL REFERENCES Performance(id)
);

CREATE TABLE Actor_playing_role (
    isMain BOOLEAN NOT NULL,
    date_of_playing DATE NOT NULL,
    role_id BIGINT NOT NULL REFERENCES Role(id),
    actor_id BIGINT NOT NULL REFERENCES Actor(id)
);

CREATE TABLE Place (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    number NUMERIC(3) NOT NULL UNIQUE,
    is_free BOOLEAN
);

CREATE TABLE Ticket (
    is_preliminarily_sold BOOLEAN NOT NULL,
    place_id BIGINT NOT NULL UNIQUE REFERENCES Place(id),
    price SMALLINT NOT NULL,
    performance_id BIGINT NOT NULL REFERENCES Performance(id)
);

CREATE TABLE Musician (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    age SMALLINT NOT NULL,
    gender_id BIGINT NOT NULL REFERENCES Gender,
    date_of_birth DATE NOT NULL,
    start_work_date DATE,
    children_count SMALLINT,
    salary NUMERIC(10, 2),
    name VARCHAR NOT NULL
);

CREATE TABLE Headmaster (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    age SMALLINT NOT NULL,
    gender_id BIGINT NOT NULL REFERENCES Gender,
    date_of_birth DATE NOT NULL,
    start_work_date DATE,
    children_count SMALLINT,
    salary NUMERIC(10, 2),
    name VARCHAR NOT NULL
);

INSERT INTO gender
(type)
VALUES ('Мужчина'),
       ('Женщина');

INSERT INTO genre
(genre_class)
VALUES ('Комедия'),
       ('Драма'),
       ('Трагедия');

INSERT INTO author
(country, age_during_writing, name)
VALUES ('Англия', 37, 'Уильям Шекспир'), --Гамлет (Трагедия)
       ('Россиская империя', 43, 'А.П. Чехов'), --Вишневый сад (комедия)
       ('СССР', 30, 'А.В. Вампилов'); --Утиная охота (драма)

INSERT INTO musician
(age, gender_id, date_of_birth, start_work_date, children_count, salary, name)
VALUES (23, 1, '01-01-1999', '2022-01-01', 0, 45.000, 'Иван'),
       (35, 1, '01-01-1987', '2016-01-01', 1, 65.000, 'Василий'),
       (37, 2, '01-01-1985', '2012-01-01', 2, 60.000, 'Мария'),
       (22, 2, '01-01-2000', '2022-01-01', 1, 30.000, 'Светлана');

INSERT INTO headmaster
(age, gender_id, date_of_birth, start_work_date, children_count, salary, name)
VALUES (43, 1, '01-01-1979', '1999-01-01', 0, 45.000, 'Стас'),
       (40, 1, '01-01-1982', '2001-01-01', 0, 45.000, 'Владимир');

INSERT INTO date_of_tour
(date_start, date_end)
VALUES ('01-01-2022', '10-01-2022'),
       ('01-01-2012', '10-01-2012');

INSERT INTO actor
(age, gender_id, height, date_of_birth, start_work_date, children_count, salary, name, is_student)
VALUES (25, 1, 178, '01-01-1997', '01-01-2020', 0, 35.000, 'Андрей', true),
       (35, 2, 178, '01-01-1987', '01-01-2012', 1, 50.000, 'Светлана', false),
       (55, 2, 178, '01-01-1967', '01-01-1989', 3, 60.000, 'Оксана', false);

INSERT INTO actor_tour
(actor_id, date_of_tour_id)
VALUES (2, 1),
       (3, 1),
       (3, 2);

INSERT INTO achievement
(date_of_competition, title, actor_id)
VALUES ('01-01-2010', 'Заслуженная артистка России', 3);

INSERT INTO performance
(age_limit, premiere_date, author_id, genre_id, time_duration)
VALUES (18, '01-01-2018', 1, 3, 135);

INSERT INTO director
(age, gender_id, date_of_birth, start_work_date, children_count, salary, name)
VALUES (45, 1, '01-01-1977', '01-01-2005', 2, 60.000, 'Иван');

INSERT INTO director_performance
(director_id, performance_id)
VALUES (1, 1);

INSERT INTO date_of_playing
(date_of_performance, count_of_tickets, is_tour)
VALUES ('20-03-2021', 150, false);

INSERT INTO date_performance
(date_id, performance_id)
VALUES (1, 1);

INSERT INTO place
(number, is_free)
VALUES (1, true),
       (2, true);

INSERT INTO ticket
(is_preliminarily_sold, place_id, price, performance_id)
VALUES (false, 1, 100, 1);

INSERT INTO subscription
(author_id, genre_id)
VALUES (1, 3);

