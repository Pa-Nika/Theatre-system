DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE Start (
    id SERIAL PRIMARY KEY,
    start_work_theatre_date DATE NOT NULL
);

CREATE TABLE Gender (
    id SERIAL PRIMARY KEY,
    type VARCHAR NOT NULL
);

CREATE TABLE Genre (
    id SERIAL PRIMARY KEY,
    genre_class VARCHAR
);

CREATE TABLE Author (
    id SERIAL PRIMARY KEY,
    country VARCHAR NOT NULL,
    age_during_writing SMALLINT,
    name VARCHAR,
    title varchar NOT NULL,
    genre_id BIGINT NOT NULL REFERENCES Genre,
    date_of_birth DATE NOT NULL
);

CREATE TABLE Employee_type (
    id SERIAL PRIMARY KEY,
    type VARCHAR NOT NULL
);

CREATE TABLE Employee (
    id SERIAL PRIMARY KEY,
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
      id SERIAL PRIMARY KEY,
      author_id BIGINT REFERENCES Author(id),
      genre_id BIGINT REFERENCES Genre(id)
);


CREATE TABLE Director (
    id SERIAL PRIMARY KEY,
    employee_id BIGINT NOT NULL REFERENCES Employee
);

CREATE TABLE Actor (
    id SERIAL PRIMARY KEY,
    employee_id BIGINT NOT NULL REFERENCES Employee,
    height SMALLINT NOT NULL,
    is_student BOOLEAN NOT NULL
);

CREATE TABLE Achievement (
    id SERIAL PRIMARY KEY,
    date_of_competition DATE,
    title VARCHAR,
    actor_id BIGINT NOT NULL REFERENCES Actor(id)
);

CREATE TABLE Date_of_playing (
    id SERIAL PRIMARY KEY,
    date_of_performance DATE NOT NULL,
    season double precision NOT NULL,
    count_of_tickets SMALLINT,
    is_tour BOOLEAN
);

CREATE TABLE Performance (
    id SERIAL PRIMARY KEY,
    age_limit SMALLINT NOT NULL,
    premiere_date DATE,
    author_id BIGINT REFERENCES Author,
    time_duration NUMERIC(3)
);

CREATE TABLE Date_of_tour (
    id SERIAL PRIMARY KEY,
    date_start DATE NOT NULL,
    date_end DATE NOT NULL,
    performance_id BIGINT NOT NULL REFERENCES Performance(id)
);

CREATE TABLE Actor_tour (
    actor_id  BIGINT REFERENCES Actor(id) NOT NULL,
    date_of_tour_id BIGINT REFERENCES Date_of_tour(id) NOT NULL,
    PRIMARY KEY (actor_id, date_of_tour_id)
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
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    is_main BOOLEAN NOT NULL,
--     main_actor_id BIGINT NOT NULL REFERENCES Actor(id),
--     understudy_id BIGINT NOT NULL REFERENCES Actor(id),
    age SMALLINT NOT NULL,
    gender_id BIGINT NOT NULL REFERENCES Gender,
    height SMALLINT,
    performance_id BIGINT NOT NULL REFERENCES Performance(id)
);

CREATE TABLE Actor_playing_role (
    is_main BOOLEAN NOT NULL,
    date_of_playing DATE NOT NULL,
    role_id BIGINT NOT NULL REFERENCES Role(id),
    actor_id BIGINT NOT NULL REFERENCES Actor(id),
    PRIMARY KEY (role_id, actor_id)
);

CREATE TABLE Place (
    id SERIAL PRIMARY KEY,
    number NUMERIC(3) NOT NULL UNIQUE
);

CREATE TABLE Ticket (
    id SERIAL PRIMARY KEY,
    is_preliminarily_sold BOOLEAN NOT NULL,
--     place_id BIGINT NOT NULL REFERENCES Place(id),
    price SMALLINT NOT NULL,
    performance_id BIGINT NOT NULL REFERENCES Performance(id),
    date_id BIGINT REFERENCES Date_of_playing(id) NOT NULL
);

CREATE TABLE Ticket_place (
    ticket_id BIGINT REFERENCES Ticket(id) NOT NULL,
    place_id BIGINT REFERENCES Place(id) NOT NULL,
    PRIMARY KEY (ticket_id, place_id)
);

CREATE TABLE Musician (
    id SERIAL PRIMARY KEY,
    employee_id BIGINT NOT NULL REFERENCES Employee
);

CREATE TABLE Headmaster (
    id SERIAL PRIMARY KEY,
    employee_id BIGINT NOT NULL REFERENCES Employee
);

