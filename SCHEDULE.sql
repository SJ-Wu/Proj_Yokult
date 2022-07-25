-- 創建資料庫
CREATE DATABASE `yokult`;

USE `yokult`;

-- 排班資料
DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
  `schedule_date` DATE NOT NULL COMMENT '日期',
  `schedule_working_staff` VARCHAR(320) NOT NULL COMMENT '上班員工',
  `schedule_dayoff_staff` VARCHAR(10) NOT NULL COMMENT '休假員工',

  PRIMARY KEY (`schedule_date`))
COMMENT = '班表';

INSERT INTO 
  `schedule` (`schedule_date`, `schedule_working_staff`, `schedule_dayoff_staff`)
VALUES
  ('2022-08-01', 'tga001,tga002,tga003', 'tga004'),
  ('2022-08-02', 'tga001,tga002,tga004', 'tga003'),
  ('2022-08-03', 'tga001,tga003,tga004', 'tga002'),
  ('2022-08-04', 'tga002,tga003,tga004', 'tga001'),
  ('2022-08-05', 'tga001,tga002,tga003', 'tga004'),
  ('2022-08-06', 'tga001,tga002,tga003', 'tga004'),
  ('2022-08-07', 'tga001,tga002,tga004', 'tga003'),
  ('2022-08-08', 'tga001,tga003,tga004', 'tga002'),
  ('2022-08-09', 'tga002,tga003,tga004', 'tga001'),
  ('2022-08-10', 'tga001,tga002,tga003', 'tga004'), 
  ('2022-08-11', 'tga001,tga002,tga003', 'tga004'),
  ('2022-08-12', 'tga001,tga002,tga004', 'tga003'),
  ('2022-08-13', 'tga001,tga003,tga004', 'tga002'),
  ('2022-08-14', 'tga002,tga003,tga004', 'tga001'),
  ('2022-08-15', 'tga001,tga002,tga003', 'tga004'), 
  ('2022-08-16', 'tga001,tga002,tga003', 'tga004'),
  ('2022-08-17', 'tga001,tga002,tga004', 'tga003'),
  ('2022-08-18', 'tga001,tga003,tga004', 'tga002'),
  ('2022-08-19', 'tga002,tga003,tga004', 'tga001'),
  ('2022-08-20', 'tga001,tga002,tga003', 'tga004'), 
  ('2022-08-21', 'tga001,tga002,tga003', 'tga004'),
  ('2022-08-22', 'tga001,tga002,tga004', 'tga003'),
  ('2022-08-23', 'tga001,tga003,tga004', 'tga002'),
  ('2022-08-24', 'tga002,tga003,tga004', 'tga001'),
  ('2022-08-25', 'tga001,tga002,tga003', 'tga004'), 
  ('2022-08-26', 'tga001,tga002,tga003', 'tga004'),
  ('2022-08-27', 'tga001,tga002,tga004', 'tga003'),
  ('2022-08-28', 'tga001,tga003,tga004', 'tga002'),
  ('2022-08-29', 'tga002,tga003,tga004', 'tga001'),
  ('2022-08-30', 'tga001,tga002,tga003', 'tga004');
