CREATE SCHEMA `jobs` ;

CREATE TABLE `jobs`.`region` (
  `idregion` INT NULL AUTO_INCREMENT,
  `regionname` VARCHAR(145) NOT NULL,
  UNIQUE INDEX `regionname_UNIQUE` (`regionname` ASC),
  PRIMARY KEY (`idregion`));
CREATE TABLE `jobs`.`sphere` (
  `idsphere` INT NOT NULL AUTO_INCREMENT,
  `spherename` VARCHAR(145) NOT NULL,
  PRIMARY KEY (`idsphere`),
  UNIQUE INDEX `spherename_UNIQUE` (`spherename` ASC));


CREATE TABLE `jobs`.`employer` (
  `idemployer` INT NOT NULL AUTO_INCREMENT,
  `employername` VARCHAR(245) NOT NULL,
  `description` VARCHAR(5000) NOT NULL,
  PRIMARY KEY (`idemployer`),
  UNIQUE INDEX `employername_UNIQUE` (`employername` ASC));



CREATE TABLE `jobs`.`vacancy` (
  `idvacancy` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(245) NOT NULL,
  `employerid` INT NOT NULL,
  `sphereid` INT NOT NULL,
  `locationid` INT NOT NULL,
  `description` VARCHAR(5000) NOT NULL,
  `requirements` VARCHAR(2000) NOT NULL,
  `offer` VARCHAR(2000) NOT NULL,
  PRIMARY KEY (`idvacancy`),
  INDEX `vac_employer_idx` (`employerid` ASC),
  INDEX `vac_sphere_idx` (`sphereid` ASC),
  INDEX `vac_location_idx` (`locationid` ASC),
  CONSTRAINT `vac_employer`
    FOREIGN KEY (`employerid`)
    REFERENCES `jobs`.`employer` (`idemployer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `vac_sphere`
    FOREIGN KEY (`sphereid`)
    REFERENCES `jobs`.`sphere` (`idsphere`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `vac_location`
    FOREIGN KEY (`locationid`)
    REFERENCES `jobs`.`region` (`idregion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
