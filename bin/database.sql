USE [DuAn2]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 27/11/2021 10:06:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Accounts](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[fullname] [nvarchar](50) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[image] [nvarchar](500) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Authorities]    Script Date: 27/11/2021 10:06:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Authorities](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[RoleId] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 27/11/2021 10:06:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order_Status]    Script Date: 27/11/2021 10:06:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order_Status](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[description] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 27/11/2021 10:06:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[OrderId] [bigint] NOT NULL,
	[ProductId] [int] NOT NULL,
	[Price] [float] NOT NULL,
	[Quantity] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 27/11/2021 10:06:24 ******/
drop table Orders
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](50) NOT NULL,
	[CreateDate] [datetime] NOT NULL,
	[Address] [nvarchar](100) NOT NULL,
	OrderStatusId int not null,
	[payment_method_id] [int] NOT NULL,
	[notes] [nvarchar](max) NOT NULL,
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Payment_Method]    Script Date: 27/11/2021 10:06:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payment_Method](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[description] [nvarchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 27/11/2021 10:06:24 ******/
drop table Products
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[image] [nvarchar](max) NOT NULL,
	[count] [int] NOT NULL,
	[special] [bit] NOT NULL,
	[price] [float] NOT NULL,
	[description] [nvarchar](max) NOT NULL,
	[category_id] [int] NOT NULL,
	[create_date] [date] NOT NULL,
	product_status_id int not null,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

CREATE TABLE [dbo].[Product_Status](
	[id] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[description] [nvarchar](50) NOT NULL
)
/****** Object:  Table [dbo].[Roles]    Script Date: 27/11/2021 10:06:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[Id] [nvarchar](10) NOT NULL,
	[Name] [nvarchar](50) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Size]    Script Date: 27/11/2021 10:06:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Size](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[type] [varchar](10) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

INSERT [dbo].[Order_Status] ( [description]) VALUES ( N'Chờ duyệt')
INSERT [dbo].[Order_Status] ( [description]) VALUES ( N'Đã duyệt')
INSERT [dbo].[Order_Status] ( [description]) VALUES ( N'Đang giao')
INSERT [dbo].[Order_Status] ( [description]) VALUES ( N'Đã giao')
INSERT [dbo].[Order_Status] ( [description]) VALUES ( N'Đã hủy')

INSERT [dbo].[Product_Status] ( [description]) VALUES ( N'Bình thường')
INSERT [dbo].[Product_Status] ( [description]) VALUES ( N'Bán chạy')
INSERT [dbo].[Product_Status] ( [description]) VALUES ( N'Mới')
INSERT [dbo].[Product_Status] ( [description]) VALUES ( N'20%')
INSERT [dbo].[Product_Status] ( [description]) VALUES ( N'50%')
INSERT [dbo].[Product_Status] ( [description]) VALUES ( N'70%')

 insert into Categories values 
 ('Whey protein'), (N'Năng lượng trong tập'),
 (N'Mass gainer-Tăng cân'),
 (N'Giảm mỡ'),
 (N'Hỗ trợ sức khỏe Vitamin'),
 (N'Phụ kiện thể hình'),
 (N'Trang phục gymer'),
 ('BCAA')
      
 insert into Products  values 


(N'S.A.N Mass Effect Revolution bịch 5.9kg','mass1.jpg',1,'True',1800000,N'Nhập khẩu từ Mỹ',3,'11/11/2021',1),
(N'Big Mass Pro Gainer 7,1 kg','mass3.jpg',1,'True',2170000,N'Nhập khẩu từ Mỹ',3,'11/11/2021',1),
(N'Super Huge Gain - MASS Evogen','mass4.jpg',1,'True',2000000,N'Nhập khẩu từ Mỹ',3,'11/11/2021',1),
(N'Nutrex Mass Infusion bịch lớn 5.45kg','mass5.png',1,'True',1450000,N'Nhập khẩu từ Mỹ',3,'11/11/2021',1),
(N'Labrada Muscle Mass bịch 5.4kg','mass6.jpg',1,'True',1700000,N'Nhập khẩu từ Mỹ',3,'11/11/2021',1),
(N'Lean Mass Weight Gainer','mass7.png',1,'True',2170000,N'Nhập khẩu từ Mỹ',3,'11/11/2021',1),
(N'RSP TrueGain - Tăng cân hạn chế mỡ','mass8.jpg',1,'True',1150000,N'Nhập khẩu từ Mỹ',3,'11/11/2021',1),

(N'ISOJECT Premium EVOGEN - Whey Isolate','whey1.jpg',1,'True',1450000,N'Nhập khẩu từ Mỹ',1,'11/11/2021',1),
(N'Nutrex ISOFIT - Whey Protein ','whey2.jpg',1,'True',1350000,N'Nhập khẩu từ Mỹ',1,'11/11/2021',1),
(N'ISOLEAN Hydrolyzed Whey Protein Isolate','whey3.jpg',1,'True',1700000,N'Nhập khẩu từ Mỹ',1,'11/11/2021',1),
(N'S.A.N Titanium Whey Isolate Supreme','whey4.jpg',1,'True',1900000,N'Nhập khẩu từ Mỹ',1,'11/11/2021',1),
(N'Ration Whey Protein Blend','whey5.jpg',1,'True',1190000,N'Nhập khẩu từ Mỹ',1,'11/11/2021',1),
(N'RSP Whey Protein Powder - Whey','whey6.jpg',1,'True',1000000,N'Nhập khẩu từ Mỹ',1,'11/11/2021',1),
(N'Labrada Lean Pro 8','whey7.jpg',1,'True',1650000,N'Nhập khẩu từ Mỹ',1,'11/11/2021',1),
(N'Whey Tech – Xây dựng nuôi dưỡng cơ bắp hoàn hảo ','whey8.jpg',1,'True',1750000,N'Nhập khẩu từ Mỹ',1,'11/11/2021',1),

(N'ALPHA BUMP','energy1.jpg',1,'True',750000,N'Nhập khẩu từ Mỹ',2,'11/11/2021',1),
(N'Evogen Amino Ject ','energy2.jpg',1,'True',870000,N'Nhập khẩu từ Mỹ',2,'11/11/2021',1),
(N'Amino K.E.M','energy3.jpg',1,'True',1330000,N'Nhập khẩu từ Mỹ',2,'11/11/2021',1),
(N'RSP AminoLean','energy4.jpg',1,'True',900000,N'Nhập khẩu từ Mỹ',2,'11/11/2021',1),
(N'BCAA 6000','energy5.jpg',1,'True',390000,N'Nhập khẩu từ Mỹ',2,'11/11/2021',1),
(N'CREATINE MONOHYDRATE','energy6.jpg',1,'True',400000,N'Nhập khẩu từ Mỹ',2,'11/11/2021',1),
(N'EAA HYDRATION','energy7.jpg',1,'True',800000,N'Nhập khẩu từ Mỹ',2,'11/11/2021',1),
(N'EVP-3D ','energy8.jpg',1,'True',1400000,N'Nhập khẩu từ Mỹ',2,'11/11/2021',1),

(N'Áo Bra Tập GYM & Yoga','pk1.jpg',1,'True',700000,N'Nhập khẩu từ Mỹ',6,'11/11/2021',1),
(N'Cây Hít Đất','pk2.jpg',1,'True',100000,N'Nhập khẩu từ Mỹ',6,'11/11/2021',1),
(N'Đai Arm Blaster','pk3.jpg',1,'True',490000,N'Nhập khẩu từ Mỹ',6,'11/11/2021',1),
(N'Đai Treo Tập Bụng','pk4.jpg',1,'True',490000,N'Nhập khẩu từ Mỹ',6,'11/11/2021',1),
(N'Quần KickBoxing','pk5.jpg',1,'True',450000,N'Nhập khẩu từ Mỹ',6,'11/11/2021',1),
(N'Quấn Chỏ Dán','pk6.jpg',1,'True',350000,N'Nhập khẩu từ Mỹ',6,'11/11/2021',1),
(N'Quấn Chỏ Loại Mỏng','pk7.jpg',1,'True',300000,N'Nhập khẩu từ Mỹ',6,'11/11/2021',1),
(N'Quấn Chỏ Loại Dày','pk8.jpg',1,'True',300000,N'Nhập khẩu từ Mỹ',6,'11/11/2021',1),

 (N'Áo Thun Body Sexy','trangphuc1.jpg',1,'True',400000,N'Nhập khẩu từ Mỹ',7,'11/11/2021',1),
(N'Áo T-Shirt Gymer Nam','trangphuc2.jpg',1,'True',350000,N'Nhập khẩu từ Mỹ',7,'11/11/2021',1),
(N'Áo Thun Không Tay','trangphuc3.jpg',1,'True',400000,N'Nhập khẩu từ Mỹ',7,'11/11/2021',1),
(N'Gym Bag GB001','trangphuc4.jpg',1,'True',1200000,N'Nhập khẩu từ Mỹ',7,'11/11/2021',1),
(N'Quần Tập Gym Sexy','trangphuc5.jpg',1,'True',400000,N'Nhập khẩu từ Mỹ',7,'11/11/2021',1),
(N'Giày Tập Gym','trangphuc6.jpg',1,'True',1000000,N'Nhập khẩu từ Mỹ',7,'11/11/2021',1),
(N'Quần Dài Gymer','trangphuc7.jpg',1,'True',600000,N'Nhập khẩu từ Mỹ',7,'11/11/2021',1)

INSERT INTO Size VALUES ( N'S', N'SIZE S', N'LOẠI NHỎ'),
 ( N'M', N'SIZE M', N'LOẠI TRUNG BÌNH'),
 ( N'L', N'SIZE L', N'LOẠI LỚN'),
 ( N'XL', N'SIZE XL', N'LOẠI  RẤT LỚN'),
( N'XXL', N'SIZE XX', N'LOẠI RẤT RẤT LỚN'),
( N'NO', N'SIZE 0', N'KHÔNG SIZE')

INSERT [dbo].[Roles] ([Id], [Name]) VALUES (N'CUST', N'Customers')
INSERT [dbo].[Roles] ([Id], [Name]) VALUES (N'DIRE', N'Directors')
INSERT [dbo].[Roles] ([Id], [Name]) VALUES (N'STAF', N'Staffs')

INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [image]) VALUES (N'customer', N'123', N'Nguyễn Khach Hang', N'teonv@gmail.com', N'user.png')
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [image]) VALUES (N'director', N'123', N'Nguyễn Chí Phèo', N'pheonc@fpt.edu.vn', N'-1407968806.jpg')
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [image]) VALUES (N'staff', N'123', N'Nguyễn Chí Minh', N'pheonc@fpt.edu.vn', N'1234.jpg')
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [image]) VALUES (N'ALFKI', N'alfki', N'Maria Anders', N'alfki@gmail.com', N'user.png')
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [image]) VALUES (N'ANATR', N'anatr', N'Ana Trujillo', N'anatr@gmail.com', N'user.png')
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [image]) VALUES (N'ANTON', N'anton', N'Antonio Moreno', N'anton@gmail.com', N'user.png')
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [image]) VALUES (N'AROUT', N'arout', N'Thomas Hardy', N'arout@gmail.com', N'user.png')
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [image]) VALUES (N'BERGS', N'bergs', N'Christina Berglund', N'bergs@gmail.com', N'user.png')
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [image]) VALUES (N'BLAUS', N'blaus', N'Hanna Moos', N'blaus@gmail.com', N'user.png')
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [image]) VALUES (N'BLONP', N'blonp', N'Frédérique Citeaux', N'blonp@gmail.com', N'user.png')
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [image]) VALUES (N'BOLID', N'bolid', N'Martín Sommer', N'bolid@gmail.com', N'user.png')
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [image]) VALUES (N'BONAP', N'bonap', N'Laurence Lebihan', N'bonap@gmail.com', N'user.png')
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [image]) VALUES (N'BOTTM', N'bottm', N'Elizabeth Lincoln', N'bottm@gmail.com', N'user.png')
INSERT [dbo].[Accounts] ([Username], [Password], [Fullname], [Email], [image]) VALUES (N'BSBEV', N'bsbev', N'Victoria Ashworth', N'bsbev@gmail.com', N'user.png')

INSERT [dbo].[Authorities] ([Username], [RoleId]) VALUES ( N'director', N'DIRE')
INSERT [dbo].[Authorities] ( [Username], [RoleId]) VALUES ( N'staff', N'STAF')
INSERT [dbo].[Authorities] ( [Username], [RoleId]) VALUES ( N'ALFKI', N'CUST')
INSERT [dbo].[Authorities] ( [Username], [RoleId]) VALUES ( N'ANATR', N'CUST')
INSERT [dbo].[Authorities] ( [Username], [RoleId]) VALUES ( N'ANTON', N'CUST')
INSERT [dbo].[Authorities] ( [Username], [RoleId]) VALUES ( N'AROUT', N'CUST')
INSERT [dbo].[Authorities] ( [Username], [RoleId]) VALUES ( N'BERGS', N'CUST')
INSERT [dbo].[Authorities] ( [Username], [RoleId]) VALUES ( N'BLAUS', N'CUST')
INSERT [dbo].[Authorities] ( [Username], [RoleId]) VALUES ( N'BLONP', N'CUST')
INSERT [dbo].[Authorities] ( [Username], [RoleId]) VALUES ( N'BOLID', N'CUST')
INSERT [dbo].[Authorities] ( [Username], [RoleId]) VALUES ( N'BONAP', N'CUST')
INSERT [dbo].[Authorities] ( [Username], [RoleId]) VALUES ( N'BOTTM', N'CUST')
INSERT [dbo].[Authorities] ( [Username], [RoleId]) VALUES ( N'BSBEV', N'CUST')


INSERT [dbo].[Orders] ([Username], [CreateDate], [Address],[OrderStatusId],[payment_method_id],[notes]) VALUES ( N'ALFKI', CAST(0x000089B100000000 AS DateTime), N'Tp.Ho Chi Minh',1,1,'Giao hang nhanh')
INSERT [dbo].[Orders] ([Username], [CreateDate], [Address],[OrderStatusId],[payment_method_id],[notes]) VALUES ( N'ANATR', CAST(0x000089B400000000 AS DateTime), N'Tp.Ho Chi Minh',1,1,'Xin bịch mắm tôm')
INSERT [dbo].[Orders] ([Username], [CreateDate], [Address],[OrderStatusId],[payment_method_id],[notes]) VALUES ( N'ANTON', CAST(0x000089B400000000 AS DateTime), N'Tp.Ho Chi Minh',1,1,'Giao hang nhanh')
INSERT [dbo].[Orders] ([Username], [CreateDate], [Address],[OrderStatusId],[payment_method_id],[notes]) VALUES ( N'AROUT', CAST(0x000089B500000000 AS DateTime), N'Tp.Ho Chi Minh',1,1,'Giao hang nhanh')
INSERT [dbo].[Orders] ([Username], [CreateDate], [Address],[OrderStatusId],[payment_method_id],[notes]) VALUES ( N'BERGS', CAST(0x000089B600000000 AS DateTime), N'Tp.Ho Chi Minh',1,1,'Giao hang nhanh')
INSERT [dbo].[Orders] ([Username], [CreateDate], [Address],[OrderStatusId],[payment_method_id],[notes]) VALUES ( N'BLAUS', CAST(0x000089B700000000 AS DateTime), N'Tp.Ho Chi Minh',1,2,'Giao hang nhanh')
INSERT [dbo].[Orders] ([Username], [CreateDate], [Address],[OrderStatusId],[payment_method_id],[notes]) VALUES ( N'BLONP', CAST(0x000089B800000000 AS DateTime), N'Tp.Ho Chi Minh',1,2,'Giao hang nhanh')
INSERT [dbo].[Orders] ([Username], [CreateDate], [Address],[OrderStatusId],[payment_method_id],[notes]) VALUES ( N'BOLID', CAST(0x000089BB00000000 AS DateTime), N'Tp.Ho Chi Minh',1,2,'Giao hang nhanh')
INSERT [dbo].[Orders] ([Username], [CreateDate], [Address],[OrderStatusId],[payment_method_id],[notes]) VALUES ( N'BONAP', CAST(0x000089BC00000000 AS DateTime), N'Tp.Ho Chi Minh',1,2,'Giao hang nhanh')
INSERT [dbo].[Orders] ([Username], [CreateDate], [Address],[OrderStatusId],[payment_method_id],[notes]) VALUES ( N'BOTTM', CAST(0x000089BD00000000 AS DateTime), N'Tp.Ho Chi Minh',1,2,'Giao hang nhanh')
INSERT [dbo].[Orders] ([Username], [CreateDate], [Address],[OrderStatusId],[payment_method_id],[notes]) VALUES ( N'BSBEV', CAST(0x000089BE00000000 AS DateTime), N'Tp.Ho Chi Minh',1,2,'Giao hang nhanh')

INSERT [dbo].[OrderDetails] ( [OrderId], [ProductId], [Price], [Quantity]) VALUES (1, 2, 1000000, 8)
INSERT [dbo].[OrderDetails] ( [OrderId], [ProductId], [Price], [Quantity]) VALUES (2, 3, 2000000, 3)
INSERT [dbo].[OrderDetails] ( [OrderId], [ProductId], [Price], [Quantity]) VALUES (3, 4, 1450000, 1)
INSERT [dbo].[OrderDetails] ( [OrderId], [ProductId], [Price], [Quantity]) VALUES (4, 5, 1700000, 1)
INSERT [dbo].[OrderDetails] ( [OrderId], [ProductId], [Price], [Quantity]) VALUES (5, 7, 1150000, 1)
INSERT [dbo].[OrderDetails] ( [OrderId], [ProductId], [Price], [Quantity]) VALUES (6, 8, 1450000, 6)
INSERT [dbo].[OrderDetails] ( [OrderId], [ProductId], [Price], [Quantity]) VALUES (7, 9, 1350000, 6)
INSERT [dbo].[OrderDetails] ( [OrderId], [ProductId], [Price], [Quantity]) VALUES (8, 10, 1700000, 6)
INSERT [dbo].[OrderDetails] ( [OrderId], [ProductId], [Price], [Quantity]) VALUES (9, 11, 1900000, 4)
INSERT [dbo].[OrderDetails] ( [OrderId], [ProductId], [Price], [Quantity]) VALUES (10, 12, 1190000, 4)
INSERT [dbo].[OrderDetails] ( [OrderId], [ProductId], [Price], [Quantity]) VALUES (11, 13, 1000000, 4)

SET IDENTITY_INSERT [dbo].[payment_method] ON 
INSERT [dbo].[payment_method] ([id], [description]) VALUES (1, N'THANH TOÁN SAU KHI NHẬN HÀNG')
INSERT [dbo].[payment_method] ([id], [description]) VALUES (2, N'THANH TOÁN TRƯỚC KHI NHẬN HÀNG')
SET IDENTITY_INSERT [dbo].[payment_method] OFF