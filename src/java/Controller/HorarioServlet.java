/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author omaralejandromoralesdiaz
 */
public class HorarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //objeto para la redireccion
        RequestDispatcher rd;
       
        //obtengo el numero de materias y parseo 
        int v_lunes = 0, v_martes = 0, v_miercoles = 0, v_jueves = 0, v_viernes = 0;
        boolean act_parseo = false;
        try {
            //si se obtienen lo valores se activa el parseo si no exception numberformat
            if (request.getParameter("lunes") != null && request.getParameter("martes") != null & request.getParameter("miercoles") != null && request.getParameter("jueves") != null && request.getParameter("viernes") != null) {
                v_lunes = Integer.parseInt(request.getParameter("lunes"));
                v_martes = Integer.parseInt(request.getParameter("martes"));
                v_miercoles = Integer.parseInt(request.getParameter("miercoles"));
                v_jueves = Integer.parseInt(request.getParameter("jueves"));
                v_viernes = Integer.parseInt(request.getParameter("viernes"));
                act_parseo = true ;
            }
            //establecer valores de la siguiente parte del jsp y guardar los valores de la sesion
            if (v_lunes > 0 || v_martes > 0 || v_miercoles > 0 || v_jueves > 0 || v_viernes > 0 && act_parseo) {
                System.out.println("insercion de cantidad de materias  en objsesion exitosa ");
                HttpSession objsesion = request.getSession();
                objsesion.setAttribute("materias_lunes", v_lunes);
                objsesion.setAttribute("materias_martes", v_martes);
                objsesion.setAttribute("materias_miercoles", v_miercoles);
                objsesion.setAttribute("materias_jueves", v_jueves);
                objsesion.setAttribute("materias_viernes", v_viernes);
                rd = request.getRequestDispatcher("/Horario_two.jsp");
                rd.forward(request, response);
            } else if (v_lunes == 0 && v_martes == 0 && v_miercoles == 0 && v_jueves == 0 && v_viernes == 0) {
                System.out.println("if para valores == 0");
                String advertencia = "Se necesita almenos una materia en un dia para generar el horario";
                request.setAttribute("advertencia", advertencia);
                rd = request.getRequestDispatcher("/Horario.jsp");
                rd.forward(request, response);

            }
        } catch (NumberFormatException e) {
            System.err.println("error:" + e);
        }
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
