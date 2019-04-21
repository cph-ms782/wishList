CREATE DATABASE IF NOT EXISTS `wishlist`/*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `wishlist`;

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `user`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `user` (
  `userid` int AUTO_INCREMENT,
  `user` varchar(22) NOT NULL,
  `userpassword` varchar(50) NOT NULL,
  `image` varchar(1900),
  PRIMARY KEY (`userid`)
);

INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Martin','halvtreds','');
INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Bettina','halvtreds','');
INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Johannes','halvtreds','');
INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Elly','halvtreds','');
INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Peter','halvtreds','');
INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Jakob','halvtreds','');
INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Isabel','halvtreds','');
INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Esther','halvtreds','');
