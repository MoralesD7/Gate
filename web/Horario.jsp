<%@page import="java.util.ArrayList"%>
<%
//obtengo el sesion y lo guardo en la referencia 

    HttpSession objsesion = request.getSession();
    //valido la sesion del usuario para estar dentro del generador 
    if (objsesion.getAttribute("alumno_validado") == null) {
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
        <link rel="stylesheet" href="CSS/Horario.css">
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
        <form action="HorarioServlet" method="post">
            <h2>Digita la cantidad de materias que habrá en cada día respectivo:</h2>
            <div class="form-row">
                <div class="form-group">
                    <label for="lunes">Lunes:</label>
                    <select name="lunes" id="lunes">
                        <% for (int i = 0; i <= 8; i++) {%>
                        <option value="<%=i%>"<%
                            if (objsesion.getAttribute("materias_lunes") != null && (Integer) objsesion.getAttribute("materias_lunes") == i) {
                                %>selected<%
                                }%>
                                >
                            <%=i%>
                        </option>
                        <% } %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="martes">Martes:</label>
                    <select name="martes" id="martes">
                        <% for (int i = 0; i <= 8; i++) {%>
                        <option value="<%=i%>"<%
                            if (objsesion.getAttribute("materias_martes") != null && (Integer) objsesion.getAttribute("materias_martes") == i) {
                                %>selected<%
                                }%>
                                >
                            <%=i%>
                        </option>
                        <% } %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="miercoles">Miércoles:</label>
                    <select name="miercoles" id="miercoles">
                        <% for (int i = 0; i <= 8; i++) {%>
                        <option value="<%=i%>"<%
                            if (objsesion.getAttribute("materias_miercoles") != null && (Integer) objsesion.getAttribute("materias_miercoles") == i) {
                                %>selected<%
                                }%>
                                >
                            <%=i%>
                        </option>
                        <% } %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="jueves">Jueves:</label>
                    <select name="jueves" id="jueves">
                        <% for (int i = 0; i <= 8; i++) {%>
                        <option value="<%=i%>"<%
                            if (objsesion.getAttribute("materias_jueves") != null && (Integer) objsesion.getAttribute("materias_jueves") == i) {
                                %>selected<%
                                }%>
                                >
                            <%=i%>
                        </option>
                        <% } %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="viernes">Viernes:</label>
                    <select name="viernes" id="viernes">
                        <% for (int i = 0; i <= 8; i++) {%>
                        <option value="<%=i%>"<%
                            if (objsesion.getAttribute("materias_viernes") != null && (Integer) objsesion.getAttribute("materias_viernes") == i) {
                                %>selected<%
                                }%>
                                >
                            <%=i%>
                        </option>
                        <% } %>
                    </select>
                </div>
            </div>
            <input class="btn" type="submit" value="Guardar">
            <div name="advertencia">
                <%
                    if (request.getAttribute("advertencia") != null) {
                        out.print(request.getAttribute("advertencia"));
                    }
                %>
            </div>
        </form>
        

    </body>
</html>
