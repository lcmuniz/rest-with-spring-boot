CREATE TABLE "rest-with-spring-boot".people (
        id SERIAL PRIMARY KEY NOT NULL,
        email varchar(100) NOT NULL,
        first_name varchar(100) NOT NULL,
        gender varchar(6) NOT NULL,
        last_name varchar(100) NOT NULL
);