--DECLARE start_work_theatre_date DATE;

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
(country, age_during_writing, name, title, genre_id, date_of_birth)
VALUES ('Англия', 37, 'Уильям Шекспир', 'Гамлет', 3, '26-04-1564'),
       ('Россиская империя', 43, 'А.П. Чехов', 'Вишневый сад', 1, '29-01-1860'),
       ('СССР', 30, 'А.В. Вампилов', 'Утиная охота', 2, '19-08-1937'),
       ('Российская империя', 45, 'Ф. М. Достоевский', 'Преступление и наказание',3, '11-11-1821');

INSERT INTO actor
(employee_id, height, is_student)
VALUES (1, 178, false),
       (2, 160, true);

INSERT INTO director
(employee_id)
VALUES (5);

INSERT INTO achievement
(date_of_competition, title, actor_id)
VALUES ('24-05-2022', 'Заслуженный артист России', 1);

INSERT INTO performance
(age_limit, premiere_date, author_id, time_duration)
VALUES (18, '01-01-2018', 1, 135),
       (12, '10-04-2005', 2, 125),
       (16, '10-11-2022', 4, 130);

INSERT INTO date_of_tour
(date_start, date_end, performance_id)
VALUES ('27-11-2022', '05-12-2022', 1),
       ('10-01-2021', '24-01-2021', 3);

INSERT INTO actor_tour
(actor_id, date_of_tour_id)
VALUES (2, 1),
       (1, 2),
       (1, 1);

INSERT INTO director_performance
(director_id, performance_id)
VALUES (1, 1);

INSERT INTO date_of_playing
(date_of_performance, count_of_tickets, is_tour, season)
VALUES ('20-03-2021', 150, false, date_part('years', age(timestamp '20-03-2021', timestamp '01-09-1980'))),
       ('12-09-2000', 150, false, date_part('years', age(timestamp '12-09-2000', timestamp '01-09-1980'))),
       ('24-10-2025', 150, true, date_part('years', age(timestamp '24-10-2025', timestamp '01-09-1980'))),
       ('31-03-2019', 150, false, date_part('years', age(timestamp '31-03-2019', timestamp '01-09-1980'))),
       ('15-09-2010', 150, false, date_part('years', age(timestamp '15-09-2010', timestamp '01-09-1980')));

