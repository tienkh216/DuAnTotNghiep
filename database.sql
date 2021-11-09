create database DuAn2
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
	[description] [nvarchar](max) NOT NULL,
	[category_id] [int] NOT NULL,
	[create_date] [date] NOT NULL
	)

CREATE TABLE [dbo].[Product_Size](
	[id] [int] IDENTITY(1,1) primary key ,
	[product_id] [int] NOT NULL,
	[size_id] [int] NOT NULL,
	[price] [float] NULL
	)

CREATE TABLE [dbo].[Size](
	[id] [int] IDENTITY(1,1) primary key,
	[type] [varchar](10) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](50) NOT NULL
	)

drop table account

select * from accounts

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

INSERT INTO Size VALUES ( N'S', N'SIZE S', N'LOẠI NHỎ'),
 ( N'M', N'SIZE M', N'LOẠI TRUNG BÌNH'),
 ( N'L', N'SIZE L', N'LOẠI LỚN'),
 ( N'XL', N'SIZE XL', N'LOẠI  RẤT LỚN'),
( N'XXL', N'SIZE XX', N'LOẠI RẤT RẤT LỚN'),
( N'NO', N'SIZE 0', N'KHÔNG SIZE')

