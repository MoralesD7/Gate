package Controller;

import DAO_impl.AlumnoDAOI;
import Model.Alumno;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        //Variables para obtener parametros y enrutar
        String matricula, nombre, apellido, email, contraseña;
        RequestDispatcher rd;
        
       
        //get datos 
        matricula = request.getParameter("matricula");
        nombre = request.getParameter("nombre");
        apellido = request.getParameter("apellido");
        email = request.getParameter("email");
        contraseña = request.getParameter("password");

        //creacion de obj implementacion para verificar si ya hay un usurio con esos datos 
        AlumnoDAOI alumno_DAO_I = new AlumnoDAOI();

        if (!alumno_DAO_I.Verificacion_registro(email)) {
            //de no ser asi se creara un alumno nuevo 
            Alumno alumno = new Alumno(matricula, nombre, apellido, email, contraseña);
            alumno_DAO_I.Agregar_alumno(alumno);
            rd = request.getRequestDispatcher("/Login.jsp");
            rd.forward(request, response);
        } else {
            //rechazo por email ya dentro de la bd  
            String advertencia = "El correo ya esta en uso intenta utilizar otro";
            request.setAttribute("advertencia", advertencia);
            rd = request.getRequestDispatcher("/Registro.jsp");
            rd.forward(request, response);
        }
         //System.out.println("entro a do post ");
        /*
        MANIPULACION DE SESION 
        //manejo de sesiones veamos como funciona esta cosa 
        HttpSession objeto_sesion = request.getSession(true);//si ponemos esto en false amenos que ya tenga una cuenta en bd no admitira nuevas
        String id_sesion = objeto_sesion.getId();
        Long fecha_creacion = objeto_sesion.getCreationTime();
        Long fecha_ultimo_acceso = objeto_sesion.getLastAccessedTime();
        System.out.println("id de la sesion : " + id_sesion);
        System.out.println("fecha de creacion : " + new Date(fecha_creacion.toString()));
        System.out.println("fecha de ultimo acceso : " + new Date(fecha_ultimo_acceso.toString()));
        
        Integer contador_entradas = (Integer) objeto_sesion.getAttribute("contador_sesion");//obtengo la n cantidad de veces qe ha entrado
        if (contador_entradas == null) {
            contador_entradas = 1;
        } else {
            contador_entradas += 1;//aumento si no es la primera vez 
        }
        objeto_sesion.setAttribute("contador_sesion", contador_entradas); //lo establezco al final
        
        
        // Mostrar todos los atributos como si fuera un HashMap
        System.out.println("----- Atributos en la sesión -----");
        Enumeration<String> keys = objeto_sesion.getAttributeNames();
        
        while (keys.hasMoreElements()) {
            String clave = keys.nextElement();
            Object valor = objeto_sesion.getAttribute(clave);
            System.out.println(clave + " : " + valor);
        }
        System.out.println("----------------------------------");
        */

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
