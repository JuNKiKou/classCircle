-- MySQL dump 10.13  Distrib 5.7.15, for osx10.11 (x86_64)
--
-- Host: localhost    Database: classCircle
-- ------------------------------------------------------
-- Server version	5.7.15

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
-- Table structure for table `Class`
--

DROP TABLE IF EXISTS `Class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Class` (
  `c_id` char(16) NOT NULL,
  `c_name` varchar(20) NOT NULL,
  `c_school` char(8) NOT NULL,
  `c_description` text,
  `c_status` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`c_id`),
  UNIQUE KEY `c_name` (`c_name`),
  KEY `FK_class_school` (`c_school`),
  CONSTRAINT `FK_class_school` FOREIGN KEY (`c_school`) REFERENCES `School` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Class`
--

LOCK TABLES `Class` WRITE;
/*!40000 ALTER TABLE `Class` DISABLE KEYS */;
INSERT INTO `Class` VALUES ('C000000000000001','软件工程4班','00000001','软工',''),('C000000000000002','软件工程1班','00000002','一般一般','\0');
/*!40000 ALTER TABLE `Class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Comment`
--

DROP TABLE IF EXISTS `Comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Comment` (
  `comment_id` char(16) NOT NULL,
  `comment_content` varchar(100) NOT NULL,
  `comment_message` char(16) NOT NULL,
  `comment_user` char(16) NOT NULL,
  `comment_time` datetime NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FK_comment_message` (`comment_message`),
  KEY `FK_comment_user` (`comment_user`),
  CONSTRAINT `FK_comment_message` FOREIGN KEY (`comment_message`) REFERENCES `Message` (`m_id`),
  CONSTRAINT `FK_comment_user` FOREIGN KEY (`comment_user`) REFERENCES `User` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comment`
--

LOCK TABLES `Comment` WRITE;
/*!40000 ALTER TABLE `Comment` DISABLE KEYS */;
INSERT INTO `Comment` VALUES ('D000000000000001','评论测试','M000000000000001','U000000000000003','2017-04-20 16:11:46');
/*!40000 ALTER TABLE `Comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Message`
--

DROP TABLE IF EXISTS `Message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Message` (
  `m_id` char(16) NOT NULL,
  `m_type` varchar(4) NOT NULL,
  `m_user` char(16) NOT NULL,
  `m_content` varchar(500) DEFAULT NULL,
  `m_path` text,
  `m_time` datetime NOT NULL,
  PRIMARY KEY (`m_id`),
  KEY `FK_message_user` (`m_user`),
  CONSTRAINT `FK_message_user` FOREIGN KEY (`m_user`) REFERENCES `User` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Message`
--

