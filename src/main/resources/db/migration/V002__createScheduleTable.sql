CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE public.schedule
(
    id          uuid DEFAULT uuid_generate_v4(),
    start_time  TIMESTAMP NOT NULL,
    end_time    TIMESTAMP NOT NULL,
    schedule_day DATE NOT NULL,
    employee_id uuid NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT employee_id FOREIGN KEY (employee_id) REFERENCES employees (id)
);