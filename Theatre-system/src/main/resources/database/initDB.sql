--DROP view IF EXISTS public.clients;

CREATE TABLE IF NOT EXISTS clients
(
    id    SERIAL PRIMARY KEY ,
    user_name  VARCHAR(200) NOT NULL ,
    email VARCHAR(254) NOT NULL ,
    phone VARCHAR(50)  NOT NULL
);

CREATE TABLE IF NOT EXISTS a1
(
    id    SERIAL PRIMARY KEY ,
    users  VARCHAR(200) NOT NULL ,
    home VARCHAR(254) NOT NULL ,
    family VARCHAR(50)  NOT NULL
);

