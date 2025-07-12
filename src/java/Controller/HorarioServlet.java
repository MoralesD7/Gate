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
        String regreso ;
        regreso = request.getParameter("regresar");
        System.out.println("valor de regreso"+regreso);
        if(regreso!=null){
            boolean horario_generador = false;
            System.out.println("entro al if del regreso");
            request.setAttribute("horario_generador", horario_generador);
            rd = request.getRequestDispatcher("/Horario.jsp");
            rd.forward(request, response);
        }
        
        //obtengo los valores de las materias deseadas 
        int v_lunes, v_martes, v_miercoles, v_jueves, v_viernes;
        
        try{
        v_lunes = Integer.parseInt(request.getParameter("lunes"));
        v_martes = Integer.parseInt(request.getParameter("martes"));
        v_miercoles = Integer.parseInt(request.getParameter("miercoles"));
        v_jueves = Integer.parseInt(request.getParameter("jueves"));
        v_viernes = Integer.parseInt(request.getParameter("viernes"));
        
        if (v_lunes > 0 || v_martes > 0 || v_miercoles > 0 || v_jueves > 0 || v_viernes > 0) {
            System.out.println("entro al if y no hay problema se va a mandar el valor correcto al if de el jsp");
            boolean horario_generador = true;
            request.setAttribute("materias_lunes", v_lunes);
            request.setAttribute("materias_martes", v_martes);
            request.setAttribute("materias_miercoles", v_miercoles);
            request.setAttribute("materias_jueves", v_jueves);
            request.setAttribute("materias_viernes", v_viernes);
            request.setAttribute("horario_generador", horario_generador);
            HttpSession objsesion = request.getSession();
            objsesion.setAttribute("materias_lunes", v_lunes);
            objsesion.setAttribute("materias_martes", v_martes);
            objsesion.setAttribute("materias_miercoles", v_miercoles);
            objsesion.setAttribute("materias_jueves", v_jueves);
            objsesion.setAttribute("materias_viernes", v_viernes);

        } else if(v_lunes == 0 && v_martes == 0 && v_miercoles == 0 && v_jueves == 0 && v_viernes == 0) {
            System.out.println("no se registran los valores de manera correcta ");
            String advertencia ="no se puede generar un horario si no hay alguna ninguna materia en ningun dia de la semana";
            request.setAttribute("advertencia", advertencia);
            
        }
        }catch(NumberFormatException e){
            System.err.println("error:"+e);
        }
        rd = request.getRequestDispatcher("/Horario.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
