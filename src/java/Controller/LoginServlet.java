/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO_impl.AlumnoDAOI;
import Model.Alumno;
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
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("entro al do post ");
        //variables para login y redireccion 
        RequestDispatcher rd;
        String email, password, advertencia ="";
        
        //obtencion de parametros 
        email = request.getParameter("email");
        password = request.getParameter("password");

        //Verificacion de si ese usuario ya esta dentro de la bd y si esta redirijir de no ser asi lanzar un aviso de que esta mal
        AlumnoDAOI alumno_logeo = new AlumnoDAOI();
        String resultado = alumno_logeo.Verificacion_login(email, password);
        
        //control de errores 
        switch (resultado) {
            case "LOGEOCORRECTO":
               
                Alumno alumno_validado = alumno_logeo.Busqueda_alumno(email);
                //aqui creo la sesion y asigno el obj usuario 
                HttpSession objsesion = request.getSession(true);//por defecto viene true pero es indiferente si no hay sesion crea una
                objsesion.setAttribute("alumno_validado", alumno_validado);
                rd = request.getRequestDispatcher("/Landing.jsp");
                rd.forward(request, response);
                break;
            case "PASSWORDINCORRECTA":
                //rechazo por email ya dentro de la bd  
                advertencia = "La contraseña que introduces es incorrecta";
                request.setAttribute("password_erronea", advertencia);
                rd = request.getRequestDispatcher("/Login.jsp");
                rd.forward(request, response);
                break;
            case "NOENCONTRADO":
                //rechazo por email ya dentro de la bd  
                advertencia = "el email no ha sido registrado";
                request.setAttribute("email_erroneo", advertencia);
                rd = request.getRequestDispatcher("/Login.jsp");
                rd.forward(request, response);
                break;
            default:
                System.out.println("error no verificado por el programador ingenioso");
                break;

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
