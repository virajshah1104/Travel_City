<?php
require_once 'android_login_connect.php';
        // connecting to database
        $db = new android_login_connect();
        $conn = $db->connect();
		
		$city = array();
		$i=0;
		if(isset($_POST['cid']))
		{
	$cityid = $_POST["cid"];
	$stmt = $conn->prepare("SELECT mname FROM modes WHERE cid = ?");
        $stmt->bind_param("i",$cityid);
        $stmt->execute();
        $stmt-> bind_result($token1);
		while ( $stmt-> fetch() ) {
               $city[$i] = $token1;
			   $i++;
            }
			$stmt->close();
			echo json_encode($city);
		}
?>