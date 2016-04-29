CREATE TABLE `guestbook`.`surveys` (
`sid` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(255) DEFAULT NULL,
`desc` mediumtext,
`UUID` tinytext,
PRIMARY KEY (`sid`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `guestbook`.`questions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` TEXT(250) NULL,
  `Typ` VARCHAR(20) NULL,
  `sid` INT NOT NULL,
  PRIMARY KEY (`id`));
