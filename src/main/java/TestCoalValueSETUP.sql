SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `Transport` ;
CREATE SCHEMA IF NOT EXISTS `Transport` DEFAULT CHARACTER SET utf8 ;
USE `Transport` ;






  -- -----------------------------------------------------
-- Table `TestCoalValue`.`payment_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Transport`.`station` ;

CREATE  TABLE IF NOT EXISTS `Transport`.`station` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
    `type` VARCHAR(30) NULL , --

  `name` VARCHAR(30) NULL ,
  `company_id` INT NULL , -- 收款方
  `location_id` INT NULL ,
  `location` VARCHAR(20) NULL ,

  `status` VARCHAR(50) NULL ,
 `description` VARCHAR(50) NULL ,

  `CREATE_BY` INT NULL ,
  `CREATE_DATE` DATETIME NULL ,
  `MODIFY_BY` INT NULL ,
  `MODIFY_DATE` DATETIME NULL ,
  `VERSION` INT NULL ,
  PRIMARY KEY (`ID`) )
  ENGINE = InnoDB;



-- company id，  type company， type
  -- -----------------------------------------------------
-- Table `TestCoalValue`.`payment_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Transport`.`platform` ;

CREATE  TABLE IF NOT EXISTS `Transport`.`platform` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `stationID` INT NULL , -- 收款方
  `platformNumber` VARCHAR(20) NULL ,
  `status` VARCHAR(30) NULL , -- 银行承兑汇票 Bank acceptance 商业承兑汇票 Trade acceptance
  `note` VARCHAR(50) NULL ,
  `type` VARCHAR(30) NULL ,

  `CREATE_BY` INT NULL ,
  `CREATE_DATE` DATETIME NULL ,
  `MODIFY_BY` INT NULL ,
  `MODIFY_DATE` DATETIME NULL ,
  `VERSION` INT NULL ,
  PRIMARY KEY (`ID`) )
  ENGINE = InnoDB;



CREATE  TABLE IF NOT EXISTS `Transport`.`line` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
    `line_name` VARCHAR(20) NULL ,

  `departure_station` INT NOT NULL , -- 收款方
  `arrival_station` INT NOT NULL , -- 收款方
      `description` VARCHAR(30) NULL ,
  `status` VARCHAR(30) NULL , -- 银行承兑汇票 Bank acceptance 商业承兑汇票 Trade acceptance

  `CREATE_BY` INT NULL ,
  `CREATE_DATE` DATETIME NULL ,
  `MODIFY_BY` INT NULL ,
  `MODIFY_DATE` DATETIME NULL ,
  `VERSION` INT NULL ,
  PRIMARY KEY (`ID`) )
  ENGINE = InnoDB;


DROP TABLE IF EXISTS `Transport`.`location` ;

  CREATE  TABLE IF NOT EXISTS `Transport`.`location` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
    `name` VARCHAR(20) NULL ,
    `postal_code` VARCHAR(20) NULL ,

  `country_id` INT  , -- 收款方

  `description` VARCHAR(30) NULL ,
  `status` VARCHAR(30) NULL , -- 银行承兑汇票 Bank acceptance 商业承兑汇票 Trade acceptance

  `CREATE_BY` INT NULL ,
  `CREATE_DATE` DATETIME NULL ,
  `MODIFY_BY` INT NULL ,
  `MODIFY_DATE` DATETIME NULL ,
  `VERSION` INT NULL ,
  PRIMARY KEY (`ID`) )
  ENGINE = InnoDB;




DROP TABLE IF EXISTS `Transport`.`trip` ;

CREATE  TABLE IF NOT EXISTS `Transport`.`trip` (
  `ID` INT NOT NULL AUTO_INCREMENT ,

  `line_id` INT NOT NULL , -- 收款方
    `departure_time` DATETIME NULL ,
  `arrival_time` DATETIME NULL ,
      `description` VARCHAR(30) NULL ,
  `status` VARCHAR(30) NULL , -- 银行承兑汇票 Bank acceptance 商业承兑汇票 Trade acceptance



  `flat_wagon_price` DECIMAL(8,2) ,
    `open_top_wagon` DECIMAL(8,2) ,
  `CREATE_BY` INT NULL ,
  `CREATE_DATE` DATETIME NULL ,
  `MODIFY_BY` INT NULL ,
  `MODIFY_DATE` DATETIME NULL ,
  `VERSION` INT NULL ,
  PRIMARY KEY (`ID`) )
  ENGINE = InnoDB;



DROP TABLE IF EXISTS `Transport`.`schedule_lines_schedules` ;

    CREATE  TABLE IF NOT EXISTS `Transport`.`schedule_lines_schedules` (
  `ID` INT NOT NULL AUTO_INCREMENT ,

    `trip_id` INT NOT NULL , -- 收款方
    `station_id` INT NOT NULL , -- 收款方

    `departure_time` DATETIME NULL ,
  `arrival_time` DATETIME NULL ,



  `description` VARCHAR(30) NULL ,
  `status` VARCHAR(30) NULL , -- 银行承兑汇票 Bank acceptance 商业承兑汇票 Trade acceptance

  `CREATE_BY` INT NULL ,
  `CREATE_DATE` DATETIME NULL ,
  `MODIFY_BY` INT NULL ,
  `MODIFY_DATE` DATETIME NULL ,
  `VERSION` INT NULL ,
  PRIMARY KEY (`ID`) )
  ENGINE = InnoDB;






    CREATE  TABLE IF NOT EXISTS `Transport`.`composition` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `code` VARCHAR(30) NULL ,

    `cars` INT NOT NULL , -- 收款方
    `operator_id` INT NOT NULL , -- 收款方

    `update_time` DATETIME NULL ,
    `additional_capacity` INT NOT NULL , -- 收款方

  `description` VARCHAR(30) NULL ,
  `status` VARCHAR(30) NULL , -- 银行承兑汇票 Bank acceptance 商业承兑汇票 Trade acceptance

  `CREATE_BY` INT NULL ,
  `CREATE_DATE` DATETIME NULL ,
  `MODIFY_BY` INT NULL ,
  `MODIFY_DATE` DATETIME NULL ,
  `VERSION` INT NULL ,
  PRIMARY KEY (`ID`) )
  ENGINE = InnoDB;



  -- -----------------------------------------------------
-- Table `TestCoalValue`.`transaction`
-- --------------------------------------------------d---
DROP TABLE IF EXISTS `Transport`.`brand_enterprise` ;

CREATE  TABLE IF NOT EXISTS `Transport`.`brand_enterprise` (
  `ID` INT NOT NULL AUTO_INCREMENT ,

  `item_id` INT NULL ,

  `item_type` VARCHAR(20) NULL , --  销售过的总类

  `enterprise_index` INT NULL ,

  `note` VARCHAR(150) NULL , --  销售过的总类

  `status` VARCHAR(20) NULL , --  销售过的总类


  `feature` VARCHAR(20) NULL , --  销售过的总类



  `CREATE_BY` INT NULL ,
  `CREATE_DATE` DATETIME NULL ,
  `MODIFY_BY` INT NULL ,
  `MODIFY_DATE` DATETIME NULL ,
  `VERSION` INT NULL ,
  PRIMARY KEY (`ID`) )
  ENGINE = InnoDB;
