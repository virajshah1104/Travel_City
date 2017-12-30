<?php
require_once 'android_login_connect.php';
        // connecting to database
        $db = new android_login_connect();
        $conn = $db->connect();
		
		$bus = array();
		$i=0;
		$stmt = $conn->prepare("SELECT sname FROM bus_stop");
        $stmt->execute();
        $stmt-> bind_result($token1);
		while ( $stmt-> fetch() ) {
               $bus["stop"][$i] = $token1;
			   $i++;
            }
			$stmt->close();
			echo json_encode($bus);
?>