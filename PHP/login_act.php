<?php
	session_start();
	include 'koneksi.php';
	// include 'password.php';

	$email = $_POST['email'];
	$pass = $_POST['password'];
	// $db_pass = mysqli_query($koneksi, "select password from users where username = '$username'");
	// $res_db_pass = mysqli_fetch_array($db_pass);
	// $string_pass = implode("",$res_db_pass);
	// $saved_pass = substr($string_pass,0,60);	

	$query = mysqli_query($koneksi, "SELECT * FROM users WHERE email='$email' AND password='$pass'")or die(mysql_error());
		if(mysqli_num_rows($query)==0){
			echo "<script>alert('Username dan Password tidak valid.'); window.location = 'login.php'</script>";
		}else{
			$_SESSION['email']=$email;
			$_SESSION['masuk']=TRUE;
			$row=mysqli_fetch_assoc($query);
			$_SESSION['nama']=$row['nama'];
            $_SESSION['role_id']=$row['role_id'];
            $_SESSION['no_hp']=$row['no_hp'];
			
			if ($row['role_id']==1) {
				echo "<script>alert('Selamat datang'); window.location = 'index.php'</script>";	
			}
			if ($row['role_id']==2) {
				echo "<script>alert('Selamat datang $username'); window.location = 'admin-kantin/index.php'</script>";
			}else{
			echo "<script>alert('Username dan Password tidak valid.'); window.location = 'login.php'</script>";
			}
		}	
	
?>


  
