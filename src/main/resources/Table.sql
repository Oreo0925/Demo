CREATE SCHEMA `wedding` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `wedding`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `phoneNumber` VARCHAR(45) NULL DEFAULT '',
  `createTime` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));
  
INSERT INTO `wedding`.`user` (`name`, `phoneNumber`) VALUES ('Ariel', '02-1234567');
INSERT INTO `wedding`.`user` (`name`) VALUES ('Ben');
