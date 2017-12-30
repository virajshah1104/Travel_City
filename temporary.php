<?php
require_once 'android_login_connect.php';
        // connecting to database
        $db = new android_login_connect();
        $conn = $db->connect();
		
		$station = array();
		$i=0;
		if(isset($_POST['tid']))
		{
		$routeid = $_POST["tid"];
		$stmt = $conn->prepare("SELECT start,end FROM mumbai_trains WHERE tid = ?");
        $stmt->bind_param("i",$routeid);
        $stmt->execute();
        $stmt-> bind_result($token1,$token2);
		while ( $stmt-> fetch() ) {
               $station[$i]["1"] = $token1;
			   $station[$i]["2"] = $token2;
			   $i++;
            }
			$stmt->close();
			echo json_encode($station);
		}
?>