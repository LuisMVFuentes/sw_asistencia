-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sw_asistencia
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sw_asistencia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sw_asistencia` DEFAULT CHARACTER SET utf8 ;
USE `sw_asistencia` ;

-- -----------------------------------------------------
-- Table `sw_asistencia`.`carrera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sw_asistencia`.`carrera` (
  `idcarrera` INT(11) NOT NULL,
  `carrera` VARCHAR(45) NOT NULL,
  `facultad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcarrera`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sw_asistencia`.`docente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sw_asistencia`.`docente` (
  `iddocente` INT(11) NOT NULL,
  `codigo` VARCHAR(7) NOT NULL,
  `nombre_doc` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`iddocente`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sw_asistencia`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sw_asistencia`.`curso` (
  `idcurso` INT(11) NOT NULL,
  `codigo` VARCHAR(5) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `grupo` VARCHAR(3) NOT NULL,
  `ciclo` INT(11) NOT NULL,
  `doc_iddocente` INT(11) NOT NULL,
  `car_idcarrera` INT(11) NOT NULL,
  PRIMARY KEY (`idcurso`),
  UNIQUE INDEX `codigo` (`codigo` ASC),
  UNIQUE INDEX `idcurso` (`idcurso` ASC),
  INDEX `fk_curso_docente1_idx` (`doc_iddocente` ASC),
  INDEX `fk_curso_carrera1_idx` (`car_idcarrera` ASC),
  CONSTRAINT `fk_curso_carrera1`
    FOREIGN KEY (`car_idcarrera`)
    REFERENCES `sw_asistencia`.`carrera` (`idcarrera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_curso_docente1`
    FOREIGN KEY (`doc_iddocente`)
    REFERENCES `sw_asistencia`.`docente` (`iddocente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sw_asistencia`.`estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sw_asistencia`.`estudiante` (
  `codigo` VARCHAR(7) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NULL DEFAULT NULL,
  `celular` VARCHAR(45) NULL DEFAULT NULL,
  `curso_idcurso` INT(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_estudiante_curso1_idx` (`curso_idcurso` ASC),
  CONSTRAINT `fk_estudiante_curso1`
    FOREIGN KEY (`curso_idcurso`)
    REFERENCES `sw_asistencia`.`curso` (`idcurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sw_asistencia`.`sesion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sw_asistencia`.`sesion` (
  `idsesiones` INT(11) NOT NULL,
  `fecha` DATE NOT NULL,
  `hora_inicio` VARCHAR(5) NULL DEFAULT NULL,
  `hora_fin` VARCHAR(5) NULL DEFAULT NULL,
  `cur_idcurso` INT(11) NOT NULL,
  PRIMARY KEY (`idsesiones`),
  INDEX `fk_sesion_curso1_idx` (`cur_idcurso` ASC),
  CONSTRAINT `fk_sesion_curso1`
    FOREIGN KEY (`cur_idcurso`)
    REFERENCES `sw_asistencia`.`curso` (`idcurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sw_asistencia`.`sesion_has_estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sw_asistencia`.`sesion_has_estudiante` (
  `sesion_idsesiones` INT(11) NOT NULL,
  `estudiante_codigo` VARCHAR(7) NOT NULL,
  `estado` VARCHAR(1) NOT NULL,
  `observacion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`sesion_idsesiones`, `estudiante_codigo`),
  INDEX `fk_sesion_has_estudiante_estudiante1_idx` (`estudiante_codigo` ASC),
  INDEX `fk_sesion_has_estudiante_sesion1_idx` (`sesion_idsesiones` ASC),
  CONSTRAINT `fk_sesion_has_estudiante_estudiante1`
    FOREIGN KEY (`estudiante_codigo`)
    REFERENCES `sw_asistencia`.`estudiante` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sesion_has_estudiante_sesion1`
    FOREIGN KEY (`sesion_idsesiones`)
    REFERENCES `sw_asistencia`.`sesion` (`idsesiones`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
