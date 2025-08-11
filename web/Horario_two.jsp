<%-- 
    Document   : Horario_two
    Created on : 13 jul 2025, 3:13:45 p.m.
    Author     : omaralejandromoralesdiaz
--%>
<%@page import="Model.Materia"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="Handling_exception.Inconsistencia_hora"%>
<%@page import="java.util.ArrayList"%>
<%
    HttpSession objsesion = request.getSession();
    if (objsesion.getAttribute("alumno_validado") == null) {
%>
<jsp:forward page="Login.jsp">
    <jsp:param name="error" value="es necesario iniciar sesion"/>
</jsp:forward>
<%
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <script src="JS/Validacion_horario.js"></script>
    <head>
        <meta charset="UTF-8">
        <title>Generador de Horario</title>
        <link rel="stylesheet" href="CSS/Horario_two.css"> <%-- Ruta de tu archivo CSS --%>
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

        <%-- Form para botón de regreso --%>
        <div class="regresar">
            <a href="Horario.jsp">Regresar</a>
        </div>



        <%
            int cantidad_lunes = (Integer) objsesion.getAttribute("materias_lunes");
            int cantidad_martes = (Integer) objsesion.getAttribute("materias_martes");
            int cantidad_miercoles = (Integer) objsesion.getAttribute("materias_miercoles");
            int cantidad_jueves = (Integer) objsesion.getAttribute("materias_jueves");
            int cantidad_viernes = (Integer) objsesion.getAttribute("materias_viernes");
        %>

        <form id="horarioForm" action="HorarioTwoServlet" method="post" class="form-materias">
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
                <div name="advertencia">

                    <%
                        if (request.getAttribute("traslapadas") != null) {
                            ArrayList<Inconsistencia_hora> inconsistencias = (ArrayList<Inconsistencia_hora>) request.getAttribute("traslapadas");
                            for (int j = 0; j < inconsistencias.size(); j++) {
                                Inconsistencia_hora obj_incons = inconsistencias.get(j);
                                if (obj_incons.getIterador_inconsistencia() == i) {
                                    out.print("Hay un error en " + obj_incons.getNombre_mat() + " estas insertando un intervalo invalido");
                                }
                            }

                        }
                    %>
                    <%
                        if (request.getAttribute("lista_materias_traslapadas") != null && i == cantidad_lunes-1 ) {
                            ArrayList<Materia> traslapes = (ArrayList<Materia>) request.getAttribute("lista_materias_traslapadas");
                            if(!traslapes.isEmpty()){
                            out.print("La lista de materias que traslapan sus materias son: ");
                            for (int k = 0; k < traslapes.size(); k++) {
                                Materia mat = traslapes.get(k);
                                out.print(mat.getNombre_materia()+" : "+"\n"+ 
                                mat.getHor_inicial()+" - "+mat.getHor_final()+"\n");
                            }
                            }
                        }

                    %>
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
                <% }%>
            </div>

            <button class="btn" type="submit">Guardar</button>
        </form>
    </body>
</html>
