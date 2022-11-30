<?php

if ($_SERVER['REQUEST_METHOD']=='POST') {
    
    $id = $_POST['id'];

    require_once 'connection.php';

    $sql = "SELECT * FROM akun WHERE id='$id' ";

    $response = mysqli_query($con, $sql);

    $result = array();
    $result['read'] = array();

    if( mysqli_num_rows($response) === 1 ) {
        
        if ($row = mysqli_fetch_assoc($response)) {
 
             $h['username'] = $row['username'] ;
             $h['ttl'] = $row['ttl'] ;
             $h['jk'] = $row['jk'] ;
             $h['telepon'] = $row['telepon'] ;
             $h['jabatan'] = $row['jabatan'] ;
             $h['alamat'] = $row['alamat'] ;
             $h['email'] = $row['email'] ;
 
             array_push($result["read"], $h);
 
             $result["success"] = "1";
             echo json_encode($result);
        }
 
   }
 
 }else {
 
     $result["success"] = "0";
     $result["message"] = "Error!";
     echo json_encode($result);
 
     mysqli_close($conn);
 }
 
 ?>