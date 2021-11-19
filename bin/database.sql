
﻿create database DuAn2

use DuAn2
drop database DuAn2

CREATE TABLE Accounts(
	id int primary key IDENTITY  ,
	username nvarchar(50) NOT NULL,
	password nvarchar(50) NOT NULL,
	fullname nvarchar(50) NOT NULL,
	address nvarchar(100) NOT NULL,
	phone nvarchar(50) NOT NULL,
	email nvarchar(50) NOT NULL,
	activated bit NOT NULL,
	admin bit NOT NULL
	)

CREATE TABLE [dbo].[Categories](
	[id] [int] IDENTITY(1,1) primary key ,
	[name] [nvarchar](50) NOT NULL
	)

CREATE TABLE [dbo].[Orders](
	[id] [int] IDENTITY(1,1) primary key ,
	[order_date] [date] NOT NULL,
	[amount] [float] NOT NULL,
	[notes] [nvarchar](max) NOT NULL,
	[shipping_address] [nvarchar](50) NOT NULL,
	[payment_method_id] [int] NOT NULL,
	[order_status_id] [int] NOT NULL,
	[account_id] [int] NOT NULL
	)

CREATE TABLE [dbo].[Order_Details](
	[id] [int] IDENTITY(1,1) primary key,
	[order_id] [int] NOT NULL,
	[product_size_id] [int] NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL
	)

CREATE TABLE [dbo].[Order_Status](
	[id] [int] IDENTITY(1,1) primary key ,
	[description] [nvarchar](50) NOT NULL
	)

CREATE TABLE [dbo].[Payment_Method](
	[id] [int] IDENTITY(1,1) primary key ,
	[description] [nvarchar](200) NOT NULL
	)

CREATE TABLE [dbo].[Products](
	[id] [int] IDENTITY(1,1) primary key ,
	[name] [nvarchar](50) NOT NULL,
	[image] [nvarchar](max) NOT NULL,
	[count] [int] NOT NULL,
	[special] [bit] NOT NULL,
	[price] [float] NOT NULL,
	[description] [nvarchar](max) NOT NULL,
	[category_id] [int] NOT NULL,
	[create_date] [date] NOT NULL
	)

	

CREATE TABLE [dbo].[Size](
	[id] [int] IDENTITY(1,1) primary key,
	[type] [varchar](10) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](50) NOT NULL
	)

drop table account

select * from accounts
delete from Products
drop table order
select * from Accounts
INSERT into Accounts VALUES ( N'tien01', N'123', N'Hoang Kim Tien', N'Quang Trung', N'0399215588', N'cuongbag@gmail.com', 1, 0),
 ( N'hung01', N'123', N'Ho Pham Si Hung', N'quang trung111', N'0399215788', N'cuongbag@gmail.com', 1, 0),
 ( N'minh01', N'123', N'Pham Trieu Duy Minh', N'Quang Trung', N'0399215588', N'cuongbag@gmail.com', 1, 0),
 ( N'thong01', N'123', N'Ho Huynh Thong', N'quang trung111', N'0399215788', N'cuongbag@gmail.com', 1, 0),
 ( N'phuc01', N'123', N'Tran Minh Phuc', N'Quang Trung', N'0399215588', N'cuongbag@gmail.com', 1, 0)


 insert into Categories values 
 ('Whey protein'), (N'Năng lượng trong tập'),
 (N'Mass gainer-Tăng cân'),
 (N'Giảm mỡ'),
 (N'Hỗ trợ sức khỏe Vitamin'),
 (N'Phụ kiện thể hình'),
 (N'Trang phục gymer'),
 ('BCAA')
      
 insert into Products  values 


(N'S.A.N Mass Effect Revolution bịch 5.9kg','mass1.jpg',1,'True',1800000,N'Nhập khẩu từ Mỹ',3,'11/11/2021'),
(N'Big Mass Pro Gainer 7,1 kg','mass3.jpg',1,'True',2170000,N'Nhập khẩu từ Mỹ',3,'11/11/2021'),
(N'Super Huge Gain - MASS Evogen','mass4.jpg',1,'True',2000000,N'Nhập khẩu từ Mỹ',3,'11/11/2021'),
(N'Nutrex Mass Infusion bịch lớn 5.45kg','mass5.png',1,'True',1450000,N'Nhập khẩu từ Mỹ',3,'11/11/2021'),
(N'Labrada Muscle Mass bịch 5.4kg','mass6.jpg',1,'True',1700000,N'Nhập khẩu từ Mỹ',3,'11/11/2021'),
(N'Lean Mass Weight Gainer','mass7.png',1,'True',2170000,N'Nhập khẩu từ Mỹ',3,'11/11/2021'),
(N'RSP TrueGain - Tăng cân hạn chế mỡ','mass8.jpg',1,'True',1150000,N'Nhập khẩu từ Mỹ',3,'11/11/2021'),

