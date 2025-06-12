/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO_impl.AlumnoDAOI;
import Model.Alumno;
import static Config.Conexion.getConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author omaralejandromoralesdiaz
 */
public class RegistroServlet extends HttpServlet {
            String variable =System.getProperty("DB_USER");


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistroServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistroServlet at " + request.getParameter("nombre:") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Variables 
        String matricula, nombre, apellido, email, contraseña;
        System.out.println("entro a do post ");
        //get datos 
        matricula = request.getParameter("matricula");
        nombre = request.getParameter("nombre");
        apellido = request.getParameter("apellido");
        email = request.getParameter("email");
        contraseña = request.getParameter("contraseña");

        //creacion de obj e impl de metodo
        
        
        Alumno alumno = new Alumno(matricula, nombre, apellido, email, contraseña);
        AlumnoDAOI alumnoDAO_implementacion = new AlumnoDAOI();
        alumnoDAO_implementacion.Agregar_alumno(alumno);
        /*
        String USER = System.getProperty("DB_USER");
        String PASSWORD = System.getProperty("DB_PASSWORD");
        String BD_NAME = System.getProperty("DB_G_NAME");
        String HOST = System.getProperty("DB_HOST");
        String PORT = System.getProperty("DB_PORT");
        String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+BD_NAME+"?autoReconnect=true&useSSL=false";
        System.out.println("\n"+USER+"\n"+PASSWORD+"\n"+BD_NAME+"\n"+HOST+"\n"+PORT+"\n"+URL);
        getConnection();*/

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
