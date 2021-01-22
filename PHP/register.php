<?php
  include 'header.php';
?>
    <div class="register">
      <h2>Register</h2>
        <form action="regis_act.php" method="POST">
          <input type="text" name="nama" placeholder="Nama Lengkap" />
        	<input type="email" name="email" placeholder="Email" />
          <input type="text" name="no_hp" placeholder="Nomor Handphone" />
          <input type="text" name="nomor_ktp" placeholder="Nomor KTP" />
      		<input type="password" name="password" placeholder="Password"/>
          <input type="password" name="konfirmpass" placeholder="Ulang Password"/>
          <input type="submit" value="Daftar" name="daftar" />
            <div class="utilities">
              <a>Sudah punya akun?</a>
              <a href="index.php">Login disini! &rarr;</a>
            </div>
        </form>
    </div>