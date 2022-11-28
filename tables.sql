DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE Start (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    start_work_theatre_date DATE NOT NULL
);

CREATE TABLE Gender (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    type VARCHAR NOT NULL
);

CREATE TABLE Genre (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    genre_class VARCHAR
);

CREATE TABLE Author (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    country VARCHAR NOT NULL,
    age_during_writing SMALLINT,
    name VARCHAR,
    title varchar NOT NULL,
    genre_id BIGINT NOT NULL REFERENCES Genre
);

CREATE TABLE Employee_type (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    type VARCHAR NOT NULL
);

CREATE TABLE Employee (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    type_id BIGINT NOT NULL REFERENCES Employee_type,
    date_of_birth DATE NOT NULL,
    age INTERVAL NOT NULL,
    gender_id BIGINT NOT NULL REFERENCES Gender,
    start_work_date DATE,
    children_count SMALLINT,
    salary NUMERIC(10, 2),
    name VARCHAR NOT NULL
);

CREATE TABLE Subscription (
      id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
      author_id BIGINT REFERENCES Author(id),
      genre_id BIGINT REFERENCES Genre(id)
);


CREATE TABLE Director (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    employee_id BIGINT NOT NULL REFERENCES Employee
);

CREATE TABLE Actor (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    employee_id BIGINT NOT NULL REFERENCES Employee,
    height SMALLINT NOT NULL,
    is_student BOOLEAN NOT NULL
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
    season double precision NOT NULL,
    count_of_tickets SMALLINT,
    is_tour BOOLEAN
);

CREATE TABLE Performance (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    age_limit SMALLINT NOT NULL,
    premiere_date DATE,
    author_id BIGINT REFERENCES Author,
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
    employee_id BIGINT NOT NULL REFERENCES Employee
);

CREATE TABLE Headmaster (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    employee_id BIGINT NOT NULL REFERENCES Employee
);

INSERT INTO gender
(type)
VALUES ('Мужчина'),
       ('Женщина');

INSERT INTO start
(start_work_theatre_date)
VALUES ('01-09-1980');

INSERT INTO genre
(genre_class)
VALUES ('Комедия'),
       ('Драма'),
       ('Трагедия');

INSERT INTO employee_type
(type)
VALUES ('Актер'),
       ('Режиссер'),
       ('Музыкант'),
       ('Директор');

INSERT INTO employee
(type_id, date_of_birth, gender_id, start_work_date, children_count, salary, name, age)
VALUES (1,'10-12-1997', 1, '23-10-2020', 0, 35.000, 'Крышенко Иван Евгеньевич', age(timestamp '10-12-1997')),
       (1, '18-04-2002', 2, '10-09-2021', 0, 15.000, 'Борисова Александра Алексеевна', age(timestamp '18-04-2002')),
       (2, '11-10-1981', 2, '13-05-2000', 2, 55.000, 'Епончинская Елена Олеговна', age(timestamp '11-12-1981')),
       (3, '16-09-1972', 2, '14-02-2002', 1, 45.000, 'Дымонт Надежда Андреевна', age(timestamp '16-09-1972')),
       (4, '14-06-1969', 1, '13-07-1999', 1, 70.000, 'Демчук Роман Евгеньевич', age(timestamp '14-06-1969'));

INSERT INTO author
(country, age_during_writing, name, title, genre_id)
VALUES ('Англия', 37, 'Уильям Шекспир', 'Гамлет', 3),
       ('Россиская империя', 43, 'А.П. Чехов', 'Вишневый сад', 1),
       ('СССР', 30, 'А.В. Вампилов', 'Утиная охота', 2),
       ('Российская империя', 22, 'Ф. М. Достоевский', 'Преступление и наказание',3 );

INSERT INTO actor
(employee_id, height, is_student)
VALUES (1, 178, false),
       (2, 160, true);

INSERT INTO director
(employee_id)
VALUES (3);


INSERT INTO date_of_tour
(date_start, date_end)
VALUES ('27-11-2022', '05-12-2022'),
       ('10-01-2021', '24-01-2021');

INSERT INTO actor_tour
(actor_id, date_of_tour_id)
VALUES (2, 1),
       (1, 2),
       (1, 1);

INSERT INTO achievement
(date_of_competition, title, actor_id)
VALUES ('24-05-2022', 'Заслуженная артистка России', 1);

INSERT INTO performance
(age_limit, premiere_date, author_id, time_duration)
VALUES (18, '01-01-2018', 1, 135),
       (12, '10-04-2005', 2, 125),
       (16, '10-11-2022', 4, 130);

INSERT INTO director_performance
(director_id, performance_id)
VALUES (1, 1);

INSERT INTO date_of_playing
(date_of_performance, count_of_tickets, is_tour, season)
VALUES ('20-03-2021', 150, false, date_part('years', age(timestamp '20-03-2021', timestamp '01-09-1980'))),
       ('12-09-2000', 150, false, date_part('years', age(timestamp '12-09-2000', timestamp '01-09-1980'))),
       ('24-10-2025', 150, true, date_part('years', age(timestamp '24-10-2025', timestamp '01-09-1980')));

INSERT INTO date_performance
(performance_id, date_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (2, 3);

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

--1.1
SELECT name, et.type, date_of_birth, age, g.type, start_work_date, children_count, salary
FROM employee
    JOIN employee_type et on et.id = employee.type_id
    JOIN gender g on employee.gender_id = g.id;

--1.2
SELECT COUNT(*) FROM employee;

--2.1
SELECT author_of_performance.name, author_of_performance.title, g.genre_class, date.date_of_performance,date.season
FROM performance
    JOIN date_performance dp on Performance.id = dp.performance_id
    JOIN date_of_playing date on dp.date_id = date.id
    JOIN author author_of_performance on author_of_performance.id = Performance.author_id
    JOIN genre g on g.id = author_of_performance.genre_id
    WHERE season = 40;
--2.2
SELECT author_of_performance.name, author_of_performance.title, g.genre_class, date.date_of_performance,date.season
FROM performance
    JOIN date_performance dp on Performance.id = dp.performance_id
    JOIN date_of_playing date on dp.date_id = date.id
    JOIN author author_of_performance on author_of_performance.id = Performance.author_id
    JOIN genre g on g.id = author_of_performance.genre_id
    WHERE date_of_performance < current_date and genre_class = 'Трагедия'
      and date_of_performance > '10-01-1990' and date_of_performance < '10-01-2020'; --сть один спектакль в 45 сезоне

