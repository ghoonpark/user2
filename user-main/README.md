# user
Springboot3 Security

Database : board

Create Table: 
CREATE TABLE `tb_user` (
  `USER_NO` int(11) NOT NULL AUTO_INCREMENT COMMENT '사용자번호',  
  `USER_ID` varchar(255) NOT NULL COMMENT '아이디',
  `USER_PW` varchar(256) DEFAULT NULL COMMENT '비밀번호',  
  `USER_NAME` varchar(255) NOT NULL COMMENT '사용자명',
  `USER_AUTH` varchar(255) NOT NULL COMMENT '권한',  
  `APPEND_DATE` datetime DEFAULT NULL COMMENT '추가날짜',  
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '수정날짜',  
  PRIMARY KEY (`USER_NO`)    
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci
