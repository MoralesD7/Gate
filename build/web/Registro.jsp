<%-- 
    Document   : Registro
    Created on : 14 jun 2025, 8:38:58 p.m.
    Author     : omaralejandromoralesdiaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
      <meta charset="UTF-8">
    <title>Registro - Gate</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Fuente cursiva desde Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script&display=swap" rel="stylesheet">
    
    <link rel="stylesheet" href="CSS/Registro.css">
    </head>
    <body>
        <div class="container">
        <!-- Lado izquierdo -->
        <div class="left">
            <h1 class="logo-text">GaTe</h1>
            <img class="hourglass" src="Images/logo.png" alt="Reloj de arena">
        </div>

        <!-- Lado derecho -->
        <div class="right">
            <div class="form-box">
                <div class="form-header">
                    <h2>Bienvenido</h2>
                </div>
                <form action="RegistroServlet" method="post" id="Formulario">
                    <label for="matricula">Matrícula:</label>
                    <input type="text" id="matricula" name="matricula">
                    <span id="matricula_js"></span>

                    <label for="nombre">Nombre(s):</label>
                    <input type="text" id="nombre" name="nombre">
                    <span id="nombre_js"></span>

                    <label for="apellido">Apellidos:</label>
                    <input type="text" id="apellido" name="apellido">
                    <span id="apellido_js"></span>

                    <label for="email">Correo electrónico:</label>
                    <input type="email" id="email" name="email">
                    <span id="email_js"></span>

                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password">
                    <span id="contraseña_js"></span>
                    <div name="advertencia">
                        <%
                            //validacion de email usado
                            if(request.getAttribute("advertencia") != null){
                              out.print(request.getAttribute("advertencia"));  
                            }
                        %>
                    </div>

                    <input class="btn" type="submit" value="Registrarme">
                </form>
                <div class="login-link">
                    <a href="/Gate/Login.jsp">Ya tengo una cuenta</a>
                </div>
            </div>
        </div>
    </div>

    <script src="JS/Validacion_registro.js"></script>
    </body>
</html>