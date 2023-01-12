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
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor` (
  `idinstructor` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `prefix` varchar(4) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `middleInitial` varchar(4) DEFAULT NULL,
  `lastName` varchar(50) NOT NULL,
  `age` int NOT NULL,
  `sex` varchar(50) NOT NULL,
  `degree` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`idinstructor`,`username`,`password`,`prefix`,`firstName`,`lastName`,`age`,`sex`,`degree`,`email`),
  UNIQUE KEY `idinstructor_UNIQUE` (`idinstructor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (1,'gflores','blackend84','Mr.','Glenn','G.','Flores',1,'Male','Bachelor of Science in Computer Science','gflores@gmail.com'),(2,'xaviersymth','darkboat52','Mr.','Xavier','L.','Cruz',45,'Male','Bachelor of Science in Computer Engineering','xavcruz@gmail.com'),(3,'rygomz','darkdme97','Mr.','Ryan','D.C.','Ramirez',53,'Male','Bachelor of Science in Physical Education','ryan1978@gmail.com'),(4,'eva1226','graygrip36','Mrs.','Evangeline','G.','Diaz',38,'Female','Bachelor of Science in Mathematics','diazeva@gmail.com'),(5,'tyler1','noisypotato26','Mr.','Tyler','','Lopez',33,'Male','Bachelor of Science in Mathematics','ty_lopez@gmail.com');
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
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
