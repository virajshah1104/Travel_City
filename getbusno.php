<?php
require_once 'android_login_connect.php';
        // connecting to database
        $db = new android_login_connect();
        $conn = $db->connect();
		
		$bus = array();
		$i=0;
		$stmt = $conn->prepare("SELECT bno,start,end FROM bus_no");
        $stmt->execute();
        $stmt-> bind_result($token1,$token2,$token3);
		while ( $stmt-> fetch() ) {
               $bus[$i]["number"] = $token1;
			   $bus[$i]["start"] = $token2;
			   $bus[$i]["end"] = $token3;
			   $i++;
            }
			$stmt->close();
			echo json_encode($bus);
?>