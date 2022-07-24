-- 創建資料庫
CREATE DATABASE `yokult`;

USE `yokult`;

-- 會員資料
DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `memid` VARCHAR(50) NOT NULL COMMENT '會員帳號',
  `email` VARCHAR(320) NOT NULL COMMENT '會員信箱',
  `password` VARCHAR(10) NOT NULL COMMENT '會員密碼',
  `firstname` VARCHAR(10) NOT NULL COMMENT '會員姓氏',
  `lastname` VARCHAR(10) NOT NULL COMMENT '會員名字',
  `birth` DATE COMMENT '會員生日',
  `cellphone` VARCHAR(10) NOT NULL COMMENT '手機號碼',
  `addr` VARCHAR(50) COMMENT '居住地址',
  PRIMARY KEY (`memid`))
COMMENT = '會員資料';

INSERT INTO 
  `member` (`memid`, `email`, `password`, `firstname`, `lastname`, `birth`, `cellphone`, `addr`)
VALUES
  ('TGA001', 'tga001@gmail.com', '123', '家豪', '李', '2022-04-11', '0910123456', '110台北市信義區市府路45號'),
  ('TGA002', 'tga002@gmail.com', '123', '美玉', '王', '2022-05-01', '0912345678', '407台中市西屯區惠來路二段101號'),
  ('TGA003', 'tga003@gmail.com', '123', '志明', '張', '2022-05-31', '0972345678', '717台南市仁德區文華路二段66號'),
  ('TGA004', 'tga004@gmail.com', '123', '淑華', '劉', '2022-06-05', '0954567890', '803高雄市鹽埕區大勇路1號'),
  ('TGA005', 'tga005@gmail.com', '123', '俊傑', '陳', '2022-08-25', '0987654321', '944屏東縣車城鄉後灣路2號');

-- 訂單資料
DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `odrid` VARCHAR(50) NOT NULL COMMENT '訂單編號',
  `memid` VARCHAR(50) NOT NULL COMMENT '會員帳號',
  `paymentid` INTEGER NOT NULL COMMENT '付款方式ID',
  `addr` VARCHAR(50) NOT NULL COMMENT '訂單地址',
  `receipter` VARCHAR(45) NOT NULL COMMENT '收貨人',
  `shoptime` VARCHAR(45) NOT NULL COMMENT '下單時間',
  `retunrs` BOOLEAN NULL COMMENT '退換貨',
  `statusid` INTEGER NOT NULL COMMENT '訂單狀態ID',
  PRIMARY KEY (`odrid`),
  CONSTRAINT `fk_member_memid`
    FOREIGN KEY (`memid`)
    REFERENCES `member` (`memid`)
    ON UPDATE CASCADE);

INSERT INTO 
  `order` (`odrid`, `memid`, `paymentid`, `addr`, `receipter`, `shoptime`, `statusid`) 
VALUES 
  ('ODR001', 'TGA001', '0', '231新北市新店區民權路100號', '龍蝦', '2022-05-17 00:00:00', '1'),
  ('ODR002', 'TGA002', '0', '231新北市新店區民權路101號', '蝦蛄', '2022-05-17 01:00:00', '1'),
  ('ODR003', 'TGA003', '0', '231新北市新店區民權路102號', '波士頓龍蝦', '2022-05-17 02:00:00', '1'),
  ('ODR004', 'TGA004', '0', '231新北市新店區民權路103號', '撒尿蝦', '2022-05-17 03:00:00', '1'),
  ('ODR005', 'TGA005', '0', '231新北市新店區民權路104號', '水姑娘', '2022-05-17 04:00:00', '1');
  
CREATE TABLE `orderlist`(
	`orderlist_number` int primary key,
	`productid` varchar(100) not null,
	`unitprice` int not null,
	`quantity` int,
	`odrid` varchar(50) unique
);
select * from `orderlist`;

insert into `orderlist` (orderlist_number, productid, unitprice, quantity, odrid) 
values (2, 'MARVIS 義大利經典牙膏85ml(銀-亮白)', '339', '1', '2207070002');

CREATE TABLE `product` (
  `proid` varchar(300) NOT NULL COMMENT '商品ID',
  `proname` varchar(300) NOT NULL COMMENT '商品名稱',
  `prostock` int NOT NULL COMMENT '商品庫存',
  `proprice` int NOT NULL COMMENT '商品定價',
  `prospecs` varchar(300) NOT NULL COMMENT '商品規格',
  `probrand` varchar(300) NOT NULL COMMENT '商品品牌',
  `propicture` longblob COMMENT '商品圖片',
  `procategory` varchar(300) NOT NULL COMMENT '商品類別',
  PRIMARY KEY (`proid`))
  COMMENT = '產品資訊';
  
