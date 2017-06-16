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

########################################   t_round_img   ###################################
DROP TABLE IF EXISTS t_slide_img;
CREATE TABLE t_slide_img
(
  id          VARCHAR(32) NOT NULL,
  detail      VARCHAR(30),
  src         VARCHAR(100),
  create_time DATETIME,
  status      VARCHAR(1),
  update_time DATETIME,
  PRIMARY KEY (id)
)
  ENGINE "InnoDB", CHARSET "UTF8";

########################################   t_round_img   ###################################
DROP TABLE IF EXISTS t_lama;
CREATE TABLE t_lama
(
  id        VARCHAR(32) NOT NULL,
  lama_name VARCHAR(30),
  src       VARCHAR(50),
  PRIMARY KEY (id)
);

########################################   t_round_img   ###################################
DROP TABLE IF EXISTS t_article;
CREATE TABLE t_article
(
  id          VARCHAR(32) NOT NULL,
  title       VARCHAR(30),
  status      VARCHAR(6),
  content     VARCHAR(20000),
  create_time DATETIME,
  update_time DATETIME,
  author_id   VARCHAR(32) REFERENCES t_lama (id),
  PRIMARY KEY (id)
)
  ENGINE "InnoDB", CHARSET "UTF8";

########################################   t_user   ########################################
DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user
(
  id              VARCHAR(32) NOT NULL,
  name            VARCHAR(20),
  fa_name         VARCHAR(30),
  phone           VARCHAR(11),
  src             VARCHAR(50),
  password        VARCHAR(32),
  salt            VARCHAR(10),
  sex             VARCHAR(2),
  status          VARCHAR(2),
  province        VARCHAR(10),
  area            VARCHAR(30),
  sign            VARCHAR(100),
  email           VARCHAR(30),
  register_time   DATETIME,
  last_login_time DATETIME,
  lama_id         VARCHAR(32) REFERENCES t_lama (id),
  PRIMARY KEY (id)
)
  ENGINE "InnoDB", CHARSET "UTF8";

