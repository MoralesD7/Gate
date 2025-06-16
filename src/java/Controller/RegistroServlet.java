package Controller;

import DAO_impl.AlumnoDAOI;
import Model.Alumno;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistroServlet extends HttpServlet {
    
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

        response.setContentType("text/html;charset=UTF-8");

        //Var 
        String matricula, nombre, apellido, email, contraseña;
        RequestDispatcher rd;
        System.out.println("entro a do post ");

        //get datos 
        matricula = request.getParameter("matricula");
        nombre = request.getParameter("nombre");
        apellido = request.getParameter("apellido");
        email = request.getParameter("email");
        contraseña = request.getParameter("password");

        //creacion de obj implementacion
        AlumnoDAOI alumno_DAO_I = new AlumnoDAOI();
        
        //insercion de usuario a bd o rechazo por email usado 
        if (!alumno_DAO_I.Verificacion_registro(email)) {
            Alumno alumno = new Alumno(matricula, nombre, apellido, email, contraseña);
            alumno_DAO_I.Agregar_alumno(alumno);
        }else{
            String advertencia ="El correo ya esta en uso ";
            request.setAttribute("advertencia",advertencia);
            rd= request.getRequestDispatcher("/Vistas/Registro.jsp");
            rd.forward(request, response);
        }

        /*VERIFICACION SI SE RECOLECTARON DE MANERA CORRECTA LAS VARIABLES DE ENTORNO 
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
