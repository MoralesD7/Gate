/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO_impl.DiaDAOI;
import DAO_impl.MateriaDAOI;
import Handling_exception.Inconsistencia_hora;
import Model.Materia;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author omaralejandromoralesdiaz
 */
public class HorarioTwoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //obtener la sesion
        HttpSession objsesion = request.getSession();

        //obtener al usuario 
        String email = (String) objsesion.getAttribute("email");

        //obj para llamar al metodo de insercion
        DiaDAOI manipulacion_lunes = new DiaDAOI();
        MateriaDAOI validador = new MateriaDAOI();
        Inconsistencia_hora incons ;
        RequestDispatcher rd = null;
        
        //objetos para mandarlo como parametro 
        LocalTime obj_t_inicial, obj_t_final;

        //string para obtener el parametro
        String nom_materia, hor_inicial, hor_final, salon;

        //variables para manejo de la division
        int hora_inicio = 0, minutos_inicio = 0, hora_final = 0, minutos_final = 0,activador_traslapes = 0;

        //arreglo reciclable 
        String[] tiempo_division;

        //obtener los cantidad de materias de un dia 
        int materias_lunes = (Integer) objsesion.getAttribute("materias_lunes");
        int materias_martes = (Integer) objsesion.getAttribute("materias_martes");
        int materias_miercoles = (Integer) objsesion.getAttribute("materias_miercoles");
        int materias_jueves = (Integer) objsesion.getAttribute("materias_jueves");
        int materias_viernes = (Integer) objsesion.getAttribute("materias_viernes");

        //if para lunes 
        ArrayList<Materia> lista_materias_lunes = new ArrayList<>();
        ArrayList<Inconsistencia_hora> inconsistencias = new ArrayList<>();
        ArrayList<Materia> listado_preeliminar = new ArrayList<>();
        

        if (materias_lunes > 0) {
            System.out.println("Materias lunes :");
            for (int i = 0; i < materias_lunes; i++) {

                //primero parametro del obj materia
                nom_materia = request.getParameter("nombre_materia_lunes_" + i);
                System.out.println(nom_materia);

                //obtener hora inicial
                hor_inicial = request.getParameter("hor_inicio_lunes_" + i);
                //Primero tengo que obtener el dato en string y guardarlo en un arreglo correspondiente 
                tiempo_division = hor_inicial.split(":");
                //asginacion de el parseo 
                hora_inicio = Integer.parseInt(tiempo_division[0]);
                minutos_inicio = Integer.parseInt(tiempo_division[1]);
                obj_t_inicial = LocalTime.of(hora_inicio, minutos_inicio);

                //obtener hora final
                hor_final = request.getParameter("hor_final_lunes_" + i);
                //Primero tengo que obtener el dato en string y guardarlo en un arreglo correspondiente 
                tiempo_division = hor_final.split(":");
                //asginacion de el parseo 
                hora_final = Integer.parseInt(tiempo_division[0]);
                minutos_final = Integer.parseInt(tiempo_division[1]);
                obj_t_final = LocalTime.of(hora_final, minutos_final);

                System.out.println("hora inicial" + obj_t_inicial + "\n" + "hora final" + obj_t_final);

                salon = request.getParameter("salon_lunes_" + i);
                System.out.println("el salon correspondiente a la materia es :" + salon);

                Materia materia = new Materia(nom_materia, obj_t_inicial, obj_t_final, salon);
                boolean inconsistencia = validador.validar_hora_d_materia(materia);
                
                //validacion para que no inserte materias con hor_i y hor_f de manera inconsistente
                if (inconsistencia) {
                     listado_preeliminar.add(materia);
                }else{
                    //NMMS QUE MANEJO DE POO SE QUE ES BASICO PERO ES INCREIBLE FUCK 
                    incons = new Inconsistencia_hora(i,materia.getNombre_materia());
                    inconsistencias.add(incons);
                    request.setAttribute("traslapadas", inconsistencias);
                    activador_traslapes++;
                }
            }
            if(activador_traslapes == 0){
            
            }
            
            
            for(Inconsistencia_hora m: inconsistencias){
                System.out.println("listado desde el servlet:"+m);
            }
            rd = request.getRequestDispatcher("/Horario_two.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
