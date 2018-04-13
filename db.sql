-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: vintohelpdesk
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'Минск'),(2,'Колядичи');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privileges`
--

DROP TABLE IF EXISTS `privileges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privileges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privileges`
--

LOCK TABLES `privileges` WRITE;
/*!40000 ALTER TABLE `privileges` DISABLE KEYS */;
INSERT INTO `privileges` VALUES (1,'User'),(2,'Admin'),(3,'Operator'),(4,'executor');
/*!40000 ALTER TABLE `privileges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subdivision`
--

DROP TABLE IF EXISTS `subdivision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subdivision` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subdivision`
--

LOCK TABLES `subdivision` WRITE;
/*!40000 ALTER TABLE `subdivision` DISABLE KEYS */;
INSERT INTO `subdivision` VALUES (1,'Бухгалтерия'),(2,'Маркетинг');
/*!40000 ALTER TABLE `subdivision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user`
--

DROP TABLE IF EXISTS `system_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `family` varchar(50) DEFAULT NULL,
  `e_mail` varchar(50) NOT NULL,
  `privilege_id` int(11) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `branch_id` int(11) DEFAULT NULL,
  `subdivision_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `system_user_privilege_id_fk` (`privilege_id`),
  KEY `system_user_branch_id_fk` (`branch_id`),
  KEY `system_user_subdivision_id_fk` (`subdivision_id`),
  CONSTRAINT `system_user_branch_id_fk` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`),
  CONSTRAINT `system_user_privilege_id_fk` FOREIGN KEY (`privilege_id`) REFERENCES `privileges` (`id`),
  CONSTRAINT `system_user_subdivision_id_fk` FOREIGN KEY (`subdivision_id`) REFERENCES `subdivision` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user`
--

LOCK TABLES `system_user` WRITE;
/*!40000 ALTER TABLE `system_user` DISABLE KEYS */;
INSERT INTO `system_user` VALUES (56,'Vitaly','Ushakov','vinty1978@gmail.com',NULL,'$2a$10$pD2l/XsEB9T5ZC2Rq077ve3eAccPITsGB/LzHbk2pZCsuF1bYZfdu',1,1),(70,'Вит','Ушаков','uv@ecp.by',NULL,'$2a$10$Vy1GGvH9WVma.yZveWtGpOuwojtG.bupplNOxi80MhbYvllFJBZiq',1,2),(71,'Ярослав','Зыскунов','lk@ecp.by',NULL,'$2a$10$PvIldFa3GEwNCBhtDGQ18eycG26iu25QBIip1DXBiA9CCW2un5J7m',1,2),(97,'Кирилл','Красовский','v@u.a',NULL,'$2a$10$iG25XgcOiNFDTiNRi1M5I.C6Vxsgtug4ZpuI6NsweS9LjULVlRDrW',1,1),(101,'Игорь','Поташов','vinty1977@gmail.com',NULL,'$2a$10$5E8x68eaBFzq6cCU0fj0ceBJUfRnvvWs65ELK.3WTlsG990MZhPGm',2,2);
/*!40000 ALTER TABLE `system_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `type_of_job_id` int(11) DEFAULT NULL,
  `text` text,
  `system_user_id` int(11) DEFAULT NULL,
  `executor_id` int(11) DEFAULT NULL,
  `operator_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `task_id_uindex` (`id`),
  KEY `task_type_of_jobs_id_fk` (`type_of_job_id`),
  KEY `task_system_user_id_fk` (`system_user_id`),
  KEY `task_system_user_id_fk_2` (`executor_id`),
  KEY `task_system_user_id_fk_3` (`operator_id`),
  CONSTRAINT `task_system_user_id_fk` FOREIGN KEY (`system_user_id`) REFERENCES `system_user` (`id`),
  CONSTRAINT `task_system_user_id_fk_2` FOREIGN KEY (`executor_id`) REFERENCES `system_user` (`id`),
  CONSTRAINT `task_system_user_id_fk_3` FOREIGN KEY (`operator_id`) REFERENCES `system_user` (`id`),
  CONSTRAINT `task_type_of_jobs_id_fk` FOREIGN KEY (`type_of_job_id`) REFERENCES `type_of_jobs` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (2,'Коля',1,NULL,NULL,NULL,NULL),(19,NULL,1,'sdhfgsdfgh',NULL,NULL,NULL),(20,NULL,1,'fghrtyjdfbncvkmfguk',NULL,NULL,NULL),(21,NULL,1,'sdfgsd\r\nsdfgsdfhs\r\nggggggggggggggggg\r\nмммммммммммм\r\nрррррррррррррррррррррррррррррррррррррррр\r\nшшшшшшшшшшшшшшш\r\n',NULL,NULL,NULL),(22,NULL,1,'dsffdfffffffffffffffffffffffffffffff hhhhhhhhhhhhhhhhhhhhh\r\nsadfgasdlkfglsadkfglsdkfghlksdfg\r\nakdsfgpsdlfkg;lsdkjfh;sjdf\'hbjadf;ja;dfkgja\r\najsdfaljkf;gjagjafdg\r\nagjaplsdjkg;aljdg]aosdjglad\r\ng',NULL,NULL,NULL),(23,NULL,1,'Надо починять принтир!!!!!! Нихрена не работаеть!!!!!! ПАМАГИТЯ!!!!!!!!!!',NULL,NULL,NULL),(24,NULL,1,'AWDGAERGASDRF',NULL,NULL,NULL),(29,NULL,1,'Нихуя не работает',NULL,NULL,NULL),(77,NULL,1,'00000000000000000',70,NULL,NULL),(78,NULL,1,'asdv;kasjdv\r\nas;dlvj\'z;lsdfbv\r\n\\zvbj\\z;xlcjb;lzxcjb\r\njnakl;sdjgv;lajdsfbv\r\nal;ksdjbv;lzdcjbz\r\nkjazlsdfjvb;lzdjfb\r\nzjkzldjblsjdlbjldjfblxjdfbjxdvb\r\n;lakscjv;lzajfgbv\r\n',56,NULL,NULL),(79,NULL,1,'asdv;kasjdv\r\nas;dlvj\'z;lsdfbv\r\n\\zvbj\\z;xlcjb;lzxcjb\r\njnakl;sdjgv;lajdsfbv\r\nal;ksdjbv;lzdcjbz\r\nkjazlsdfjvb;lzdjfb\r\nzjkzldjblsjdlbjldjfblxjdfbjxdvb\r\n;lakscjv;lzajfgbv\r\n',56,NULL,NULL);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_of_jobs`
--

DROP TABLE IF EXISTS `type_of_jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_of_jobs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_of_jobs`
--

LOCK TABLES `type_of_jobs` WRITE;
/*!40000 ALTER TABLE `type_of_jobs` DISABLE KEYS */;
INSERT INTO `type_of_jobs` VALUES (1,'Отдел Тыж-Программистов'),(2,'Другое');
/*!40000 ALTER TABLE `type_of_jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_privileges`
--

DROP TABLE IF EXISTS `users_privileges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_privileges` (
  `user_id` int(11) NOT NULL,
  `privilege_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`privilege_id`),
  KEY `fk_users_privileges_privilege_id` (`privilege_id`),
  CONSTRAINT `fk_users_privileges_privilege_id` FOREIGN KEY (`privilege_id`) REFERENCES `privileges` (`id`),
  CONSTRAINT `fk_users_privileges_user_id` FOREIGN KEY (`user_id`) REFERENCES `system_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_privileges`
--

LOCK TABLES `users_privileges` WRITE;
/*!40000 ALTER TABLE `users_privileges` DISABLE KEYS */;
INSERT INTO `users_privileges` VALUES (56,1),(97,1),(101,1),(70,2),(71,3);
/*!40000 ALTER TABLE `users_privileges` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-23 15:19:14
