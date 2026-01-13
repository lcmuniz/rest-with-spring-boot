CREATE TABLE IF NOT EXISTS "rest-with-spring-boot".users (
  id serial NOT NULL PRIMARY KEY,
  user_name varchar(255) DEFAULT NULL,
  full_name varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  account_non_expired boolean DEFAULT FALSE,
  account_non_locked boolean DEFAULT FALSE,
  credentials_non_expired boolean DEFAULT FALSE,
  enabled boolean DEFAULT FALSE,
  CONSTRAINT uk_user_name UNIQUE (user_name)
);