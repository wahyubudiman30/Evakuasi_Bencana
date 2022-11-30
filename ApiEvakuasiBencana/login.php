<?php 

require 'koneksi.php';

if($_SERVER['REQUEST_METHOD']=='POST'){
    
    $username = $_POST['username'];
    $password = $_POST['password'];
    
    $Sql_Query = "SELECT * FROM akun WHERE username = '$username' and password = '$password' ";
    
    $check = mysqli_fetch_array(mysqli_query($con,$Sql_Query));
    
    if(isset($check)){
        echo "Berhasil Login";
    }else{
        echo "Gagal Login";
    }
    
    }else{
    echo "Check Again";
    }
   mysqli_close($con);

?>