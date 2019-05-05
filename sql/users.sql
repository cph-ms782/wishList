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
) ENGINE=InnoDB;

INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Johannes','halvtreds','50.gif');
INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Martin','halvtreds','martin2.JPG');
INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Bettina','halvtreds','bettina1.JPG');
INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Johannes','halvtreds','johannes3.JPG');
INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Elly','halvtreds','elly1.JPG');
INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Peter','halvtreds','peter1.JPG');
INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Jakob','halvtreds','jakob1.JPG');
INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Isabel','halvtreds','isabel1.JPG');
INSERT INTO `user` (`user`, `userpassword`, `image`) VALUES('Esther','halvtreds','esther1.JPG');
