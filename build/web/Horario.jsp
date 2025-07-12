<%@page import="java.util.ArrayList"%>
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
<%
    Boolean horario_generador = (Boolean) request.getAttribute("horario_generador");
    if (horario_generador == null) {
        horario_generador = false;
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
        
        <% if (!horario_generador) { %>
        
        <form action="HorarioServlet" method="post">
            <h2>Digita la cantidad de materias que habrá en cada día respectivo:</h2>
            <div class="form-row">
                <div class="form-group">
                    <label for="lunes">Lunes:</label>
                    <select name="lunes" id="lunes">
                        <% for (int i = 0; i <= 8; i++) {%>
                        <option value="<%=i%>"<%
                            if(objsesion.getAttribute("materias_lunes")!=null && (Integer)objsesion.getAttribute("materias_lunes")==i){
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
                        <option value="<%= i%>"><%= i%></option>
                        <% } %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="miercoles">Miércoles:</label>
                    <select name="miercoles" id="miercoles">
                        <% for (int i = 0; i <= 8; i++) {%>
                        <option value="<%= i%>"><%= i%></option>
                        <% } %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="jueves">Jueves:</label>
                    <select name="jueves" id="jueves">
                        <% for (int i = 0; i <= 8; i++) {%>
                        <option value="<%= i%>"><%= i%></option>
                        <% } %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="viernes">Viernes:</label>
                    <select name="viernes" id="viernes">
                        <% for (int i = 0; i <= 8; i++) {%>
                        <option value="<%= i%>"><%= i%></option>
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
        <% } else if (horario_generador) {%>
        <%/*Form para boton de regreso */%>
        <form action="HorarioServlet" method="post" class="form-regresar">
            <div class="ocultar">
                <select name="regresar" id="regresar">
                    <option value="regresar">regreso</option>
                </select>
            </div>
            <input class="btn" type="submit" value="Regresar">
        </form>
        <%/*Form generar los target */
            int cantidad_lunes = (Integer) request.getAttribute("materias_lunes");
            int cantidad_martes = (Integer) request.getAttribute("materias_martes");
            int cantidad_miercoles = (Integer) request.getAttribute("materias_miercoles");
            int cantidad_jueves = (Integer) request.getAttribute("materias_jueves");
            int cantidad_viernes = (Integer) request.getAttribute("materias_viernes");
        %>
            <form action="HorarioServlet" method="post" class="form-materias">
                <div class="day-container">
                    <h3>Lunes :</h3>
                    <% for (int i = 0; i < cantidad_lunes; i++) {%>
                    <div class="day-box">
                        <label>Nombre de la materia:</label>
                        <input type="text" name="nombre_materia_lunes_<%=i%>">

                        <label>Hora de inicio:</label>
                        <input type="time" name="hor_inicio_lunes_<%=i%>">

                        <label>Hora de terminación:</label>
                        <input type="time" name="hor_final_lunes_<%=i%>">

                        <label>Salón:</label>
                        <input type="text" name="salon_lunes_<%=i%>">
                    </div>
                    <% } %>
                </div>

                <div class="day-container">
                    <h3>Martes :</h3>
                    <% for (int i = 0; i < cantidad_martes; i++) {%>
                    <div class="day-box">
                        <label>Nombre de la materia:</label>
                        <input type="text" name="nombre_materia_martes_<%=i%>">

                        <label>Hora de inicio:</label>
                        <input type="time" name="hor_inicio_martes_<%=i%>">

                        <label>Hora de terminación:</label>
                        <input type="time" name="hor_final_martes_<%=i%>">

                        <label>Salón:</label>
                        <input type="text" name="salon_martes_<%=i%>">
                    </div>
                    <% } %>
                </div>

                <div class="day-container">
                    <h3>Miércoles :</h3>
                    <% for (int i = 0; i < cantidad_miercoles; i++) {%>
                    <div class="day-box">
                        <label>Nombre de la materia:</label>
                        <input type="text" name="nombre_materia_miercoles_<%=i%>">

                        <label>Hora de inicio:</label>
                        <input type="time" name="hor_inicio_miercoles_<%=i%>">

                        <label>Hora de terminación:</label>
                        <input type="time" name="hor_final_miercoles_<%=i%>">

                        <label>Salón:</label>
                        <input type="text" name="salon_miercoles_<%=i%>">
                    </div>
                    <% } %>
                </div>

                <div class="day-container">
                    <h3>Jueves :</h3>
                    <% for (int i = 0; i < cantidad_jueves; i++) {%>
                    <div class="day-box">
                        <label>Nombre de la materia:</label>
                        <input type="text" name="nombre_materia_jueves_<%=i%>">

                        <label>Hora de inicio:</label>
                        <input type="time" name="hor_inicio_jueves_<%=i%>">

                        <label>Hora de terminación:</label>
                        <input type="time" name="hor_final_jueves_<%=i%>">

                        <label>Salón:</label>
                        <input type="text" name="salon_jueves_<%=i%>">
                    </div>
                    <% } %>
                </div>

                <div class="day-container">
                    <h3>Viernes :</h3>
                    <% for (int i = 0; i < cantidad_viernes; i++) {%>
                    <div class="day-box">
                        <label>Nombre de la materia:</label>
                        <input type="text" name="nombre_materia_viernes_<%=i%>">

                        <label>Hora de inicio:</label>
                        <input type="time" name="hor_inicio_viernes_<%=i%>">

                        <label>Hora de terminación:</label>
                        <input type="time" name="hor_final_viernes_<%=i%>">

                        <label>Salón:</label>
                        <input type="text" name="salon_viernes_<%=i%>">
                    </div>
                    <% } %>
                </div>

                <button class="btn" type="submit">Guardar</button>
            </form>
        <%}%>

    </body>
</html>
