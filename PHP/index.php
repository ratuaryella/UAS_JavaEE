<?php
  require_once('header.php');
?>

</script>
<div class="login">
    <h2>Login</h2>
    <form action="login_act.php" method="POST">
    	<input type="text" name="email" placeholder="Email" />
  		<input type="password" name="password" placeholder="Password"/>
      <div class="form-group"> 
  <input type="submit" value="Login"/>
  <div class="utilities">
    <a>Belum punya akun?</a>
    <a href="register.php">Daftar disini! &rarr;</a>
  </div>
</div>

</form>