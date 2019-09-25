CREATE SEQUENCE users_id_seq;
CREATE TABLE users (
id BIGINT NOT NULL DEFAULT nextval('users_id_seq'::regclass) PRIMARY KEY,
email VARCHAR (50) UNIQUE NOT NULL,
name VARCHAR (50) UNIQUE NOT NULL,
password VARCHAR (100) NOT NULL,
username VARCHAR (50) UNIQUE NOT NULL
);
ALTER SEQUENCE users_id_seq
OWNED BY users.id;

CREATE SEQUENCE roles_id_seq;
CREATE TABLE roles(
id BIGINT NOT NULL DEFAULT nextval('roles_id_seq'::regclass) PRIMARY KEY,
name VARCHAR (60) UNIQUE
);
ALTER SEQUENCE roles_id_seq
OWNED BY roles.id;

CREATE TABLE user_roles AS
 SELECT users.id AS user_id,
	roles.id AS role_id
 FROM (users JOIN roles ON ((users.name = roles.name)));