(N'ISOJECT Premium EVOGEN - Whey Isolate','whey1.jpg',1,'True',1450000,N'Nhập khẩu từ Mỹ',1,'11/11/2021'),
(N'Nutrex ISOFIT - Whey Protein ','whey2.jpg',1,'True',1350000,N'Nhập khẩu từ Mỹ',1,'11/11/2021'),
(N'ISOLEAN Hydrolyzed Whey Protein Isolate','whey3.jpg',1,'True',1700000,N'Nhập khẩu từ Mỹ',1,'11/11/2021'),
(N'S.A.N Titanium Whey Isolate Supreme','whey4.jpg',1,'True',1900000,N'Nhập khẩu từ Mỹ',1,'11/11/2021'),
(N'Ration Whey Protein Blend','whey5.jpg',1,'True',1190000,N'Nhập khẩu từ Mỹ',1,'11/11/2021'),
(N'RSP Whey Protein Powder - Whey','whey6.jpg',1,'True',1000000,N'Nhập khẩu từ Mỹ',1,'11/11/2021'),
(N'Labrada Lean Pro 8','whey7.jpg',1,'True',1650000,N'Nhập khẩu từ Mỹ',1,'11/11/2021'),
(N'Whey Tech – Xây dựng nuôi dưỡng cơ bắp hoàn hảo ','whey8.jpg',1,'True',1750000,N'Nhập khẩu từ Mỹ',1,'11/11/2021'),

(N'ALPHA BUMP','energy1.jpg',1,'True',750000,N'Nhập khẩu từ Mỹ',2,'11/11/2021'),
(N'Evogen Amino Ject ','energy2.jpg',1,'True',870000,N'Nhập khẩu từ Mỹ',2,'11/11/2021'),
(N'Amino K.E.M','energy3.jpg',1,'True',1330000,N'Nhập khẩu từ Mỹ',2,'11/11/2021'),
(N'RSP AminoLean','energy4.jpg',1,'True',900000,N'Nhập khẩu từ Mỹ',2,'11/11/2021'),
(N'BCAA 6000','energy5.jpg',1,'True',390000,N'Nhập khẩu từ Mỹ',2,'11/11/2021'),
(N'CREATINE MONOHYDRATE','energy6.jpg',1,'True',400000,N'Nhập khẩu từ Mỹ',2,'11/11/2021'),
(N'EAA HYDRATION','energy7.jpg',1,'True',800000,N'Nhập khẩu từ Mỹ',2,'11/11/2021'),
(N'EVP-3D ','energy8.jpg',1,'True',1400000,N'Nhập khẩu từ Mỹ',2,'11/11/2021'),

(N'Áo Bra Tập GYM & Yoga','pk1.jpg',1,'True',700000,N'Nhập khẩu từ Mỹ',6,'11/11/2021'),
(N'Cây Hít Đất','pk2.jpg',1,'True',100000,N'Nhập khẩu từ Mỹ',6,'11/11/2021'),
(N'Đai Arm Blaster','pk3.jpg',1,'True',490000,N'Nhập khẩu từ Mỹ',6,'11/11/2021'),
(N'Đai Treo Tập Bụng','pk4.jpg',1,'True',490000,N'Nhập khẩu từ Mỹ',6,'11/11/2021'),
(N'Quần KickBoxing','pk5.jpg',1,'True',450000,N'Nhập khẩu từ Mỹ',6,'11/11/2021'),
(N'Quấn Chỏ Dán','pk6.jpg',1,'True',350000,N'Nhập khẩu từ Mỹ',6,'11/11/2021'),
(N'Quấn Chỏ Loại Mỏng','pk7.jpg',1,'True',300000,N'Nhập khẩu từ Mỹ',6,'11/11/2021'),
(N'Quấn Chỏ Loại Dày','pk8.jpg',1,'True',300000,N'Nhập khẩu từ Mỹ',6,'11/11/2021'),

 (N'Áo Thun Body Sexy','trangphuc1.jpg',1,'True',400000,N'Nhập khẩu từ Mỹ',7,'11/11/2021'),
(N'Áo T-Shirt Gymer Nam','trangphuc2.jpg',1,'True',350000,N'Nhập khẩu từ Mỹ',7,'11/11/2021'),
(N'Áo Thun Không Tay','trangphuc3.jpg',1,'True',400000,N'Nhập khẩu từ Mỹ',7,'11/11/2021'),
(N'Gym Bag GB001','trangphuc4.jpg',1,'True',1200000,N'Nhập khẩu từ Mỹ',7,'11/11/2021'),
(N'Quần Tập Gym Sexy','trangphuc5.jpg',1,'True',400000,N'Nhập khẩu từ Mỹ',7,'11/11/2021'),
(N'Giày Tập Gym','trangphuc6.jpg',1,'True',1000000,N'Nhập khẩu từ Mỹ',7,'11/11/2021'),
(N'Quần Dài Gymer','trangphuc7.jpg',1,'True',600000,N'Nhập khẩu từ Mỹ',7,'11/11/2021')

INSERT INTO Size VALUES ( N'S', N'SIZE S', N'LOẠI NHỎ'),
 ( N'M', N'SIZE M', N'LOẠI TRUNG BÌNH'),
 ( N'L', N'SIZE L', N'LOẠI LỚN'),
 ( N'XL', N'SIZE XL', N'LOẠI  RẤT LỚN'),
( N'XXL', N'SIZE XX', N'LOẠI RẤT RẤT LỚN'),
( N'NO', N'SIZE 0', N'KHÔNG SIZE')
