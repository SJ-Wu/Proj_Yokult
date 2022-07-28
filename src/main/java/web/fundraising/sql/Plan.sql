-- 建立募資平台資料庫
-- 選擇專題資料庫
use `YOKULT`;

-- 建立方案資料
create table `Fund_PLAN`(
	`planID` Integer auto_increment not null primary key comment '方案編號',
	`planName` varchar(50) not null comment '方案名稱',
	`planAmount` integer not null comment '方案金額',
	`planContent` varchar(300) not null comment '方案內容',
	`planPostNote` varchar(100) not null comment '寄送備註',
	`planStartedDateTime` datetime not null comment '方案開始時間',
	`planEndedDateTime` datetime not null comment '方案結束時間',
	`statusID` varchar(2) not null comment '階段編號',
	`proposalID` integer not null comment '提案編號'
);

-- 存入資料

insert into `Fund_PLAN`(
	`planName`,
	`planAmount`,
	`planContent`,
	`planPostNote`,
	`planStartedTime`,
	`planEndedTime`,
	`statusID`,
	`proposalID`
) values
(
'感謝小卡',
500,
'備註：感謝小卡將由我們親自設計',
'只寄送台灣本島',
'2022-06-19 00:00:00',
'2022-11-19 00:00:00',
1,
1
),
(
'大力贊助 + 紀念T恤',
5000,
'備註：紀念T恤為國寶設計師XXX設計',
'只寄送台灣本島',
'2022-07-25 00:00:00',
'2022-12-25 00:00:00',
3,
1
)