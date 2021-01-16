<?php
    require "connect.php";

    $luotthich=$_POST["luotthich"];
    $idbaihat=$_POST["idbaihat"];
    $query = "SELECT LuotThich FROM baihat WHERE IdBaiHat = '$idbaihat'";
    
    $data = mysqli_query($con,$query);
    $row = mysqli_fetch_assoc($data);
    $tongluotthich=$row['LuotThich'];
    if(isset($luotthich)){
        $tongluotthich += $luotthich;
        $querysum = "UPDATE baihat SET LuotThich= '$tongluotthich' WHERE IdBaiHat = '$idbaihat'";
        $dataupdate = mysqli_query($con, $querysum);
        if ($dataupdate) {
            echo "Success";
        }else
            echo "False";
    }
?>