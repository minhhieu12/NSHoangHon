USE [BOOKSTORE]
GO
/****** Object:  User [hieu]    Script Date: 12/12/2020 12:56:13 PM ******/
CREATE USER [hieu] FOR LOGIN [hieu] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [hieu]
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_HD]    Script Date: 12/12/2020 12:56:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[AUTO_HD]()
RETURNS CHAR(5)
AS
BEGIN
	DECLARE @ID CHAR(5)
	IF (SELECT COUNT(MAHD) FROM HOADON) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(MAHD, 3)) FROM HOADON
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'HD00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'HD0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_NV]    Script Date: 12/12/2020 12:56:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[AUTO_NV]()
RETURNS CHAR(5)
AS
BEGIN
	DECLARE @ID CHAR(5)
	IF (SELECT COUNT(MANV) FROM NHANVIEN) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(MANV, 3)) FROM NHANVIEN
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'NV00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'NV0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_NXB]    Script Date: 12/12/2020 12:56:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[AUTO_NXB]()
RETURNS CHAR(5)
AS
BEGIN
	DECLARE @ID CHAR(5)
	IF (SELECT COUNT(MANXB) FROM NHAXB) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(MANXB, 3)) FROM NHAXB
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'XB00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'XB0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_PHIEUNHAP]    Script Date: 12/12/2020 12:56:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[AUTO_PHIEUNHAP]()
RETURNS CHAR(5)
AS
BEGIN
	DECLARE @ID CHAR(5)
	IF (SELECT COUNT(SOPHIEU) FROM PHIEUNHAP) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(SOPHIEU, 3)) FROM PHIEUNHAP
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'PN00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'PN0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_SACH]    Script Date: 12/12/2020 12:56:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[AUTO_SACH]()
RETURNS CHAR(5)
AS
BEGIN
	DECLARE @ID CHAR(5)
	IF (SELECT COUNT(MASACH) FROM SACH) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(MASACH, 3)) FROM SACH
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'SA00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'SA0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[AUTO_TL]    Script Date: 12/12/2020 12:56:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE FUNCTION [dbo].[AUTO_TL]()
RETURNS CHAR(5)
AS
BEGIN
	DECLARE @ID CHAR(5)
	IF (SELECT COUNT(MATL) FROM THELOAI) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(MATL, 3)) FROM THELOAI
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'TL00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'TL0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
/****** Object:  UserDefinedFunction [dbo].[fu_TINHTONGHOADON]    Script Date: 12/12/2020 12:56:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[fu_TINHTONGHOADON] 
(
	@SOHOADON char(5)
)
RETURNS money
AS
BEGIN
	declare @tongtien money

	select @tongtien = sum(CTHOADON.THANHTIEN)
	from HOADON, CTHOADON
	WHERE HOADON.MAHD = CTHOADON.SOHD and HOADON.MAHD = @SOHOADON

	return @tongtien
END
GO
/****** Object:  UserDefinedFunction [dbo].[FU_TINHTONKHO]    Script Date: 12/12/2020 12:56:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[FU_TINHTONKHO] 
(
	@MAHH CHAR(5)
)
RETURNS INT
AS
BEGIN
	DECLARE @SLTON INT
	SELECT @SLTON = SACH.SL + CTPHIEUNHAP.SL - CTHOADON.SOLUONG
	FROM SACH, CTPHIEUNHAP, CTHOADON
	WHERE SACH.MASACH = CTPHIEUNHAP.MASACH AND SACH.MASACH = CTHOADON.MASACH AND SACH.MASACH = @MAHH

	RETURN @SLTON
END
GO
/****** Object:  Table [dbo].[CTHOADON]    Script Date: 12/12/2020 12:56:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTHOADON](
	[SOHD] [char](5) NOT NULL,
	[MASACH] [char](5) NOT NULL,
	[SOLUONG] [int] NULL,
	[DONGIA] [int] NULL,
	[CHIETKHAU] [int] NULL,
	[THANHTIEN] [int] NULL,
 CONSTRAINT [PK_CTHOADON] PRIMARY KEY CLUSTERED 
(
	[SOHD] ASC,
	[MASACH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTPHIEUNHAP]    Script Date: 12/12/2020 12:56:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTPHIEUNHAP](
	[SOPHIEU] [char](5) NOT NULL,
	[MASACH] [char](5) NOT NULL,
	[DVT] [nchar](5) NULL,
	[SL] [int] NULL,
	[DONGIA] [int] NULL,
	[MANXB] [nvarchar](150) NULL,
	[CHIETKHAU] [int] NULL,
	[THANHTIEN] [int] NULL,
 CONSTRAINT [PK_CTPHIEUNHAP] PRIMARY KEY CLUSTERED 
(
	[SOPHIEU] ASC,
	[MASACH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOADON]    Script Date: 12/12/2020 12:56:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADON](
	[MAHD] [char](5) NOT NULL,
	[NGAYTAO] [date] NULL,
	[TONGTIEN] [int] NULL,
	[TENKH] [nvarchar](30) NULL,
	[DIACHI] [nvarchar](50) NULL,
	[SDT] [char](10) NULL,
 CONSTRAINT [PK_HOADON] PRIMARY KEY CLUSTERED 
(
	[MAHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHANVIEN]    Script Date: 12/12/2020 12:56:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHANVIEN](
	[MANV] [char](5) NOT NULL,
	[TENNV] [nchar](30) NULL,
	[GIOITINH] [bit] NULL,
	[NGAYSINH] [date] NULL,
	[QUEQUAN] [nchar](30) NULL,
	[CMND] [char](9) NULL,
	[SDT] [char](10) NULL,
	[EMAIL] [char](30) NULL,
	[CHUCVU] [nchar](10) NULL,
	[TENDN] [char](20) NULL,
	[MATKHAU] [char](20) NULL,
 CONSTRAINT [PK_NHANVIEN] PRIMARY KEY CLUSTERED 
(
	[MANV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHAXB]    Script Date: 12/12/2020 12:56:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHAXB](
	[MANXB] [nvarchar](5) NOT NULL,
	[TENNXB] [nchar](30) NULL,
	[DIACHI] [nchar](150) NULL,
	[SDT] [char](11) NULL,
	[EMAIL] [char](30) NULL,
 CONSTRAINT [PK_NHACUNGCAP] PRIMARY KEY CLUSTERED 
(
	[MANXB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PHIEUNHAP]    Script Date: 12/12/2020 12:56:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHIEUNHAP](
	[SOPHIEU] [char](5) NOT NULL,
	[NGAYNHAP] [date] NULL,
	[NVNHAP] [char](5) NULL,
	[GHICHU] [nvarchar](512) NULL,
 CONSTRAINT [PK_PHIEUNHAP] PRIMARY KEY CLUSTERED 
(
	[SOPHIEU] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SACH]    Script Date: 12/12/2020 12:56:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SACH](
	[MASACH] [char](5) NOT NULL,
	[TENSACH] [nvarchar](150) NULL,
	[TACGIA] [nvarchar](30) NULL,
	[THELOAI] [nvarchar](30) NULL,
	[NXB] [nchar](30) NULL,
	[DVT] [nchar](10) NULL,
	[SL] [int] NULL,
	[DONGIA] [int] NULL,
	[MATL] [nvarchar](5) NULL,
	[MANXB] [char](5) NULL,
 CONSTRAINT [PK_SACH] PRIMARY KEY CLUSTERED 
(
	[MASACH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[THELOAI]    Script Date: 12/12/2020 12:56:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[THELOAI](
	[MATL] [nvarchar](5) NOT NULL,
	[TENTL] [nvarchar](30) NULL,
 CONSTRAINT [PK_THELOAI] PRIMARY KEY CLUSTERED 
(
	[MATL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CTHOADON] ([SOHD], [MASACH], [SOLUONG], [DONGIA], [CHIETKHAU], [THANHTIEN]) VALUES (N'HD001', N'NGK03', 1, 100000, NULL, 100000)
GO
INSERT [dbo].[CTHOADON] ([SOHD], [MASACH], [SOLUONG], [DONGIA], [CHIETKHAU], [THANHTIEN]) VALUES (N'HD002', N'ShL01', 1, 500000, NULL, 500000)
GO
INSERT [dbo].[CTPHIEUNHAP] ([SOPHIEU], [MASACH], [DVT], [SL], [DONGIA], [MANXB], [CHIETKHAU], [THANHTIEN]) VALUES (N'SPN01', N'ShL01', N'bo   ', 5, 500000, N'XB008', NULL, 2500000)
GO
INSERT [dbo].[CTPHIEUNHAP] ([SOPHIEU], [MASACH], [DVT], [SL], [DONGIA], [MANXB], [CHIETKHAU], [THANHTIEN]) VALUES (N'SPN02', N'SGK23', N'cuon ', 10, 16000, N'XB004', NULL, 160000)
GO
INSERT [dbo].[CTPHIEUNHAP] ([SOPHIEU], [MASACH], [DVT], [SL], [DONGIA], [MANXB], [CHIETKHAU], [THANHTIEN]) VALUES (N'SPN03', N'NGK03', N'cuon ', 10, 100000, N'XB008', NULL, 1000000)
GO
INSERT [dbo].[HOADON] ([MAHD], [NGAYTAO], [TONGTIEN], [TENKH], [DIACHI], [SDT]) VALUES (N'HD001', CAST(N'2020-10-29' AS Date), 100000, N'Trần Văn Hiếu', N'Bình Dương', N'0346489037')
GO
INSERT [dbo].[HOADON] ([MAHD], [NGAYTAO], [TONGTIEN], [TENKH], [DIACHI], [SDT]) VALUES (N'HD002', CAST(N'2020-10-27' AS Date), 500000, N'Lê Văn Đạt', N'Bình Dương', N'0326488251')
GO
INSERT [dbo].[HOADON] ([MAHD], [NGAYTAO], [TONGTIEN], [TENKH], [DIACHI], [SDT]) VALUES (N'HD003', CAST(N'2020-10-31' AS Date), 48000, N'Nguyễn Hoàng Khang', N'Bình Dương', N'0356894789')
GO
INSERT [dbo].[NHANVIEN] ([MANV], [TENNV], [GIOITINH], [NGAYSINH], [QUEQUAN], [CMND], [SDT], [EMAIL], [CHUCVU], [TENDN], [MATKHAU]) VALUES (N'NV001', N'Trần Minh hiếu                ', 1, CAST(N'2000-08-12' AS Date), N'Bình Dương                    ', N'281231339', N'0346489037', N'hieuleggo1280@gmail.com       ', N'Admin     ', N'minhhieu            ', N'admin               ')
GO
INSERT [dbo].[NHANVIEN] ([MANV], [TENNV], [GIOITINH], [NGAYSINH], [QUEQUAN], [CMND], [SDT], [EMAIL], [CHUCVU], [TENDN], [MATKHAU]) VALUES (N'NV002', N'Lê Thành Đạt                  ', 1, CAST(N'2000-05-22' AS Date), N'Bình Dương                    ', N'281231338', N'0346489036', N'thanhdat@gmail.com            ', N'Bán hàng  ', N'thanhdat            ', N'banhang             ')
GO
INSERT [dbo].[NHANVIEN] ([MANV], [TENNV], [GIOITINH], [NGAYSINH], [QUEQUAN], [CMND], [SDT], [EMAIL], [CHUCVU], [TENDN], [MATKHAU]) VALUES (N'NV003', N'Phạm Minh Nghĩa               ', 1, CAST(N'2000-08-24' AS Date), N'Bình Phước                    ', N'281231337', N'0346489035', N'nghiaphamln3@gmail.com        ', N'Kho       ', N'minhnghia           ', N'kho                 ')
GO
INSERT [dbo].[NHAXB] ([MANXB], [TENNXB], [DIACHI], [SDT], [EMAIL]) VALUES (N'XB001', N'Kim Đồng                      ', N'55 Quang Trung, Hai Bà Trưng, Hà Nội                                                                                                                  ', N'02439434730', N'kimdong@hn.vnn.vn             ')
GO
INSERT [dbo].[NHAXB] ([MANXB], [TENNXB], [DIACHI], [SDT], [EMAIL]) VALUES (N'XB002', N'Trẻ                           ', N'161B Lý Chính Thắng, Phường 7, Quận 3, Thành phố Hồ Chí Minh                                                                                          ', N'02839316289', N'hopthubandoc@nxbtre.com.vn    ')
GO
INSERT [dbo].[NHAXB] ([MANXB], [TENNXB], [DIACHI], [SDT], [EMAIL]) VALUES (N'XB003', N'Tổng hợp TPHCM                ', N'62 Nguyễn Thị Minh Khai, Phường Đa Kao, Quận 1, TP.HCM                                                                                                ', N'02838225340', N'tonghop@nxbhcm.com.vn         ')
GO
INSERT [dbo].[NHAXB] ([MANXB], [TENNXB], [DIACHI], [SDT], [EMAIL]) VALUES (N'XB004', N'Giáo dục                      ', N'81 Trần Hưng Đạo, Hà Nội                                                                                                                              ', N'02438220801', NULL)
GO
INSERT [dbo].[NHAXB] ([MANXB], [TENNXB], [DIACHI], [SDT], [EMAIL]) VALUES (N'XB005', N'Lao động                      ', N'175 Giảng Võ, Đống Đa, Hà Nội                                                                                                                         ', N'02438515380', N'nxblaodong@yahoo.com          ')
GO
INSERT [dbo].[NHAXB] ([MANXB], [TENNXB], [DIACHI], [SDT], [EMAIL]) VALUES (N'XB006', N'ĐHQG Hà Nội                   ', N'16 Hàng Chuối, Phạm Đình Hổ, Hai Bà Trưng, Hà Nội                                                                                                     ', N'02439714896', NULL)
GO
INSERT [dbo].[NHAXB] ([MANXB], [TENNXB], [DIACHI], [SDT], [EMAIL]) VALUES (N'XB007', N'Nhã Nam                       ', N'59 Đỗ Quang, phường Trung Hoà, quận Cầu Giấy, Hà Nội                                                                                                  ', N'0903244248 ', N'bookstore@nhanam.vn           ')
GO
INSERT [dbo].[NHAXB] ([MANXB], [TENNXB], [DIACHI], [SDT], [EMAIL]) VALUES (N'XB008', N'Văn Học                       ', N'290/20 Nam Kỳ Khởi Nghĩa, phường 14, quận 3, Tp Hồ Chí Minh                                                                                           ', N'02838469858', N'info@nxbvanhoc.com.vn         ')
GO
INSERT [dbo].[PHIEUNHAP] ([SOPHIEU], [NGAYNHAP], [NVNHAP], [GHICHU]) VALUES (N'SPN01', CAST(N'2020-10-25' AS Date), N'NV003', NULL)
GO
INSERT [dbo].[PHIEUNHAP] ([SOPHIEU], [NGAYNHAP], [NVNHAP], [GHICHU]) VALUES (N'SPN02', CAST(N'2020-10-27' AS Date), N'NV003', NULL)
GO
INSERT [dbo].[PHIEUNHAP] ([SOPHIEU], [NGAYNHAP], [NVNHAP], [GHICHU]) VALUES (N'SPN03', CAST(N'2020-10-30' AS Date), N'NV003', NULL)
GO
INSERT [dbo].[PHIEUNHAP] ([SOPHIEU], [NGAYNHAP], [NVNHAP], [GHICHU]) VALUES (N'SPN04', CAST(N'2020-10-31' AS Date), N'NV003', NULL)
GO
INSERT [dbo].[SACH] ([MASACH], [TENSACH], [TACGIA], [THELOAI], [NXB], [DVT], [SL], [DONGIA], [MATL], [MANXB]) VALUES (N'SA002', N'Nhà Giả Kim', N'Paulo Coelho', N'Sách tham khảo', N'Trẻ                           ', N'cuốn      ', 100, 150000, NULL, NULL)
GO
INSERT [dbo].[SACH] ([MASACH], [TENSACH], [TACGIA], [THELOAI], [NXB], [DVT], [SL], [DONGIA], [MATL], [MANXB]) VALUES (N'SA004', N'Sherlock Holmes', N'Arthur Conan Doyle', N'Tiểu thuyết trinh thám', N'Văn Học                       ', N'bộ        ', 10, 500000, NULL, NULL)
GO
INSERT [dbo].[SACH] ([MASACH], [TENSACH], [TACGIA], [THELOAI], [NXB], [DVT], [SL], [DONGIA], [MATL], [MANXB]) VALUES (N'SA005', N'Harry Potter và hòn đá phù thuỷ', N'J.K.Rowling', N'Trẻ                           ', N'Tiểu thuyết                   ', N'cuốn      ', 10, 110000, NULL, NULL)
GO
INSERT [dbo].[SACH] ([MASACH], [TENSACH], [TACGIA], [THELOAI], [NXB], [DVT], [SL], [DONGIA], [MATL], [MANXB]) VALUES (N'SA006', N'Nỗi cô đơn của các số nguyên tố', N'Paolo Giordano', N'Sách giáo khoa', N'Giáo dục                      ', N'cuốn      ', 50, 98000, NULL, NULL)
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL001', N'Tiểu thuyết trinh thám')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL002', N'Tiểu thuyết kinh dị')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL003', N'Tiểu thuyết lãng mạn')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL004', N'Truyện tranh')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL005', N'Truyện ngắn Việt Nam')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL006', N'Truyện dài Việt Nam')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL007', N'Truyện ngắn nước ngoài')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL008', N'Truyện dài nước ngoài')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL009', N'Kinh Tế')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL010', N'Y học')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL011', N'Thiếu nhi')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL012', N'Kỹ thuật')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL013', N'Nghệ thuật')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL014', N'Kỹ năng sống')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL015', N'Chính trị')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL016', N'Sách giáo khoa')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL017', N'Sách tham khảo')
GO
INSERT [dbo].[THELOAI] ([MATL], [TENTL]) VALUES (N'TL018', N'Tiểu thuyết')
GO
ALTER TABLE [dbo].[HOADON] ADD  CONSTRAINT [DF_HOADON_MAHD]  DEFAULT ([dbo].[AUTO_HD]()) FOR [MAHD]
GO
ALTER TABLE [dbo].[NHANVIEN] ADD  CONSTRAINT [DF_NHANVIEN_MANV]  DEFAULT ([dbo].[AUTO_NV]()) FOR [MANV]
GO
ALTER TABLE [dbo].[NHAXB] ADD  CONSTRAINT [DF_NHAXB_MANXB]  DEFAULT ([dbo].[AUTO_NXB]()) FOR [MANXB]
GO
ALTER TABLE [dbo].[PHIEUNHAP] ADD  CONSTRAINT [DF_PHIEUNHAP_SOPHIEU]  DEFAULT ([dbo].[AUTO_PHIEUNHAP]()) FOR [SOPHIEU]
GO
ALTER TABLE [dbo].[SACH] ADD  CONSTRAINT [DF_SACH_MASACH]  DEFAULT ([dbo].[AUTO_SACH]()) FOR [MASACH]
GO
ALTER TABLE [dbo].[THELOAI] ADD  CONSTRAINT [DF_THELOAI_MATL]  DEFAULT ([dbo].[AUTO_TL]()) FOR [MATL]
GO
ALTER TABLE [dbo].[CTHOADON]  WITH CHECK ADD  CONSTRAINT [FK_CTHOADON_HOADON] FOREIGN KEY([SOHD])
REFERENCES [dbo].[HOADON] ([MAHD])
GO
ALTER TABLE [dbo].[CTHOADON] CHECK CONSTRAINT [FK_CTHOADON_HOADON]
GO
ALTER TABLE [dbo].[PHIEUNHAP]  WITH CHECK ADD  CONSTRAINT [FK_PHIEUNHAP_NHANVIEN] FOREIGN KEY([NVNHAP])
REFERENCES [dbo].[NHANVIEN] ([MANV])
GO
ALTER TABLE [dbo].[PHIEUNHAP] CHECK CONSTRAINT [FK_PHIEUNHAP_NHANVIEN]
GO
ALTER TABLE [dbo].[SACH]  WITH CHECK ADD  CONSTRAINT [FK_SACH_THELOAI] FOREIGN KEY([MATL])
REFERENCES [dbo].[THELOAI] ([MATL])
GO
ALTER TABLE [dbo].[SACH] CHECK CONSTRAINT [FK_SACH_THELOAI]
GO
