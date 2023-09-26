
# Forms Creation Project

This project was generated with Angular CLI and this part is the server side of formCreator_Angular.

The aim of the project is to create a platform where users can create their own surveys and create an answer key for surveys. 

This web-based project allows for more effective survey results by using various types of questions in the survey creation process.

## Technologies Used

**Client:** Angular, PrimeNG, Bootstrap

**Server:** Java Springboot, MySQL


## MySQL Scripts

```sql
CREATE TABLE `form_data` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `sub_title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=219 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci



CREATE TABLE `questions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `form_id` bigint DEFAULT NULL,
  `question_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsh2qshoj6ic3exh8hktwrjr3p` (`form_id`),
  CONSTRAINT `FKsh2qshoj6ic3exh8hktwrjr3p` FOREIGN KEY (`form_id`) REFERENCES `form_data` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=249 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci



CREATE TABLE `options` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `question_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_option_question` (`question_id`),
  CONSTRAINT `FK5bmv46so2y5igt9o9n9w4fh6y` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`),
  CONSTRAINT `FK_option_question` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci



CREATE TABLE `answers` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `form_id` bigint DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `question_id` bigint DEFAULT NULL,
  `option_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `answers_fk_1` (`form_id`),
  KEY `answers_fk_2` (`question_id`),
  KEY `answers_fk_3` (`option_id`),
  CONSTRAINT `answers_fk_1` FOREIGN KEY (`form_id`) REFERENCES `form_data` (`id`),
  CONSTRAINT `answers_fk_2` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`),
  CONSTRAINT `answers_fk_3` FOREIGN KEY (`option_id`) REFERENCES `options` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```

  
  
## Screenshots
![image-1](https://github.com/KutayTunaa/Angular_NodeJs_Annotation_Webcam_Project/assets/113691691/cd4a3097-e055-4936-b6d4-7b759470d146)
![image-2](https://github.com/KutayTunaa/Angular_NodeJs_Annotation_Webcam_Project/assets/113691691/7ee691b1-a7eb-487d-bc9d-105f123a6c59)
![image-3](https://github.com/KutayTunaa/Angular_NodeJs_Annotation_Webcam_Project/assets/113691691/c620ce7f-8e07-409e-be48-ff8aefeda1a6)
![image-6](https://github.com/KutayTunaa/formCreator_Angular/assets/113691691/dc652a17-7c48-4e3b-83e6-ab4f8f736bc1)
![image-4](https://github.com/KutayTunaa/Angular_NodeJs_Annotation_Webcam_Project/assets/113691691/f116e884-9495-4d33-b997-b1f7fb26df69)
![image-5](https://github.com/KutayTunaa/Angular_NodeJs_Annotation_Webcam_Project/assets/113691691/c44196c8-917f-4480-a18d-34428a966a6c)
