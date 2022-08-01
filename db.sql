-- 創建資料庫
CREATE DATABASE `YOKULT`;

USE `YOKULT`;

-- 會員資料
DROP TABLE IF EXISTS `MEMBER`;

CREATE TABLE `MEMBER` (
  `MEMID` VARCHAR(50) NOT NULL COMMENT '會員帳號',
  `EMAIL` VARCHAR(320) NOT NULL COMMENT '會員信箱',
  `PASSWORD` VARCHAR(10) NOT NULL COMMENT '會員密碼',
  `FIRSTNAME` VARCHAR(10) NOT NULL COMMENT '會員姓氏',
  `LASTNAME` VARCHAR(10) NOT NULL COMMENT '會員名字',
  `BIRTH` DATETIME COMMENT '會員生日',
  `CELLPHONE` VARCHAR(10) NOT NULL COMMENT '手機號碼',
  `ADDR` VARCHAR(50) COMMENT '居住地址',
  PRIMARY KEY (`MEMID`))
COMMENT = '會員資料';

INSERT INTO 
  `MEMBER` (`MEMID`, `EMAIL`, `PASSWORD`, `FIRSTNAME`, `LASTNAME`, `BIRTH`, `CELLPHONE`, `ADDR`)
VALUES
  ('TGA001', 'tga001@gmail.com', '123', '天樂', '古', '2022-04-11', '0910123456', '110台北市信義區市府路45號'),
  ('TGA002', 'tga002@gmail.com', '123', '仲珊', '葛', '2022-05-01', '0912345678', '407台中市西屯區惠來路二段101號'),
  ('TGA003', 'tga003@gmail.com', '123', '容萱', '任', '2022-05-31', '0972345678', '717台南市仁德區文華路二段66號'),
  ('TGA004', 'tga004@gmail.com', '123', '麗玲', '黃', '2022-06-05', '0954567890', '803高雄市鹽埕區大勇路1號'),
  ('TGA005', 'tga005@gmail.com', '123', '廣仲', '盧', '2022-08-25', '0987654321', '944屏東縣車城鄉後灣路2號'),
  ('TGA006', 'tga006@gmail.com', '123', '少勛', '范', '2022-04-11', '0919495902', '110台北市信義區市府路655號'),
  ('TGA007', 'tga007@gmail.com', '123', '敬華', '曾', '2022-05-01', '0914091490', '407台中市西屯區惠來路二段321號'),
  ('TGA008', 'tga008@gmail.com', '123', '城武', '金', '2022-01-31', '0999930190', '717台南市仁德區文華路二段766號'),
  ('TGA009', 'tga009@gmail.com', '123', '健華', '霍', '2022-02-05', '0999308109', '803高雄市鹽埕區大勇路10號'),
  ('TGA0010', 'tga0010@gmail.com', '123', '俊傑', '林', '2022-03-25', '0919304404', '944屏東縣車城鄉後灣路223號'),
  ('TGA0011', 'tga0011@gmail.com', '123', '思凱', '伍', '2022-09-11', '0911223345', '110台北市信義區市府路125號'),
  ('TGA0012', 'tga0012@gmail.com', '123', '楊明', '王', '2022-10-01', '0912245678', '407台中市西屯區惠來路二段340號'),
  ('TGA0013', 'tga0013@gmail.com', '123', '蕙', '江', '2022-10-31', '0972346478', '717台南市仁德區文華路一段790號'),
  ('TGA0014', 'tga0014@gmail.com', '123', '德華', '劉', '2022-12-05', '0919304511', '803高雄市鹽埕區大勇路86號'),
  ('TGA0015', 'tga0015@gmail.com', '123', '嘉樺', '陳', '2022-11-25', '0909451145', '944屏東縣車城鄉後灣路190號'),
  ('TGA0016', 'tga0016@gmail.com', '123', '麗君', '鄧', '2022-04-10', '0919034503', '110台北市信義區市府路546號'),
  ('TGA0017', 'tga0017@gmail.com', '123', '馥甄', '田', '2022-07-01', '0912348756', '407台中市西屯區惠來路三段399號'),
  ('TGA0018', 'tga0018@gmail.com', '123', '玖哲', '李', '2022-06-31', '0989406723', '717台南市仁德區文華路一段566號'),
  ('TGA0019', 'tga0019@gmail.com', '123', '禮安', '韋', '2022-12-05', '0912580647', '803高雄市鹽埕區大勇路189號'),
  ('TGA0020', 'tga0020@gmail.com', '123', '杰倫', '周', '2022-11-25', '0957905347', '944屏東縣車城鄉後灣路212號'),
  ('TGA0021', 'tga0021@gmail.com', '123', '喆', '陶', '2022-10-11', '0919867432', '110台北市信義區市府路415號'),
  ('TGA0022', 'tga0022@gmail.com', '123', '惠妹', '張', '2022-02-01', '0996029485', '407台中市西屯區惠來路五段329號'),
  ('TGA0023', 'tga0023@gmail.com', '123', '依林', '蔡', '2022-06-31', '0998749201', '717台南市仁德區文華路三段100號'),
  ('TGA0024', 'tga0024@gmail.com', '123', '文樂', '余', '2022-08-05', '09578920390', '803高雄市鹽埕區大勇路231號'),
  ('TGA0025', 'tga0025@gmail.com', '123', '姍儒', '吳', '2022-01-25', '0929190345', '944屏東縣車城鄉後灣路12號');

-- 訂單資料
DROP TABLE IF EXISTS `ORDER`;

CREATE TABLE `ORDER` (
  `ODRID` VARCHAR(50) NOT NULL COMMENT '訂單編號',
  `FK_ORDER_MEMID` VARCHAR(50) NOT NULL COMMENT '會員帳號',
  `PAYMENTID` INTEGER NOT NULL COMMENT '付款方式ID',
  `ADDR` VARCHAR(50) NOT NULL COMMENT '訂單地址',
  `RECEIPTER` VARCHAR(45) NOT NULL COMMENT '收貨人',
  `SHOPTIME` VARCHAR(45) NOT NULL COMMENT '下單時間',
  `RETURNS` BOOLEAN NULL COMMENT '退換貨',
  `STATUSID` INTEGER NOT NULL COMMENT '訂單狀態ID',
  PRIMARY KEY (`ODRID`),
  CONSTRAINT `FK_ORDER_MEMID`
    FOREIGN KEY (`FK_ORDER_MEMID`)
    REFERENCES `MEMBER` (`MEM_ID`)
    ON UPDATE CASCADE);

INSERT INTO 
  `ORDER` (`ODRID`, `FK_ORDER_MEMID`, `PAYMENTID`, `ADDR`, `RECEIPTER`, `SHOPTIME`, `STATUSID`) 
VALUES 
  ('ODR001', 'TGA001', '0', '231新北市新店區民權路100號', '龍蝦', '2022-05-17 00:00:00', '1'),
  ('ODR002', 'TGA001', '0', '231新北市新店區民權路101號', '蝦蛄', '2022-05-17 01:00:00', '1'),
  ('ODR003', 'TGA001', '0', '231新北市新店區民權路102號', '波士頓龍蝦', '2022-05-17 02:00:00', '1'),
  ('ODR004', 'TGA001', '0', '231新北市新店區民權路103號', '撒尿蝦', '2022-05-17 03:00:00', '1'),
  ('ODR005', 'TGA001', '0', '231新北市新店區民權路104號', '水姑娘', '2022-05-17 04:00:00', '1');