-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th1 16, 2021 lúc 05:30 PM
-- Phiên bản máy phục vụ: 10.3.16-MariaDB
-- Phiên bản PHP: 7.3.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `id13151175_mp3zing`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `album`
--

CREATE TABLE `album` (
  `IdAlbum` int(11) NOT NULL,
  `TenAlbum` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `TenCaSiAlbum` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HinhAlbum` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `album`
--

INSERT INTO `album` (`IdAlbum`, `TenAlbum`, `TenCaSiAlbum`, `HinhAlbum`) VALUES
(1, 'Đom Đóm (Single)', 'Jack', 'https://stadsneakers.000webhostapp.com/Hinhanh/Album/domdom.jpg'),
(2, 'Đi Để Trở Về', 'SOOBIN Hoàng Sơn', 'https://stadsneakers.000webhostapp.com/Hinhanh/Album/chuyendicuanam.png'),
(3, 'Góc Nhỏ Trong Tim', 'Khởi My', 'https://stadsneakers.000webhostapp.com/Hinhanh/Album/gocnhotrongtimalbum.jpg'),
(4, 'Ngàn Nỗi Nhớ Gửi Đến Em', 'The Men', 'https://stadsneakers.000webhostapp.com/Hinhanh/Album/albumthemen.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baihat`
--

CREATE TABLE `baihat` (
  `IdBaiHat` int(11) NOT NULL,
  `IdAlbum` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `IdTheLoai` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `IdPlayList` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `TenBaiHat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HinhBaiHat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `CaSi` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `LinkBaiHat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `LuotThich` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `baihat`
--

INSERT INTO `baihat` (`IdBaiHat`, `IdAlbum`, `IdTheLoai`, `IdPlayList`, `TenBaiHat`, `HinhBaiHat`, `CaSi`, `LinkBaiHat`, `LuotThich`) VALUES
(1, '1', '0', '2', 'Đom Đóm', 'https://stadsneakers.000webhostapp.com/Hinhanh/Album/domdom.jpg', 'Jack', 'https://musicapplication19021999.000webhostapp.com/Dom%20Dom%20-%20Jack.mp3', 4),
(2, '0', '1', '1', 'Nàng Thơ... Trời Giấu Trời Mang Đi', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/nangtho_tgtmd.jpg', 'AMEE, Hoàng Dũng', 'https://musicapplication19021999.000webhostapp.com/NangThoTroiGiauMangDi-AMeeHoang.mp3', 7),
(3, '0', '0', '1', 'Vì Yêu Cứ Đâm Đầu', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/vycdd.jpg', 'MIN, Đen, JustaTee', 'https://musicapplication19021999.000webhostapp.com/ViYeuCuDamDau.mp3', 37),
(4, '0', '0', '5', 'Vay Em Vài Ngày', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/vayemvaingaybaihat.jpg', 'Đức Uri, Masew, Grammy', 'https://musicapplication19021999.000webhostapp.com/vayemvaingay.mp3', 4),
(5, '0', '0', '0', 'Người Anh Yêu Nhất', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/nguoianhyeunhat.jpg', 'Đinh Đại Vũ', 'https://musicapplication19021999.000webhostapp.com/Nguoianhyeunhat.mp3', 0),
(6, '0', '7', '3', 'Thiên Đàng', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/thiendang.jpg', 'Wowy, JoliPoli', 'https://musicapplication19021999.000webhostapp.com/thiendang.mp3', 1),
(7, '0', '0', '4', 'Lại Nhớ Người Yêu', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/top100boleroicon.jpg', 'Lưu Ánh Loan, Đoàn Minh', 'https://musicapplication19021999.000webhostapp.com/Lai-Nho-Nguoi-Yeu-Luu-Anh-Loan-Doan-Minh.mp3', 0),
(8, '0', '4', '0', 'Tết Này Con Không Về', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/tetnayconkhongve.jpg', 'Thanh Hưng', 'https://musicapplication19021999.000webhostapp.com/Tetnayconkhongve.mp3', 0),
(9, '0', '4', '0', 'Tết Xa', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/tetxabaouyen.jpg', 'Bảo Uyên', 'https://musicapplication19021999.000webhostapp.com/Tet-Xa-Bao-Uyen.mp3', 0),
(10, '0', '4', '5', 'Đi Để Trở Về 5', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/didetrovo5.jpg', 'Hương Tràm, Tiên Cookie', 'https://musicapplication19021999.000webhostapp.com/Didetrove5.mp3', 0),
(11, '0', '3', '3', 'Cả Ngàn Lời Chúc', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/canganloichuc.jpg', 'Rhymastic, Suboi', 'https://musicapplication19021999.000webhostapp.com/Canganloichuc.mp3', 0),
(12, '2', '3', '2,1', 'Chuyến Đi Của Năm', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/chuyendicuanam.png', 'SOOBIN', 'https://musicapplication19021999.000webhostapp.com/Chuyendicuanam.mp3', 2),
(13, '2', '3', '2', 'Đi Để Trở Về', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/didetrove.jpg', 'SOOBIN', 'https://musicapplication19021999.000webhostapp.com/didetrove.mp3', 22),
(14, '0', '3', '0', 'Lắng Nghe Mùa Xuân Về', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/langnghemuaxuanve.jpg', 'Đạt G, DuUyen', 'https://musicapplication19021999.000webhostapp.com/Langnghemuaxuanve.mp3', 0),
(15, '0', '2', '5', 'Con Bướm Xuân', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/conbuomxuan.jpg', 'Hồ Quang Hiếu', 'https://musicapplication19021999.000webhostapp.com/Con-Buom-Xuan-Ho-Quang-Hieu.mp3', 0),
(16, '0', '2', '0', 'Cánh Thiệp Đầu Xuân', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/Canhthiepdauxuan.jpg', 'Phương Anh', 'https://musicapplication19021999.000webhostapp.com/canhthiepdauxuan.mp3', 0),
(17, '0', '6', '0', 'Kiss The Rain', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/kisstherain.jpg', 'Yiruma', 'https://musicapplication19021999.000webhostapp.com/KisstheRain.mp3', 0),
(18, '0', '6', '0', 'Rain Kwai', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/rainkwai.jpg', 'Jin Shi', 'https://musicapplication19021999.000webhostapp.com/RainKwai.mp3', 0),
(19, '0', '5', '0', 'Anh Cứ Đi Đi (Piano Cover)', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/Anhcudidi.jpg', 'Phạm Thế Anh', 'https://musicapplication19021999.000webhostapp.com/Anh-Cu-Di-Di-Piano-Cover-Pham-The-Anh.mp3', 1),
(20, '0', '5', '0', 'Chờ Người Nơi Ấy (Piano Cover)', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/chonguoinoiay.jpg', 'An Coong', 'https://musicapplication19021999.000webhostapp.com/Cho-Nguoi-Noi-Ay-Piano-Cover-An-Coong.mp3', 1),
(21, '0', '1', '1', 'Phố Không Em', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/phokhongem.jpg', 'Thái Đinh', 'https://musicapplication19021999.000webhostapp.com/Pho-Khong-Em-Thai-Dinh.mp3', 1),
(22, '0', '1', '1', 'Yêu Được Không (Cover)', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/yeuduockhonghuonglycover.jpg', 'Hương Ly', 'https://musicapplication19021999.000webhostapp.com/yeudcko.mp3', 0),
(23, '0', '7', '3', 'Say Em', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/sayem.jpg', 'QNT, Refund Band', 'https://musicapplication19021999.000webhostapp.com/Sayem.mp3', 58),
(24, '1', '0', '2', 'Hoa Hải Đường', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/hoahaiduong.jpg', 'Jack', 'https://musicapplication19021999.000webhostapp.com/hoahaiduong.mp3', 0),
(25, '3', '0', '0', 'Góc Nhỏ Trong Tim', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/gocnhotrongtim.jpg', 'Khởi My', 'https://musicapplication19021999.000webhostapp.com/Goc-Nho-Trong-Tim-Khoi-My.mp3', 0),
(26, '3', '0', '0', 'Miss You Need You', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/gocnhotrongtim.jpg', 'Khởi My', 'https://musicapplication19021999.000webhostapp.com/Miss-You-Need-You-Khoi-My.mp3', 0),
(27, '4', '0', '0', 'Nếu Là Anh', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/Neulaanh.jpg', 'The Men', 'https://musicapplication19021999.000webhostapp.com/Neu-La-Anh-The-Men.mp3', 0),
(28, '4', '0', '0', 'Ngàn Nổi Nhớ Gửi Đến Em', 'https://stadsneakers.000webhostapp.com/Hinhanh/Baihat/ngannoinhoguidenem.jpg', 'The Men', 'https://musicapplication19021999.000webhostapp.com/Ngan-Noi-Nho-Gui-Den-Em-The-Men.mp3', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chude`
--

CREATE TABLE `chude` (
  `IdChuDe` int(11) NOT NULL,
  `TenChuDe` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HinhChuDe` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chude`
--

INSERT INTO `chude` (`IdChuDe`, `TenChuDe`, `HinhChuDe`) VALUES
(1, 'Acoustic', 'https://stadsneakers.000webhostapp.com/Hinhanh/Chude/acoustic.jpg'),
(2, 'Nhạc Xuân 2021', 'https://stadsneakers.000webhostapp.com/Hinhanh/Chude/Chudenhacxuan.jpg'),
(3, 'Piano', 'https://stadsneakers.000webhostapp.com/Hinhanh/Chude/Piano.jpg'),
(4, 'Hip-Hop', 'https://stadsneakers.000webhostapp.com/Hinhanh/Chude/hiphopchude.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `playlist`
--

CREATE TABLE `playlist` (
  `IdPlayList` int(11) NOT NULL,
  `Ten` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Hinhnen` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Hinhicon` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `playlist`
--

INSERT INTO `playlist` (`IdPlayList`, `Ten`, `Hinhnen`, `Hinhicon`) VALUES
(1, 'Playlist Này Chill Phết', 'https://stadsneakers.000webhostapp.com/Hinhanh/Playlist/backgroundplaylistchill.jpg', 'https://stadsneakers.000webhostapp.com/Hinhanh/Playlist/playlistnaychillphet.jpg'),
(2, 'Top 100 Nhạc V-Pop Hay Nhất', 'https://stadsneakers.000webhostapp.com/Hinhanh/Playlist/top100banner.jpg', 'https://stadsneakers.000webhostapp.com/Hinhanh/Playlist/top100icon.jpg'),
(3, 'Top 100 Nhạc Rap Việt Nam Hay Nhất', 'https://stadsneakers.000webhostapp.com/Hinhanh/Playlist/background-top100rapviet.jpg', 'https://stadsneakers.000webhostapp.com/Hinhanh/Playlist/top100rapvieticon.jpg'),
(4, 'Top 100 Nhạc Quê Hương Hay Nhất', 'https://stadsneakers.000webhostapp.com/Hinhanh/Playlist/top100bolerobackground.jpg', 'https://stadsneakers.000webhostapp.com/Hinhanh/Playlist/quehuongtop100.jpg'),
(5, 'Nhạc VIP Chọn Lọc', 'https://stadsneakers.000webhostapp.com/Hinhanh/Playlist/playlistnhacvipchonloc.jpg', 'https://stadsneakers.000webhostapp.com/Hinhanh/Playlist/iconnhacvipchonloc.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `QuangCao`
--

CREATE TABLE `QuangCao` (
  `Id` int(11) NOT NULL,
  `HinhAnh` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NoiDung` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `IdBaiHat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `QuangCao`
--

INSERT INTO `QuangCao` (`Id`, `HinhAnh`, `NoiDung`, `IdBaiHat`) VALUES
(1, 'https://stadsneakers.000webhostapp.com/Hinhanh/Quangcao/vayemvaingay.jpg', 'Màn kết hợp giữa Đức Uri và Masew trong ca khúc với cái tên mới lạ', 4),
(2, 'https://stadsneakers.000webhostapp.com/Hinhanh/Quangcao/backgroundnguoianhyeunhat.jpg', 'Người Anh Yêu Nhất - ca khúc mới đầy cảm xúc từ Đinh Đại Vũ, chỉ có trên Zing MP3', 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `theloai`
--

CREATE TABLE `theloai` (
  `IdTheLoai` int(11) NOT NULL,
  `IdChuDe` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `TenTheLoai` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `HinhTheLoai` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `theloai`
--

INSERT INTO `theloai` (`IdTheLoai`, `IdChuDe`, `TenTheLoai`, `HinhTheLoai`) VALUES
(1, '1', 'Acoustic V-Pop', 'https://stadsneakers.000webhostapp.com/Hinhanh/Theloai/acousticvpop.jpg'),
(2, '2', 'Chào Xuân Mới 2021', 'https://stadsneakers.000webhostapp.com/Hinhanh/Theloai/theloaichaoxuan2021.jpg'),
(3, '2', 'Câu Chuyện Ngày Tết', 'https://stadsneakers.000webhostapp.com/Hinhanh/Theloai/Cauchuyenngaytet.jpg'),
(4, '2', 'Xuân Lắng Đọng', 'https://stadsneakers.000webhostapp.com/Hinhanh/Theloai/Xuanlangdong.jpg'),
(5, '3', 'Piano Cover', 'https://stadsneakers.000webhostapp.com/Hinhanh/Theloai/pianocover.jpg'),
(6, '3', 'Coffee & Radio', 'https://stadsneakers.000webhostapp.com/Hinhanh/Theloai/coffeeandradio.jpg'),
(7, '4', 'Rap Việt Nghe Là Ghiền', 'https://stadsneakers.000webhostapp.com/Hinhanh/Theloai/rapvietnghelaghien.jpg');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`IdAlbum`);

--
-- Chỉ mục cho bảng `baihat`
--
ALTER TABLE `baihat`
  ADD PRIMARY KEY (`IdBaiHat`);

--
-- Chỉ mục cho bảng `chude`
--
ALTER TABLE `chude`
  ADD PRIMARY KEY (`IdChuDe`);

--
-- Chỉ mục cho bảng `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`IdPlayList`);

--
-- Chỉ mục cho bảng `QuangCao`
--
ALTER TABLE `QuangCao`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`IdTheLoai`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `album`
--
ALTER TABLE `album`
  MODIFY `IdAlbum` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `baihat`
--
ALTER TABLE `baihat`
  MODIFY `IdBaiHat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT cho bảng `chude`
--
ALTER TABLE `chude`
  MODIFY `IdChuDe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `playlist`
--
ALTER TABLE `playlist`
  MODIFY `IdPlayList` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `QuangCao`
--
ALTER TABLE `QuangCao`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `theloai`
--
ALTER TABLE `theloai`
  MODIFY `IdTheLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
