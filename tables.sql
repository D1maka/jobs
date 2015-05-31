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

INSERT INTO `jobs`.`region` (`idregion`, `regionname`) VALUES (1, 'Kyiv');
INSERT INTO `jobs`.`region` (`idregion`, `regionname`) VALUES (2, 'Lviv');
INSERT INTO `jobs`.`region` (`idregion`, `regionname`) VALUES (3, 'Kharkiv');
INSERT INTO `jobs`.`region` (`idregion`, `regionname`) VALUES (4, 'Dnipropetrovsk');
INSERT INTO `jobs`.`region` (`idregion`, `regionname`) VALUES (5, 'Poltava');
INSERT INTO `jobs`.`region` (`idregion`, `regionname`) VALUES (6, 'Lutsk');
INSERT INTO `jobs`.`region` (`idregion`, `regionname`) VALUES (7, 'Rivne');
INSERT INTO `jobs`.`region` (`idregion`, `regionname`) VALUES (8, 'Ternopil');

INSERT INTO `jobs`.`sphere` (`idsphere`, `spherename`) VALUES('1', 'IT');
INSERT INTO `jobs`.`sphere` (`idsphere`, `spherename`) VALUES('2', 'Finance');
INSERT INTO `jobs`.`sphere` (`idsphere`, `spherename`) VALUES('3', 'Design');
INSERT INTO `jobs`.`sphere` (`idsphere`, `spherename`) VALUES('4', 'Security');
INSERT INTO `jobs`.`sphere` (`idsphere`, `spherename`) VALUES('5', 'Science, Education');
INSERT INTO `jobs`.`sphere` (`idsphere`, `spherename`) VALUES('6', 'Service');
INSERT INTO `jobs`.`sphere` (`idsphere`, `spherename`) VALUES('7', 'Telecommunication');

CREATE TABLE `jobs`.`resume` (
  `idresume` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(500) NOT NULL,
  `sphereid` INT NOT NULL,
  `regionid` INT NOT NULL,
  `salary` DOUBLE NOT NULL,
  `additionalInformation` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`idresume`),
  INDEX `resume_region_idx` (`regionid` ASC),
  INDEX `resume_sphere_idx` (`sphereid` ASC),
  CONSTRAINT `resume_region`
  FOREIGN KEY (`regionid`)
  REFERENCES `jobs`.`region` (`idregion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `resume_sphere`
  FOREIGN KEY (`sphereid`)
  REFERENCES `jobs`.`sphere` (`idsphere`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `jobs`.`work_experience` (
  `idwork_experience` INT NOT NULL AUTO_INCREMENT,
  `resumeid` INT NOT NULL,
  `company_name` VARCHAR(500) NOT NULL,
  `city` VARCHAR(145) NOT NULL,
  `position` VARCHAR(145) NOT NULL,
  `sphere` VARCHAR(145) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `additional_information` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`idwork_experience`));

ALTER TABLE `jobs`.`work_experience`
ADD INDEX `experience_resume_idx` (`resumeid` ASC);
ALTER TABLE `jobs`.`work_experience`
ADD CONSTRAINT `experience_resume`
FOREIGN KEY (`resumeid`)
REFERENCES `jobs`.`resume` (`idresume`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `jobs`.`eduation` (
  `ideduation` INT NOT NULL AUTO_INCREMENT,
  `resumeid` INT NOT NULL,
  `institution` VARCHAR(300) NOT NULL,
  `speciality` VARCHAR(300) NOT NULL,
  `degree` VARCHAR(200) NOT NULL,
  `city` VARCHAR(100) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `additional_information` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`ideduation`),
  INDEX `education_resume_idx` (`resumeid` ASC),
  CONSTRAINT `education_resume`
  FOREIGN KEY (`resumeid`)
  REFERENCES `jobs`.`resume` (`idresume`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `jobs`.`vacancy_history` (
  `idvacancy_history` INT NOT NULL AUTO_INCREMENT,
  `vacancyid` INT NOT NULL,
  `resumeid` INT NOT NULL,
  PRIMARY KEY (`idvacancy_history`),
  INDEX `vachistory_resume_idx` (`resumeid` ASC),
  INDEX `vachistory_vacancy_idx` (`vacancyid` ASC),
  CONSTRAINT `vachistory_resume`
  FOREIGN KEY (`resumeid`)
  REFERENCES `jobs`.`resume` (`idresume`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `vachistory_vacancy`
  FOREIGN KEY (`vacancyid`)
  REFERENCES `jobs`.`vacancy` (`idvacancy`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `jobs`.`resume_history` (
  `idresume_history` INT NOT NULL AUTO_INCREMENT,
  `resumeid` INT NOT NULL,
  `employerid` INT NOT NULL,
  PRIMARY KEY (`idresume_history`),
  INDEX `reshistory_resume_idx` (`resumeid` ASC),
  INDEX `reshistory_employer_idx` (`employerid` ASC),
  CONSTRAINT `reshistory_resume`
  FOREIGN KEY (`resumeid`)
  REFERENCES `jobs`.`resume` (`idresume`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `reshistory_employer`
  FOREIGN KEY (`employerid`)
  REFERENCES `jobs`.`employer` (`idemployer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `jobs`.`resume_history`
ADD COLUMN `date` DATE NOT NULL AFTER `employerid`;

ALTER TABLE `jobs`.`vacancy_history`
ADD COLUMN `date` DATE NOT NULL AFTER `resumeid`;