DROP DATABASE IF EXISTS cmfz;
CREATE DATABASE cmfz;

########################################  t_admin   ########################################
DROP TABLE IF EXISTS t_admin;
CREATE TABLE cmfz.t_admin
(
  id        VARCHAR(32) NOT NULL,
  name      VARCHAR(30),
  real_name VARCHAR(30),
  password  VARCHAR(32),
  salt      VARCHAR(10),
  PRIMARY KEY (id)
)
  ENGINE "InnoDB", CHARSET "UTF8";

########################################   t_menu   ########################################
DROP TABLE IF EXISTS t_menu;
CREATE TABLE t_menu
(
  id        VARCHAR(32) NOT NULL,
  text      VARCHAR(20),
  url       VARCHAR(50),
  icon      VARCHAR(30),
  father_id VARCHAR(32) REFERENCES t_menu (id),
  PRIMARY KEY (id)
)
  ENGINE "InnoDB", CHARSET "UTF8";

########################################   t_menu   ########################################
