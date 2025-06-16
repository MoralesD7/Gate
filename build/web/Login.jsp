<%-- 
    Document   : Login
    Created on : 15 jun 2025, 5:46:04 p.m.
    Author     : omaralejandromoralesdiaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Iniciar Sesión</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="CSS/Login.css">
</head>
<body>
  <div class="login-container">
    <div class="login-box">
      <div class="left-side">
        <img src="Images/logo.png" alt="Reloj de arena" class="icono">
      </div>
      <div class="right-side">
        <h2 class="login-title">Iniciar Sesión</h2>
        <form action="LoginServlet" method="post">
          <label for="correo">Correo electrónico:</label>
          <input type="email" id="correo" name="correo" required>

          <label for="password">Contraseña:</label>
          <input type="password" id="password" name="password" required>

          <input class="btn" type="submit" value="Iniciar Sesión">
        </form>
      </div>
    </div>
  </div>
</body>
</html>
