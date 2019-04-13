<?php
header('Content-Type: application/json; charset=utf-8');
$db=mysqli_connect("localhost","root","","quanlyhanghoa");
mysqli_set_charset($db, 'UTF8');
$sql="SELECT * FROM taikhoan";
$result=mysqli_query($db,$sql);
while ($row=$result->fetch_assoc()){
    $mangtk []=array(
    	"idtaikhoan"=>$row['idtaikhoan'],
        "hoten"=>$row['hoten'],
        "username"=>$row['username'],
        "password"=>$row['password']
    );

}
$json = json_encode($mangtk, JSON_PRETTY_PRINT);
print_r($json);
