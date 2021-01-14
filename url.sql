/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.5.57 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `url` */

DROP TABLE IF EXISTS `url`;

CREATE TABLE `url` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `long_url` varchar(500) DEFAULT NULL COMMENT '长链接',
  `short_url` varchar(10) DEFAULT NULL COMMENT '短链接',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `destroy_time` datetime DEFAULT NULL COMMENT '销毁时间',
  `click_count` int(11) DEFAULT NULL COMMENT '点击次数',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `SHORTURL` (`short_url`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `url` */

insert  into `url`(`id`,`long_url`,`short_url`,`create_time`,`destroy_time`,`click_count`,`status`) values (1,'https://www.baidu.com','maYZjy','2021-01-12 14:12:37','2021-01-13 14:12:37',2,1),(2,'https://www.baidu.com','6J3iqe','2021-01-10 20:31:03','2021-01-10 20:31:03',1,1),(5,'https://www.baidu.com','qEfyQb','2021-01-10 20:29:51','2021-01-17 20:29:51',11,1),(6,'https://www.baidu.com','3IN7Nf','2021-01-10 20:30:31','2021-01-17 20:30:31',1,1),(7,'https://www.x6d.com/','buEjUz','2021-01-12 14:12:37','2021-01-13 14:12:37',1,1),(8,'https://www.x6d.com/','m2QRre','2021-01-12 14:09:32','2021-01-13 14:09:32',0,1),(9,'https://www.baidu.com/','AneQ3u','2021-01-12 14:12:12','2021-01-13 14:12:12',0,1),(10,'https://www.52pojie.cn/','AzIf6f','2021-01-12 14:12:37','2021-01-13 14:12:37',1,1),(11,'https://www.x6d.com/','Fn6JRf','2021-01-12 14:12:12','2021-01-13 14:12:12',1,1),(12,'https://www.52pojie.cn/','aeERze','2021-01-12 14:12:12','2021-01-11 14:12:12',0,1),(14,'https://www.xd0.com/\n','y6JN3y','2021-01-12 14:24:18','2021-01-19 14:24:18',1,1),(15,'https://www.jd.com','nUrmQv','2021-01-12 20:23:41',NULL,3,1),(16,'http://www.cosplayfl.art/','2YviIz','2021-01-12 20:38:12','2021-01-19 20:38:12',0,1),(17,'https://blog.csdn.net/lovelovelovelovelo/article/details/73548167','z6nyQz','2021-01-12 20:38:12','2021-01-19 20:38:12',0,1),(18,'http://www.cosplayfl.art/','uqYfuy','2021-01-12 20:30:18',NULL,0,1),(19,'https://blog.csdn.net/lovelovelovelovelo/article/details/73548167','32IbUz','2021-01-12 20:40:12','2021-01-19 20:40:12',0,1),(20,'http://www.cosplayfl.art/','rMZjui','2021-01-12 20:40:19','2021-01-19 20:40:19',1,1),(21,'https://blog.csdn.net/lovelovelovelovelo/article/details/73548167','bMJf63','2021-01-12 20:40:19','2021-01-19 20:40:19',3,1),(22,'http://www.cosplayfl.art/','rQZfEv','2021-01-12 20:39:34','2021-01-19 20:39:34',0,1),(24,'http://localhost/rMZjui','vqmaYv','2021-01-12 20:40:45',NULL,1,0),(25,'http://localhost/bMJf63','f2Yzqu','2021-01-12 20:40:45',NULL,2,1),(26,'http://localhost/vqmaYv','Q7bMRb','2021-01-12 20:42:50','2021-01-19 20:42:50',0,1),(27,'http://localhost/f2Yzqu','yI3EZn','2021-01-12 20:42:50','2021-01-19 20:42:50',0,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
