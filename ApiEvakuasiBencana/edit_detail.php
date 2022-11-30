<?php

if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $username = $_POST['username'];
    $ttl = $_POST['ttl'];
    $jk = $_POST['jk'];
    $telepon = $_POST['telepon'];
    $jabatan = $_POST['jabatan'];
    $alamat = $_POST['alamat'];
    $email = $_POST['email'];
    $id = $_POST['id'];

    require_once 'connection.php';

    $sql = "UPDATE akun SET username='$username', ttl='$ttl', jk='$jk', telepon='$telepon', jabatan='$jabatan', alamat='$alamat', email='$email' WHERE id='$id' ";

    if(mysqli_query($conn, $sql)) {

          $result["success"] = "1";
          $result["message"] = "success";

          echo json_encode($result);
          mysqli_close($conn);
      }
  }

else{

   $result["success"] = "0";
   $result["message"] = "error!";
   echo json_encode($result);

   mysqli_close($conn);
}

?>


