<?php
require_once 'android_login_connect.php';
        // connecting to database
        $db = new android_login_connect();
        $conn = $db->connect();
		
		$station = array();
		$i=0;
		if(isset($_POST['rid']))
		{
		$routeid = $_POST["rid"];
		$stmt = $conn->prepare("SELECT name FROM mumbai_stations WHERE rid = ?");
        $stmt->bind_param("i",$routeid);
        $stmt->execute();
        $stmt-> bind_result($token1);
		while ( $stmt-> fetch() ) {
               $station["stat"][$i] = $token1;
			   $i++;
            }
			$stmt->close();
			echo json_encode($station);
		}
?>