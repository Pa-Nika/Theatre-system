 INSERT INTO gender
 (id, type)
 VALUES (1, 'Мужчина'),
        (2, 'Женщина');

 INSERT INTO genre
 (id, genre_class)
 VALUES (1, 'Комедия'),
        (2, 'Драма'),
        (3, 'Трагедия');

 INSERT INTO employee_type
 (id, type)
 VALUES (1, 'Актер'),
        (2, 'Режиссер'),
        (3, 'Музыкант'),
        (4, 'Директор');

Insert into country
(id, country)
values (1, 'Англия'),
        (2, 'Российская империя'),
        (3, 'СССР'),
        (4, 'Франция'),
        (5, 'США'),
        (6, 'Россия'),
        (7, 'Великобритания'),
        (8, 'Ирландия');

INSERT INTO employee
 (id, type_id, date_of_birth, gender_id, start_work_date, children_count, salary, user_name, age)
 VALUES (1, 1, to_date('10-12-1997', 'DD-MM-YYYY'), 1, to_date('23-10-2020', 'DD-MM-YYYY'), 0, 35000, 'Крышенко Иван Евгеньевич', age(to_date('10-12-1997', 'DD-MM-YYYY'))),
        (2, 1, to_date('18-04-2002', 'DD-MM-YYYY'), 2, to_date('10-09-2021', 'DD-MM-YYYY'), 0, 15000, 'Борисова Александра Алексеевна', age(to_date('18-04-2002', 'DD-MM-YYYY'))),
        (3, 2, to_date('11-10-1981', 'DD-MM-YYYY'), 2, to_date('13-05-2000', 'DD-MM-YYYY'), 2, 55000, 'Епончинская Елена Олеговна', age(to_date('11-12-1981', 'DD-MM-YYYY'))),
        (4, 3, to_date('16-09-1972', 'DD-MM-YYYY'), 2, to_date('14-02-2002', 'DD-MM-YYYY'), 1, 45000, 'Дымонт Надежда Андреевна', age(to_date('16-09-1972', 'DD-MM-YYYY'))),
        (5, 4, to_date('14-06-1969', 'DD-MM-YYYY'), 1, to_date('13-07-1999', 'DD-MM-YYYY'), 1, 70000, 'Демчук Роман Евгеньевич', age(to_date('14-06-1969', 'DD-MM-YYYY'))),
        (6, 1, to_date('01-01-1990', 'DD-MM-YYYY'), 1, to_date('01-01-2022', 'DD-MM-YYYY'), 2, 40000, 'Иванов Иван Иванович', age(to_date('01-01-1990', 'DD-MM-YYYY'))),
        (7, 2, to_date('15-05-1985', 'DD-MM-YYYY'), 2, to_date('01-01-2021', 'DD-MM-YYYY'), 1, 50000, 'Петрова Ольга Андреевна', age(to_date('15-05-1985', 'DD-MM-YYYY'))),
        (8, 3, to_date('20-03-1995', 'DD-MM-YYYY'), 1, to_date('01-03-2022', 'DD-MM-YYYY'), 0, 20000, 'Сидоров Сергей Иванович', age(to_date('20-03-1995', 'DD-MM-YYYY'))),
        (9, 2, to_date('10-11-1980', 'DD-MM-YYYY'), 1, to_date('01-02-2022', 'DD-MM-YYYY'), 3, 60000, 'Козлова Елена Владимировна', age(to_date('10-11-1980', 'DD-MM-YYYY'))),
        (10, 1, to_date('05-07-1998', 'DD-MM-YYYY'), 2, to_date('01-01-2023', 'DD-MM-YYYY'), 0, 30000, 'Смирнова Мария Дмитриевна', age(to_date('05-07-1998', 'DD-MM-YYYY'))),
        (11, 4, to_date('12-09-1988', 'DD-MM-YYYY'), 1, to_date('01-04-2022', 'DD-MM-YYYY'), 2, 80000, 'Краснов Андрей Игоревич', age(to_date('12-09-1988', 'DD-MM-YYYY'))),
        (12, 2, to_date('03-12-1975', 'DD-MM-YYYY'), 2, to_date('01-05-2021', 'DD-MM-YYYY'), 1, 55000, 'Новикова Юлия Сергеевна', age(to_date('03-12-1975', 'DD-MM-YYYY'))),
        (13, 1, to_date('22-08-1993', 'DD-MM-YYYY'), 1, to_date('01-03-2022', 'DD-MM-YYYY'), 0, 35000, 'Леонидов Артем Андреевич', age(to_date('22-08-1993', 'DD-MM-YYYY')));

 INSERT INTO author
 (id, country_id, age_during_writing, user_name, title, genre_id, date_of_birth)
 VALUES (1, 1, 37, 'Уильям Шекспир', 'Гамлет', 3, '26-04-1564'),
        (2, 2, 43, 'А.П. Чехов', 'Вишневый сад', 1, '29-01-1860'),
        (3, 3, 30, 'А.В. Вампилов', 'Утиная охота', 2, '19-08-1937'),
        (4, 2, 45, 'Ф. М. Достоевский', 'Преступление и наказание',3, '11-11-1821'),
        (5, 4, 30, 'Гюстав Флобер', 'Мадам Бовари', 2, '12-12-1821'),
        (6, 5, 27, 'Фрэнсис Скотт Фицджеральд', 'Великий Гэтсби', 1, '24-09-1896'),
        (7, 6, 42, 'Александр Солженицын', 'Один день Ивана Денисовича', 3, '11-12-1918'),
        (8, 7, 43, 'Джордж Оруэлл', '1984', 2, '25-06-1903'),
        (9, 5, 33, 'Эрнест Хемингуэй', 'Старик и море', 1, '21-07-1899'),
        (10, 6, 39, 'М.Ю.Лермонтов', 'Герой нашего времени', 3, '15-12-1811'),
        (11, 6, 29, 'Л.Н. Толстой', 'Война и мир', 2, '09-09-1828'),
        (12, 5, 28, 'Харпер Ли', 'Убить пересмешника', 3, '28-04-1926'),
        (13, 1, 36, 'Джейн Остин', 'Гордость и предубеждение', 2, '16-12-1775'),
        (14, 8, 22, 'Оскар Уайльд', 'Портрет Дориана Грея', 1, '16-10-1854');

 INSERT INTO actor
 (id, employee_id, height, is_student)
 VALUES (1, 1, 178, false),
        (2, 2, 160, true);

 INSERT INTO director
 (id, employee_id)
 VALUES (1, 5);

 INSERT INTO achievement
 (id, date_of_competition, title, actor_id)
 VALUES (1, '24-05-2022', 'Заслуженный артист России', 1);

 INSERT INTO performance
 (id, age_limit, premiere_date, author_id, time_duration)
 VALUES (1, 18, '01-01-2018', 1, 135),
        (2, 12, '10-04-2005', 2, 125),
        (3, 16, '10-11-2022', 4, 130),
        (4, 18, '05-06-2019', 3, 145),
        (5, 16, '15-03-2017', 5, 120),
        (6, 12, '20-09-2015', 6, 150),
        (7, 18, '25-12-2019', 7, 175),
        (8, 16, '18-07-2020', 8, 130),
        (9, 14, '05-02-2014', 9, 110),
        (10, 18, '30-08-2016', 10, 160),
        (11, 12, '01-05-2021', 11, 125),
        (12, 16, '12-11-2018', 12, 140),
        (13, 14, '24-09-2017', 13, 155);

 INSERT INTO date_of_tour
 (id, date_start, date_end, performance_id)
 VALUES (1, '27-11-2022', '05-12-2022', 1),
        (2,'10-01-2021', '24-01-2021', 3);

 INSERT INTO actor_tour
 (actor_id, date_of_tour_id)
 VALUES (2, 1),
        (1, 2),
        (1, 1);

 INSERT INTO director_performance
 (director_id, performance_id)
 VALUES (1, 1);

