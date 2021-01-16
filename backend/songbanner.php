<?php
	require "connect.php";

	$query = "SELECT QuangCao.Id , QuangCao.HinhAnh , QuangCao.NoiDung , QuangCao.IdBaiHat, baihat.TenBaiHat, baihat.HinhBaiHat FROM baihat, QuangCao WHERE QuangCao.IdBaiHat = baihat.IdBaiHat";
	$data = mysqli_query($con,$query);

	class Quangcao{
		function Quangcao($idquangcao,$hinhanh,$noidung,$idbaihat,$tenbaihat,$hinhbaihat){
			$this->IdQuangCao = $idquangcao;
			$this->HinhAnh = $hinhanh;
			$this->NoiDung = $noidung;
			$this->IdBaiHat = $idbaihat;
			$this->TenBaiHat = $tenbaihat;
			$this->HinhBaiHat = $hinhbaihat;
		}
	}
	$mangquangcao = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangquangcao, new Quangcao($row['Id']
												,$row['HinhAnh']
												,$row['NoiDung']
												,$row['IdBaiHat']
												,$row['TenBaiHat']
												,$row['HinhBaiHat']));
	}
	echo json_encode($mangquangcao);
?>