CREATE USER developer WITH CREATEDB REPLICATION PASSWORD '123456';
CREATE DATABASE "SpringApp"  WITH OWNER = developer  ENCODING = 'UTF8' TABLESPACE = pg_default CONNECTION LIMIT = -1;


