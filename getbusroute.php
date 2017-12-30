<?php
require_once 'android_login_connect.php';
        // connecting to database
        $db = new android_login_connect();
        $conn = $db->connect();
		$t = array();
		$bus_details = array();
		$i=0;
		if(isset($_POST['bid']))
		{
		$busid = $_POST["bid"];
		$stmt = $conn->prepare("SELECT sid FROM bus_join WHERE bid = ?");
		$stmt->bind_param("i",$busid);
		$stmt->execute();
        $stmt-> bind_result($token1);
		while ( $stmt-> fetch() ) {
			$t[$i] = $token1;
			$i++;
		}
		$stmt->close();
		for($j=0;$j<$i;$j++){
		$stmt1 = $conn->prepare("SELECT sname FROM bus_stop WHERE sid = ?");
        $stmt1->bind_param("i",$t[$j]);
        $stmt1->execute();
        $stmt1-> bind_result($token2);
		while ( $stmt1-> fetch() ) {
               $bus_details["stop"][$j] = $token2;
            }
			$stmt1->close();
		}
		echo json_encode($bus_details);
		}
?>