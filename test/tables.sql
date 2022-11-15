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
    gender VARCHAR NOT NULL,
    date_of_birth DATE NOT NULL,
    start_work_date DATE,
    children_count SMALLINT,
    salary NUMERIC(10, 2),
    name VARCHAR NOT NULL,
    director_class VARCHAR
    --tour_date DATE[]
);

CREATE TABLE Actor (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    age SMALLINT NOT NULL,
    gender VARCHAR NOT NULL,
    height SMALLINT NOT NULL,
    date_of_birth DATE NOT NULL,
    start_work_date DATE,
    children_count SMALLINT,
    salary NUMERIC(10, 2),
    name VARCHAR NOT NULL,
    is_student BOOLEAN,
    tour_date DATE
);

CREATE TABLE Achievement (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    date_of_competition DATE,
    competition VARCHAR,
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
    author VARCHAR,
    gender VARCHAR(2),
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
    gender VARCHAR (2),
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
    gender VARCHAR NOT NULL,
    date_of_birth DATE NOT NULL,
    start_work_date DATE,
    children_count SMALLINT,
    salary NUMERIC(10, 2),
    name VARCHAR NOT NULL
);

CREATE TABLE Headmaster (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    age SMALLINT NOT NULL,
    gender VARCHAR NOT NULL,
    date_of_birth DATE NOT NULL,
    start_work_date DATE,
    children_count SMALLINT,
    salary NUMERIC(10, 2),
    name VARCHAR NOT NULL
);

----Как реализовать playing?
