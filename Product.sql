-- 創建資料庫
 CREATE DATABASE `product`;

USE `YOKULT`;

-- 會員資料
  -- DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `proid` int auto_increment COMMENT '商品ID',
  `proname` varchar(300) NOT NULL COMMENT '商品名稱',
  `prostock` int NOT NULL COMMENT '商品庫存',
  `proprice` int NOT NULL COMMENT '商品定價',
  `prospecs` varchar(300) NOT NULL COMMENT '商品規格',
  `probrand` varchar(300) NOT NULL COMMENT '商品品牌',
  `propicture` varchar(300) NOT NULL COMMENT '商品圖片',
  `procategory` varchar(300) NOT NULL COMMENT '商品類別',
  PRIMARY KEY (`proid`)) 
  COMMENT = '商品資訊';
 
 
 INSERT INTO 
	`product` (`proname`, `prostock`, `proprice`, `prospecs`, `probrand`, `propicture`, `procategory`) 
VALUES 
    ('MARVIS義大利經典牙膏', '30', '339', '85ml', 'MARVIS ', 'https://raw.githubusercontent.com/Peggy79/first/main/img/000.jpg', '清潔相關'),
	('舒酸定強化琺瑯質兒童牙膏', '30', '180', '65g', '舒酸定', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images62.jpg', '清潔相關'),
	('舒酸定專業修復牙膏', '30', '180', '100g', '舒酸定', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images63.jpg', '清潔相關'),
	('4', '舒酸定強效抗敏牙膏', '30', '180', '160g', '舒酸定', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images64.jpg', '清潔相關'),
	('5', 'BlackIsWhite酷黑淨白牙刷組', '30', '450', '2支', 'BlackIsWhite', 'https://raw.githubusercontent.com/Peggy79/first/main/img/222.png', '清潔相關'),
	('6', '獅王固齒佳超薄刷頭牙刷', '30', '109', '1支', '獅王', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images68.jpg', '清潔相關'),
	('7', 'EBISU惠比壽3~6歲兒童牙刷', '30', '50', '1支', 'EBISU', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images69.jpg', '清潔相關'),
	('8', '獅王固齒佳酵素漱口水', '20', '365', '450ml', '獅王', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images70.jpg', '清潔相關'),
	('9', '速可淨矯正含氟專用漱口水', '30', '250', '500ml', '速可淨', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images71.jpg', '清潔相關'),
	('10', '獅王NONIO終結口氣漱口水', '20', '158', '600ml', '獅王', 'https://raw.githubusercontent.com/Peggy79/first/main/img/111.jpg', '清潔相關'),
	('11', '3M護齒霜', '30', '299', '113g', '3M', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images66.jpg', '保健相關'),
	('12', '獅王固齒佳固齒牙膏', '20', '180', '130g', '獅王', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images65.jpg', '保健相關'),
	('13', 'Oral-B歐樂B矯正專用牙間刷', '30', '80', '1支', 'Oral-B', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images73.jpg', '保健相關'),
	('14', 'TePe緹碧矯正專用單頭刷', '30', '135', '1支', 'TePe', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images75.jpg', '保健相關'),
	('15', 'Oral-B歐樂B便攜型牙縫刷', '20', '189', '1盒', 'Oral-B',' https://raw.githubusercontent.com/Peggy79/first/main/img/images74.jpg', '保健相關'),
	('16', 'Oral-B深層清潔牙線', '20', '145', '1盒', 'Oral-B', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images76.jpg', '保健相關'),
	('17', '日本UFCFLOSSY兒童木醣醇安全牙線棒', '10', '350', '1盒', 'UFCFLOSSY', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images77.jpg', '保健相關'),
	('18', 'maxill(大圈)美適牙橋穿透線', '20', '89', '4包', 'maxill', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images9.png', '保健相關'),
	('19', 'maxill(小圈)美適牙橋穿透線', '20', '89', '4包', 'maxill', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images8.png', '保健相關'),
	('20', 'Platypus鴨嘴獸矯正用牙線棒', '20', '330', '1包', 'Platypus', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images78.jpg', '保健相關'),
	('21', 'Panasonic噴射水流攜帶型沖牙機EW-DJ40', '10', '1800', '1台', 'Panasonic', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images79.jpg', '其他品項'),
	('22', 'Panasonic噴射水流沖牙機EW-1613-W', '10', '2900', '1台', 'Panasonic', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images81.jpg', '其他品項'),
	('23', 'Panasonic國際牌超音波水流沖牙機EW-1513-W', '10', '2680', '1台', 'Panasonic', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images82.jpg', '其他品項'),
	('24', 'Panasonic無線國際電壓沖牙機EW-1413-H', '10', '2080', '1台', 'Panasonic', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images83.jpg', '其他品項'),
	('25', 'DENTCLEAR碧利妥酵素假牙清潔錠', '15', '300', '1盒', 'DENTCLEAR', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images84.jpg', '其他品項'),
	('26', 'DENTCLEAR碧利妥綠茶假牙清潔錠', '10', '300', '1盒', 'DENTCLEAR', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images85.jpg', '其他品項'),
	('27', '德恩奈假牙清潔錠', '10', '120', '1盒', '德恩奈', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images86.jpg', '其他品項'),
	('28', '保麗淨局部假牙清潔錠', '10', '370', '1盒', '保麗淨', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images87.jpg', '其他品項'),
	('29', '德恩奈口腔護具清潔錠', '10', '200', '1盒', '德恩奈', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images88.jpg', '其他品項'),
	('30', '速口舒牙菌斑顯示劑', '20', '130', '1瓶', '速口舒', 'https://raw.githubusercontent.com/Peggy79/first/main/img/images89.jpg', '其他品項');