/*
SQLyog Enterprise Trial - MySQL GUI v6.56
MySQL - 6.0.0-alpha-community-nt-debug : Database - cssrain
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`cssrain` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cssrain`;

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(16) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`username`,`password`,`age`,`address`) values (1,'cssrain','cssrain',23,'浙江宁波鄞州区'),(2,'test','test',22,'testtesttesttest'),(3,'test2','test2',22,'testtesttesttesttest'),(4,'test3','test3',23,'testtesttesttesttesttesttesttest'),(5,'test4','test4',25,'testtesttesttesttesttesttesttest'),(6,'test6','test6',26,'test'),(7,'ad','ad',23,'ad'),(8,'ad','ad',22,'ad'),(9,'ff','ff',22,'ff'),(10,'ee','ee',44,'ff'),(11,'ee','ee',55,'ff'),(12,'ff','ff',33,'ff'),(13,'ee','eee',22,'ff'),(14,'adsf地方','adsf地方',22,'adsf地方'),(15,'阿里斯','阿里斯',23,'阿里斯'),(16,'吗砸','吗砸',22,'吗砸'),(17,'发达','发达',44,'发达'),(18,'以后','以后',33,'以后'),(19,'纷纷','纷纷',5,'纷纷'),(20,'宝宝','宝宝',4,'宝宝'),(21,'低调','低调',3,'低调'),(22,'非法','非法',2,'非法'),(23,'对方','对方',1,'对方'),(24,'公告','公告',2,'公告'),(25,'仿佛','仿佛',6,'仿佛'),(26,'仿佛','ee',1,'浙江'),(27,'仿佛','ee',1,'浙江'),(28,'仿佛','ee',1,'浙江'),(29,'仿佛','ee',1,'浙江'),(30,'仿佛','ee',1,'浙江'),(31,'仿佛','ee',1,'浙江'),(32,'仿佛','ee',1,'浙江'),(33,'仿佛','ee',1,'浙江'),(34,'仿佛','ee',1,'浙江'),(35,'仿佛','ee',1,'浙江'),(36,'仿佛','ee',1,'浙江'),(37,'仿佛','ee',1,'浙江'),(38,'仿佛','ee',1,'浙江'),(39,'仿佛','ee',1,'浙江'),(40,'仿佛','ee',1,'浙江'),(41,'仿佛','ee',1,'浙江'),(42,'仿佛','ee',1,'浙江'),(43,'仿佛','ee',1,'浙江'),(44,'仿佛','ee',1,'浙江'),(45,'仿佛','ee',1,'浙江'),(46,NULL,'ee',1,'浙江');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
