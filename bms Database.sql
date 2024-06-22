CREATE DATABASE bms;
use bms;
CREATE TABLE `accountdetails` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pin` varchar(20) DEFAULT NULL,
  `type` varchar(40) DEFAULT NULL,
  `income` varchar(40) DEFAULT NULL,
  `date` varchar(40) DEFAULT NULL,
  `facilities` varchar(300) DEFAULT NULL,
  `cardno` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `personalinformation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `father_name` varchar(50) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `cnic` varchar(20) DEFAULT NULL,
  `qualification` varchar(50) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `date_of_birth` varchar(50) DEFAULT NULL,
  `source` varchar(50) DEFAULT NULL,
  `martial` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `transactions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `acc_no` varchar(50) DEFAULT NULL,
  `amount` varchar(50) DEFAULT '0',
  `date` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);



