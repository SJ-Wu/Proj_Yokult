-- 建立募資平台資料庫
-- 選擇專題資料庫
use `YOKULT`;

-- 建立募資提案table

create table `Fund_PROPOSAL`(
	`proposalID` integer auto_increment not null primary key comment '提案編號',
	`proposalName` varchar(40) not null comment '提案名稱',
	`proposalHostName` varchar(70) not null comment '提案人姓名',
	`proposalGoal` integer not null comment '目標金額',
	`proposalCategoryID` varchar(2) not null comment '分類編號',
	`proposalStartedDateTime` datetime not null comment '提案開始時間',
	`proposalEndedDateTime` datetime not null comment '提案結束時間',
	`statusID` varchar(2) not null comment '階段編號',
	`proposalEmail` varchar(320) not null comment '電子信箱',
	`proposalCellphone` varchar(10) not null comment '手機號碼',
	`proposalSummary` varchar(500) not null comment '提案概要',
	`proposalPageContent` varchar(200) not null comment '頁面內容檔案',
	`memID` varchar(50) not null comment '會員帳號'
);


-- 存入以下資料庫的數據

insert into `Fund_PROPOSAL` (	
	`proposalName`,
	`proposalHostName`,
	`proposalGoal`,
	`proposalCategoryID`,
	`proposalStartedDateTime`,
	`proposalEndedDateTime`,
	`statusID`,
	`proposalEmail`,
	`proposalCellphone`,
	`proposalSummary`,
	`proposalPageContent`,
	`memID`
) values
(
'偏鄉牙醫志工團｜為偏鄉學童巡迴牙齒健檢', 
'社團法人中華民國牙醫師公會全國聯合會', 
'500000',
1, 
'2022-06-01 00:00:00', 
'2022-09-01 00:00:00',
'1',
'abc@gmail.com',
'0912345678',
'跟我們一起為偏鄉國小注入活力吧！',
'\\src\\main\\java\\web\\fundraising\\sql\\file\\PageContent_1.docx',
'test_account1'
),
(
'2023微笑曲線計畫｜為每個人打造獨一無二的微笑曲線', 
'牙樂多診所', 
'1000000',
2, 
'2022-08-01 00:00:00', 
'2022-11-01 00:00:00',
'2',
'xyz@yahoo.com',
'0987654321',
'跟我們一起打造獨一無二的微笑曲線吧！',
'\\src\\main\\java\\web\\fundraising\\sql\\file\\PageContent_2.docx',
'test_account2'
)



