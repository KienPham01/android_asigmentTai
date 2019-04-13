<?php
header('Content-Type: application/json; charset=utf-8');
$db=mysqli_connect("localhost","root","","quanlyhanghoa");
mysqli_set_charset($db, 'UTF8');
$sql="SELECT * FROM hanghoa";
$result=mysqli_query($db,$sql);
while ($row=$result->fetch_assoc()){
    $manghh []=array(

    	"idhanghoa"=>$row['idhanghoa'],
        "tenhanghoa"=>$row['tenhanghoa'],
        "nhasanxuat"=>$row['nhasanxuat'],
        "loaihang"=>$row['loaihang'],
        "gia"=>$row['gia'],
        "tinhtrang"=>$row['tinhtrang']
    );

}
$json = json_encode($manghh, JSON_PRETTY_PRINT);
print_r($json);
