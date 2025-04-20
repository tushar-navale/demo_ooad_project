-- MySQL dump 10.13  Distrib 8.0.39, for Win64 (x86_64)
--
-- Host: localhost    Database: trainer
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `blog_post`
--

DROP TABLE IF EXISTS `blog_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog_post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `likes` int NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7vg0q5xiixc6i1m14dx0h5n49` (`user_id`),
  CONSTRAINT `FK7vg0q5xiixc6i1m14dx0h5n49` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_post`
--

LOCK TABLES `blog_post` WRITE;
/*!40000 ALTER TABLE `blog_post` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_posts`
--

DROP TABLE IF EXISTS `blog_posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog_posts` (
  `post_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` text NOT NULL,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `likes_count` int DEFAULT '0',
  PRIMARY KEY (`post_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `blog_posts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_posts`
--

LOCK TABLES `blog_posts` WRITE;
/*!40000 ALTER TABLE `blog_posts` DISABLE KEYS */;
INSERT INTO `blog_posts` VALUES (1,2,'My HIIT Journey','After 8 weeks of high-intensity interval training, I\'ve seen tremendous improvements in my endurance and recovery time. Here\'s what worked for me...','2025-03-30 14:03:16',14),(2,7,'The Perfect Chest Day','Struggling with building chest muscles? I\'ve compiled my top 5 exercises that transformed my chest development over the past year.','2025-03-30 14:03:16',21),(3,4,'Women\'s Strength Training Myths','Let\'s debunk some common myths about women and weightlifting. Contrary to popular belief, lifting heavy weights won\'t make you bulky...','2025-03-30 14:03:16',35),(4,9,'Nutrition for Power Athletes','Your diet is just as important as your training when it comes to developing explosive power. Here\'s my meal plan that supports heavy lifting...','2025-03-30 14:03:16',28),(5,1,'From Skinny to Strong','My transformation journey over the past 6 months has taught me valuable lessons about progressive overload and nutrition...','2025-03-30 14:03:16',16),(6,5,'Weight Loss After 40','It\'s never too late to start your fitness journey. Here are the adjustments I\'ve made to my routine that work well for my age group...','2025-03-30 14:03:16',19),(7,8,'How I Fixed My Posture','Years of desk work left me with terrible posture. These exercises have been game-changers for my back pain and alignment...','2025-03-30 14:03:16',24),(8,3,'Beginner\'s Guide to Gym Equipment','Feeling intimidated by all the machines at the gym? This post breaks down the most common equipment and how to use it properly.','2025-03-30 14:03:16',31),(9,6,'My Favorite Post-Workout Meals','Recovery nutrition is crucial for muscle growth. Here are my top 5 quick and easy high-protein meals to fuel recovery.','2025-03-30 14:03:16',17),(10,10,'Finding Time to Work Out as a Parent','Balancing parenting and fitness isn\'t easy, but it\'s possible. Here\'s how I fit in effective workouts with a busy family schedule.','2025-03-30 14:03:16',22),(11,2,'My HIIT Journey','After 8 weeks of high-intensity interval training, I\'ve seen tremendous improvements in my endurance and recovery time. Here\'s what worked for me...','2025-03-30 14:03:23',14),(12,7,'The Perfect Chest Day','Struggling with building chest muscles? I\'ve compiled my top 5 exercises that transformed my chest development over the past year.','2025-03-30 14:03:23',21),(13,4,'Women\'s Strength Training Myths','Let\'s debunk some common myths about women and weightlifting. Contrary to popular belief, lifting heavy weights won\'t make you bulky...','2025-03-30 14:03:23',35),(14,9,'Nutrition for Power Athletes','Your diet is just as important as your training when it comes to developing explosive power. Here\'s my meal plan that supports heavy lifting...','2025-03-30 14:03:23',28),(15,1,'From Skinny to Strong','My transformation journey over the past 6 months has taught me valuable lessons about progressive overload and nutrition...','2025-03-30 14:03:23',16),(16,5,'Weight Loss After 40','It\'s never too late to start your fitness journey. Here are the adjustments I\'ve made to my routine that work well for my age group...','2025-03-30 14:03:23',19),(17,8,'How I Fixed My Posture','Years of desk work left me with terrible posture. These exercises have been game-changers for my back pain and alignment...','2025-03-30 14:03:23',24),(18,3,'Beginner\'s Guide to Gym Equipment','Feeling intimidated by all the machines at the gym? This post breaks down the most common equipment and how to use it properly.','2025-03-30 14:03:23',31),(19,6,'My Favorite Post-Workout Meals','Recovery nutrition is crucial for muscle growth. Here are my top 5 quick and easy high-protein meals to fuel recovery.','2025-03-30 14:03:23',17),(20,10,'Finding Time to Work Out as a Parent','Balancing parenting and fitness isn\'t easy, but it\'s possible. Here\'s how I fit in effective workouts with a busy family schedule.','2025-03-30 14:03:23',22),(21,2,'My HIIT Journey','After 8 weeks of high-intensity interval training, I\'ve seen tremendous improvements in my endurance and recovery time. Here\'s what worked for me...','2025-03-30 14:03:48',14),(22,7,'The Perfect Chest Day','Struggling with building chest muscles? I\'ve compiled my top 5 exercises that transformed my chest development over the past year.','2025-03-30 14:03:48',21),(23,4,'Women\'s Strength Training Myths','Let\'s debunk some common myths about women and weightlifting. Contrary to popular belief, lifting heavy weights won\'t make you bulky...','2025-03-30 14:03:48',35),(24,9,'Nutrition for Power Athletes','Your diet is just as important as your training when it comes to developing explosive power. Here\'s my meal plan that supports heavy lifting...','2025-03-30 14:03:48',28),(25,1,'From Skinny to Strong','My transformation journey over the past 6 months has taught me valuable lessons about progressive overload and nutrition...','2025-03-30 14:03:48',16),(26,5,'Weight Loss After 40','It\'s never too late to start your fitness journey. Here are the adjustments I\'ve made to my routine that work well for my age group...','2025-03-30 14:03:48',19),(27,8,'How I Fixed My Posture','Years of desk work left me with terrible posture. These exercises have been game-changers for my back pain and alignment...','2025-03-30 14:03:48',24),(28,3,'Beginner\'s Guide to Gym Equipment','Feeling intimidated by all the machines at the gym? This post breaks down the most common equipment and how to use it properly.','2025-03-30 14:03:48',31),(29,6,'My Favorite Post-Workout Meals','Recovery nutrition is crucial for muscle growth. Here are my top 5 quick and easy high-protein meals to fuel recovery.','2025-03-30 14:03:48',17),(30,10,'Finding Time to Work Out as a Parent','Balancing parenting and fitness isn\'t easy, but it\'s possible. Here\'s how I fit in effective workouts with a busy family schedule.','2025-03-30 14:03:48',22),(31,2,'My HIIT Journey','After 8 weeks of high-intensity interval training, I\'ve seen tremendous improvements in my endurance and recovery time. Here\'s what worked for me...','2025-03-30 14:04:01',14),(32,7,'The Perfect Chest Day','Struggling with building chest muscles? I\'ve compiled my top 5 exercises that transformed my chest development over the past year.','2025-03-30 14:04:01',21),(33,4,'Women\'s Strength Training Myths','Let\'s debunk some common myths about women and weightlifting. Contrary to popular belief, lifting heavy weights won\'t make you bulky...','2025-03-30 14:04:01',35),(34,9,'Nutrition for Power Athletes','Your diet is just as important as your training when it comes to developing explosive power. Here\'s my meal plan that supports heavy lifting...','2025-03-30 14:04:01',28),(35,1,'From Skinny to Strong','My transformation journey over the past 6 months has taught me valuable lessons about progressive overload and nutrition...','2025-03-30 14:04:01',16),(36,5,'Weight Loss After 40','It\'s never too late to start your fitness journey. Here are the adjustments I\'ve made to my routine that work well for my age group...','2025-03-30 14:04:01',19),(37,8,'How I Fixed My Posture','Years of desk work left me with terrible posture. These exercises have been game-changers for my back pain and alignment...','2025-03-30 14:04:01',24),(38,3,'Beginner\'s Guide to Gym Equipment','Feeling intimidated by all the machines at the gym? This post breaks down the most common equipment and how to use it properly.','2025-03-30 14:04:01',31),(39,6,'My Favorite Post-Workout Meals','Recovery nutrition is crucial for muscle growth. Here are my top 5 quick and easy high-protein meals to fuel recovery.','2025-03-30 14:04:01',17),(40,10,'Finding Time to Work Out as a Parent','Balancing parenting and fitness isn\'t easy, but it\'s possible. Here\'s how I fit in effective workouts with a busy family schedule.','2025-03-30 14:04:01',22),(41,2,'My HIIT Journey','After 8 weeks of high-intensity interval training, I\'ve seen tremendous improvements in my endurance and recovery time. Here\'s what worked for me...','2025-03-30 14:04:02',14),(42,7,'The Perfect Chest Day','Struggling with building chest muscles? I\'ve compiled my top 5 exercises that transformed my chest development over the past year.','2025-03-30 14:04:02',21),(43,4,'Women\'s Strength Training Myths','Let\'s debunk some common myths about women and weightlifting. Contrary to popular belief, lifting heavy weights won\'t make you bulky...','2025-03-30 14:04:02',35),(44,9,'Nutrition for Power Athletes','Your diet is just as important as your training when it comes to developing explosive power. Here\'s my meal plan that supports heavy lifting...','2025-03-30 14:04:02',28),(45,1,'From Skinny to Strong','My transformation journey over the past 6 months has taught me valuable lessons about progressive overload and nutrition...','2025-03-30 14:04:02',16),(46,5,'Weight Loss After 40','It\'s never too late to start your fitness journey. Here are the adjustments I\'ve made to my routine that work well for my age group...','2025-03-30 14:04:02',19),(47,8,'How I Fixed My Posture','Years of desk work left me with terrible posture. These exercises have been game-changers for my back pain and alignment...','2025-03-30 14:04:02',24),(48,3,'Beginner\'s Guide to Gym Equipment','Feeling intimidated by all the machines at the gym? This post breaks down the most common equipment and how to use it properly.','2025-03-30 14:04:02',31),(49,6,'My Favorite Post-Workout Meals','Recovery nutrition is crucial for muscle growth. Here are my top 5 quick and easy high-protein meals to fuel recovery.','2025-03-30 14:04:02',17),(50,10,'Finding Time to Work Out as a Parent','Balancing parenting and fitness isn\'t easy, but it\'s possible. Here\'s how I fit in effective workouts with a busy family schedule.','2025-03-30 14:04:02',22),(51,2,'My HIIT Journey','After 8 weeks of high-intensity interval training, I\'ve seen tremendous improvements in my endurance and recovery time. Here\'s what worked for me...','2025-03-30 14:04:03',14),(52,7,'The Perfect Chest Day','Struggling with building chest muscles? I\'ve compiled my top 5 exercises that transformed my chest development over the past year.','2025-03-30 14:04:03',21),(53,4,'Women\'s Strength Training Myths','Let\'s debunk some common myths about women and weightlifting. Contrary to popular belief, lifting heavy weights won\'t make you bulky...','2025-03-30 14:04:03',35),(54,9,'Nutrition for Power Athletes','Your diet is just as important as your training when it comes to developing explosive power. Here\'s my meal plan that supports heavy lifting...','2025-03-30 14:04:03',28),(55,1,'From Skinny to Strong','My transformation journey over the past 6 months has taught me valuable lessons about progressive overload and nutrition...','2025-03-30 14:04:03',16),(56,5,'Weight Loss After 40','It\'s never too late to start your fitness journey. Here are the adjustments I\'ve made to my routine that work well for my age group...','2025-03-30 14:04:03',19),(57,8,'How I Fixed My Posture','Years of desk work left me with terrible posture. These exercises have been game-changers for my back pain and alignment...','2025-03-30 14:04:03',24),(58,3,'Beginner\'s Guide to Gym Equipment','Feeling intimidated by all the machines at the gym? This post breaks down the most common equipment and how to use it properly.','2025-03-30 14:04:03',31),(59,6,'My Favorite Post-Workout Meals','Recovery nutrition is crucial for muscle growth. Here are my top 5 quick and easy high-protein meals to fuel recovery.','2025-03-30 14:04:03',17),(60,10,'Finding Time to Work Out as a Parent','Balancing parenting and fitness isn\'t easy, but it\'s possible. Here\'s how I fit in effective workouts with a busy family schedule.','2025-03-30 14:04:03',22),(61,2,'My HIIT Journey','After 8 weeks of high-intensity interval training, I\'ve seen tremendous improvements in my endurance and recovery time. Here\'s what worked for me...','2025-03-30 14:04:03',14),(62,7,'The Perfect Chest Day','Struggling with building chest muscles? I\'ve compiled my top 5 exercises that transformed my chest development over the past year.','2025-03-30 14:04:03',21),(63,4,'Women\'s Strength Training Myths','Let\'s debunk some common myths about women and weightlifting. Contrary to popular belief, lifting heavy weights won\'t make you bulky...','2025-03-30 14:04:03',35),(64,9,'Nutrition for Power Athletes','Your diet is just as important as your training when it comes to developing explosive power. Here\'s my meal plan that supports heavy lifting...','2025-03-30 14:04:03',28),(65,1,'From Skinny to Strong','My transformation journey over the past 6 months has taught me valuable lessons about progressive overload and nutrition...','2025-03-30 14:04:03',16),(66,5,'Weight Loss After 40','It\'s never too late to start your fitness journey. Here are the adjustments I\'ve made to my routine that work well for my age group...','2025-03-30 14:04:03',19),(67,8,'How I Fixed My Posture','Years of desk work left me with terrible posture. These exercises have been game-changers for my back pain and alignment...','2025-03-30 14:04:03',24),(68,3,'Beginner\'s Guide to Gym Equipment','Feeling intimidated by all the machines at the gym? This post breaks down the most common equipment and how to use it properly.','2025-03-30 14:04:03',31),(69,6,'My Favorite Post-Workout Meals','Recovery nutrition is crucial for muscle growth. Here are my top 5 quick and easy high-protein meals to fuel recovery.','2025-03-30 14:04:03',17),(70,10,'Finding Time to Work Out as a Parent','Balancing parenting and fitness isn\'t easy, but it\'s possible. Here\'s how I fit in effective workouts with a busy family schedule.','2025-03-30 14:04:03',22),(71,2,'My HIIT Journey','After 8 weeks of high-intensity interval training, I\'ve seen tremendous improvements in my endurance and recovery time. Here\'s what worked for me...','2025-03-30 14:04:04',14),(72,7,'The Perfect Chest Day','Struggling with building chest muscles? I\'ve compiled my top 5 exercises that transformed my chest development over the past year.','2025-03-30 14:04:04',21),(73,4,'Women\'s Strength Training Myths','Let\'s debunk some common myths about women and weightlifting. Contrary to popular belief, lifting heavy weights won\'t make you bulky...','2025-03-30 14:04:04',35),(74,9,'Nutrition for Power Athletes','Your diet is just as important as your training when it comes to developing explosive power. Here\'s my meal plan that supports heavy lifting...','2025-03-30 14:04:04',28),(75,1,'From Skinny to Strong','My transformation journey over the past 6 months has taught me valuable lessons about progressive overload and nutrition...','2025-03-30 14:04:04',16),(76,5,'Weight Loss After 40','It\'s never too late to start your fitness journey. Here are the adjustments I\'ve made to my routine that work well for my age group...','2025-03-30 14:04:04',19),(77,8,'How I Fixed My Posture','Years of desk work left me with terrible posture. These exercises have been game-changers for my back pain and alignment...','2025-03-30 14:04:04',24),(78,3,'Beginner\'s Guide to Gym Equipment','Feeling intimidated by all the machines at the gym? This post breaks down the most common equipment and how to use it properly.','2025-03-30 14:04:04',31),(79,6,'My Favorite Post-Workout Meals','Recovery nutrition is crucial for muscle growth. Here are my top 5 quick and easy high-protein meals to fuel recovery.','2025-03-30 14:04:04',17),(80,10,'Finding Time to Work Out as a Parent','Balancing parenting and fitness isn\'t easy, but it\'s possible. Here\'s how I fit in effective workouts with a busy family schedule.','2025-03-30 14:04:04',22),(81,2,'My HIIT Journey','After 8 weeks of high-intensity interval training, I\'ve seen tremendous improvements in my endurance and recovery time. Here\'s what worked for me...','2025-03-30 14:04:04',14),(82,7,'The Perfect Chest Day','Struggling with building chest muscles? I\'ve compiled my top 5 exercises that transformed my chest development over the past year.','2025-03-30 14:04:04',21),(83,4,'Women\'s Strength Training Myths','Let\'s debunk some common myths about women and weightlifting. Contrary to popular belief, lifting heavy weights won\'t make you bulky...','2025-03-30 14:04:04',35),(84,9,'Nutrition for Power Athletes','Your diet is just as important as your training when it comes to developing explosive power. Here\'s my meal plan that supports heavy lifting...','2025-03-30 14:04:04',28),(85,1,'From Skinny to Strong','My transformation journey over the past 6 months has taught me valuable lessons about progressive overload and nutrition...','2025-03-30 14:04:04',16),(86,5,'Weight Loss After 40','It\'s never too late to start your fitness journey. Here are the adjustments I\'ve made to my routine that work well for my age group...','2025-03-30 14:04:04',19),(87,8,'How I Fixed My Posture','Years of desk work left me with terrible posture. These exercises have been game-changers for my back pain and alignment...','2025-03-30 14:04:04',24),(88,3,'Beginner\'s Guide to Gym Equipment','Feeling intimidated by all the machines at the gym? This post breaks down the most common equipment and how to use it properly.','2025-03-30 14:04:04',31),(89,6,'My Favorite Post-Workout Meals','Recovery nutrition is crucial for muscle growth. Here are my top 5 quick and easy high-protein meals to fuel recovery.','2025-03-30 14:04:04',17),(90,10,'Finding Time to Work Out as a Parent','Balancing parenting and fitness isn\'t easy, but it\'s possible. Here\'s how I fit in effective workouts with a busy family schedule.','2025-03-30 14:04:04',22),(91,2,'My HIIT Journey','After 8 weeks of high-intensity interval training, I\'ve seen tremendous improvements in my endurance and recovery time. Here\'s what worked for me...','2025-03-30 14:04:04',14),(92,7,'The Perfect Chest Day','Struggling with building chest muscles? I\'ve compiled my top 5 exercises that transformed my chest development over the past year.','2025-03-30 14:04:04',21),(93,4,'Women\'s Strength Training Myths','Let\'s debunk some common myths about women and weightlifting. Contrary to popular belief, lifting heavy weights won\'t make you bulky...','2025-03-30 14:04:04',35),(94,9,'Nutrition for Power Athletes','Your diet is just as important as your training when it comes to developing explosive power. Here\'s my meal plan that supports heavy lifting...','2025-03-30 14:04:04',28),(95,1,'From Skinny to Strong','My transformation journey over the past 6 months has taught me valuable lessons about progressive overload and nutrition...','2025-03-30 14:04:04',16),(96,5,'Weight Loss After 40','It\'s never too late to start your fitness journey. Here are the adjustments I\'ve made to my routine that work well for my age group...','2025-03-30 14:04:04',19),(97,8,'How I Fixed My Posture','Years of desk work left me with terrible posture. These exercises have been game-changers for my back pain and alignment...','2025-03-30 14:04:04',24),(98,3,'Beginner\'s Guide to Gym Equipment','Feeling intimidated by all the machines at the gym? This post breaks down the most common equipment and how to use it properly.','2025-03-30 14:04:04',31),(99,6,'My Favorite Post-Workout Meals','Recovery nutrition is crucial for muscle growth. Here are my top 5 quick and easy high-protein meals to fuel recovery.','2025-03-30 14:04:04',17),(100,10,'Finding Time to Work Out as a Parent','Balancing parenting and fitness isn\'t easy, but it\'s possible. Here\'s how I fit in effective workouts with a busy family schedule.','2025-03-30 14:04:04',22),(101,2,'My HIIT Journey','After 8 weeks of high-intensity interval training, I\'ve seen tremendous improvements in my endurance and recovery time. Here\'s what worked for me...','2025-03-30 14:04:05',14),(102,7,'The Perfect Chest Day','Struggling with building chest muscles? I\'ve compiled my top 5 exercises that transformed my chest development over the past year.','2025-03-30 14:04:05',21),(103,4,'Women\'s Strength Training Myths','Let\'s debunk some common myths about women and weightlifting. Contrary to popular belief, lifting heavy weights won\'t make you bulky...','2025-03-30 14:04:05',35),(104,9,'Nutrition for Power Athletes','Your diet is just as important as your training when it comes to developing explosive power. Here\'s my meal plan that supports heavy lifting...','2025-03-30 14:04:05',28),(105,1,'From Skinny to Strong','My transformation journey over the past 6 months has taught me valuable lessons about progressive overload and nutrition...','2025-03-30 14:04:05',16),(106,5,'Weight Loss After 40','It\'s never too late to start your fitness journey. Here are the adjustments I\'ve made to my routine that work well for my age group...','2025-03-30 14:04:05',19),(107,8,'How I Fixed My Posture','Years of desk work left me with terrible posture. These exercises have been game-changers for my back pain and alignment...','2025-03-30 14:04:05',24),(108,3,'Beginner\'s Guide to Gym Equipment','Feeling intimidated by all the machines at the gym? This post breaks down the most common equipment and how to use it properly.','2025-03-30 14:04:05',31),(109,6,'My Favorite Post-Workout Meals','Recovery nutrition is crucial for muscle growth. Here are my top 5 quick and easy high-protein meals to fuel recovery.','2025-03-30 14:04:05',17),(110,10,'Finding Time to Work Out as a Parent','Balancing parenting and fitness isn\'t easy, but it\'s possible. Here\'s how I fit in effective workouts with a busy family schedule.','2025-03-30 14:04:05',22);
/*!40000 ALTER TABLE `blog_posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `post_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1qophqykj3ae2rmeiwt7jbbh2` (`post_id`),
  KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`),
  CONSTRAINT `FK1qophqykj3ae2rmeiwt7jbbh2` FOREIGN KEY (`post_id`) REFERENCES `blog_post` (`id`),
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `post_id` int NOT NULL,
  `user_id` int NOT NULL,
  `content` text NOT NULL,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_id`),
  KEY `post_id` (`post_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `blog_posts` (`post_id`) ON DELETE CASCADE,
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,1,3,'This is exactly what I needed to read as a beginner. Thanks for sharing!','2025-03-30 14:04:19'),(2,1,5,'Have you tried incorporating weights into your HIIT routine?','2025-03-30 14:04:19'),(3,2,1,'Definitely going to try your chest routine next week!','2025-03-30 14:04:19'),(4,2,9,'Incline bench press has been a game-changer for me too.','2025-03-30 14:04:19'),(5,3,8,'Thank you for addressing these myths! Sharing this with my friends.','2025-03-30 14:04:19'),(6,3,2,'Couldn\'t agree more. I\'ve been lifting heavy for years and love the results.','2025-03-30 14:04:19'),(7,4,7,'Great meal plan ideas. What do you think about pre-workout nutrition?','2025-03-30 14:04:19'),(8,5,6,'Your transformation is inspiring! How long did it take to see initial results?','2025-03-30 14:04:19'),(9,5,10,'What was the hardest part of your journey?','2025-03-30 14:04:19'),(10,6,4,'As someone in my 40s too, I appreciate these specific tips!','2025-03-30 14:04:19'),(11,7,3,'My posture has improved so much following similar exercises!','2025-03-30 14:04:19'),(12,8,5,'Wish I had this guide when I first started at the gym. So helpful!','2025-03-30 14:04:19'),(13,9,1,'That smoothie recipe sounds delicious, will try it tomorrow.','2025-03-30 14:04:19'),(14,10,6,'As a fellow parent, these are great practical tips. Morning workouts have been key for me too.','2025-03-30 14:04:19');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diet_plans`
--

DROP TABLE IF EXISTS `diet_plans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diet_plans` (
  `plan_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `meal_plan` text,
  `calorie_goal` int DEFAULT NULL,
  PRIMARY KEY (`plan_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `diet_plans_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diet_plans`
--

LOCK TABLES `diet_plans` WRITE;
/*!40000 ALTER TABLE `diet_plans` DISABLE KEYS */;
INSERT INTO `diet_plans` VALUES (1,1,'High protein, moderate carbs, focuses on lean meats, eggs, protein shakes, whole grains, and vegetables. 5 meals per day.',2800),(2,2,'Balanced macros with emphasis on timing around HIIT workouts. Complex carbs before, protein and simple carbs after.',2200),(3,3,'Beginner nutrition plan with gradual changes. Focus on replacing processed foods with whole foods and proper hydration.',2500),(4,4,'Moderate calorie, high protein plan. Emphasis on protein at every meal and complex carbohydrates around workouts.',1900),(5,5,'Caloric deficit with high protein to preserve muscle. Intermittent fasting approach with 8-hour eating window.',2000),(6,6,'Performance-focused nutrition with timed carbohydrate intake. Higher calories on training days, maintenance on rest days.',2400),(7,7,'Bodybuilding diet with precise macro tracking. High protein, cyclical carbohydrates, and moderate fats.',3000),(8,8,'Anti-inflammatory focus with plenty of omega-3s, antioxidants, and whole foods. Limited processed items and added sugars.',1800),(9,9,'Power athlete diet with higher carbohydrates, moderate protein, and strategic supplement timing. Focuses on performance.',3200),(10,10,'Balanced nutrition plan designed for busy schedules. Includes meal prep strategies and quick protein-rich options.',1950);
/*!40000 ALTER TABLE `diet_plans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercises`
--

DROP TABLE IF EXISTS `exercises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercises` (
  `exercise_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `muscle_group` varchar(50) DEFAULT NULL,
  `equipment_required` varchar(100) DEFAULT NULL,
  `difficulty_level` enum('Easy','Medium','Hard') DEFAULT NULL,
  PRIMARY KEY (`exercise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercises`
--

LOCK TABLES `exercises` WRITE;
/*!40000 ALTER TABLE `exercises` DISABLE KEYS */;
INSERT INTO `exercises` VALUES (1,'Bench Press','Chest','Barbell, Bench','Medium'),(2,'Squats','Legs','Barbell, Squat Rack','Hard'),(3,'Pull-ups','Back','Pull-up Bar','Hard'),(4,'Push-ups','Chest','None','Easy'),(5,'Deadlift','Back, Legs','Barbell','Hard'),(6,'Bicep Curls','Arms','Dumbbells','Easy'),(7,'Shoulder Press','Shoulders','Dumbbells','Medium'),(8,'Plank','Core','None','Medium'),(9,'Lunges','Legs','None, Dumbbells (optional)','Medium'),(10,'Tricep Dips','Arms','Dip bars, Bench','Medium'),(11,'Russian Twists','Core','Medicine ball (optional)','Easy'),(12,'Leg Press','Legs','Leg Press Machine','Medium'),(13,'Lat Pulldown','Back','Cable Machine','Medium'),(14,'Jumping Jacks','Cardio','None','Easy'),(15,'Mountain Climbers','Core, Cardio','None','Medium');
/*!40000 ALTER TABLE `exercises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes` (
  `like_id` int NOT NULL AUTO_INCREMENT,
  `post_id` int NOT NULL,
  `user_id` int NOT NULL,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`like_id`),
  UNIQUE KEY `post_id` (`post_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `likes_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `blog_posts` (`post_id`) ON DELETE CASCADE,
  CONSTRAINT `likes_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES (1,1,3,'2025-03-30 14:04:30'),(2,1,4,'2025-03-30 14:04:30'),(3,1,5,'2025-03-30 14:04:30'),(4,1,7,'2025-03-30 14:04:30'),(5,1,9,'2025-03-30 14:04:30'),(6,1,10,'2025-03-30 14:04:30'),(7,2,1,'2025-03-30 14:04:30'),(8,2,3,'2025-03-30 14:04:30'),(9,2,5,'2025-03-30 14:04:30'),(10,2,6,'2025-03-30 14:04:30'),(11,2,8,'2025-03-30 14:04:30'),(12,2,10,'2025-03-30 14:04:30'),(13,3,1,'2025-03-30 14:04:30'),(14,3,2,'2025-03-30 14:04:30'),(15,3,5,'2025-03-30 14:04:30'),(16,3,7,'2025-03-30 14:04:30'),(17,3,8,'2025-03-30 14:04:30'),(18,3,9,'2025-03-30 14:04:30'),(19,3,10,'2025-03-30 14:04:30'),(20,4,1,'2025-03-30 14:04:30'),(21,4,2,'2025-03-30 14:04:30'),(22,4,3,'2025-03-30 14:04:30'),(23,4,5,'2025-03-30 14:04:30'),(24,4,6,'2025-03-30 14:04:30'),(25,4,7,'2025-03-30 14:04:30'),(26,4,8,'2025-03-30 14:04:30'),(27,5,2,'2025-03-30 14:04:30'),(28,5,3,'2025-03-30 14:04:30'),(29,5,7,'2025-03-30 14:04:30'),(30,5,8,'2025-03-30 14:04:30'),(31,5,9,'2025-03-30 14:04:30'),(32,6,1,'2025-03-30 14:04:30'),(33,6,4,'2025-03-30 14:04:30'),(34,6,7,'2025-03-30 14:04:30'),(35,6,8,'2025-03-30 14:04:30'),(36,6,10,'2025-03-30 14:04:30'),(37,7,1,'2025-03-30 14:04:30'),(38,7,2,'2025-03-30 14:04:30'),(39,7,3,'2025-03-30 14:04:30'),(40,7,5,'2025-03-30 14:04:30'),(41,7,6,'2025-03-30 14:04:30'),(42,7,9,'2025-03-30 14:04:30'),(43,7,10,'2025-03-30 14:04:30'),(44,8,2,'2025-03-30 14:04:30'),(45,8,4,'2025-03-30 14:04:30'),(46,8,5,'2025-03-30 14:04:30'),(47,8,6,'2025-03-30 14:04:30'),(48,8,7,'2025-03-30 14:04:30'),(49,8,9,'2025-03-30 14:04:30'),(50,8,10,'2025-03-30 14:04:30'),(51,9,2,'2025-03-30 14:04:30'),(52,9,3,'2025-03-30 14:04:30'),(53,9,4,'2025-03-30 14:04:30'),(54,9,5,'2025-03-30 14:04:30'),(55,9,8,'2025-03-30 14:04:30'),(56,10,1,'2025-03-30 14:04:30'),(57,10,3,'2025-03-30 14:04:30'),(58,10,4,'2025-03-30 14:04:30'),(59,10,5,'2025-03-30 14:04:30'),(60,10,7,'2025-03-30 14:04:30'),(61,10,9,'2025-03-30 14:04:30');
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan_exercises`
--

DROP TABLE IF EXISTS `plan_exercises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan_exercises` (
  `plan_id` int NOT NULL,
  `exercise_id` int NOT NULL,
  PRIMARY KEY (`plan_id`,`exercise_id`),
  KEY `exercise_id` (`exercise_id`),
  CONSTRAINT `plan_exercises_ibfk_1` FOREIGN KEY (`plan_id`) REFERENCES `workout_plans` (`plan_id`) ON DELETE CASCADE,
  CONSTRAINT `plan_exercises_ibfk_2` FOREIGN KEY (`exercise_id`) REFERENCES `exercises` (`exercise_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_exercises`
--

LOCK TABLES `plan_exercises` WRITE;
/*!40000 ALTER TABLE `plan_exercises` DISABLE KEYS */;
INSERT INTO `plan_exercises` VALUES (1,1),(6,1),(7,1),(9,1),(1,2),(5,2),(7,2),(9,2),(2,3),(6,3),(10,3),(3,4),(4,4),(8,4),(1,5),(6,5),(7,5),(9,5),(10,5),(3,6),(4,6),(6,6),(7,6),(1,7),(6,7),(7,7),(9,7),(2,8),(3,8),(4,8),(5,8),(8,8),(10,8),(3,9),(5,9),(8,9),(4,10),(2,11),(4,11),(8,11),(10,11),(9,12),(1,13),(10,13),(2,14),(3,14),(5,14),(2,15),(5,15),(8,15);
/*!40000 ALTER TABLE `plan_exercises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `progress_tracker`
--

DROP TABLE IF EXISTS `progress_tracker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `progress_tracker` (
  `tracker_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `date` date NOT NULL,
  `weight` decimal(5,2) DEFAULT NULL,
  `reps` int DEFAULT NULL,
  `sets` int DEFAULT NULL,
  `notes` text,
  PRIMARY KEY (`tracker_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `progress_tracker_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `progress_tracker`
--

LOCK TABLES `progress_tracker` WRITE;
/*!40000 ALTER TABLE `progress_tracker` DISABLE KEYS */;
INSERT INTO `progress_tracker` VALUES (1,1,'2025-03-01',185.50,NULL,NULL,'Starting weight'),(2,1,'2025-03-15',183.20,NULL,NULL,'Down 2.3 lbs'),(3,1,'2025-03-27',182.00,NULL,NULL,'Continuing to lose slowly'),(4,1,'2025-03-27',NULL,8,3,'Bench press: 185 lbs'),(5,2,'2025-03-02',142.20,NULL,NULL,'Starting weight'),(6,2,'2025-03-16',141.50,NULL,NULL,'Maintaining while building muscle'),(7,2,'2025-03-28',NULL,12,4,'Pull-ups with perfect form'),(8,3,'2025-03-05',170.80,NULL,NULL,'Starting weight'),(9,3,'2025-03-20',168.50,NULL,NULL,'Weight decreasing, muscle definition improving'),(10,3,'2025-03-27',NULL,10,2,'First time completing 2 sets of 10 push-ups'),(11,4,'2025-03-10',138.60,NULL,NULL,'Starting measurement'),(12,4,'2025-03-28',137.80,NULL,NULL,'Slight decrease in weight, feeling stronger'),(13,5,'2025-03-15',210.30,NULL,NULL,'Starting weight'),(14,5,'2025-03-26',207.10,NULL,NULL,'Down 3.2 lbs in first two weeks'),(15,6,'2025-03-12',145.50,NULL,NULL,'Weight stable, focusing on performance'),(16,7,'2025-03-05',175.00,NULL,NULL,'Starting weight'),(17,7,'2025-03-25',NULL,5,5,'Deadlift: 225 lbs, new personal record'),(18,8,'2025-03-10',132.00,NULL,NULL,'Starting weight'),(19,9,'2025-03-08',190.60,NULL,NULL,'Starting weight'),(20,9,'2025-03-26',NULL,3,5,'Squat: 275 lbs');
/*!40000 ALTER TABLE `progress_tracker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` int DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fitness_level` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,'john_28@example.com',NULL,NULL,NULL,NULL,'123',NULL),(2,NULL,'abc@gmail.com',NULL,NULL,NULL,NULL,'123',NULL),(3,23,'DEF_23@gmail.com','intermediate','female',5.12,'DEF','123',67);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `age` int DEFAULT NULL,
  `gender` enum('Male','Female','Other') DEFAULT NULL,
  `weight` decimal(5,2) DEFAULT NULL,
  `height` decimal(5,2) DEFAULT NULL,
  `fitness_level` enum('Beginner','Intermediate','Advanced') DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uk_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'John Smith',28,'Male',185.50,180.30,'Intermediate','2025-03-30 13:59:55','john_28@example.com','123'),(2,'Sarah Johnson',34,'Female',142.20,165.10,'Advanced','2025-03-30 13:59:55','sarah_34@example.com','123'),(3,'Mike Wilson',22,'Male',170.80,175.50,'Beginner','2025-03-30 13:59:55','mike_22@example.com','123'),(4,'Emma Davis',29,'Female',138.60,162.80,'Intermediate','2025-03-30 13:59:55','emma_29@example.com','123'),(5,'Robert Jones',45,'Male',210.30,182.90,'Beginner','2025-03-30 13:59:55','robert_45@example.com','123'),(6,'Jennifer Lee',31,'Female',145.50,168.20,'Advanced','2025-03-30 13:59:55','jennifer_31@example.com','123'),(7,'David Brown',27,'Male',175.00,177.80,'Intermediate','2025-03-30 13:59:55','david_27@example.com','123'),(8,'Lisa Garcia',33,'Female',132.00,160.00,'Beginner','2025-03-30 13:59:55','lisa_33@example.com','123'),(9,'Chris Martinez',39,'Male',190.60,179.10,'Advanced','2025-03-30 13:59:55','chris_39@example.com','123'),(10,'Amy Robinson',25,'Female',128.70,163.50,'Intermediate','2025-03-30 13:59:55','amy_25@example.com','123');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workout_plans`
--

DROP TABLE IF EXISTS `workout_plans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workout_plans` (
  `plan_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `plan_name` varchar(100) NOT NULL,
  `goal` text,
  `duration_weeks` int DEFAULT NULL,
  PRIMARY KEY (`plan_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `workout_plans_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workout_plans`
--

LOCK TABLES `workout_plans` WRITE;
/*!40000 ALTER TABLE `workout_plans` DISABLE KEYS */;
INSERT INTO `workout_plans` VALUES (1,1,'Strength Builder','Increase overall strength and muscle mass',12),(2,2,'Advanced HIIT','Improve cardiovascular endurance and maintain muscle',8),(3,3,'Beginner Basics','Learn proper form and build foundational strength',16),(4,4,'Tone & Shape','Tone muscles without significant mass gain',10),(5,5,'Weight Loss Focus','Reduce body fat while maintaining muscle',12),(6,7,'Bodybuilding Split','Increase muscle definition and size',14),(7,8,'Functional Fitness','Improve everyday movement and prevent injury',8),(8,9,'Power Development','Enhance explosive power and strength',10),(9,2,'Marathon Prep','Build endurance for long-distance running',16),(10,6,'Posture Improvement','Strengthen back and core for better posture',12);
/*!40000 ALTER TABLE `workout_plans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workout_sessions`
--

DROP TABLE IF EXISTS `workout_sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workout_sessions` (
  `session_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `date` date NOT NULL,
  `duration_minutes` int DEFAULT NULL,
  `notes` text,
  PRIMARY KEY (`session_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `workout_sessions_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workout_sessions`
--

LOCK TABLES `workout_sessions` WRITE;
/*!40000 ALTER TABLE `workout_sessions` DISABLE KEYS */;
INSERT INTO `workout_sessions` VALUES (1,1,'2025-03-25',65,'Felt strong today, increased weights on all exercises'),(2,1,'2025-03-27',55,'Slightly tired but completed full workout'),(3,2,'2025-03-26',75,'Intense HIIT session, new personal best on burpees'),(4,2,'2025-03-28',70,'Focused on form rather than speed today'),(5,3,'2025-03-25',45,'First session with trainer, learning proper form'),(6,3,'2025-03-27',50,'Slight improvement in form, added light weights'),(7,4,'2025-03-28',60,'Great pump in arms and shoulders'),(8,5,'2025-03-26',80,'Extended cardio session after strength training'),(9,6,'2025-03-27',65,'Back feeling much better after focused exercises'),(10,7,'2025-03-25',70,'Chest day, new PR on bench press'),(11,8,'2025-03-28',45,'Short session focusing on core stability'),(12,9,'2025-03-26',85,'Heavy lifting day, focusing on power moves'),(13,10,'2025-03-27',55,'Recovery workout with light weights and stretching');
/*!40000 ALTER TABLE `workout_sessions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-03 19:39:29
