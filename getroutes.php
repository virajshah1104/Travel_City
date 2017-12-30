<?php
require_once 'android_login_connect.php';
        // connecting to database
        $db = new android_login_connect();
        $conn = $db->connect();
		
		$route = array();
		$i=0;
		if(isset($_POST['mid']))
		{
		$modeid = $_POST["mid"];
		$stmt = $conn->prepare("SELECT rname FROM routes WHERE mid = ?");
        $stmt->bind_param("i",$modeid);
        $stmt->execute();
        $stmt-> bind_result($token1);
		while ( $stmt-> fetch() ) {
               $route[$i] = $token1;
			   $i++;
            }
			$stmt->close();
			echo json_encode($route);
		}
?>