LOCK TABLES `Message` WRITE;
/*!40000 ALTER TABLE `Message` DISABLE KEYS */;
INSERT INTO `Message` VALUES ('M000000000000001','ABC','U000000000000001','文字加语音加图片','audio : /Users/JuN/myfile/java/classCircle/target/muggle/audio/8e52ed64-babf-4307-bb57-e3ad4a8fd6132017-04-20&15:32:22.mp3||pictures : /Users/JuN/myfile/java/classCircle/target/muggle/photo/f51d177b-a623-462c-bd59-f4a2211383fe2017-04-20&15:32:22.jpeg|/Users/JuN/myfile/java/classCircle/target/muggle/photo/af3c80ed-ad09-4ddf-99aa-c4c946ba28a52017-04-20&15:32:22.jpg','2017-04-20 15:32:23'),('M000000000000002','A','U000000000000003','文字','','2017-04-20 19:27:52'),('M000000000000003','A','U000000000000006','家长的','','2017-04-20 19:34:04');
/*!40000 ALTER TABLE `Message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PS`
--

DROP TABLE IF EXISTS `PS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PS` (
  `ps_id` int(11) NOT NULL,
  `ps_parent` char(16) NOT NULL,
  `ps_student` char(16) NOT NULL,
  PRIMARY KEY (`ps_id`),
  KEY `FK_ps_parent` (`ps_parent`),
  KEY `FK_ps_student` (`ps_student`),
  CONSTRAINT `FK_ps_parent` FOREIGN KEY (`ps_parent`) REFERENCES `Parent` (`p_id`),
  CONSTRAINT `FK_ps_student` FOREIGN KEY (`ps_student`) REFERENCES `Student` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PS`
--

LOCK TABLES `PS` WRITE;
/*!40000 ALTER TABLE `PS` DISABLE KEYS */;
INSERT INTO `PS` VALUES (1,'P000000000000002','S000000000000001');
/*!40000 ALTER TABLE `PS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Parent`
--

DROP TABLE IF EXISTS `Parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Parent` (
  `p_id` char(16) NOT NULL,
  `p_name` varchar(20) NOT NULL,
  `p_sex` bit(1) DEFAULT NULL,
  `p_telephone` char(11) NOT NULL,
  `p_password` char(16) NOT NULL,
  `p_header` text,
  `p_index` text,
  PRIMARY KEY (`p_id`),
  UNIQUE KEY `p_telephone` (`p_telephone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Parent`
--

LOCK TABLES `Parent` WRITE;
/*!40000 ALTER TABLE `Parent` DISABLE KEYS */;
INSERT INTO `Parent` VALUES ('P000000000000001','张智成','','12345678901','8ad9902aecba32e2',NULL,NULL),('P000000000000002','李淑敏','\0','12345678902','77804d2ba1922c33',NULL,NULL);
/*!40000 ALTER TABLE `Parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reply`
--

DROP TABLE IF EXISTS `Reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Reply` (
  `r_id` char(16) NOT NULL,
  `r_content` varchar(100) NOT NULL,
  `r_comment` char(16) NOT NULL,
  `r_time` datetime NOT NULL,
  PRIMARY KEY (`r_id`),
  KEY `FK_reply_comment` (`r_comment`),
  CONSTRAINT `FK_reply_comment` FOREIGN KEY (`r_comment`) REFERENCES `Comment` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reply`
--

LOCK TABLES `Reply` WRITE;
/*!40000 ALTER TABLE `Reply` DISABLE KEYS */;
INSERT INTO `Reply` VALUES ('R000000000000001','回复测试','D000000000000001','2017-04-20 16:25:47');
/*!40000 ALTER TABLE `Reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `School`
--

DROP TABLE IF EXISTS `School`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `School` (
  `id` char(8) NOT NULL,
  `name` varchar(20) NOT NULL,
  `type` int(11) NOT NULL,
  `area` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `School`
--

LOCK TABLES `School` WRITE;
/*!40000 ALTER TABLE `School` DISABLE KEYS */;
INSERT INTO `School` VALUES ('00000001','慈溪实验高级中学',3,''),('00000002','杭州学军小学',1,'求智校区'),('00000003','杭州学军小学',1,'紫金港校区');
/*!40000 ALTER TABLE `School` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student` (
  `s_id` char(16) NOT NULL,
  `s_name` varchar(20) NOT NULL,
  `s_sex` bit(1) NOT NULL,
  `s_class` char(16) DEFAULT NULL,
  PRIMARY KEY (`s_id`),
  KEY `FK_student_class` (`s_class`),
  CONSTRAINT `FK_student_class` FOREIGN KEY (`s_class`) REFERENCES `Class` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES ('S000000000000001','戴心仪','\0','C000000000000001'),('S000000000000002','陈天','','C000000000000002');
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Subject`
--

DROP TABLE IF EXISTS `Subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Subject` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Subject`
--

LOCK TABLES `Subject` WRITE;
/*!40000 ALTER TABLE `Subject` DISABLE KEYS */;
INSERT INTO `Subject` VALUES (1,'语文'),(2,'数学'),(3,'英语'),(4,'物理'),(5,'化学'),(6,'音乐'),(7,'美术'),(8,'信息技术'),(9,'通用技术'),(10,'生物'),(11,'体育'),(12,'劳技');
/*!40000 ALTER TABLE `Subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TC`
--

DROP TABLE IF EXISTS `TC`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TC` (
  `tc_id` int(11) NOT NULL,
  `tc_teacher` char(16) NOT NULL,
  `tc_class` char(16) NOT NULL,
  PRIMARY KEY (`tc_id`),
  KEY `FK_tc_teacher` (`tc_teacher`),
  KEY `FK_tc_class` (`tc_class`),
  CONSTRAINT `FK_tc_class` FOREIGN KEY (`tc_class`) REFERENCES `Class` (`c_id`),
  CONSTRAINT `FK_tc_teacher` FOREIGN KEY (`tc_teacher`) REFERENCES `Teacher` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TC`
--

LOCK TABLES `TC` WRITE;
/*!40000 ALTER TABLE `TC` DISABLE KEYS */;
INSERT INTO `TC` VALUES (2,'T000000000000001','C000000000000001'),(3,'T000000000000002','C000000000000001');
/*!40000 ALTER TABLE `TC` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Teacher`
--

DROP TABLE IF EXISTS `Teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Teacher` (
  `t_id` char(16) NOT NULL,
  `t_name` varchar(20) NOT NULL,
  `t_sex` bit(1) NOT NULL,
  `t_subject` int(11) NOT NULL,
  `t_telephone` char(11) NOT NULL,
  `t_password` char(16) NOT NULL,
  `t_header` text,
  `t_index` text,
  `t_power` bit(1) NOT NULL,
  PRIMARY KEY (`t_id`),
  UNIQUE KEY `t_telephone` (`t_telephone`),
  KEY `FK_teacher_subject` (`t_subject`),
  CONSTRAINT `FK_teacher_subject` FOREIGN KEY (`t_subject`) REFERENCES `Subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teacher`
--

LOCK TABLES `Teacher` WRITE;
/*!40000 ALTER TABLE `Teacher` DISABLE KEYS */;
INSERT INTO `Teacher` VALUES ('T000000000000001','张珂','\0',3,'17764591485','ac59075b964b0715','',NULL,''),('T000000000000002','陈志豪','',2,'13429339432','49ba59abbe56e057',NULL,NULL,'\0'),('T000000000000003','吴菱','',2,'10000000000','8ad9902aecba32e2',NULL,NULL,'');
/*!40000 ALTER TABLE `Teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `u_id` char(16) NOT NULL,
  `u_type` int(11) NOT NULL,
  `u_teacher` char(16) DEFAULT NULL,
  `u_parent` char(16) DEFAULT NULL,
  `u_telephone` char(11) NOT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_telephone` (`u_telephone`),
  KEY `FK_user_teacher` (`u_teacher`),
  KEY `FK_user_parent` (`u_parent`),
  CONSTRAINT `FK_user_parent` FOREIGN KEY (`u_parent`) REFERENCES `Parent` (`p_id`),
  CONSTRAINT `FK_user_teacher` FOREIGN KEY (`u_teacher`) REFERENCES `Teacher` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES ('U000000000000001',0,'T000000000000001',NULL,'17764591485'),('U000000000000002',1,NULL,'P000000000000001','12345678901'),('U000000000000003',0,'T000000000000002',NULL,'13429339432'),('U000000000000005',0,'T000000000000003',NULL,'10000000000'),('U000000000000006',1,NULL,'P000000000000002','12345678902');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Z`
--

DROP TABLE IF EXISTS `Z`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Z` (
  `z_id` int(11) NOT NULL,
  `z_user` char(16) NOT NULL,
  `z_message` char(16) NOT NULL,
  `z_status` bit(1) NOT NULL,
  PRIMARY KEY (`z_id`),
  KEY `FK_z_user` (`z_user`),
  KEY `FK_z_message` (`z_message`),
  CONSTRAINT `FK_z_message` FOREIGN KEY (`z_message`) REFERENCES `Message` (`m_id`),
  CONSTRAINT `FK_z_user` FOREIGN KEY (`z_user`) REFERENCES `User` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Z`
--

LOCK TABLES `Z` WRITE;
/*!40000 ALTER TABLE `Z` DISABLE KEYS */;
INSERT INTO `Z` VALUES (1,'U000000000000002','M000000000000001','');
/*!40000 ALTER TABLE `Z` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'classCircle'
--
/*!50003 DROP FUNCTION IF EXISTS `getCharId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getCharId`(
     in_table CHAR(1)
  ) RETURNS char(16) CHARSET utf8
BEGIN

  DECLARE oldId VARCHAR(16);
  DECLARE newId CHAR(16);
  DECLARE id INT DEFAULT 1;
  DECLARE length INT DEFAULT 1;
  DECLARE str VARCHAR(15);
  IF in_table = 'C' THEN
    SET oldId = (SELECT c_id FROM Class ORDER BY c_id DESC LIMIT 1);  
  ELSEIF in_table = 'D' THEN
    SET oldId = (SELECT comment_id FROM Comment ORDER BY comment_id DESC LIMIT 1);
  ELSEIF in_table = 'M' THEN
    SET oldId = (SELECT m_id FROM Message ORDER BY m_id DESC LIMIT 1);
  ELSEIF in_table = 'P' THEN
    SET oldId = (SELECT p_id FROM Parent ORDER BY p_id DESC LIMIT 1);
  ELSEIF in_table = 'R' THEN
    SET oldId = (SELECT r_id FROM Reply ORDER BY r_id DESC LIMIT 1);
  ELSEIF in_table = 'S' THEN
    SET oldId = (SELECT s_id FROM Student ORDER BY s_id DESC LIMIT 1);
  ELSEIF in_table = 'T' THEN
    SET oldId = (SELECT t_id FROM Teacher ORDER BY t_id DESC LIMIT 1);
  ELSEIF in_table = 'U' THEN
    SET oldId = (SELECT u_id FROM User ORDER BY u_id DESC LIMIT 1);
  END IF;
  IF oldId IS NOT NULL THEN
      SET id = cast(SUBSTRING(oldId,2,15) AS UNSIGNED);
      SET id = id + 1;
  ELSE
      SET id = 1;
  END IF;
  SET length = 15 - length(cast(id AS CHAR));
  SET newId = in_table;
  WHILE length > 0 DO
  SET newId = CONCAT(newId,'0');
  SET length = length - 1;
  END WHILE;
  SET newId = CONCAT(newId,cast(id AS CHAR));  
  RETURN newId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `getCurrentCharId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getCurrentCharId`(
  in_table CHAR(1)
) RETURNS char(16) CHARSET utf8
BEGIN

    DECLARE oldId VARCHAR(16);
    DECLARE newId CHAR(16);
    DECLARE id INT DEFAULT 0;
    DECLARE length INT DEFAULT 1;
    DECLARE str VARCHAR(15);
    IF in_table = 'C' THEN
      SET oldId = (SELECT c_id FROM Class ORDER BY c_id DESC LIMIT 1);
    ELSEIF in_table = 'D' THEN
      SET oldId = (SELECT comment_id FROM Comment ORDER BY comment_id DESC LIMIT 1);
    ELSEIF in_table = 'M' THEN
      SET oldId = (SELECT m_id FROM Message ORDER BY m_id DESC LIMIT 1);
    ELSEIF in_table = 'P' THEN
      SET oldId = (SELECT p_id FROM Parent ORDER BY p_id DESC LIMIT 1);
    ELSEIF in_table = 'R' THEN
      SET oldId = (SELECT r_id FROM Reply ORDER BY r_id DESC LIMIT 1);
    ELSEIF in_table = 'S' THEN
      SET oldId = (SELECT s_id FROM Student ORDER BY s_id DESC LIMIT 1);
    ELSEIF in_table = 'T' THEN
      SET oldId = (SELECT t_id FROM Teacher ORDER BY t_id DESC LIMIT 1);
    ELSEIF in_table = 'U' THEN
      SET oldId = (SELECT u_id FROM User ORDER BY u_id DESC LIMIT 1);
    END IF;
    IF oldId IS NOT NULL THEN
      SET id = cast(SUBSTRING(oldId,2,15) AS UNSIGNED);
    ELSE
      SET id = 0;
    END IF;
    SET length = 15 - length(cast(id AS CHAR));
    SET newId = in_table;
    WHILE length > 0 DO
      SET newId = CONCAT(newId,'0');
      SET length = length - 1;
    END WHILE;
    SET newId = CONCAT(newId,cast(id AS CHAR));
    RETURN newId;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `getCurrentIntId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getCurrentIntId`(
  in_table VARCHAR(2)
) RETURNS int(11)
BEGIN

    DECLARE oldId INT;
    DECLARE newId INT;
    IF in_table = 'PS' THEN
      SET oldId = (SELECT ps_id FROM PS ORDER BY ps_id DESC LIMIT 1);
    ELSEIF in_table = 'TC' THEN
      SET oldId = (SELECT tc_id FROM TC ORDER BY tc_id DESC LIMIT 1);
    ELSEIF in_table = 'Z' THEN
      SET oldId = (SELECT z_id FROM Z ORDER BY z_id DESC LIMIT 1);
    END IF;
    IF oldId IS NOT NULL THEN
      SET newId = oldId;
    ELSE
      SET newId = 0;
    END IF;
    RETURN newId;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `getIntId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getIntId`(
  in_table VARCHAR(2)
) RETURNS int(11)
BEGIN

    DECLARE oldId INT;
    DECLARE newId INT;
    IF in_table = 'PS' THEN
      SET oldId = (SELECT ps_id FROM PS ORDER BY ps_id DESC LIMIT 1);
    ELSEIF in_table = 'TC' THEN
      SET oldId = (SELECT tc_id FROM TC ORDER BY tc_id DESC LIMIT 1);
    ELSEIF in_table = 'Z' THEN
      SET oldId = (SELECT z_id FROM Z ORDER BY z_id DESC LIMIT 1);
    END IF;
    IF oldId IS NOT NULL THEN
      SET newId = oldId + 1;
    ELSE
      SET newId = 1;
    END IF;
    RETURN newId;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addClass` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addClass`(
    in in_name VARCHAR(20),
    in in_school CHAR(8),
    in in_description TEXT,
    IN leader CHAR(16),
    out resultCode int
  )
BEGIN
    DECLARE error_flag INT;
    DECLARE teacher CHAR(16);
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET error_flag = -1;
    START TRANSACTION ;
    SET teacher = (SELECT u_teacher FROM User WHERE u_id = leader);
    INSERT INTO Class VALUES (getCharId('C'),in_name,in_school,in_description,b'1');
    INSERT INTO TC VALUES (getIntId('TC'),teacher,getCurrentCharId('C'));
    SELECT getCurrentCharId('C');
    SET resultCode = 1;
    IF error_flag = -1 THEN 
      SET resultCode = -1; 
      ROLLBACK ;
    ELSE 
      COMMIT ;
    END IF;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addStudent`(
    IN in_name VARCHAR(20),
    IN in_sex BIT,
    IN in_class CHAR(16),
    OUT resultCode INT
  )
BEGIN
  DECLARE error_flag INT;
  DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET error_flag = -1;
  START TRANSACTION;
  INSERT INTO Student VALUES (getCharId('S'),in_name,in_sex,in_class);
  SELECT getCurrentCharId('S');
  SET resultCode = 1;
  IF error_flag = -1 THEN 
    SET resultCode = -1;
    ROLLBACK ;
  ELSE 
    COMMIT ;
  END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `comment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `comment`(
  in in_user CHAR(16),
  IN in_message CHAR(16),
  IN in_content VARCHAR(100),
  out resultCode int
)
BEGIN
    INSERT INTO Comment VALUES (getCharId('D'),in_content,in_message,in_user,sysdate());
    SET resultCode = 1;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `cutStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cutStudent`(
    IN in_student CHAR(16),
    OUT resultCode INT
  )
BEGIN
  UPDATE Student SET s_class = NULL WHERE s_id = in_student;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteClass` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteClass`(
    IN in_class CHAR(16),
    OUT resultCode INT
  )
BEGIN
  UPDATE Class SET c_status = b'0' WHERE c_id = in_class;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteMessage` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteMessage`(
  in in_message CHAR(16),
  out resultCode int,
  OUT path TEXT
)
BEGIN
   SET path = (SELECT m_path FROM Message WHERE m_id = in_message);
   DELETE FROM Z WHERE z_message = in_message;
   DELETE FROM Reply WHERE r_comment IN (SELECT comment_id FROM Comment WHERE comment_message = in_message);
   DELETE FROM Comment WHERE comment_message = in_message;
   DELETE FROM Message WHERE m_id = in_message;
   SET resultCode = 1;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getClassInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getClassInfo`(
  in in_class CHAR(16),
  out resultCode int
)
BEGIN
   SELECT c_id,c_name,c_description,name,area FROM Class JOIN School ON Class.c_school = School.id WHERE c_id = in_class;
   SET resultCode = 1;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getClassStudents` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getClassStudents`(
  in in_class CHAR(16),
  out resultCode int
)
BEGIN
   SELECT s_id,s_name,s_sex FROM Student WHERE s_class = in_class;
   SET resultCode = 1;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getClassTeachers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getClassTeachers`(
  in in_class CHAR(16),
  out resultCode int
)
BEGIN
   SELECT u_id,t_name,t_header,Subject.name,t_telephone,t_power FROM Teacher LEFT JOIN Subject ON Teacher.t_subject = Subject.id JOIN TC ON Teacher.t_id = TC.tc_teacher JOIN User ON Teacher.t_id = User.u_teacher WHERE tc_class = in_class;
   SET resultCode = 1;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSchool` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSchool`(
  out resultCode int
)
BEGIN
    SELECT * FROM School;
    SET resultCode = 1;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSubject` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getSubject`(
  out resultCode int
)
BEGIN
    SELECT * FROM Subject;
    SET resultCode = 1;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getUserInfo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUserInfo`(
  in in_user CHAR(16),
  out resultCode int
)
BEGIN
   DECLARE type INT DEFAULT 0;
   SET type = (SELECT u_type FROM User WHERE u_id = in_user);
   IF type = 0 THEN
     SELECT u_type,t_name,t_sex,t_telephone,Subject.name,t_power,t_header,t_index,c_id,c_name,School.name,School.area,NULL FROM User LEFT JOIN Teacher ON User.u_teacher = Teacher.t_id JOIN TC ON Teacher.t_id = TC.tc_teacher JOIN Class ON TC.tc_class = Class.c_id JOIN School ON Class.c_school = School.id JOIN Subject ON Teacher.t_subject = Subject.id WHERE u_id = in_user AND c_status = b'1';
   ELSE
     SELECT u_type,p_name,p_sex,p_telephone,NULL,NULL,p_header,p_index,c_id,c_name,School.name,School.area,s_name FROM User LEFT JOIN Parent ON User.u_parent = Parent.p_id JOIN PS ON Parent.p_id = PS.ps_parent JOIN Student ON PS.ps_student = Student.s_id JOIN Class ON Student.s_class = Class.c_id JOIN School ON Class.c_school = School.id;
   END IF;
   SET resultCode = 1;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `giveZ` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `giveZ`(
  in in_user CHAR(16),
  IN in_message CHAR(16),
  out resultCode int
)
BEGIN
   INSERT INTO Z VALUES (getIntId('Z'),in_user,in_message,b'1');
   SET resultCode = 1;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `loadComment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `loadComment`(
  in in_message CHAR(16),
  IN flag BIT,
  OUT resultCode INT
)
BEGIN
   DECLARE counts INT DEFAULT 0;
   CREATE TEMPORARY TABLE IF NOT EXISTS tmp_comment(
     comment_id CHAR(16) PRIMARY KEY NOT NULL ,
     comment_content VARCHAR(100) NOT NULL ,
     comment_user CHAR(16) NOT NULL ,
     comment_time DATETIME NOT NULL ,
     type INT NOT NULL ,
     name VARCHAR(20) NOT NULL ,
     header TEXT,
     r_id CHAR(16) DEFAULT NULL ,
     r_content VARCHAR(100) DEFAULT NULL ,
     r_time DATETIME DEFAULT NULL ,
     subject VARCHAR(20) DEFAULT NULL,
     power BIT,
     student VARCHAR(20) DEFAULT NULL
   );
   TRUNCATE TABLE tmp_comment;
   INSERT INTO tmp_comment SELECT comment_id,comment_content,comment_user,comment_time,u_type,t_name,t_header,r_id,r_content,r_time,Subject.name,t_power,NULL FROM Comment JOIN User ON Comment.comment_user = User.u_id LEFT JOIN Teacher ON User.u_teacher = Teacher.t_id LEFT JOIN Reply ON Comment.comment_id = Reply.r_comment JOIN Subject ON Teacher.t_subject = Subject.id WHERE comment_message = in_message;
   INSERT INTO tmp_comment SELECT comment_id,comment_content,comment_user,comment_time,u_type,p_name,p_header,r_id,r_content,r_time,NULL,NULL,s_name FROM Comment JOIN User ON Comment.comment_user = User.u_id LEFT JOIN Parent ON User.u_parent = Parent.p_id LEFT JOIN Reply ON Comment.comment_id = Reply.r_comment JOIN PS ON Parent.p_id = PS.ps_parent JOIN Student ON PS.ps_student = Student.s_id WHERE comment_message = in_message;
   IF flag = b'0' THEN
     SELECT DISTINCT * FROM tmp_comment ORDER BY comment_time DESC LIMIT 3;
     SET counts = (SELECT count(comment_id) FROM tmp_comment);
     IF counts > 3 THEN 
       SET resultCode = 2;
     ELSE 
       SET resultCode = 1;
     END IF;
   ELSE
     SELECT DISTINCT * FROM tmp_comment ORDER BY comment_time DESC;
     SET resultCode = 1;
   END IF;

  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `loadDetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `loadDetails`(
  in in_message CHAR(16),
  OUT resultCode INT
)
BEGIN
    CREATE TEMPORARY TABLE IF NOT EXISTS tmp_details(
      m_id CHAR(16) PRIMARY KEY NOT NULL,
      m_type VARCHAR(4) NOT NULL ,
      m_user CHAR(16) NOT NULL ,
      m_content VARCHAR(500),
      m_path TEXT,
      m_time DATETIME NOT NULL ,
      type INT NOT NULL ,
      name VARCHAR(20) NOT NULL ,
      header TEXT,
      subject VARCHAR(20) DEFAULT NULL ,
      power BIT,
      student VARCHAR(20) DEFAULT NULL
    );
    TRUNCATE TABLE tmp_details;
    INSERT INTO tmp_details SELECT m_id,m_type,m_user,m_content,m_path,m_time,u_type,t_name,t_header,Subject.name,t_power,NULL FROM Message JOIN User ON Message.m_user = User.u_id LEFT JOIN Teacher ON User.u_teacher = Teacher.t_id JOIN Subject ON Teacher.t_subject = Subject.id
    WHERE m_id = in_message;
    INSERT INTO tmp_details SELECT m_id,m_type,m_user,m_content,m_path,m_time,u_type,p_name,p_header,NULL,NULL,s_name FROM Message JOIN User ON Message.m_user = User.u_id LEFT JOIN Parent ON User.u_parent = Parent.p_id JOIN PS ON Parent.p_id = PS.ps_parent JOIN Student ON PS.ps_student = Student.s_id
    WHERE m_id = in_message;
    SELECT * FROM tmp_details;
    SET resultCode = 1;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `loadMessage` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `loadMessage`(
  in in_class CHAR(16),
  IN cnt INT,
  OUT resultCode INT
)
BEGIN
    DECLARE startIndex INT;
    DECLARE endIndex INT;
    SET startIndex = cnt * 50;
    CREATE TEMPORARY TABLE IF NOT EXISTS tmp_message(
      m_id CHAR(16) PRIMARY KEY NOT NULL,
      m_type VARCHAR(4) NOT NULL ,
      m_user CHAR(16) NOT NULL ,
      m_content VARCHAR(500),
      m_path TEXT,
      m_time DATETIME NOT NULL ,
      type INT NOT NULL ,
      name VARCHAR(20) NOT NULL ,
      header TEXT,
      subject VARCHAR(20) DEFAULT NULL ,
      power BIT,
      student VARCHAR(20) DEFAULT NULL
    );
    TRUNCATE TABLE tmp_message;
    INSERT INTO tmp_message SELECT m_id,m_type,m_user,m_content,m_path,m_time,u_type,t_name,t_header,Subject.name,t_power,NULL FROM Message JOIN User ON Message.m_user = User.u_id LEFT JOIN Teacher ON User.u_teacher = Teacher.t_id JOIN TC ON Teacher.t_id = TC.tc_teacher JOIN Subject ON Teacher.t_subject = Subject.id
    WHERE TC.tc_class = in_class;
    INSERT INTO tmp_message SELECT m_id,m_type,m_user,m_content,m_path,m_time,u_type,p_name,p_header,NULL,NULL,s_name FROM Message JOIN User ON Message.m_user = User.u_id LEFT JOIN Parent ON User.u_parent = Parent.p_id JOIN PS ON Parent.p_id = PS.ps_parent JOIN Student ON PS.ps_student = Student.s_id
    WHERE s_class = in_class;
    SELECT * FROM tmp_message ORDER BY m_time DESC LIMIT startIndex,50;
    SET resultCode = 1;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `loadZ` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `loadZ`(
  in in_message CHAR(16),
  IN flag BIT,
  OUT resultCode INT
)
BEGIN
   DECLARE counts INT DEFAULT 0;
   CREATE TEMPORARY TABLE IF NOT EXISTS tmp_z(
     user CHAR(16) NOT NULL ,
     z_id INT PRIMARY KEY NOT NULL ,
     name VARCHAR(20) NOT NULL ,
     type INT NOT NULL ,
     subject VARCHAR(20) DEFAULT NULL ,
     power BIT,
     student VARCHAR(20)
   );
   TRUNCATE TABLE tmp_z;
   INSERT INTO tmp_z SELECT z_user,z_id,t_name,u_type,Subject.name,t_power,NULL FROM Z JOIN User ON Z.z_user = User.u_id LEFT JOIN Teacher ON User.u_teacher = Teacher.t_id JOIN Subject ON Teacher.t_subject = Subject.id WHERE z_message = in_message AND z_status = b'1';
   INSERT INTO tmp_z SELECT z_user,z_id,p_name,u_type,NULL,NULL,s_name FROM Z JOIN User ON Z.z_user = User.u_id LEFT JOIN Parent ON User.u_parent = Parent.p_id JOIN PS ON Parent.p_id = PS.ps_parent JOIN Student ON PS.ps_student = Student.s_id WHERE z_message = in_message AND z_status = b'1';
   IF flag = b'0' THEN 
     SELECT DISTINCT * FROM tmp_z ORDER BY z_id ASC LIMIT 3;
     SET counts = (SELECT count(z_id) FROM tmp_z);
     IF counts > 3 THEN 
       SET resultCode = 2;
     ELSE 
       SET resultCode = 1;
     END IF;
   ELSE 
     SELECT DISTINCT * FROM tmp_z ORDER BY z_id ASC;
     SET resultCode = 1;
   END IF;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `login`(
	in in_telephone char(11),
	in in_password char(16),
	out resultCode int
)
BEGIN
	declare pwd char(16);
	declare user_id char(16);
	declare user_type int default 0;
	declare id char(16);
	set user_id = (select u_id from User where u_telephone = in_telephone);
	if user_id is not null then
		set user_type = (select u_type from User where u_id = user_id);
		if user_type = 0 then
			set pwd = (select t_password from Teacher where t_id = (select u_teacher from User where u_id = user_id));
		else
			set pwd = (select t_password from Parent where p_id = (select u_parent from User where u_id = user_id));
		end if;
		if pwd = in_password then
			if user_type = 0 then
				select u_id,u_type,t_name,t_sex,t_subject,t_header,t_index from User join Teacher on User.u_teacher = Teacher.t_id
					where u_telephone = in_telephone;
				set resultCode = 1;	
			else
				select u_id,u_type,p_name,p_sex,p_header,p_index from User join Parent on User.u_parent = Parent.p_id
					where u_telephone = in_telephone;		
				set resultCode = 2;
			end if;
		else
			set resultCode = -1;
		end if;
	else
		set resultCode = -2;
	end if;				
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modifyBindStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifyBindStudent`(
  IN in_user CHAR(16),
  IN in_student CHAR(16),
  OUT resultCode INT
)
BEGIN
  DECLARE id CHAR(16);
  SET id = (SELECT u_parent FROM User WHERE u_id = in_user);
  UPDATE PS SET ps_student = in_student WHERE ps_parent = id;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modifyClassName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifyClassName`(
    IN in_id CHAR(16),
    IN in_name VARCHAR(20),
    OUT resultCode INT
  )
BEGIN
  UPDATE Class SET c_name = in_name WHERE c_id = in_id;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modifyDescription` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifyDescription`(
    IN in_id CHAR(16),
    IN in_description TEXT,
    OUT resultCode INT
  )
BEGIN
  UPDATE Class SET c_description = in_description WHERE c_id = in_id;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modifyPassword` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifyPassword`(
    IN in_user CHAR(16),
    IN in_password CHAR(16),
    OUT resultCode INT
  )
BEGIN
  DECLARE type INT;
  DECLARE id CHAR(16);
  SET type = (SELECT u_type FROM User WHERE u_id = in_user);
  IF type = 0 THEN
    SET id = (SELECT u_teacher FROM User WHERE u_id = in_user);
    UPDATE Teacher SET t_password = in_password WHERE t_id = id;
  ELSE 
    SET id = (SELECT u_parent FROM User WHERE u_id = in_user);
    UPDATE Parent SET p_password = in_password WHERE p_id = id;
  END IF;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modifySchool` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifySchool`(
    IN in_id CHAR(16),
    IN in_school CHAR(8),
    OUT resultCode INT
  )
BEGIN
  UPDATE Class SET c_school = in_school WHERE c_id = in_id;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modifyStudentClass` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifyStudentClass`(
    IN in_student CHAR(16),
    IN in_class CHAR(16),
    OUT resultCode INT
  )
BEGIN
  UPDATE Student SET s_class = in_class WHERE s_id = in_student;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modifyStudentName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifyStudentName`(
    IN in_student CHAR(16),
    IN in_name VARCHAR(20),
    OUT resultCode INT
  )
BEGIN
  UPDATE Student SET s_name = in_name WHERE s_id = in_student;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modifyStudentSex` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifyStudentSex`(
    IN in_student CHAR(16),
    IN in_sex BIT,
    OUT resultCode INT
  )
BEGIN
  UPDATE Student SET s_sex = in_sex WHERE s_id = in_student;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modifySubject` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifySubject`(
  IN in_user CHAR(16),
  IN in_subject INT,
  OUT resultCode INT
)
BEGIN
  DECLARE id CHAR(16);
  SET id = (SELECT u_teacher FROM User WHERE u_id = in_user);
  UPDATE Teacher SET t_subject = in_subject WHERE t_id = id;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modifyUserHeader` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifyUserHeader`(
  IN in_user CHAR(16),
  IN in_header TEXT,
  OUT resultCode INT
)
BEGIN
  DECLARE id CHAR(16);
  DECLARE type INT;
  SET type = (SELECT u_type FROM User WHERE u_id = in_user);
  IF type = 0 THEN
    SET id = (SELECT u_teacher FROM User WHERE u_id = in_user);
    UPDATE Teacher SET t_header = in_header WHERE t_id = id;
  ELSE
    SET id = (SELECT u_parent FROM User WHERE u_id = in_user);
    UPDATE Parent SET p_header = in_header WHERE p_id = id;
  END IF;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modifyUserIndex` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifyUserIndex`(
  IN in_user CHAR(16),
  IN in_index TEXT,
  OUT resultCode INT
)
BEGIN
  DECLARE id CHAR(16);
  DECLARE type INT;
  SET type = (SELECT u_type FROM User WHERE u_id = in_user);
  IF type = 0 THEN
    SET id = (SELECT u_teacher FROM User WHERE u_id = in_user);
    UPDATE Teacher SET t_index = in_index WHERE t_id = id;
  ELSE
    SET id = (SELECT u_parent FROM User WHERE u_id = in_user);
    UPDATE Parent SET p_index = in_index WHERE p_id = id;
  END IF;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modifyUserName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifyUserName`(
  IN in_user CHAR(16),
  IN in_name VARCHAR(20),
  OUT resultCode INT
)
BEGIN
  DECLARE id CHAR(16);
  DECLARE type INT;
  SET type = (SELECT u_type FROM User WHERE u_id = in_user);
  IF type = 0 THEN
    SET id = (SELECT u_teacher FROM User WHERE u_id = in_user);
    UPDATE Teacher SET t_name = in_name WHERE t_id = id;
  ELSE
    SET id = (SELECT u_parent FROM User WHERE u_id = in_user);
    UPDATE Parent SET p_name = in_name WHERE p_id = id;
  END IF;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modifyUserSex` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifyUserSex`(
  IN in_user CHAR(16),
  IN in_sex BIT,
  OUT resultCode INT
)
BEGIN
  DECLARE id CHAR(16);
  DECLARE type INT;
  SET type = (SELECT u_type FROM User WHERE u_id = in_user);
  IF type = 0 THEN
    SET id = (SELECT u_teacher FROM User WHERE u_id = in_user);
    UPDATE Teacher SET t_sex = in_sex WHERE t_id = id;
  ELSE
    SET id = (SELECT u_parent FROM User WHERE u_id = in_user);
    UPDATE Parent SET p_sex = in_sex WHERE p_id = id;
  END IF;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modifyZ` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modifyZ`(
  in in_user CHAR(16),
  IN in_message CHAR(16),
  out resultCode int
)
BEGIN
   DECLARE type BIT;
   SET type = (SELECT z_status FROM Z WHERE z_user = in_user AND z_message = in_message);
   IF type = b'1' THEN 
     SET type = b'0';
   else
     SET type = b'1';
   END IF;
  UPDATE Z SET z_status = type WHERE z_user = in_user AND z_message = in_message;
  SET resultCode = 1;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `parentBindStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `parentBindStudent`(
        in in_user_id char(16),
        in in_student_id char(16),
        out resultCode int
    )
BEGIN
        declare parent_id char(16);
        DECLARE error_flag INT;
        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET error_flag = -1;
        START TRANSACTION ;
        set parent_id = (select u_parent from User where u_id = in_user_id);
        insert into PS values(getIntId('PS'),parent_id,in_student_id);
        set resultCode = 1;
        IF error_flag = -1 THEN 
          ROLLBACK ;
        ELSE 
          COMMIT ;
        END IF;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registerParent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registerParent`(
        in in_name varchar(20),
        in in_sex bit,
        in in_telephone char(11),
        in in_password char(16),
        out resultCode int
    )
BEGIN   
        declare user_id char(16);
        DECLARE error_flag INT;
        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET error_flag = -1;
        START TRANSACTION ;
        set user_id = (select u_id from User where u_telephone = in_telephone);
        if user_id is not null then
            set resultCode = -1;
        else
            -- 注册
            insert into Parent values(getCharId('P'),in_name,in_sex,in_telephone,in_password,null,null);
            insert into User values(getCharId('U'),1,null,getCurrentCharId('P'),in_telephone);
            SELECT getCurrentCharId('U');
            set resultCode = 1;
        end if;
        IF error_flag = -1 THEN 
          ROLLBACK ;
        ELSE 
          COMMIT ;
        END IF;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registerTeacher` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registerTeacher`(
    in in_name varchar(20),
    in in_sex bit,
    in in_subject int,
    in in_telephone char(11),
    in in_password char(16),
    in in_is_leader bit,
    out resultCode int
  )
BEGIN
    declare user_id char(16);
    DECLARE error_flag INT;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET error_flag = -1;
    START TRANSACTION ;

    set user_id = (select u_id from User where u_telephone = in_telephone);
    if user_id is not null then
      set resultCode = -1;
    else
      -- 注册

      insert into Teacher values(getCharId('T'),in_name,in_sex,in_subject,in_telephone,in_password,null,null,in_is_leader);
      insert into User values(getCharId('U'),0,getCurrentCharId('T'),null,in_telephone);
      SELECT getCurrentCharId('U');
      set resultCode = 1;
    end if;

    IF error_flag = -1 THEN
      ROLLBACK ;
    ELSE
      COMMIT ;
    END IF;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `reply` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `reply`(
  in in_comment CHAR(16),
  IN in_content VARCHAR(100),
  out resultCode int
)
BEGIN
    INSERT INTO Reply VALUES (getCharId('R'),in_content,in_comment,sysdate());
    SET resultCode = 1;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchClass` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `searchClass`(
  in in_keyword VARCHAR(50),
  OUT resultCode INT
)
BEGIN
    SELECT DISTINCT c_id,c_name,c_description FROM Class WHERE c_name LIKE concat('%',in_keyword,'%') OR Class.c_description LIKE concat('%',in_keyword,'%');
    SET resultCode = 1;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sendMessage` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sendMessage`(
    IN in_user CHAR(16),
    IN in_type VARCHAR(4),
    IN in_content VARCHAR(500),
    IN in_path TEXT,
    OUT resultCode INT
  )
BEGIN
    DECLARE error_flag INT;
    DECLARE c CHAR(16);
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET error_flag = -1;
    INSERT INTO Message VALUES (getCharId('M'),in_type,in_user,in_content,in_path,sysdate());
    IF error_flag = -1 THEN
      SET resultCode = -1;
      ROLLBACK ;
    ELSE
      SET resultCode = 1;
      COMMIT ;
    END IF;

  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `setLeader` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `setLeader`(
    IN in_class CHAR(16),
    IN in_leader CHAR(16),
    OUT resultCode INT
  )
BEGIN
  DECLARE id INT;
  DECLARE teacher CHAR(16);
  SET id = (SELECT tc_id FROM TC LEFT JOIN Teacher ON Teacher.t_id = TC.tc_teacher WHERE tc_class = in_class AND t_power = b'1');
  SET teacher = (SELECT u_teacher FROM User WHERE u_id = in_leader);
  IF id IS NOT NULL THEN
      UPDATE TC SET tc_teacher = teacher WHERE tc_id = id;
  ELSE
      INSERT INTO TC VALUES (getIntId('TC'),teacher,in_class);
  END IF;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `studentBindClass` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `studentBindClass`(
    IN in_student CHAR(16),
    IN in_class CHAR(16),
    OUT resultCode INT
  )
BEGIN
  UPDATE Student SET s_class = in_class WHERE s_id = in_student;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `unbindLeader` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `unbindLeader`(
    IN in_class CHAR(16),
    OUT resultCode INT
  )
BEGIN
  DECLARE id INT;
  SET id = (SELECT tc_id FROM TC left JOIN Teacher ON Teacher.t_id = TC.tc_teacher WHERE t_power = b'1' AND tc_class = in_class);
  DELETE FROM TC WHERE tc_id = id;
  SET resultCode = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-22 10:21:57
