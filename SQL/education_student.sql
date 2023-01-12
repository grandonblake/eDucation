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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `middleName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `program` varchar(50) NOT NULL,
  `age` varchar(2) NOT NULL,
  `sex` varchar(6) NOT NULL,
  `contactNumber` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(50) NOT NULL,
  `cs002_section` varchar(45) NOT NULL,
  `gec004_section` varchar(45) NOT NULL,
  `pe001_section` varchar(45) NOT NULL,
  `math014_section` varchar(45) NOT NULL,
  `cs001_section` varchar(45) NOT NULL,
  PRIMARY KEY (`id`,`email`,`address`,`contactNumber`,`age`,`sex`,`program`,`lastName`,`middleName`,`firstName`,`password`,`username`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Lance','lance','Lance','Alcantara','Candelaria','Computer Science','18','Male','09276608404','Unit A Alcaraz Building, Poblacion Muntinlupa National Road','Lancelance@gmail.com','null','null','null','null','null'),(2,'Redd','redd','Redd','ronahold','Gacer','Computer Science','18','Male','09123456789','#1 Rose St. Cubao ','redd@yahoo.com','null','null','null','null','null'),(3,'vicent','bisente','Blake','Primo','Vicente','Computer Science','17','Male','09170802652','39 Mirasol Street Cubao 1100','39 Mirasol Street Cubao 1100','CS11S1','CS11S1','CS11S1','CS11S1','CS11S1'),(4,'studentmadrigal','danilo01','Danilo','Palito','Madrigal','Computer Science','26','Male','09178327423','Lucena Grand Central Terminal Diversion Rd., Ilayang Dupay','jemarch@gmail.com','null','null','null','null','null'),(5,'christian','christian','Christian','Sena','Paano','Computer Science','19','Male','09954387530','LG - 7 Cityland Condominium 898 Sen. Gil Puyat Avenue 1200','eabrown@yahoo.ca','null','null','null','null','null'),(6,'malou','malou','Malou','Geoz','Riyad','Computer Science','17','Female','09089440253','Iyam District','wayward@live.com','null','null','null','null','null'),(7,'aaliyah','aaliyah','aaliyah','weliz','salani','Computer Science','20','Female','09175007253','101 Legaspi Towers 1200','chrwin@yahoo.ca','null','null','null','null','null'),(8,'miakhalima','miakhalima','Mia','Siro','Khalima','Computer Science','18','Female','09228246523','Unit D Vsk Building 2 Acacia Lane Corner Shaw Boulevard 1552','rfoley@mac.com','null','null','null','null','null'),(9,'siadiaz','siadiaz','Sia','Diaz','Ramirez','Computer Science','17','Female','09950266637','Greson Building 100 B. Serrano Street, Bet.10th & 11th Avenue, Gracepark','kronvold@live.com','null','null','null','null','null'),(10,'kara','kara','kara','seno','dula','Computer Science','18','Female','09069030819','1st Level, Shangri-La Plaza Mall, shaw Boulevard corner EDSA','qrczak@me.com','null','null','null','null','null'),(11,'jaysushi','jaysushi','jay','quishi','pacer','Computer Science','19','Male','09107797480','536 Samson Road 1400','denism@live.com','null','null','null','null','null'),(12,'sipuuu','joseph','Joseph','Yamero','Colesio','Computer Science','19','Male','09581573482','344 Km. 14 West Service Road South Superhighway 1700','avalon@msn.com','null','null','null','null','null'),(13,'carl','carl','Carl','Ban','Sy','Computer Science','18','Male','09079651984','5/F Araneta Square, Bonifacio Monument Circle','adamk@outlook.com','null','null','null','null','null'),(14,'ceejay','ceejay','Cj','Vien','Hesoyam','Computer Science','18','Male','09194226763','51 Ragang 1100','rade@yahoo.com','null','null','null','null','null'),(15,'ramon','ramon','Ramon','Amon','Unima','Computer Science','19','Male','09132157137','2nd Floor B&C Square Building, Iznart Street','chaikin@icloud.com','null','null','null','null','null'),(16,'abdul','abdul','Abdul','Bhadi','Ahmed','Computer Science','19','Male','09762970289','109 Commonwealth Avenue','noodles@outlook.com','null','null','null','null','null'),(17,'tanya','tanya','Tanya','Valenzuela','Aduli','Computer Science','17','Female','09896164379','Metropolitan Avenue 1200','balchen@live.com','null','null','null','null','null'),(18,'marcial','marcial','Marcial','Nolu','Matining','Computer Science','18','Male','09134637741','127 Amang Rodriguez Avenue 1600','rsmartin@icloud.com','null','null','null','null','null'),(19,'jepoy','jepoy','Jepoy','Win','Senoni','Computer Science','18','Male','09172997519','eritage Building, JP Rizal Street corner Honradez Street, Barangay Olympia','sartak@gmail.com','null','null','null','null','null'),(20,'jose','jose','Jose','Revilla','Padilla','Computer Science','18','Male','09975584822','4/F Market! Market!, 25th Street Corner C5','tezbo@gmail.com','null','null','null','null','null'),(22,'juan','juan123','John','Agapito','Santos','Computer Science','1','Male','09123456789','#1 Ruby St. Concepcion Marikina City','juan_santos@yahoo.com','CS11S1','CS11S1','CS11S1','CS11S1','CS11S1');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-15  1:00:17
