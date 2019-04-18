CREATE DATABASE IF NOT EXISTS `wishlist`;

USE `wishlist`;

DROP TABLE IF EXISTS `wishes`;

CREATE TABLE `wishes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `wishtext` varchar(1900) NOT NULL,
  `giver` varchar(90) DEFAULT NULL,
  `notes` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

INSERT INTO `wishes` (`wishtext`,`giver`,`notes`) VALUES 
('Keyboard www.dr.dk','Lars og Jens','Den køber vi'),
('Gamer mus. Set i ELgiganten','Bo og Morten','Købt');

INSERT INTO `wishes` (`wishtext`) VALUES 
('KHK');
