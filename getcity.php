<?php
require_once 'android_login_connect.php';
        // connecting to database
        $db = new android_login_connect();
        $conn = $db->connect();
		$city = array();
		if(isset($_POST["cid"])){
		$cid = $_POST["cid"];
		$stmt = $conn->prepare("SELECT cname FROM city WHERE cid = ?");
		$stmt->bind_param("i",$cid);
        $stmt->execute();
        $stmt-> bind_result($token1);
		while ( $stmt-> fetch() ) {
               $city = $token1;
            }
			$stmt->close();
			echo json_encode($city);
			}
?>