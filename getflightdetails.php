<?php
require_once 'android_login_connect.php';
        // connecting to database
        $db = new android_login_connect();
        $conn = $db->connect();
		
		$flight = array();
		$i=0;
		if(isset($_POST["aid"])){
		$routeid = $_POST["aid"];
		$stmt = $conn->prepare("SELECT * FROM flight_join WHERE aid = ?");
		$stmt->bind_param("i",$routeid);
        $stmt->execute();
        $stmt-> bind_result($token1,$token2,$token3,$token4,$token5,$token6);
		while ( $stmt-> fetch() ) {
				$flight[$i]["count"] = $token2;
               $flight[$i]["arrival"] = $token3;
			   $flight[$i]["departure"] = $token4;
			   $flight[$i]["flight number"] = $token5;
			   $flight[$i]["cost"] = $token6;
			   $i++;
            }
			$stmt->close();
			echo json_encode($flight);
			}
?>