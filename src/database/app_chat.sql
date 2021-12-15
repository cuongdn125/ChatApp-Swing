create database `app_chat`;

use app_chat;

CREATE TABLE `Account` (
  `userID` INT(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT  NULL,
  `password` varchar(255) DEFAULT  NULL,
  PRIMARY KEY (`userId`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- insert into Account (userName, password) value ('admin','123');
-- drop table `Message`; 
CREATE TABLE `Message` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `mess` varchar(255) DEFAULT  NULL,
  `type` varchar(255) DEFAULT  NULL,
  `srcUser` varchar(255) DEFAULT  NULL,
  `desUser` varchar(255) DEFAULT  NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `Group` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT  NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `User_Group` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT  NULL,
  `groupname` varchar(255) DEFAULT  NULL,
  PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
