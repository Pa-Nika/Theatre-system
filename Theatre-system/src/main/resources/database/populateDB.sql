--INSERT INTO clients VALUES
--(1, 'Vassily Petrov', 'vpetrov@jr.com', '+7 (191) 322-22-33)'),
--(2, 'Pjotr Vasechkin', 'pvasechkin@jr.com', '+7 (191) 223-33-22)');

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
(type_id, date_of_birth, gender_id, start_work_date, children_count, salary, user_name, age)
VALUES (1,'10-12-1997', 1, '23-10-2020', 0, 35.000, 'Крышенко Иван Евгеньевич', interval '25 year'),
       (1, '18-04-2002', 2, '10-09-2021', 0, 15.000, 'Борисова Александра Алексеевна', interval '25 year'),
       (2, '11-10-1981', 2, '13-05-2000', 2, 55.000, 'Епончинская Елена Олеговна', interval '25 year'),
       (3, '16-09-1972', 2, '14-02-2002', 1, 45.000, 'Дымонт Надежда Андреевна', interval '25 year'),
       (4, '14-06-1969', 1, '13-07-1999', 1, 70.000, 'Демчук Роман Евгеньевич', interval '25 year');

INSERT INTO author
(country, age_during_writing, user_name, title, genre_id, date_of_birth)
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
