CREATE DATABASE  IF NOT EXISTS `wishlist` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `wishlist`;
-- MySQL dump 10.13  Distrib 8.0.15, for Linux (x86_64)
--
-- Host: localhost    Database: wishlist
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `wishes`
--

DROP TABLE IF EXISTS `wishes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `wishes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wishtext` varchar(1900) NOT NULL,
  `giver` varchar(90) DEFAULT NULL,
  `notes` varchar(500) DEFAULT NULL,
  `link` varchar(500) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`,`userid`),

	CONSTRAINT `Users_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `user` (`userid`)
);

/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishes`
--

LOCK TABLES `wishes` WRITE;
/*!40000 ALTER TABLE `wishes` DISABLE KEYS */;
INSERT INTO `wishes` (`wishtext`, `giver`, `notes`, `link`, `userid`) VALUES 
('<b>Roccat Vulcan 120 AIMO</b> Gamer keyboard, Fra 1.160 kr. til 1.555 kr','','','https://www.pricerunner.dk/pl/111-4793853/Tastatur/Roccat-Vulcan-120-AIMO-Nordic-Sammenlign-Priser',2),
('<b>Logitech G903</b> Gamer mus, ca. pris 907kr','','','https://www.pricerunner.dk/pl/110-4119224/Mus/Logitech-G903-Lightspeed-Wireless-Sammenlign-Priser',2),
('<b>Beyerdynamic Custom Game</b> Gamer headset, Fra 1.366 kr.','','', 'https://www.pricerunner.dk/pl/94-4731093/Hoeretelefoner/Beyerdynamic-Custom-Game-Sammenlign-Priser', 2),
('<b>Lindy Displayport til HDMI</b> Adapterkabel, ca. pris 119kr','','','https://www.av-connection.dk/?PGr=4328',2),
('<b>Lindy Displayport til HDMI</b> Adapterkabel, ca. pris 119kr','','','https://www.av-connection.dk/?PGr=4328',3),
('<b>Lindy Displayport til HDMI</b> Adapterkabel, ca. pris 119kr','','','https://www.av-connection.dk/?PGr=4328',4),
('<b>Lindy Displayport til HDMI</b> Adapterkabel, ca. pris 119kr','','','https://www.av-connection.dk/?PGr=4328',5),
('<b>Lindy Displayport til HDMI</b> Adapterkabel, ca. pris 119kr','','','https://www.av-connection.dk/?PGr=4328',6),
('<b>Lindy Displayport til HDMI</b> Adapterkabel, ca. pris 119kr','','','https://www.av-connection.dk/?PGr=4328',7),
('<b>Lindy Displayport til HDMI</b> Adapterkabel, ca. pris 119kr','','','https://www.av-connection.dk/?PGr=4328',8),
('<b>Lindy Displayport til HDMI</b> Adapterkabel, ca. pris 119kr','','','https://www.av-connection.dk/?PGr=4328',9),
('<b>Brush Hero Roterende Vaskebørste</b>, 389kr',NULL,NULL,NULL,2),
('<b>Tile Style Bluetooth-tracker</b>, 149kr',NULL,NULL,NULL,2),
('<b>Game of Thrones ølkrus</b>, 509kr',NULL,NULL, NULL, 2);

/*!40000 ALTER TABLE `wishes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-21 12:14:21
