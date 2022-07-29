-- 建立募資平台資料庫
-- 選擇專題資料庫
use `YOKULT`;

-- 建立寄送資訊
create table `Fund_POST`(
	`postID` integer auto_increment not null primary key comment '寄送編號',
	`postFisrtName` varchar(50) not null comment '名字',
	`postLastName` varchar(20) not null comment '姓氏',
	`postCellphone` varchar(10) not null comment '手機號碼',
	`cityName` varchar(3) not null comment '縣市名稱',
	`districtName` varchar(5) not null comment '區域名稱',
	`postAddress` varchar(100) not null comment '寄送地址',
	`memID` varchar(50) not null comment '會員帳號'
);

-- 存入資料

insert into `Fund_POST`(
	`postFisrtName`,
	`postLastName`,
	`postCellphone`,
	`cityName`,
	`districtName`,
	`postAddress`,
	`memID`
) values
('二哥', '關', '0987187187', '新北市', '深坑區', '北深路二段XX號', 'test_account1'),
('三哥', '張', '0955123789', '新北市', '深坑區', '埔新街XX號', 'test_account1'),
('四哥', '李', '0955123789', '新北市', '深坑區', '文化街XX號', 'test_account1')

