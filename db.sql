-- 創建資料庫
CREATE DATABASE `yokult`;

USE `yokult`;

-- 會員資料
DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `memid` VARCHAR(50) NOT NULL COMMENT '會員帳號',
  `email` VARCHAR(320) NOT NULL COMMENT '會員信箱',
  `password` VARCHAR(10) NOT NULL COMMENT '會員密碼',
  `name` VARCHAR(10) NOT NULL COMMENT '會員姓名',
  `birth` DATE COMMENT '會員生日',
  `cellphone` VARCHAR(10) NOT NULL COMMENT '手機號碼',
  `addr` VARCHAR(50) COMMENT '居住地址',
  `status` VARCHAR(10) NOT NULL default ('UNKNOWN'),
  PRIMARY KEY (`memid`),
  UNIQUE KEY uk_member_email(email))
COMMENT = '會員資料';

INSERT INTO 
  `member` (`memid`, `email`, `password`, `name`, `birth`, `cellphone`, `addr`, `status`)
VALUES
  ('TGA001', 'tga001@gmail.com', '123', '古天樂', '2022-04-11', '0910123456', '110台北市信義區市府路45號', 'APPROVED'),
  ('TGA002', 'tga002@gmail.com', '123', '葛仲珊', '2022-05-01', '0912345678', '407台中市西屯區惠來路二段101號', 'APPROVED'),
  ('TGA003', 'tga003@gmail.com', '123', '任容萱', '2022-05-31', '0972345678', '717台南市仁德區文華路二段66號', 'APPROVED'),
  ('TGA004', 'tga004@gmail.com', '123', '黃麗玲', '2022-06-05', '0954567890', '803高雄市鹽埕區大勇路1號', 'APPROVED'),
  ('TGA005', 'tga005@gmail.com', '123', '盧廣仲', '2022-08-25', '0987654321', '944屏東縣車城鄉後灣路2號', 'APPROVED'),
  ('TGA006', 'tga006@gmail.com', '123', '范少勛', '2022-04-11', '0919495902', '110台北市信義區市府路655號', 'APPROVED'),
  ('TGA007', 'tga007@gmail.com', '123', '曾敬華', '2022-05-01', '0914091490', '407台中市西屯區惠來路二段321號', 'APPROVED'),
  ('TGA008', 'tga008@gmail.com', '123', '金城武', '2022-01-31', '0999930190', '717台南市仁德區文華路二段766號', 'APPROVED'),
  ('TGA009', 'tga009@gmail.com', '123', '霍健華', '2022-02-05', '0999308109', '803高雄市鹽埕區大勇路10號', 'APPROVED'),
  ('TGA0010', 'tga0010@gmail.com', '123', '林俊傑', '2022-03-25', '0919304404', '944屏東縣車城鄉後灣路223號', 'APPROVED'),
  ('TGA0011', 'tga0011@gmail.com', '123', '彭于晏', '2022-09-11', '0911223345', '110台北市信義區市府路125號', 'APPROVED'),
  ('TGA0012', 'tga0012@gmail.com', '123', '王陽明', '2022-10-01', '0912245678', '407台中市西屯區惠來路二段340號', 'APPROVED'),
  ('TGA0013', 'tga0013@gmail.com', '123', '江蕙', '2022-10-31', '0972346478', '717台南市仁德區文華路一段790號', 'APPROVED'),
  ('TGA0014', 'tga0014@gmail.com', '123', '劉德華', '2022-12-05', '0919304511', '803高雄市鹽埕區大勇路86號', 'APPROVED'),
  ('TGA0015', 'tga0015@gmail.com', '123', '陳嘉樺', '2022-11-25', '0909451145', '944屏東縣車城鄉後灣路190號', 'APPROVED'),
  ('TGA0016', 'tga0016@gmail.com', '123', '鄧麗君', '2022-04-10', '0919034503', '110台北市信義區市府路546號', 'APPROVED'),
  ('TGA0017', 'tga0017@gmail.com', '123', '田馥甄', '2022-07-01', '0912348756', '407台中市西屯區惠來路三段399號', 'APPROVED'),
  ('TGA0018', 'tga0018@gmail.com', '123', '李玖哲', '2022-06-30', '0989406723', '717台南市仁德區文華路一段566號', 'APPROVED'),
  ('TGA0019', 'tga0019@gmail.com', '123', '韋禮安', '2022-12-05', '0912580647', '803高雄市鹽埕區大勇路189號', 'APPROVED'),
  ('TGA0020', 'tga0020@gmail.com', '123', '周杰倫', '2022-11-25', '0957905347', '944屏東縣車城鄉後灣路212號', 'APPROVED'),
  ('TGA0021', 'tga0021@gmail.com', '123', '陶喆', '2022-10-11', '0919867432', '110台北市信義區市府路415號', 'APPROVED'),
  ('TGA0022', 'tga0022@gmail.com', '123', '張惠妹', '2022-02-01', '0996029485', '407台中市西屯區惠來路五段329號', 'APPROVED'),
  ('TGA0023', 'tga0023@gmail.com', '123', '蔡依林', '2022-06-30', '0998749201', '717台南市仁德區文華路三段100號', 'APPROVED'),
  ('TGA0024', 'tga0024@gmail.com', '123', '余文樂', '2022-08-05', '0957892039', '803高雄市鹽埕區大勇路231號', 'APPROVED'),
  ('TGA0025', 'tga0025@gmail.com', '123', '吳姍儒', '2022-01-25', '0929190345', '944屏東縣車城鄉後灣路12號', 'APPROVED');
  