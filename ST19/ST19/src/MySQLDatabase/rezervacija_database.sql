/*
SQLyog Professional v12.2.6 (32 bit)
MySQL - 5.6.27-log : Database - rezervacija
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

/*Table structure for table `counter` */

DROP TABLE IF EXISTS `counter`;

CREATE TABLE `counter` (
  `TableName` varchar(100) NOT NULL DEFAULT '',
  `Counter` int(11) DEFAULT '0',
  PRIMARY KEY (`TableName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `counter` */

insert  into `counter`(`TableName`,`Counter`) values 

('Rezervacija',0);

/*Table structure for table `rezervacija` */

DROP TABLE IF EXISTS `rezervacija`;

CREATE TABLE `rezervacija` (
  `sifraRezervacije` int(10) NOT NULL DEFAULT 0,
  `imePrezime` varchar(30) DEFAULT 'NULL',
  `nazivHotela` varchar(30) DEFAULT 'NULL',
  `brojOsoba` int(10) DEFAULT 0,
  `datumPocetka` date DEFAULT NULL,
  `datumZavrsetka` date DEFAULT NULL,
    `Stanje` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`sifraRezervacije`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `rezervacija` */

/* Procedure structure for procedure `upgrade_database` */

/*!50003 DROP PROCEDURE IF EXISTS  `upgrade_database` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `upgrade_database`()
BEGIN
 DECLARE _count INT;
 SET _count = (  SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS  
 WHERE   TABLE_SCHEMA = 'PAF4' AND TABLE_NAME = 'Counter' AND COLUMN_NAME = 'TableName'); 
 IF _count = 0 THEN  ALTER TABLE Counter ADD COLUMN  `TableName` varchar(100)  ; END IF; 
   
 SET _count = (  SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS  
 WHERE   TABLE_SCHEMA = 'PAF4' AND TABLE_NAME = 'Counter' AND COLUMN_NAME = 'Counter'); 
 IF _count = 0 THEN  ALTER TABLE Counter ADD COLUMN  `Counter` int  DEFAULT 0; END IF;
SET _count = (  SELECT COUNT(*) FROM Counter);  
 IF _count = 0 THEN   insert  into `counter`(`TableName`,`Counter`) values  ('IspitnaPrijava',0); END IF; 
 
   
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
