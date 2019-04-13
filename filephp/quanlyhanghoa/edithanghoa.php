<?php 
	$db=mysqli_connect("localhost","root","","quanlyhanghoa");
	mysqli_set_charset($db, 'UTF8');
	$idhanghoa=$_POST['idedit'];
	$tenhanghoa=$_POST['tenedit'];
	$nhasanxuat=$_POST['nhasxedit'];
	$loaihang=$_POST['loaiedit'];
	$gia=$_POST['giaedit'];
	$tinhtrang=$_POST['tinhtrangedit'];
	$sql="UPDATE hanghoa SET tenhanghoa='$tenhanghoa',nhasanxuat='$nhasanxuat',loaihang='$loaihang',gia='$gia',tinhtrang='$tinhtrang' WHERE idhanghoa ='$idhanghoa' ";
	if (mysqli_query($db,$sql)) {
		echo "succes";
	}else{
		echo "error";
	}
?>