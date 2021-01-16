<?php
	require "connect.php";

	$query = "SELECT DISTINCT * FROM playlist ORDER BY rand(" . date("Ymd") . ") LIMIT 4";
    
    $data = mysqli_query($con,$query);

	class PlaylistToday{
		function PlaylistToday($idplaylist,$ten,$hinh,$icon){
			$this->IdPlayList = $idplaylist;
			$this->Ten = $ten;
			$this->Hinhnen = $hinh;
			$this->Hinhicon = $icon;
		}
	}
	
	$arrayplaylistfortoday = array();

	while ($row = mysqli_fetch_assoc($data)) {
		array_push($arrayplaylistfortoday, new PlaylistToday($row['IdPlayList']
												,$row['Ten']
												,$row['Hinhnen']
												,$row['Hinhicon']));
	}
	echo json_encode($arrayplaylistfortoday);
	
?>