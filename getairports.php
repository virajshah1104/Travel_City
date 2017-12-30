<?php
require_once 'android_login_connect.php';
        // connecting to database
        $db = new android_login_connect();
        $conn = $db->connect();
		
		$flight = array();
		$i=0;
		if(isset($_POST["rid"])){
		$routeid = $_POST["rid"];
		$stmt = $conn->prepare("SELECT aname FROM mumbai_airport WHERE rid = ?");
		$stmt->bind_param("i",$routeid);
        $stmt->execute();
        $stmt-> bind_result($token1);
		while ( $stmt-> fetch() ) {
               $flight["airport"][$i] = $token1;
			   $i++;
            }
			$stmt->close();
			echo json_encode($flight);
			}
?>