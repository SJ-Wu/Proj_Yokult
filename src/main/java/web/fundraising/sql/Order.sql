-- 建立募資平台資料庫
-- 選擇專題資料庫
use `YOKULT`;

-- 建立訂單資料
create table `Fund_ORDER`(
	`orderID` integer auto_increment not null primary key comment '訂單編號',
	`orderInvoiceNumber` varchar(11) not null unique comment '發票編號',
	`orderTimeStamp` datetime not null comment '訂單時間',
	`orderAmount` integer not null comment '訂單金額',
	`proposalID` integer not null comment '提案編號',
	`planID` integer not null comment '方案編號',
	`memID` varchar(50) not null comment '會員帳號',
	`postID` integer not null comment '寄送資訊編號'
);

-- 存入資料
insert into `Fund_ORDER`(
	`orderInvoiceNumber`,
	`orderTimeStamp`,
	`orderAmount`,
	`proposalID`,
	`planID` ,
	`memID`,
	`postID`
)values
('TG-100001', '2022-07-20 00:00:00', 5000, 1, 2, 'test_account1', 1),
('TG-100002', '2022-07-21 00:00:00', 500, 1, 1, 'test_account2', 2)
