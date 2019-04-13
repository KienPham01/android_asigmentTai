<?php 
	$db=mysqli_connect("localhost","root","","quanlyhanghoa");
	mysqli_set_charset($db, 'UTF8');
	$tenhanghoa=$_POST['tenHH'];
	$nhasanxuat=$_POST['nhasxHH'];
	$loaihang=$_POST['loaiHH'];
	$gia=$_POST['giaHH'];
	$tinhtrang=$_POST['tinhtrangHH'];
	$sql="INSERT INTO hanghoa VALUES (null,'$tenhanghoa','$nhasanxuat','$loaihang','$gia','$tinhtrang')";
	if (mysqli_query($db,$sql)) {
		echo "succes";
	}else{
		echo "error";
	}
?>