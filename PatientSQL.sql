-- 創建資料庫
-- CREATE DATABASE `YOKULT`;

USE `YOKULT`;

-- 刪除醫師表格 -- 
DROP TABLE IF EXISTS DOCTOR;
-- 新增醫師表格DOCTOR
CREATE TABLE DOCTOR (
	`DOCTOR_ALPHABET` VARCHAR(50) DEFAULT 'D00' COMMENT '醫師代表文字',
	`DOCTOR_ID` INT NOT NULL AUTO_INCREMENT COMMENT '醫師流水編號',
    `DOCTOR_NAME` VARCHAR(50) NOT NULL COMMENT '醫師姓名',
    `DOCTOR_PHOTO` LONGBLOB COMMENT'醫師照片',
    `DOCTOR_CERTIFICATE` VARCHAR(50) COMMENT '醫師證書字號',
    `DOCTOR_EMAIL` VARCHAR(50) COMMENT '醫師信箱',
    `DOCTOR_PASSWARD` VARCHAR(50) COMMENT '醫師密碼',
    PRIMARY KEY(DOCTOR_ID)
);

-- 刪除看診時段表格 
DROP TABLE  IF EXISTS DOCTOR_SCHEDULE;
-- 新增看診時段表
CREATE TABLE DOCTOR_SCHEDULE (
	`SERIAL_NUMBER` INT NOT NULL AUTO_INCREMENT COMMENT '流水編號',
    `DOCTOR_ALPHABET` VARCHAR(50) DEFAULT 'D00' COMMENT '醫師代表文字',
    `DOCTOR_ID` INT NOT NULL COMMENT '醫師編號',
    `DOCTOR_SCHEDULE_DATE` DATE COMMENT '醫師看診日期',
    `DOCTOR_AMPM` VARCHAR(50) COMMENT '看診時段',
    `DOCTOR_STATUS` INT DEFAULT 1 COMMENT '看診狀態',
    PRIMARY KEY (`SERIAL_NUMBER`),
    CONSTRAINT FK_DOCTOR_SCHEDULE_DOCTOR_ID FOREIGN KEY (DOCTOR_ID) REFERENCES DOCTOR(DOCTOR_ID)
);

-- 刪除病人表格 
DROP TABLE  IF EXISTS PATIENT;
-- 建立病人表格 PATIENT
CREATE TABLE PATIENT (
	`SERIAL_NUMBER` INT NOT NULL AUTO_INCREMENT COMMENT '流水編號',
	`MEMID` VARCHAR(50) COMMENT '會員帳號',
	`PATIENT_IDCARD` VARCHAR(50) NOT NULL COMMENT '身分證字號',
	`BOOKING_DATE` DATE NOT NULL COMMENT '預約日期',
	`AMPM` VARCHAR(50) COMMENT '預約時段',
    `BOOKING_NUMBER` INT  COMMENT '預約號碼',
    `DOCTOR_ALPHABET` VARCHAR(50) DEFAULT 'D00' COMMENT '醫師代表文字',
    `DOCTOR_ID` INT COMMENT '醫師編號',
    `CHECKIN_CONDITION` INT DEFAULT 0 COMMENT '報到狀態',
    `CHART` TEXT COMMENT '病歷內容',
    PRIMARY KEY(`SERIAL_NUMBER`),
    CONSTRAINT FK_PATIENT_MEMBER_ID FOREIGN KEY (MEMID) REFERENCES MEMBER(MEMID),
    CONSTRAINT FK_PATIENT_DOCTOR_ID FOREIGN KEY (DOCTOR_ID) REFERENCES DOCTOR(DOCTOR_ID)
);

-- 新增測試資料
-- 新增醫師
INSERT INTO DOCTOR(DOCTOR_NAME, DOCTOR_PHOTO, DOCTOR_CERTIFICATE, DOCTOR_EMAIL, DOCTOR_PASSWARD ) VALUES
('李緯明' ,NULL ,'0003390', 'doctorwilliam@gmail.com', '123456'),
('吳貫鴻' ,NULL ,'0003388', 'doctordavid@gmail.com', '123456'),
('吳勇智' ,NULL ,'0003377', 'doctorpeter@gmail.com', '123456');
-- 新增醫師看診時段
INSERT INTO DOCTOR_SCHEDULE (DOCTOR_ID, DOCTOR_SCHEDULE_DATE, DOCTOR_AMPM, DOCTOR_STATUS) VALUES
(1, '2022-07-12', '早', 1),
(1, '2022-07-13', '早', 1),
(1, '2022-07-14', '早', 1),
(1, '2022-07-15', '午', 1),
(1, '2022-07-16', '早', 1),
(1, '2022-07-17', '早', 1),
(1, '2022-07-18', '午', 1),
(1, '2022-07-19', '早', 1),
(1, '2022-07-20', '早', 1),
(1, '2022-07-22', '早', 1),
(1, '2022-07-22', '晚', 1),
(1, '2022-07-23', '午', 1),
(1, '2022-07-24', '晚', 1),
(1, '2022-07-27', '午', 1),
(1, '2022-07-28', '午', 1),
(1, '2022-07-29', '早', 1),
(1, '2022-08-01', '早', 1),
(1, '2022-08-02', '早', 1),
(1, '2022-08-03', '午', 1),
(1, '2022-08-04', '早', 1),
(1, '2022-08-05', '早', 1),
(1, '2022-08-09', '午', 1),
(1, '2022-08-11', '早', 1),
(1, '2022-08-13', '早', 1),
(1, '2022-08-15', '午', 1),
(1, '2022-08-16', '早', 1),
(1, '2022-08-17', '早', 1),
(1, '2022-08-18', '午', 1),
(1, '2022-08-19', '早', 1),
(1, '2022-08-20', '早', 1),
(1, '2022-08-22', '早', 1),
(1, '2022-08-22', '晚', 1),
(1, '2022-08-23', '午', 1),
(1, '2022-08-24', '晚', 1),
(1, '2022-08-27', '午', 1),
(1, '2022-08-28', '午', 1),
(1, '2022-08-29', '晚', 1),
(1, '2022-08-30', '午', 1),
(1, '2022-08-31', '午', 1);
-- 新增掛號資料
INSERT INTO PATIENT(PATIENT_IDCARD, BOOKING_DATE, AMPM, BOOKING_NUMBER, DOCTOR_ID) VALUES
('A123456788', '2022-07-12', '早', 1, 1),
('A123456789', '2022-07-16', '早', 1, 1),
('A123456788', '2022-07-20', '早', 1, 1),
('A123456789', '2022-07-22', '早', 1, 1),
('A123456788', '2022-07-23', '午', 1, 1),
('A123456789', '2022-07-27', '午', 1, 1),
('A123456789', '2022-07-28', '午', 1, 1);

-- 修改病歷資料
UPDATE PATIENT SET CHART = "在病歷上記載病人同意你所建議的治療、處置或者用藥等。例如病人同意你所建議的蛀牙處置方式，或者選擇你所建議的選項中的哪一項，這些記載就是病人自己選擇及同意最好的證明。"
WHERE BOOKING_DATE="2022-07-16" AND DOCTOR_ID = "1";