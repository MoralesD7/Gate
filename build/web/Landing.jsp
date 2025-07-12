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
        <link rel="stylesheet" href="CSS/Landing.css">
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

        <main class="contenido">
            <h1 class="titulo">GaTe</h1>
            <p class="descripcion">
                Gate es un sistema creado para ayudar a mejorar la vida académica de los estudiantes. 
                De esta manera, podrán organizar mejor sus tiempos de estudio y aprender de una manera más eficiente.
            </p>
            <a class="boton" href="Horario.jsp">Empieza a crear tu horario</a>
        </main>
    </body>

</html>
