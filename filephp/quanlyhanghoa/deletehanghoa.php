<?php
$db=mysqli_connect("localhost","root","","quanlyhanghoa");
	mysqli_set_charset($db, 'UTF8');
	$idhanghoa=$_POST['iddelete'];
	$sql="DELETE FROM hanghoa WHERE idhanghoa ='$idhanghoa' ";
	if (mysqli_query($db,$sql)) {
		echo "succes";
	}else{
		echo "error";
	}
?>
