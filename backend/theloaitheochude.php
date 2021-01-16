<?php
	require "connect.php";

	$idChuDe = $_POST['idchude'];
	$query = "SELECT * FROM theloai WHERE IdChuDe = '$idChuDe'";
	$data = mysqli_query($con, $query);
	class TheLoai{
		function TheLoai($idtheloai,$idchude,$tentheloai,$hinhtheloai){
			$this->IdTheLoai = $idtheloai;
			$this->IdChuDe = $idchude;
			$this->TenTheLoai = $tentheloai;
			$this->HinhTheLoai = $hinhtheloai;
		}
	}
	$arraytheloai = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($arraytheloai, new TheLoai($row['IdTheLoai']
												,$row['IdChuDe']
												,$row['TenTheLoai']
												,$row['HinhTheLoai']));
	}
	echo json_encode($arraytheloai);

?>