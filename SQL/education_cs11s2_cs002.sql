-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: education
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cs11s2_cs002`
--

DROP TABLE IF EXISTS `cs11s2_cs002`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cs11s2_cs002` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_username` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `quiz_1_score` int DEFAULT NULL,
  `quiz_2_score` int DEFAULT NULL,
  `quiz_3_score` int DEFAULT NULL,
  `assignment_1_score` int DEFAULT NULL,
  `assignment_2_score` int DEFAULT NULL,
  `assignment_3_score` int DEFAULT NULL,
  `prelim_exam_score` int DEFAULT NULL,
  `periodical_exam_score` int DEFAULT NULL,
  `quiz_1_items` int DEFAULT NULL,
  `quiz_2_items` int DEFAULT NULL,
  `quiz_3_items` int DEFAULT NULL,
  `assignment_1_items` int DEFAULT NULL,
  `assignment_2_items` int DEFAULT NULL,
  `assignment_3_items` int DEFAULT NULL,
  `prelim_exam_items` int DEFAULT NULL,
  `periodical_exam_items` int DEFAULT NULL,
  PRIMARY KEY (`id`,`student_username`,`status`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cs11s2_cs002`
--

LOCK TABLES `cs11s2_cs002` WRITE;
/*!40000 ALTER TABLE `cs11s2_cs002` DISABLE KEYS */;
/*!40000 ALTER TABLE `cs11s2_cs002` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-15  1:00:18
