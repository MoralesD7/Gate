<%-- 
    Document   : Tarea
    Created on : 30 jun 2025, 1:02:33 a.m.
    Author     : omaralejandromoralesdiaz
--%>
<%
//obtengo el sesion y lo guardo en la referencia 
    
    HttpSession objsesion = request.getSession();
    //valido la sesion del usuario para estar dentro del generador 
    if(objsesion.getAttribute("alumno_validado")==null){
        %>
        <jsp:forward page="Login.jsp">
            <jsp:param name ="error" value="es necesario iniciar sesion"></jsp:param>
        </jsp:forward>
        <%
    }
    
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gate - Organiza tu tiempo</title>
        <link rel="stylesheet" href="CSS/Tarea.css">
    </head>
    <body>
        <header class="navbar">
            <a href="Landing.jsp" class="logo-btn active">
                <img src="Images/logo.png" alt="Logo" />
            </a>
            <div class="menu-container">
                <div class="menu-center">
                    <a href="Horario.jsp"><img src="Images/horario.png" alt="Horario" /></a>
                    <a href="Tarea.jsp"><img src="Images/tareas.png" alt="Tareas" /></a>
                    <a href="Calendario.jsp"><img src="Images/calendario.png" alt="Calendario" /></a>
                </div>
            </div>
            <div class="menu-side">
                <a href="Notificacion.jsp"><img src="Images/notificacion.png" alt="Notificaciones" /></a>
                <a href="Configuracion.jsp"><img src="Images/configuracion.png" alt="Configuración" /></a>
            </div>
        </header>

        <h1>Bienvenido a tu zona de tareas</h1>
    </body>

</html>
