# Perform before liquibase run

DROP DATABASE IF EXISTS project;
DROP ROLE IF EXISTS admin;

CREATE ROLE admin WITH ENCRYPTED PASSWORD 'admin';
ALTER USER admin LOGIN;
ALTER USER admin CREATEDB; 
ALTER USER admin CREATEUSER;

CREATE DATABASE project WITH ENCODING 'UTF8';
GRANT ALL PRIVILEGES ON DATABASE project TO admin;
ALTER DATABASE project OWNER TO admin;