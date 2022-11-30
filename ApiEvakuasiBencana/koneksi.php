<?php 
 define('HOST','localhost');
 define('USER','root');
 define('PASS','');
 define('DB','evakuasi_bencana');
 
 //membuat koneksi dengan database
 $conn = mysqli_connect("localhost", "root", "", "evakuasi_bencana");
 $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');