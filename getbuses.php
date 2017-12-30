<?php
require_once 'android_login_connect.php';
        // connecting to database
        $db = new android_login_connect();
        $conn = $db->connect();
		$t = array();
		$bus_details = array();
		$i=0;
		if(isset($_POST['sid']))
		{
		$busid = $_POST["sid"];
		$stmt = $conn->prepare("SELECT bid FROM bus_join WHERE sid = ?");
		$stmt->bind_param("i",$busid);
		$stmt->execute();
        $stmt-> bind_result($token1);
		while ( $stmt-> fetch() ) {
			$t[$i] = $token1;
			$i++;
		}
		$stmt->close();
		for($j=0;$j<$i;$j++){
		$stmt1 = $conn->prepare("SELECT bno FROM bus_no WHERE bid = ?");
        $stmt1->bind_param("i",$t[$j]);
        $stmt1->execute();
        $stmt1-> bind_result($token2);
		while ( $stmt1-> fetch() ) {
               $bus_details["buses"][$j] = $token2;
            }
			$stmt1->close();
		}
		echo json_encode($bus_details);
		}
?>