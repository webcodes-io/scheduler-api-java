CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE public.employees
(
    id              uuid DEFAULT uuid_generate_v4(),
    first_name      varchar NOT NULL,
    last_name       varchar NOT NULL,
    user_name       varchar NOT NULL,
    phone           integer,
    email           varchar,
    address         varchar,
    department      varchar,
    timezone        varchar(20),
    PRIMARY KEY     (id)
);