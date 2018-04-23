-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema servicedesk
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema servicedesk
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `servicedesk` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `servicedesk` ;

-- -----------------------------------------------------
-- Table `servicedesk`.`FILA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `servicedesk`.`FILA` (
  `ID_FILA` INT NOT NULL AUTO_INCREMENT,
  `NM_FILA` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_FILA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `servicedesk`.`CHAMADO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `servicedesk`.`CHAMADO` (
  `ID_CHAMADO` INT NOT NULL AUTO_INCREMENT,
  `DESCRICAO` VARCHAR(100) NOT NULL,
  `STATUS` VARCHAR(10) NOT NULL,
  `DT_ABERTURA` DATETIME NOT NULL,
  `DT_FECHAMENTO` DATETIME NULL,
  `ID_FILA` INT NOT NULL,
  PRIMARY KEY (`ID_CHAMADO`),
  INDEX `fk_CHAMADO_FILA_idx` (`ID_FILA` ASC),
  CONSTRAINT `fk_CHAMADO_FILA`
    FOREIGN KEY (`ID_FILA`)
    REFERENCES `servicedesk`.`FILA` (`ID_FILA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE usuario(
	ID_USUARIO INT PRIMARY KEY AUTO_INCREMENT,
	USERNAME VARCHAR(50) NOT NULL,
    PASSWORD VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



use servicedesk;

insert into FILA values (null,'Novos Projetos');
insert into FILA values (null,'Manutenção Sistema de Vendas');
insert into FILA values (null,'Manutenção Sistema ERP');
insert into FILA values (null,'Servidores');
insert into FILA values (null,'Redes');
insert into FILA values (null,'Telefonia');
insert into FILA values (null,'Desktops');

insert into usuario values (null,'admin','admin');


select * from fila;





















