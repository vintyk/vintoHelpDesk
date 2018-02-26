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
-- Table structure for table `privileges`
--

DROP TABLE IF EXISTS `privileges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privileges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privileges`
--

LOCK TABLES `privileges` WRITE;
/*!40000 ALTER TABLE `privileges` DISABLE KEYS */;
INSERT INTO `privileges` VALUES (1,'user'),(2,'admin'),(3,'operator');
/*!40000 ALTER TABLE `privileges` ENABLE KEYS */;
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
  PRIMARY KEY (`id`),
  KEY `system_user_privilege_id_fk` (`privilege_id`),
  CONSTRAINT `system_user_privilege_id_fk` FOREIGN KEY (`privilege_id`) REFERENCES `privileges` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user`
--

LOCK TABLES `system_user` WRITE;
/*!40000 ALTER TABLE `system_user` DISABLE KEYS */;
INSERT INTO `system_user` VALUES (38,'Виталий','Ушаков','uv@ecp.by',1,'$2a$10$VJZXoNeGBMS9S/6/uyxgku79K4xOyM2G3Pt5CVlCS1u85af/MFh.a'),(39,'Виталий','Ушаков','SystemUserRepositoryTest',1,'$2a$10$8MTEvrRHsHSCOdG9zKfmM.rYZx1vPv./220/g3G6Jo7GA85dAM14i'),(41,'Виталий','Ушаков','vinty@i.ua',1,'$2a$10$pD2l/XsEB9T5ZC2Rq077ve3eAccPITsGB/LzHbk2pZCsuF1bYZfdu'),(49,'d','d','d',1,'$2a$10$PGkCs0VH3kg4nfRg8YuttODzXuJQ4M23saaM4q6FIT5fYx7mjtHO6'),(51,'Виталий','Ушаков','v',1,'$2a$10$TMreBSgu7gAEGzzeS.k78u7OUpDv4dfpf6AnzgdXjhY3pr8LJdaqy'),(52,'a','a','a',1,'$2a$10$21ftLy/DP5YoqzmXZoxyguQNBNGEM8cl5YBWhZyQJJUQwzTQmL9Ru'),(53,'h','h','h',1,'$2a$10$Y3FWWx28mAONpZlUCJYan.q41BkH4W3ibnt3C9B6GObw47i8P5Dua'),(55,'Виталий','Ушаков','v',NULL,'$2a$10$Amar/ympKM57I1Yj4/9pduU.DOw7l4JM4dwQL2j6HJjDH08qhR/QK'),(56,'Vitaly','Ushakov','vinty1978@gmail.com',NULL,'$2a$10$jMav42.e0sfybflq8r8A6eL8bYYBXFZZTUPAGKNa1IVVevoG1ecwu');
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `task_id_uindex` (`id`),
  KEY `task_type_of_jobs_id_fk` (`type_of_job_id`),
  CONSTRAINT `task_type_of_jobs_id_fk` FOREIGN KEY (`type_of_job_id`) REFERENCES `type_of_jobs` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (2,'Коля',1,NULL),(19,NULL,1,'sdhfgsdfgh'),(20,NULL,1,'fghrtyjdfbncvkmfguk'),(21,NULL,1,'sdfgsd\r\nsdfgsdfhs\r\nggggggggggggggggg\r\nмммммммммммм\r\nрррррррррррррррррррррррррррррррррррррррр\r\nшшшшшшшшшшшшшшш\r\n');
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
INSERT INTO `users_privileges` VALUES (55,1),(56,1);
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

-- Dump completed on 2018-02-26 23:30:26
