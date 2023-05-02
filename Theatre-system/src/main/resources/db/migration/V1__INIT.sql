CREATE TABLE IF NOT EXISTS Gender (
    id SERIAL PRIMARY KEY,
    type VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS Genre (
    id SERIAL PRIMARY KEY,
    genre_class VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Country (
    id SERIAL PRIMARY KEY,
    country VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Author (
    id SERIAL PRIMARY KEY,
    country_id BIGINT NOT NULL REFERENCES Country,
    age_during_writing SMALLINT,
    user_name VARCHAR(50) NOT NULL,
    title varchar(50) NOT NULL,
    genre_id BIGINT NOT NULL REFERENCES Genre,
    date_of_birth DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS Employee_type (
    id SERIAL PRIMARY KEY,
    type VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Employee (
    id SERIAL PRIMARY KEY,
    type_id BIGINT NOT NULL REFERENCES Employee_type,
    date_of_birth DATE NOT NULL,
    age INTERVAL,
    gender_id BIGINT NOT NULL REFERENCES Gender,
    start_work_date DATE NOT NULL,
    children_count SMALLINT NOT NULL,
    salary BIGINT NOT NULL,
    user_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Subscription (
   id SERIAL PRIMARY KEY,
   author_id BIGINT REFERENCES Author,
   genre_id BIGINT REFERENCES Genre
);


CREATE TABLE IF NOT EXISTS Director (
    id SERIAL PRIMARY KEY,
    employee_id BIGINT NOT NULL REFERENCES Employee
);

CREATE TABLE IF NOT EXISTS Actor (
    id SERIAL PRIMARY KEY,
    employee_id BIGINT NOT NULL REFERENCES Employee,
    height SMALLINT NOT NULL,
    is_student BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS Achievement (
    id SERIAL PRIMARY KEY,
    date_of_competition DATE NOT NULL,
    title VARCHAR(50) NOT NULL,
    actor_id BIGINT NOT NULL REFERENCES Actor(id)
);

CREATE TABLE IF NOT EXISTS Date_of_playing (
    id SERIAL PRIMARY KEY,
    date_of_performance DATE NOT NULL,
    season SMALLINT NOT NULL,
    count_of_tickets SMALLINT,
    is_tour BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS Performance (
    id SERIAL PRIMARY KEY,
    age_limit SMALLINT NOT NULL,
    premiere_date DATE NOT NULL,
    author_id BIGINT REFERENCES Author,
    time_duration NUMERIC(3) NOT NULL
);

CREATE TABLE IF NOT EXISTS Date_of_tour (
    id SERIAL PRIMARY KEY,
    date_start DATE NOT NULL,
    date_end DATE NOT NULL,
    performance_id BIGINT NOT NULL REFERENCES Performance(id)
);

CREATE TABLE IF NOT EXISTS Actor_tour (
    actor_id  BIGINT REFERENCES Actor NOT NULL,
    date_of_tour_id BIGINT REFERENCES Date_of_tour NOT NULL,
    PRIMARY KEY (actor_id, date_of_tour_id)
);

CREATE TABLE IF NOT EXISTS Date_Performance (
    date_id BIGINT REFERENCES Date_of_playing(id) NOT NULL,
    performance_id BIGINT REFERENCES Performance(id) NOT NULL,
    PRIMARY KEY (date_id, performance_id)
);

CREATE TABLE IF NOT EXISTS Director_Performance (
    director_id BIGINT REFERENCES Director(id) NOT NULL,
    performance_id BIGINT REFERENCES Performance(id) NOT NULL,
    PRIMARY KEY (director_id, performance_id)
);

CREATE TABLE IF NOT EXISTS Role (
    id SERIAL PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL,
    is_main BOOLEAN NOT NULL,
    age SMALLINT NOT NULL,
    gender_id BIGINT NOT NULL REFERENCES Gender,
    height SMALLINT,
    performance_id BIGINT NOT NULL REFERENCES Performance(id)
);

CREATE TABLE IF NOT EXISTS Actor_playing_role (
    is_main BOOLEAN NOT NULL,
    date_of_playing DATE NOT NULL,
    role_id BIGINT NOT NULL REFERENCES Role(id),
    actor_id BIGINT NOT NULL REFERENCES Actor(id),
    PRIMARY KEY (role_id, actor_id)
);

CREATE TABLE IF NOT EXISTS Place (
    id SERIAL PRIMARY KEY,
    number NUMERIC(3) NOT NULL UNIQUE
);

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
