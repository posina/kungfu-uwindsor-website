# As Root User run this.
/*
DROP SCHEMA IF EXISTS KUNGFU_MASTER;
CREATE SCHEMA KUNGFU_MASTER;

use mysql;
DROP USER 'arthik'@'%';
CREATE USER 'arthik'@'%' IDENTIFIED WITH mysql_native_password BY 'password';
GRANT ALL PRIVILEGES ON KUNGFU_MASTER.* TO 'arthik'@'%' ;
flush privileges;
*/

DROP SCHEMA IF EXISTS KUNGFU_MASTER;
CREATE SCHEMA KUNGFU_MASTER;
USE KUNGFU_MASTER;

DROP TABLE IF EXISTS STUDENT;

CREATE TABLE STUDENT (
  s_id                       int(11)      NOT NULL AUTO_INCREMENT,
  s_first_name               varchar(128) NOT NULL,
  s_last_name                varchar(45)  NOT NULL,
  s_dob                      datetime     NOT NULL,
  s_join_date                datetime     NOT NULL,
  s_mobile                   varchar(12)  NOT NULL,
  s_email                    varchar(50)  NOT NULL,
  s_apt_no                   int(5),
  s_street                   varchar(45),
  s_city                     varchar(45),
  s_province                 varchar(45),
  s_postal_code              varchar(7),
  s_primary_contact          varchar(45),
  s_primary_contact_mobile   varchar(12),
  s_primary_contact_email    varchar(50),
  s_secondary_contact        varchar(45),
  s_secondary_contact_mobile varchar(12),
  s_secondary_contact_email  varchar(50),
  PRIMARY KEY (s_id)
);

DROP TABLE IF EXISTS RANK_MASTER;

CREATE TABLE RANK_MASTER (
  `rank_id` int(11)     NOT NULL AUTO_INCREMENT,
  `belt`    varchar(15) NOT NULL,
  PRIMARY KEY (`rank_id`)
);

DROP TABLE IF EXISTS STUD_PROGRESS;

CREATE TABLE STUD_PROGRESS (
  `pr_id`           int(11) NOT NULL AUTO_INCREMENT,
  `pr_stu_id`       int(11) NOT NULL,
  `pr_stu_rank`     int(11) NOT NULL,
  `pr_stu_level`    varchar(15)      default 'Beginner',
  `pr_date_awarded` datetime         default NULL,
  PRIMARY KEY (pr_id),
  FOREIGN KEY (pr_stu_id) REFERENCES STUDENT (s_id),
  FOREIGN KEY (pr_stu_rank) REFERENCES RANK_MASTER (rank_id)
);


DROP TABLE IF EXISTS PAYMENTS;

CREATE TABLE PAYMENTS (
  pay_id           int(11)      NOT NULL AUTO_INCREMENT,
  pay_category     varchar(128) NOT NULL,
  pay_sub_category varchar(45)  NOT NULL,
  pay_fees         int(7),
  pay_description  varchar(200) NOT NULL,
  PRIMARY KEY (pay_id)
);


DROP TABLE IF EXISTS ACCOUNT_SUMMARY;

CREATE TABLE ACCOUNT_SUMMARY (
  acc_id        int(11)  NOT NULL AUTO_INCREMENT,
  acc_stu_id    int(11)  NOT NULL,
  acc_pay_id    int(11)  NOT NULL,
  acc_date_paid datetime NOT NULL,
  PRIMARY KEY (acc_id),
  FOREIGN KEY (acc_stu_id) REFERENCES STUDENT (s_id),
  FOREIGN KEY (acc_pay_id) REFERENCES PAYMENTS (pay_id)
);


DROP TABLE IF EXISTS ATTENDANCE;

CREATE TABLE ATTENDANCE (
  att_id        int(11)      NOT NULL AUTO_INCREMENT,
  att_level     varchar(128) NOT NULL,
  att_rank      varchar(45)  NOT NULL,
  att_day       varchar(10),
  att_timetaken varchar(20)  NOT NULL,
  PRIMARY KEY (att_id)
);


DROP TABLE IF EXISTS STUD_ATTENDANCE;

CREATE TABLE STUD_ATTENDANCE (
  `satt_id`            int(11) NOT NULL AUTO_INCREMENT,
  `satt_stu_id`        int(11) NOT NULL,
  `satt_att_id`        int(11) NOT NULL,
  `satt_date_attended` date    NOT NULL,
  PRIMARY KEY (satt_id),
  FOREIGN KEY (satt_stu_id) REFERENCES STUDENT (s_id),
  FOREIGN KEY (satt_att_id) REFERENCES ATTENDANCE (att_id)
);


INSERT INTO RANK_MASTER (rank_id, belt) values
  (1, 'White'),
  (2, 'Yellow'),
  (3, 'Green'),
  (4, 'Blue'),
  (5, 'Red'),
  (6, 'Black');

