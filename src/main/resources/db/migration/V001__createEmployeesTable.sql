CREATE TABLE public.employees
(
    id               uuid    NOT NULL,
    first_name       varchar NOT NULL,
    last_name        varchar NOT NULL,
    user_name        varchar NOT NULL,
    phone            integer,
    email            varchar,
    address          varchar
);