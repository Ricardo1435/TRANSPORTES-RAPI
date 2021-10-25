<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>      
        <title>LOGIN</title>
        <script src="https://kit.fontawesome.com/85601d370d.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="CSS/login.css">
        <link rel="icon" href="IMG/login.png">

</head>  
<body>
    <style type="text/css">
            body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
            background: url(IMG/fondo.jpg);
            background-size: cover;
            background-attachment: fixed;
            }
    </style>
    <form class="formulario" action="ControladorUsuario">
        <center><img src="IMG/login3.png" height="80" width="80"></center>
        <h1>BIENVENIDO</h1>
     <div class="contenedor">
         <div class="input-contenedor">
         <i class="fas fa-envelope icon"></i>
         <input type="email" autocomplete="off" name="txtcorreo" placeholder="ejemplo@gmail.com" required>
         </div>
         <div class="input-contenedor">
         <i class="fas fa-key icon"></i>
          <input type="password" autocomplete="off" name="txtcontra" placeholder="Contraseña" required>
         </div>
         <button type="submit" name="accion" id="ingresar" value="Ingresar">INGRESAR</button><br> 
         <p>Al registrarte, aceptas nuestras Condiciones de Uso y Política de Privacidad.</p>
         <p>¿No tienes una cuenta? <a class="link" href="registro.jsp">Registrate </a></p>
     </div>
    </form>
</body>
</html>