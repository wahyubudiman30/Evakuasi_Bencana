<?php
header('content-type: application/json');

require_once 'connection.php';

$query = "SELECT * FROM akun";
$res = mysqli_query($conn,$query);

$json_data = array();
while($row = mysqli_fetch_assoc($res)){
    $json_data[] = $row;
}
echo json_encode($json_data);

?>