INSERT INTO date_of_playing
(id, date_of_performance, count_of_tickets, is_tour, season)
VALUES
  (1, to_date('20-03-2021', 'DD-MM-YYYY'), 150, false, date_part('years', age(to_date('20-03-2021', 'DD-MM-YYYY'), to_date('01-09-1980', 'DD-MM-YYYY')))),
  (2, to_date('12-09-2000', 'DD-MM-YYYY'), 150, false, date_part('years', age(to_date('12-09-2000', 'DD-MM-YYYY'), to_date('01-09-1980', 'DD-MM-YYYY')))),
  (3, to_date('24-10-2025', 'DD-MM-YYYY'), 150, true, date_part('years', age(to_date('24-10-2025', 'DD-MM-YYYY'), to_date('01-09-1980', 'DD-MM-YYYY')))),
  (4, to_date('31-03-2019', 'DD-MM-YYYY'), 150, false, date_part('years', age(to_date('31-03-2019', 'DD-MM-YYYY'), to_date('01-09-1980', 'DD-MM-YYYY')))),
  (5, to_date('15-09-2010', 'DD-MM-YYYY'), 150, false, date_part('years', age(to_date('15-09-2010', 'DD-MM-YYYY'), to_date('01-09-1980', 'DD-MM-YYYY'))));

 INSERT INTO date_performance
 (performance_id, date_id)
 VALUES (1, 1),
        (1, 2),
        (2, 2),
        (2, 3),
        (3, 4),
        (1, 5);

 INSERT INTO place
 (id, number)
 VALUES (1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 6), (7, 7), (8, 8), (9, 9), (10, 10);

-- INSERT INTO ticket
-- (id, is_preliminarily_sold, price, performance_id, date_id)
-- VALUES (1, false, 100, 1, 1),
--        (2, true, 100, 2, 2),
--        (3, false, 100, 1, 5),
--        (4, false, 150, 2, 5);
--
-- INSERT INTO Ticket_place
-- (ticket_id, place_id)
-- VALUES (1, 1),
--        (1, 2),
--        (2, 1),
--        (3, 1),
--        (3, 3),
--        (4, 5);

 INSERT INTO subscription
 (id, author_id, genre_id)
 VALUES (1, 1, 3);

 INSERT INTO role
 (id, user_name, is_main, age, gender_id, height, performance_id)
 VALUES (1, 'Гамлет', true, 30, 1, 170, 1),
        (2, 'Офелия', false, 25, 2, 165, 1),
        (3, 'Клавдий', true, 45, 1, 180, 1),
        (4, 'Полоний', false, 60, 1, 175, 1),
        (5, 'Райнцен', true, 40, 1, 185, 2),
        (6, 'Лопахин', true, 35, 1, 178, 2),
        (7, 'Варя', false, 28, 2, 170, 2),
        (8, 'Родион', true, 25, 1, 175, 3),
        (9, 'Соня Мармеладова', true, 20, 2, 165, 3),
        (10, 'Аркадий', false, 30, 1, 180, 3),
        (11, 'Дмитрий', false , 30, 1, 180, 3),
        (12, 'Максим Максимыч', true, 50, 1, 185, 7);

 INSERT INTO actor_playing_role
 (is_main, date_of_playing, role_id, actor_id)
 VALUES (true, '15-09-2002', 1, 1),
        (false, '20-03-2020', 1, 2);
