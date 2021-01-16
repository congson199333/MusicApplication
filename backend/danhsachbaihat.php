<?php
	require "connect.php";
	
	if(isset($_POST['idalbum'])){
	    $idalbum =$_POST['idalbum'];
	    $query = "SELECT * FROM baihat WHERE FIND_IN_SET('$idalbum',IdAlbum)";
    }
    
	if(isset($_POST['idtheloai'])){
		$idtheloai=$_POST['idtheloai'];
		$query = "SELECT * FROM baihat WHERE FIND_IN_SET('$idtheloai',IdTheLoai)";
	}

    if(isset($_POST['idplaylist'])){
        $idplaylist = $_POST['idplaylist'];
        $query = "SELECT * FROM baihat WHERE FIND_IN_SET('$idplaylist',IdPlayList)";
    }

    if(isset($_POST['idquangcao'])){
    	$idquangcao = $_POST['idquangcao'];
		$queryquangcao = "SELECT * FROM QuangCao WHERE Id = '$idquangcao'";
		$dataquangcao = mysqli_query($con,$queryquangcao);

		$rowquangcao = mysqli_fetch_assoc($dataquangcao);
		$id = $rowquangcao['IdBaiHat'];
		$query = "SELECT * FROM baihat WHERE IdBaiHat = '$id'";
	
    }

	
	$data = mysqli_query($con,$query);
	
	class Baihat{
	    function Baihat($idbaihat, $tenbaihat, $hinhbaihat, $casi, $linkbaihat, $luotthich){
	        $this->IdBaiHat = $idbaihat;
			$this->TenBaiHat = $tenbaihat;
			$this->HinhBaiHat = $hinhbaihat;
			$this->CaSi = $casi;
			$this->LinkBaiHat = $linkbaihat;
			$this->LuotThich = $luotthich;
	    }
	}
	$arraydanhsachbaihat = array();
	
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($arraydanhsachbaihat, new Baihat($row['IdBaiHat']
												,$row['TenBaiHat']
												,$row['HinhBaiHat']
												,$row['CaSi']
												,$row['LinkBaiHat']
												,$row['LuotThich']));
	}
	echo json_encode($arraydanhsachbaihat);


?>