<%-- 
    Document   : Login
    Created on : 15 jun 2025, 5:46:04 p.m.
    Author     : omaralejandromoralesdiaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
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
                    <h2 class="login-title">Bienvenido</h2>
                    <form action="LoginServlet" method="post">
                        <label for="email">Correo electrónico:</label>
                        <input type="email" id="email" name="email" required>
                        <div name="advertencia">
                            <%
                                if (request.getAttribute("email_erroneo") != null) {
                                    out.print(request.getAttribute("email_erroneo"));
                                }
                            %>
                        </div>
                        <label for="password">Contraseña:</label>
                        <input type="password" id="password" name="password" required>
                        <div name="advertencia">
                            <%
                                if (request.getAttribute("password_erronea") != null) {
                                    out.print(request.getAttribute("password_erronea"));
                                }
                            %>
                        </div>
                        <input class="btn" type="submit" value="Iniciar Sesión">
                    </form>

                    <!-- Enlace al ServletRegistro -->
                    <div class="registro-link" style="margin-top: 15px; text-align: center; font-size: 14px;">
                        ¿No tienes cuenta? <a href="Registro.jsp">Regístrate aquí</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