INSERT INTO PAYMENTS (pay_category, pay_sub_category, pay_fees, pay_description) values
  ('Membership', 'Gold', 800, 'Gold Membership'),
  ('Membership', 'Silver', 500, 'silver Membership'),
  ('Membership', 'Platinum', 1000, 'Platinum Membership'),
  ('Test', 'white', 100, 'White belt skills test'),
  ('Test', 'Yellow', 120, 'Yellow belt skills test'),
  ('Test', 'Green', 160, 'Green belt skills test'),
  ('Test', 'Blue', 200, 'Blue belt skills test'),
  ('Test', 'Red', 240, 'Red belt skills test'),
  ('Test', 'Black', 280, 'Black belt skills test'),
  ('Merchandise', 'Uniforms', 100, 'Uniforms'),
  ('Merchandise', 'Gloves', 50, 'Hand Gloves'),
  ('Merchandise', 'Shoes', 100, 'Shoes');


INSERT INTO ATTENDANCE (att_level, att_rank, att_day, att_timetaken) values
  ('Beginner', 'White', 'Monday', '06:00-07:00'),
  ('Beginner', 'Yellow', 'Monday', '09:00-10:00'),
  ('Beginner', 'Green', 'Monday', '16:00-17:00'),
  ('Beginner', 'Blue', 'Thursday', '06:00-07:00'),
  ('Beginner', 'Red', 'Thursday', '14:00-15:00'),
  ('Beginner', 'Black', 'Thursday', '19:00-20:00'),
  ('Intermediate', 'White', 'Tuesday', '06:00-07:00'),
  ('Intermediate', 'Yellow', 'Tuesday', '09:00-10:00'),
  ('Intermediate', 'Green', 'Tuesday', '16:00-17:00'),
  ('Intermediate', 'Blue', 'Friday', '06:00-07:00'),
  ('Intermediate', 'Red', 'Friday', '14:00-15:00'),
  ('Intermediate', 'Black', 'Friday', '19:00-20:00'),
  ('Advance', 'White', 'Wednesday', '06:00-07:00'),
  ('Advance', 'Yellow', 'Wednesday', '09:00-10:00'),
  ('Advance', 'Green', 'Wednesday', '16:00-17:00'),
  ('Advance', 'Blue', 'Saturday', '06:00-07:00'),
  ('Advance', 'Red', 'Saturday', '14:00-15:00'),
  ('Advance', 'Black', 'Saturday', '19:00-20:00');


INSERT INTO STUDENT (s_first_name, s_last_name, s_dob, s_join_date, s_mobile, s_email, s_apt_no, s_street,
                     s_city, s_province, s_postal_code, s_primary_contact, s_primary_contact_mobile,
                     s_primary_contact_email, s_secondary_contact, s_secondary_contact_mobile, s_secondary_contact_email)
VALUES
  ('Arthik Daniel', 'Das', '1212-12-12 00:00:00', '2018-06-20 00:00:00', '92023042',
                    'arthik.daniel@gmail.com', 0, '1407, 1545 Ouellette Avenue, Windsor', 'Windsor', 'Ontario',
                    'N8X 1K5', null, null,
   null, null, null, null),
  ('Pawan', 'Ganga', '2000-09-09 00:00:00', '2018-06-20 00:00:00', '92023042',
            'pavan@gmail.com', 0, '1407, 1545 Askin, Windsor', 'Windsor', 'Ontario', 'N8X 1K5', null, null, null,
   null, null, null),
  ('Kiran', 'Kour', '2000-09-09 00:00:00', '2018-06-20 00:00:00', '92023042',
            'kiran@gmail.com', 0, '1407, Curry, Windsor', 'Windsor', 'Ontario', 'N8X 1K5', null, null, null, null,
   null, null);


INSERT INTO STUD_PROGRESS (pr_stu_id, pr_stu_rank, pr_stu_level, pr_date_awarded)
VALUES
  (1, 1, 'Beginner', null),
  (2, 1, 'Advanced', '2018-06-20 00:00:00'),
  (2, 2, 'Beginner', null);


INSERT INTO ACCOUNT_SUMMARY (acc_stu_id, acc_pay_id, acc_date_paid)
VALUES
  (2, 3, '2018-06-20 00:00:00'),
  (2, 6, '2018-06-20 00:00:00'),
  (2, 5, '2018-06-20 00:00:00'),
  (2, 1, '2018-06-20 00:00:00'),
  (2, 4, '2018-06-20 00:00:00'),
  (2, 7, '2018-06-20 00:00:00'),
  (1, 3, '2018-06-20 00:00:00'),
  (3, 5, '2018-06-20 00:00:00');


COMMIT;