INSERT INTO date_performance
(performance_id, date_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (2, 3),
       (3, 4),
       (1, 5);

INSERT INTO place
(number)
VALUES (1), (2), (3), (4), (5), (6), (7), (8), (9), (10);

INSERT INTO ticket
(is_preliminarily_sold, price, performance_id, date_id)
VALUES (false, 100, 1, 1),
       (true, 100, 2, 2),
       (false, 100, 1, 5),
       (false, 150, 2, 5);

INSERT INTO Ticket_place
(ticket_id, place_id)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (3, 1),
       (3, 3),
       (4, 5);

INSERT INTO subscription
(author_id, genre_id)
VALUES (1, 3);

INSERT INTO role
(name, is_main, age, gender_id, height, performance_id)
VALUES ('Гамлет', true, 30, 1, 170, 1);

INSERT INTO actor_playing_role
(is_main, date_of_playing, role_id, actor_id)
VALUES (true, '15-09-2010', 1, 1),
       (false, '15-09-2010', 1, 2);

-- 1
SELECT name, et.type, date_of_birth, age, g.type, start_work_date, children_count, salary
FROM employee
    JOIN employee_type et on et.id = employee.type_id
    JOIN gender g on employee.gender_id = g.id;
--SELECT COUNT(*) FROM employee;

-- 2.1
SELECT author_of_performance.name, author_of_performance.title, g.genre_class, date.date_of_performance,date.season
FROM performance
    JOIN date_performance dp on Performance.id = dp.performance_id
    JOIN date_of_playing date on dp.date_id = date.id
    JOIN author author_of_performance on author_of_performance.id = Performance.author_id
    JOIN genre g on g.id = author_of_performance.genre_id
    ORDER BY date_of_performance;

--2.2
SELECT author_of_performance.name, author_of_performance.title, g.genre_class, date.date_of_performance,date.season
FROM performance
    JOIN date_performance dp on Performance.id = dp.performance_id
    JOIN date_of_playing date on dp.date_id = date.id
    JOIN author author_of_performance on author_of_performance.id = Performance.author_id
    JOIN genre g on g.id = author_of_performance.genre_id
    WHERE date_of_performance < current_date and genre_class = 'Трагедия'
      and date_of_performance > '10-01-1990' and date_of_performance < '10-01-2020'; --есть один спектакль в 45 сезоне

-- 4
SELECT Author_of_performance.name FROM performance
    JOIN Author Author_of_performance on Author_of_performance.id = Performance.author_id
    WHERE Author_of_performance.date_of_birth > '01-01-1800';

--5
SELECT title, name FROM Author
    JOIN Performance P on Author.id = P.author_id
    JOIN Genre G on Author.genre_id = G.id
    WHERE G.genre_class = 'Комедия' or Author.name = 'А.В. Вампилов' or Author.country = 'Россиская империя'
       or (Author.date_of_birth + Author.age_during_writing * 365) > '01-01-1800' ;

--6
SELECT Employee.name AS name, R.name FROM Employee
    JOIN Actor A on Employee.id = A.employee_id
    JOIN Actor_playing_role Apr on A.id = Apr.actor_id
    JOIN Role R on Apr.role_id = R.id
    JOIN Gender G on Employee.gender_id = G.id and R.gender_id = G.id
    WHERE abs(A.height - R.height) <= 20;

--7
SELECT Employee.name, A2.title As name FROM Employee
    JOIN Actor A on Employee.id = A.employee_id
    JOIN Achievement A2 on A.id = A2.actor_id
    JOIN Gender G on Employee.gender_id = G.id
    WHERE date_of_competition > '01-01-2020' and G.type = 'Мужчина' and age > interval '25 year';

--8
SELECT Employee.name AS name, A2.title AS title, date_start, date_end FROM Employee
    JOIN Actor A on Employee.id = A.employee_id
    JOIN Actor_tour t on A.id = t.actor_id
    JOIN Date_of_tour Dot on t.date_of_tour_id = Dot.id
    JOIN Performance P on Dot.performance_id = P.id
     JOIN Author A2 on P.author_id = A2.id
--      WHERE title = 'Гамлет';
     WHERE date_start > '01-01-2020' and date_end < '01-01-2023';

--9
SELECT Distinct type, E2.name FROM performance
     LEFT JOIN Director_Performance DP on Performance.id = DP.performance_id
     LEFT JOIN Role R on Performance.id = R.performance_id
     JOIN Actor_playing_role Apr on R.id = Apr.role_id
     JOIN Actor A on A.id = Apr.actor_id
     JOIN Director D on DP.director_id = D.id
     JOIN Employee E2 on A.employee_id = E2.id or D.employee_id = E2.id
     JOIN Employee_type Et on E2.type_id = Et.id;

--10
SELECT DISTINCT Role.name FROM Role
    JOIN Actor_playing_role Apr on Role.id = Apr.role_id
    JOIN Actor A on Apr.actor_id = A.id
    JOIN Employee E on E.id = A.employee_id
    --WHERE E.name = 'Крышенко Иван Евгеньевич';
    JOIN Performance P on Role.performance_id = P.id
    JOIN Date_Performance DP on P.id = DP.performance_id
    JOIN Date_of_playing Dop on DP.date_id = Dop.id
    WHERE  date_of_performance > '10-01-1990' and date_of_performance < '10-01-2020';

--11.1
SELECT COUNT(*) FROM Ticket_place;

--11.2
SELECT COUNT(*) FROM Ticket_place
    JOIN Ticket T on T.id = Ticket_place.ticket_id
    JOIN performance p on p.id = T.performance_id
    JOIN Author A on p.author_id = A.id
    JOIN Date_of_playing Dop on T.date_id = Dop.id
    WHERE A.title = 'Гамлет' and Dop.date_of_performance = '15-09-2010';

--11.3
SELECT COUNT(*) FROM Ticket_place
    JOIN Ticket T on Ticket_place.ticket_id = T.id
    JOIN Performance P on T.performance_id = P.id
    JOIN Author A on A.id = P.author_id
    WHERE title = 'Гамлет' and premiere_date = '01-01-2018';

-- 12
SELECT SUM(price) FROM ticket
    JOIN Performance P on P.id = Ticket.performance_id
    JOIN Author A on A.id = P.author_id
    JOIN Date_Performance DP on P.id = DP.performance_id
    JOIN Date_of_playing Dop on Dop.id = DP.date_id
    WHERE title = 'Гамлет' and date_of_performance = '15-09-2010';

-- 13.1
SELECT number FROM place
    EXCEPT SELECT number FROM place
    JOIN Ticket_place Tp on Place.id = Tp.place_id
    JOIN Ticket T on T.id = Tp.ticket_id
    JOIN Date_of_playing Dop on T.date_id = Dop.id
    JOIN Performance P on T.performance_id = P.id
    JOIN Author A on A.id = P.author_id
    WHERE Dop.date_of_performance = '15-09-2010' and title = 'Гамлет'
    ORDER BY number;

--13.2
SELECT (SELECT count(number) FROM place) - count(number) FROM place
    JOIN Ticket_place Tp on Place.id = Tp.place_id
    JOIN Ticket T on T.id = Tp.ticket_id
    JOIN Date_of_playing Dop on T.date_id = Dop.id
    JOIN Performance P on T.performance_id = P.id
    JOIN Author A on A.id = P.author_id
    WHERE Dop.date_of_performance = '15-09-2010' and title = 'Гамлет';

