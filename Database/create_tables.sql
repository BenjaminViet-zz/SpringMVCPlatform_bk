set search_path to SpringApp;

CREATE TABLE IF NOT EXISTS USERGROUP(
  UserGroupId BIGSERIAL PRIMARY KEY,
  Code VARCHAR(50) NOT NULL,
  Description VARCHAR(200) NOT NULL,
  Path VARCHAR(50) NOT NULL,
  CreatedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  UNIQUE (Code)
);

CREATE TABLE IF NOT EXISTS USERS(
  UserId BIGSERIAL PRIMARY KEY,
  UserName VARCHAR(50) NOT NULL,
  Password VARCHAR(100) NOT NULL,
  Email VARCHAR(30) NOT NULL,
  UserGroupId BigInt NOT NULL REFERENCES UserGroup(UserGroupId),
  CreatedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  IsActive INTEGER DEFAULT 1 NOT NULL,
  Unique (UserName)
);

-- Do not change this table name. This is used by default for PersistentTokenBasedRememberMeServices.
CREATE TABLE IF NOT EXISTS persistent_logins(
  PersistentLoginId BIGSERIAL PRIMARY KEY,
  UserName VARCHAR(64) NOT NULL,
  Series VARCHAR(64) NOT NULL,
  Token VARCHAR(64) NOT NULL,
  Last_Used TIMESTAMP NOT NULL,
  UNIQUE (Series)
);


CREATE SEQUENCE user_seq START WITH 2 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE usergroup_seq START WITH 3 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE persistent_login_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

-- Insert default values
INSERT INTO USERGROUP (Code, Description, Path, CreatedDate) VALUES ('ADMIN', 'Administration', '/admin', CURRENT_TIMESTAMP);
INSERT INTO USERGROUP (Code, Description, Path, CreatedDate) VALUES ('USER', 'Normal User', '/user', CURRENT_TIMESTAMP);

-- BCryptPassword default password: abc125
INSERT INTO USERS (UserName, Password, Email, UserGroupId,  CreatedDate, IsActive) VALUES('admin', '$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'bluckviet@gmail.com', 1, CURRENT_TIMESTAMP, 1);