INSERT INTO 
	`yokult`.`product` (`proid`, `proname`, `prostock`, `proprice`, `prospecs`, `probrand`, `propicture`, `procategory`) 
VALUES 
	('1', 'MARVIS義大利經典牙膏', '30', '339', '85ml', 'MARVIS ', '?', '牙膏'),
	('2', '舒酸定強化琺瑯質兒童牙膏', '30', '180', '65g', '舒酸定', '?', '牙膏'),
	('3', '舒酸定專業修復牙膏', '30', '180', '100g', '舒酸定', '?', '牙膏'),
	('4', '舒酸定強效抗敏牙膏', '30', '180', '160g', '舒酸定', '?', '牙膏'),
	('5', 'BlackIsWhite酷黑淨白牙刷組', '30', '450', '2支', 'BlackIsWhite', '?', '牙刷'),
	('6', '獅王固齒佳超薄刷頭牙刷', '30', '109', '1支', '獅王', '?', '牙刷'),
	('7', 'EBISU惠比壽3~6歲兒童牙刷', '30', '50', '1支', 'EBISU', '?', '牙刷'),
	('8', '獅王固齒佳酵素漱口水', '20', '365', '450ml', '獅王', '?', '漱口水'),
	('9', '速可淨矯正含氟專用漱口水', '30', '250', '500ml', '速可淨', '?', '漱口水'),
	('10', '獅王NONIO終結口氣漱口水', '20', '158', '600ml', '獅王', '?', '漱口水'),
	('11', '3M護齒霜', '30', '299', '113g', '3M', '?', '牙膏'),
	('12', '獅王固齒佳固齒牙膏', '20', '180', '130g', '獅王', '?', '牙膏'),
	('13', 'Oral-B歐樂B矯正專用牙間刷', '30', '80', '1支', 'Oral-B', '?', '牙刷'),
	('14', 'TePe緹碧矯正專用單頭刷', '30', '135', '1支', 'TePe', '?', '牙刷'),
	('15', 'Oral-B歐樂B便攜型牙縫刷', '20', '189', '1盒', 'Oral-B',' ?', '牙刷'),
	('16', 'Oral-B深層清潔牙線', '20', '145', '1盒', 'Oral-B', '?', '牙線'),
	('17', '日本UFCFLOSSY兒童木醣醇安全牙線棒', '10', '350', '1盒', 'UFCFLOSSY', '?', '牙線'),
	('18', 'maxill(大圈)美適牙橋穿透線', '20', '89', '4包', 'maxill', '?', '牙線'),
	('19', 'maxill(小圈)美適牙橋穿透線', '20', '89', '4包', 'maxill', '?', '牙線'),
	('20', 'Platypus鴨嘴獸矯正用牙線棒', '20', '330', '1包', 'Platypus', '?', '牙線'),
	('21', 'Panasonic國際牌噴射水流攜帶型沖牙機EW-DJ40', '10', '1800', '1台', 'Panasonic', '?', '沖牙機'),
	('22', 'Panasonic國際牌噴射水流沖牙機EW-1613-W', '10', '2900', '1台', 'Panasonic', '?', '沖牙機'),
	('23', 'Panasonic國際牌超音波水流沖牙機EW-1513-W', '10', '2680', '1台', 'Panasonic', '?', '沖牙機'),
	('24', 'Panasonic國際牌無線國際電壓充電式沖牙機EW-1413-H', '10', '2080', '1台', 'Panasonic', '?', '沖牙機'),
	('25', 'DENTCLEAR碧利妥酵素假牙清潔錠', '15', '300', '1盒', 'DENTCLEAR', '?', '清潔類'),
	('26', 'DENTCLEAR碧利妥綠茶假牙清潔錠', '10', '300', '1盒', 'DENTCLEAR', '?', '清潔類'),
	('27', '德恩奈假牙清潔錠', '10', '120', '1盒', '德恩奈', '?', '清潔類'),
	('28', '保麗淨局部假牙清潔錠', '10', '370', '1盒', '保麗淨', '?', '清潔類'),
	('29', '德恩奈口腔護具清潔錠', '10', '200', '1盒', '德恩奈', '?', '清潔類'),
	('30', '速口舒牙菌斑顯示劑', '20', '130', '1瓶', '速口舒', '?', '清潔類');