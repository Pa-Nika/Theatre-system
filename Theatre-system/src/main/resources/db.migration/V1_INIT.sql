--CREATE TABLE IF NOT EXISTS Start (
--    id SERIAL PRIMARY KEY,
--    start_work_theatre_date DATE NOT NULL
--);
--
--CREATE TABLE IF NOT EXISTS Gender (
--    id SERIAL PRIMARY KEY,
--    type VARCHAR NOT NULL
--);
--
--CREATE TABLE IF NOT EXISTS Genre (
--    id SERIAL PRIMARY KEY,
--    genre_class VARCHAR
--);
--
--CREATE TABLE IF NOT EXISTS Author (
--    id SERIAL PRIMARY KEY,
--    country VARCHAR NOT NULL,
--    age_during_writing SMALLINT,
--    user_name VARCHAR,
--    title varchar NOT NULL,
--    genre_id BIGINT NOT NULL REFERENCES Genre,
--    date_of_birth DATE NOT NULL
--);
--
--CREATE TABLE IF NOT EXISTS Employee_type (
--    id SERIAL PRIMARY KEY,
--    type VARCHAR NOT NULL
--);
--
--CREATE TABLE IF NOT EXISTS Employee (
--    id SERIAL PRIMARY KEY,
--    type_id BIGINT NOT NULL REFERENCES Employee_type,
--    date_of_birth DATE NOT NULL,
--    age INTERVAL NOT NULL,
--    gender_id BIGINT NOT NULL REFERENCES Gender,
--    start_work_date DATE,
--    children_count SMALLINT,
--    salary NUMERIC(10, 2),
--    user_name VARCHAR NOT NULL
--);
--
-- CREATE TABLE IF NOT EXISTS Subscription (
--       id SERIAL PRIMARY KEY,
--       author_id BIGINT REFERENCES Author(id),
--       genre_id BIGINT REFERENCES Genre(id)
-- );
--
--
--CREATE TABLE IF NOT EXISTS Director (
--    id SERIAL PRIMARY KEY,
--    employee_id BIGINT NOT NULL REFERENCES Employee
--);
--
--CREATE TABLE IF NOT EXISTS Actor (
--    id SERIAL PRIMARY KEY,
--    employee_id BIGINT NOT NULL REFERENCES Employee,
--    height SMALLINT NOT NULL,
--    is_student BOOLEAN NOT NULL
--);
--
--CREATE TABLE IF NOT EXISTS Achievement (
--    id SERIAL PRIMARY KEY,
--    date_of_competition DATE,
--    title VARCHAR,
--    actor_id BIGINT NOT NULL REFERENCES Actor(id)
--);
--
--CREATE TABLE IF NOT EXISTS Date_of_playing (
--    id SERIAL PRIMARY KEY,
--    date_of_performance DATE NOT NULL,
----    season double precision NOT NULL,
--    count_of_tickets SMALLINT,
--    is_tour BOOLEAN
--);
--
--CREATE TABLE IF NOT EXISTS Performance (
--    id SERIAL PRIMARY KEY,
--    age_limit SMALLINT NOT NULL,
--    premiere_date DATE,
--    author_id BIGINT REFERENCES Author,
--    time_duration NUMERIC(3)
--);
--
--CREATE TABLE IF NOT EXISTS Date_of_tour (
--    id SERIAL PRIMARY KEY,
--    date_start DATE NOT NULL,
--    date_end DATE NOT NULL,
--    performance_id BIGINT NOT NULL REFERENCES Performance(id)
--);
--
--CREATE TABLE IF NOT EXISTS Actor_tour (
--    actor_id  BIGINT REFERENCES Actor(id) NOT NULL,
--    date_of_tour_id BIGINT REFERENCES Date_of_tour(id) NOT NULL,
--    PRIMARY KEY (actor_id, date_of_tour_id)
--);
--
--CREATE TABLE IF NOT EXISTS Date_Performance (
--    date_id BIGINT REFERENCES Date_of_playing(id) NOT NULL,
--    performance_id BIGINT REFERENCES Performance(id) NOT NULL,
--    PRIMARY KEY (date_id, performance_id)
--);
--
--CREATE TABLE IF NOT EXISTS Director_Performance (
--    director_id BIGINT REFERENCES Director(id) NOT NULL,
--    performance_id BIGINT REFERENCES Performance(id) NOT NULL,
--    PRIMARY KEY (director_id, performance_id)
--);
--
--CREATE TABLE IF NOT EXISTS Role (
--    id SERIAL PRIMARY KEY,
--    user_name VARCHAR NOT NULL,
--    is_main BOOLEAN NOT NULL,
----     main_actor_id BIGINT NOT NULL REFERENCES Actor(id),
----     understudy_id BIGINT NOT NULL REFERENCES Actor(id),
--    age SMALLINT NOT NULL,
--    gender_id BIGINT NOT NULL REFERENCES Gender,
--    height SMALLINT,
--    performance_id BIGINT NOT NULL REFERENCES Performance(id)
--);
--
--CREATE TABLE IF NOT EXISTS Actor_playing_role (
--    is_main BOOLEAN NOT NULL,
--    date_of_playing DATE NOT NULL,
--    role_id BIGINT NOT NULL REFERENCES Role(id),
--    actor_id BIGINT NOT NULL REFERENCES Actor(id),
--    PRIMARY KEY (role_id, actor_id)
--);
--
--CREATE TABLE IF NOT EXISTS Place (
--    id SERIAL PRIMARY KEY,
--    number NUMERIC(3) NOT NULL UNIQUE
--);
--
--CREATE TABLE IF NOT EXISTS Ticket (
--    id SERIAL PRIMARY KEY,
--    is_preliminarily_sold BOOLEAN NOT NULL,
--    price SMALLINT NOT NULL,
--    performance_id BIGINT NOT NULL REFERENCES Performance(id),
--    date_id BIGINT REFERENCES Date_of_playing(id) NOT NULL
--);
--
--CREATE TABLE IF NOT EXISTS Ticket_place (
--    ticket_id BIGINT REFERENCES Ticket(id) NOT NULL,
--    place_id BIGINT REFERENCES Place(id) NOT NULL,
--    PRIMARY KEY (ticket_id, place_id)
--);
--
--
----CREATE OR REPLACE FUNCTION delete_actor_data() RETURNS TRIGGER AS $$
----BEGIN
----  IF OLD.type_id = (SELECT id FROM Employee_type WHERE type = 'Актер') THEN
----    -- удаляем все связанные записи из таблицы Achievement
----    DELETE FROM Achievement WHERE actor_id = OLD.id;
----    -- удаляем все связанные записи из таблицы Actor_playing_role
----    DELETE FROM Actor_playing_role WHERE actor_id = OLD.id;
----    -- удаляем все связанные записи из таблицы Actor_tour
----    DELETE FROM Actor_tour WHERE actor_id = OLD.id;
----    -- удаляем запись из таблицы Actor
----    DELETE FROM Actor WHERE id = OLD.id;
----  END IF;
----  RETURN OLD;
----END;
----$$ LANGUAGE plpgsql;
----
------ Создаем триггер, который будет вызывать функцию при удалении из таблицы Employee
----CREATE TRIGGER delete_actor_data_trigger
----  BEFORE DELETE ON Employee
----  FOR EACH ROW
----  EXECUTE FUNCTION delete_actor_data();
--
--INSERT INTO gender
--(type)
--VALUES ('Мужчина'),
--       ('Женщина');
--
--INSERT INTO start
--(start_work_theatre_date)
--VALUES ('01-09-1980');
--
--INSERT INTO genre
--(genre_class)
--VALUES ('Комедия'),
--       ('Драма'),
--       ('Трагедия');
--
--INSERT INTO employee_type
--(type)
--VALUES ('Актер'),
--       ('Режиссер'),
--       ('Музыкант'),
--       ('Директор');
--
--INSERT INTO employee
--(type_id, date_of_birth, gender_id, start_work_date, children_count, salary, user_name, age)
--VALUES (1,'10-12-1997', 1, '23-10-2020', 0, 35.000, 'Крышенко Иван Евгеньевич', age('18-04-2002')),
--       (1, '18-04-2002', 2, '10-09-2021', 0, 15.000, 'Борисова Александра Алексеевна',  age('18-04-2002')),
--       (2, '11-10-1981', 2, '13-05-2000', 2, 55.000, 'Епончинская Елена Олеговна', age('18-04-2002')),
--       (3, '16-09-1972', 2, '14-02-2002', 1, 45.000, 'Дымонт Надежда Андреевна', age('18-04-2002')),
--       (4, '14-06-1969', 1, '13-07-1999', 1, 70.000, 'Демчук Роман Евгеньевич', age('18-04-2002'));
--
--INSERT INTO author
--(country, age_during_writing, user_name, title, genre_id, date_of_birth)
--VALUES ('Англия', 37, 'Уильям Шекспир', 'Гамлет', 3, '26-04-1564'),
--       ('Россиская империя', 43, 'А.П. Чехов', 'Вишневый сад', 1, '29-01-1860'),
--       ('СССР', 30, 'А.В. Вампилов', 'Утиная охота', 2, '19-08-1937'),
--       ('Российская империя', 45, 'Ф. М. Достоевский', 'Преступление и наказание',3, '11-11-1821');
--
--INSERT INTO actor
--(employee_id, height, is_student)
--VALUES (1, 178, false),
--       (2, 160, true);
--
--INSERT INTO director
--(employee_id)
--VALUES (5);
--
--INSERT INTO achievement
--(date_of_competition, title, actor_id)
--VALUES ('24-05-2022', 'Заслуженный артист России', 1);
--
--INSERT INTO performance
--(age_limit, premiere_date, author_id, time_duration)
--VALUES (18, '01-01-2018', 1, 135),
--       (12, '10-04-2005', 2, 125),
--       (16, '10-11-2022', 4, 130);
--
--INSERT INTO date_of_tour
--(date_start, date_end, performance_id)
--VALUES ('27-11-2022', '05-12-2022', 1),
--       ('10-01-2021', '24-01-2021', 3);
--
--INSERT INTO actor_tour
--(actor_id, date_of_tour_id)
--VALUES (2, 1),
--       (1, 2),
--       (1, 1);
--
---- INSERT INTO director_performance
---- (director_id, performance_id)
---- VALUES (1, 1);
--
----INSERT INTO date_of_playing
----(date_of_performance, count_of_tickets, is_tour, season)
----VALUES ('20-03-2021', 150, false, date_part('years', age(timestamp '20-03-2021', timestamp '01-09-1980'))),
----       ('12-09-2000', 150, false, date_part('years', age(timestamp '12-09-2000', timestamp '01-09-1980'))),
----       ('24-10-2025', 150, true, date_part('years', age(timestamp '24-10-2025', timestamp '01-09-1980'))),
----       ('31-03-2019', 150, false, date_part('years', age(timestamp '31-03-2019', timestamp '01-09-1980'))),
----       ('15-09-2010', 150, false, date_part('years', age(timestamp '15-09-2010', timestamp '01-09-1980')));
--
----INSERT INTO date_performance
----(performance_id, date_id)
----VALUES (1, 1),
----       (1, 2),
----       (2, 2),
----       (2, 3),
----       (3, 4),
----       (1, 5);
----
----INSERT INTO place
----(number)
----VALUES (1), (2), (3), (4), (5), (6), (7), (8), (9), (10);
----
----INSERT INTO ticket
----(is_preliminarily_sold, price, performance_id, date_id)
----VALUES (false, 100, 1, 1),
----       (true, 100, 2, 2),
----       (false, 100, 1, 5),
----       (false, 150, 2, 5);
----
----INSERT INTO Ticket_place
----(ticket_id, place_id)
----VALUES (1, 1),
----       (1, 2),
----       (2, 1),
----       (3, 1),
----       (3, 3),
----       (4, 5);
----
---- INSERT INTO subscription
---- (author_id, genre_id)
---- VALUES (1, 3);
----
----INSERT INTO role
----(user_name, is_main, age, gender_id, height, performance_id)
----VALUES ('Гамлет', true, 30, 1, 170, 1);
----
----INSERT INTO actor_playing_role
----(is_main, date_of_playing, role_id, actor_id)
----VALUES (true, '15-09-2010', 1, 1),
----       (false, '15-09-2010', 1, 2);