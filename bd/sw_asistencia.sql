-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sw_asistencia
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sw_asistencia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sw_asistencia` DEFAULT CHARACTER SET utf8 ;
USE `sw_asistencia` ;

-- -----------------------------------------------------
-- Table `sw_asistencia`.`docente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sw_asistencia`.`docente` (
  `iddocente` INT NOT NULL,
  `nombre_docente` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NULL,
  PRIMARY KEY (`iddocente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sw_asistencia`.`carrera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sw_asistencia`.`carrera` (
  `idcarrera` INT NOT NULL,
  `Facultad` VARCHAR(45) NOT NULL,
  `Escuela` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcarrera`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sw_asistencia`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sw_asistencia`.`curso` (
  `idcurso` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `ciclo` VARCHAR(45) NOT NULL,
  `docente_iddocente` INT NOT NULL,
  `carrera_idcarrera` INT NOT NULL,
  PRIMARY KEY (`idcurso`),
  INDEX `fk_curso_docente1_idx` (`docente_iddocente` ASC),
  INDEX `fk_curso_carrera1_idx` (`carrera_idcarrera` ASC),
  CONSTRAINT `fk_curso_docente1`
    FOREIGN KEY (`docente_iddocente`)
    REFERENCES `sw_asistencia`.`docente` (`iddocente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_curso_carrera1`
    FOREIGN KEY (`carrera_idcarrera`)
    REFERENCES `sw_asistencia`.`carrera` (`idcarrera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sw_asistencia`.`sesion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sw_asistencia`.`sesion` (
  `idsesiones` INT NOT NULL,
  `dia` DATE NOT NULL,
  `hora_inicio` VARCHAR(45) NULL,
  `hora_fin` VARCHAR(45) NULL,
  `curso_idcurso` INT NOT NULL,
  PRIMARY KEY (`idsesiones`),
  INDEX `fk_sesion_curso1_idx` (`curso_idcurso` ASC),
  CONSTRAINT `fk_sesion_curso1`
    FOREIGN KEY (`curso_idcurso`)
    REFERENCES `sw_asistencia`.`curso` (`idcurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sw_asistencia`.`estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sw_asistencia`.`estudiante` (
  `codigo` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NULL,
  `celular` VARCHAR(45) NULL,
  `curso_idcurso` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_estudiante_curso1_idx` (`curso_idcurso` ASC),
  CONSTRAINT `fk_estudiante_curso1`
    FOREIGN KEY (`curso_idcurso`)
    REFERENCES `sw_asistencia`.`curso` (`idcurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sw_asistencia`.`sesion_has_estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sw_asistencia`.`sesion_has_estudiante` (
  `sesion_idsesiones` INT NOT NULL,
  `estudiante_codigo` INT NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`sesion_idsesiones`, `estudiante_codigo`),
  INDEX `fk_sesion_has_estudiante_estudiante1_idx` (`estudiante_codigo` ASC),
  INDEX `fk_sesion_has_estudiante_sesion_idx` (`sesion_idsesiones` ASC),
  CONSTRAINT `fk_sesion_has_estudiante_sesion`
    FOREIGN KEY (`sesion_idsesiones`)
    REFERENCES `sw_asistencia`.`sesion` (`idsesiones`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sesion_has_estudiante_estudiante1`
    FOREIGN KEY (`estudiante_codigo`)
    REFERENCES `sw_asistencia`.`estudiante` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
