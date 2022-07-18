-- 創建資料庫
CREATE DATABASE `YOKULT`;

USE `YOKULT`;

-- 會員資料
DROP TABLE IF EXISTS `STAFF`;

CREATE TABLE `STAFF` (
  `STAFF_ID` varchar(50) NOT NULL COMMENT '員工編號',
  `STAFF_NAME` varchar(50) NOT NULL COMMENT '員工姓名',
  `STAFF_EMAIL` varchar(320) NOT NULL COMMENT '員工信箱',
  `STAFF_IDNUMBER` varchar(50) NOT NULL COMMENT '員工身分證字號',
  `STAFF_BIRTHDAY` datetime NOT NULL COMMENT '員工生日',
  `STAFF_PHONE` varchar(20) NOT NULL COMMENT '手機號碼',
  `STAFF_PICTURE` longblob COMMENT '照片',
  PRIMARY KEY (`STAFF_ID`))
  comment = '員工';

INSERT INTO 
  `STAFF` (`STAFF_ID`, `STAFF_NAME`, `STAFF_EMAIL`, `STAFF_IDNUMBER`, `STAFF_BIRTHDAY`, `STAFF_PHONE`, `STAFF_PICTURE`)
VALUES
  ('TGA001', '陳花花', 'flower@gmail.com', 'A223456789', '1999-01-01','0987654321',''),
  ('TGA002', '黃泡泡', 'pop@gmail.com', 'A223456789', '1999-01-01','0987654321',''),
  ('TGA003', '林毛毛', 'green@gmail.com', 'A223456789', '1999-01-01','0987654321',''),
  ('TGA004', '楊莉莉', 'green@gmail.com', 'A223456789', '1999-01-01','0987654321','');

