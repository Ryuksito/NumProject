-- Database: game_db

-- DROP DATABASE IF EXISTS game_db;

CREATE DATABASE game_db
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Panama.1252'
    LC_CTYPE = 'Spanish_Panama.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;


CREATE TABLE users (
    id SERIAL PRIMARY KEY,                     
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,            
    game_level VARCHAR(12) NOT NULL CHECK (game_level IN ('basic', 'intermediate', 'advanced')) 
);

