DROP TABLE IF EXISTS schools;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS ss_link;



CREATE TABLE schools (
    id              int NOT NULL PRIMARY KEY,
    name            varchar(50) NOT NULL UNIQUE,
    city            varchar(50) NOT NULL
);

CREATE TABLE students (
    id              int NOT NULL PRIMARY KEY,
    name            varchar(50) NOT NULL UNIQUE,
    birth_date      varchar(50) NOT NULL
);

CREATE TABLE ss_link(
    id              int NOT NULL PRIMARY KEY,
    id_school       int NOT NULL,
    id_student      int NOT NULL
);