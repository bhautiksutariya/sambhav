-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: sambhav
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `categoryid` int(11) NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(255) NOT NULL,
  `isactive` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `productid` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(5000) NOT NULL,
  `images` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `productname` varchar(255) NOT NULL,
  `qty` int(11) NOT NULL,
  `isactive` tinyint(1) NOT NULL DEFAULT '1',
  `categoryid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`productid`),
  KEY `FK4ort9abhumpx4t2mlngljr1vi` (`categoryid`),
  KEY `FKfb9sly2jhj919n55ijuhn69qa` (`userid`),
  CONSTRAINT `FK4ort9abhumpx4t2mlngljr1vi` FOREIGN KEY (`categoryid`) REFERENCES `category` (`categoryid`),
  CONSTRAINT `FKfb9sly2jhj919n55ijuhn69qa` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportproduct`
--

DROP TABLE IF EXISTS `reportproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reportproduct` (
  `reportid` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `productid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`reportid`),
  KEY `FKjpv81e93cu12gm2fnrm13vmj3` (`productid`),
  KEY `FKa7vls5ev3kw9b9ns4npad8m29` (`userid`),
  CONSTRAINT `FKa7vls5ev3kw9b9ns4npad8m29` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FKjpv81e93cu12gm2fnrm13vmj3` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportproduct`
--

LOCK TABLES `reportproduct` WRITE;
/*!40000 ALTER TABLE `reportproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `reportproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requestproduct`
--

DROP TABLE IF EXISTS `requestproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requestproduct` (
  `requestid` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `productid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`requestid`),
  KEY `FKemk3h95j84ri1xomqfx2ig07j` (`productid`),
  KEY `FKet3ff5g50d835q94dbyg25viq` (`userid`),
  CONSTRAINT `FKemk3h95j84ri1xomqfx2ig07j` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`),
  CONSTRAINT `FKet3ff5g50d835q94dbyg25viq` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requestproduct`
--

LOCK TABLES `requestproduct` WRITE;
/*!40000 ALTER TABLE `requestproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `requestproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `transactionid` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `qty` int(11) NOT NULL,
  `productid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`transactionid`),
  KEY `FK5tcnkwfql6wcbepsyvxxbxho9` (`productid`),
  KEY `FK4bo7aslrni69vrwvbewugh2fs` (`userid`),
  CONSTRAINT `FK4bo7aslrni69vrwvbewugh2fs` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FK5tcnkwfql6wcbepsyvxxbxho9` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `contactno` varchar(13) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `isactive` tinyint(1) NOT NULL DEFAULT '1',
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'98765','test@gmail.com','$2a$10$PIfzV2glxxwZyqNQrMVuaObOpkJn.yjsU/sRkjstb1N2m.vy8IqEm','user',1,'bhautik'),(2,'7405378330','bhautik@gmail.com','$2a$10$VlIkxnXRm4L/F40OG0AYju4sSz7dTjBgzNRdKlxpgB.WkOG5tAt8m','user',1,'bhautik'),(3,'7405378330','bhautik1@gmail.com','$2a$10$s/E5L26c4NgqSVoalwett.QjMxTtDUKNFcXwTuEvI3scFPhrJ.J4O','user',1,'bhautik'),(4,'7405378330','bhautik21@gmail.com','$2a$10$dtRo14FzA40TZLihFZTNH.BuHsiDkooIMXg5wjbi72ocum18LZ7jK','user',1,'bhautik');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-11 18:28:02
