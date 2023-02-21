SET MODE PostgresQL;
CREATE SCHEMA scm
    CREATE TABLE
CREATE DATABASE news;
\c company


CREATE TABLE if NOT EXISTS users(id SERIAL PRIMARY KEY, position VARCHAR, role VARCHAR, department VARCHAR, contacts INTEGER);
CREATE TABLE if NOT EXISTS departments( id SERIAL PRIMARY KEY,departmentName VARCHAR,description VARCHAR, noOfoWorkers INTEGER);
CREATE TABLE if NOT EXISTS news(id SERIAL PRIMARY KEY, generalNews VARCHAR, departmentNews VARCHAR);
CREATE TABLE if NOT EXISTS departments_users(id SERIAL PRIMARY KEY,departmentsId INTEGER, usersId INTEGER)
;