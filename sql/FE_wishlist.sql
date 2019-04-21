-- MySQL Script generated by MySQL Workbench
-- søn 21 apr 2019 12:05:31 CEST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema wishlist
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `wishlist` ;

-- -----------------------------------------------------
-- Schema wishlist
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `wishlist` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `wishlist` ;

-- -----------------------------------------------------
-- Table `wishlist`.`wishes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wishlist`.`wishes` ;

CREATE TABLE IF NOT EXISTS `wishlist`.`wishes` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `wishtext` VARCHAR(1900) NOT NULL,
  `giver` VARCHAR(90) NULL DEFAULT NULL,
  `notes` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
