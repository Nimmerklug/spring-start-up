-- Creation of person table
CREATE TABLE IF NOT EXISTS person (
  id SERIAL PRIMARY KEY,
  name VARCHAR(32) NOT NULL,
  age INT NOT NULL,
  email VARCHAR(32) NOT NULL UNIQUE
);