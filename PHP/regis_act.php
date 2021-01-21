<?php
	include 'koneksi.php';
	// include 'password.php';
		$email = $_POST['email'];
		$password = $_POST['password'];
		$nama = $_POST['nama'];
		$no_hp = $_POST['no_hp'];
		$nomor_ktp = $_POST['nomor_ktp'];
		$role_id = 1;
		$konpass = $_POST['konfirmpass'];
		if(empty($nama) || empty($password) || empty($konpass))
		{
			echo "<script>alert('Data yang diisi belum lengkap'); window.location = 'register.php'</script>";
		}
		else
		{
			if($password == $konpass){
				$query = mysqli_query($koneksi, "SELECT * FROM users WHERE email='$email'");
				$hasil = mysqli_num_rows($query);
				if($hasil == NULL){
					mysqli_query($koneksi, "INSERT INTO users VALUES('$email', '$password', '$nomor_ktp', '$nama', '$no_hp', '$role_id')");
				echo "<script>alert('Daftar Berhasil $nama, Silahkan login'); window.location = 'login.php'</script>";
				}
				else
				{
				echo "<script>alert('Email pengguna sudah terdaftar!'); window.location = 'register.php'</script>";
				}
			}
			else{
				echo "<script>alert('Password tidak sama!'); window.location = 'register.php'</script>";			
			}
		}
?>