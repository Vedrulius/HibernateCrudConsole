CREATE TABLE regions (
id SERIAL,
name VARCHAR(40),
PRIMARY KEY (id)
);

CREATE TABLE users (
id SERIAL,
first_name VARCHAR(40),
last_name VARCHAR(40),
region_id BIGINT,
PRIMARY KEY (id)
);

CREATE TABLE posts (
id SERIAL PRIMARY KEY,
user_id BIGINT,
post TEXT,
created TIMESTAMP NOT NULL DEFAULT now(),
updated TIMESTAMP NOT NULL DEFAULT now(),
CONSTRAINT fk_users FOREIGN KEY (user_id)
REFERENCES users(id)
ON DELETE CASCADE
ON UPDATE CASCADE
);