<?php
require_once 'android_login_connect.php';
        // connecting to database
        $db = new android_login_connect();
        $conn = $db->connect();
		$t = array();
		$train_details = array();
		$i=0;
		if(isset($_POST['msid']))
		{
		$stationid = $_POST["msid"];
		$stmt = $conn->prepare("SELECT tid,time FROM stationtrain_join WHERE msid = ?");
		$stmt->bind_param("i",$stationid);
		$stmt->execute();
        $stmt-> bind_result($token1,$token2);
		while ( $stmt-> fetch() ) {
			$t[$i] = $token1;
			$train[$i]["time"] = $token2;
			$i++;
		}
		$stmt->close();
		for($j=0;$j<$i;$j++){
		$stmt1 = $conn->prepare("SELECT start,end FROM mumbai_trains WHERE tid = ?");
        $stmt1->bind_param("i",$t[$j]);
        $stmt1->execute();
        $stmt1-> bind_result($token3,$token4);
		while ( $stmt1-> fetch() ) {
               $train[$j]["start"] = $token3;
			   $train[$j]["end"] = $token4;
            }
			$stmt1->close();
		}
		echo json_encode($train);
		}
?>