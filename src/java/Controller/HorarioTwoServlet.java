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

        //objetos para manipular los met DAO
        DiaDAOI dia = new DiaDAOI();
        MateriaDAOI obj_materia = new MateriaDAOI();
        Materia materia;
        Inconsistencia_hora incons;
        RequestDispatcher rd;

        //objetos de tiempo 
        LocalTime obj_t_inicial, obj_t_final;

        //string para obtener los parametros
        String nom_materia, hor_inicial, hor_final, salon;

        boolean act_traslapes , inconsistencia,lunes_validado = false ,martes_validado = false
                ,miercoles_validado = false ,jueves_validado = false , viernes_validado = false;
        
        //obtener los cantidad de materias de un dia 
        int materias_lunes = (Integer) objsesion.getAttribute("materias_lunes");
        int materias_martes = (Integer) objsesion.getAttribute("materias_martes");
        int materias_miercoles = (Integer) objsesion.getAttribute("materias_miercoles");
        int materias_jueves = (Integer) objsesion.getAttribute("materias_jueves");
        int materias_viernes = (Integer) objsesion.getAttribute("materias_viernes");

        ArrayList<Materia> listado_traslapes ;
        ArrayList<Inconsistencia_hora> inconsistencias;
        ArrayList<Materia> listado_preeliminar ;
        

        if (materias_lunes > 0) {
            act_traslapes = false;
            listado_traslapes = new ArrayList<>();
            inconsistencias = new ArrayList<>();
            listado_preeliminar = new ArrayList<>();
            
            System.out.println("Materias lunes :");//<------cambio
            for (int i = 0; i < materias_lunes; i++) {

                //primero parametro del obj materia
                nom_materia = request.getParameter("nombre_materia_lunes_" + i);//<------cambio desde s

                //obtener hora inicial
                hor_inicial = request.getParameter("hor_inicio_lunes_" + i);//<------cambio desde s
                obj_t_inicial = obj_materia.obtener_hora(hor_inicial);

                //obtener hora final
                hor_final = request.getParameter("hor_final_lunes_" + i);//<------cambio desde s
                obj_t_final = obj_materia.obtener_hora(hor_final);

                salon = request.getParameter("salon_lunes_" + i);//<------cambio desde s

                materia = new Materia(nom_materia, obj_t_inicial, obj_t_final, salon);
                inconsistencia = obj_materia.validar_hora_d_materia(materia);

                //validacion para que no inserte materias con hor_i y hor_f de manera inconsistente
                if (inconsistencia) {
                    listado_preeliminar.add(materia);
                } else {
                    incons = new Inconsistencia_hora(i, materia.getNombre_materia());
                    inconsistencias.add(incons);
                    request.setAttribute("traslapadas_lunes", inconsistencias);//<------cambio desde  s y jsp
                    act_traslapes = true;
                }
            }
            //Validacion listado_preeliminar para una lista de materias con traslapes 
            if (!act_traslapes) {
                listado_traslapes = dia.validacion_lista_materias(listado_preeliminar);
            }

            if (listado_traslapes != null && !listado_traslapes.isEmpty()) {
                request.setAttribute("lista_materias_traslapadas_lunes", listado_traslapes);//<------cambio desde s y  jsp
            }else{
                lunes_validado = true ;
            }
            
        }else{
            lunes_validado = true ;
        }
        if (materias_martes > 0) {//<------cambio s
            act_traslapes = false;
            listado_traslapes = new ArrayList<>();
            inconsistencias = new ArrayList<>();
            listado_preeliminar = new ArrayList<>();
            
            System.out.println("Materias martes :");//<------cambio s 
            for (int i = 0; i < materias_martes; i++) {

                //primero parametro del obj materia
                nom_materia = request.getParameter("nombre_materia_martes_" + i);//<------cambio desde s

                //obtener hora inicial
                hor_inicial = request.getParameter("hor_inicio_martes_" + i);//<------cambio desde s
                obj_t_inicial = obj_materia.obtener_hora(hor_inicial);

                //obtener hora final
                hor_final = request.getParameter("hor_final_martes_" + i);//<------cambio desde s
                obj_t_final = obj_materia.obtener_hora(hor_final);

                salon = request.getParameter("salon_martes_" + i);//<------cambio desde s

                materia = new Materia(nom_materia, obj_t_inicial, obj_t_final, salon);
                inconsistencia = obj_materia.validar_hora_d_materia(materia);

                //validacion para que no inserte materias con hor_i y hor_f de manera inconsistente
                if (inconsistencia) {
                    listado_preeliminar.add(materia);
                } else {
                    incons = new Inconsistencia_hora(i, materia.getNombre_materia());
                    inconsistencias.add(incons);
                    request.setAttribute("traslapadas_martes", inconsistencias);//<------cambio desde  s y jsp
                    act_traslapes = true;
                }
            }
            //Validacion listado_preeliminar para una lista de materias con traslapes 
            if (!act_traslapes) {
                listado_traslapes = dia.validacion_lista_materias(listado_preeliminar);
            }

            if (listado_traslapes != null && !listado_traslapes.isEmpty()) {
                request.setAttribute("lista_materias_traslapadas_martes", listado_traslapes);//<------cambio desde s y  jsp
            }else{
            martes_validado = true ;
        }
            
        }else{
            martes_validado = true ;
        }
        
        if (materias_miercoles > 0) {//<------cambio s
            act_traslapes = false;
            listado_traslapes = new ArrayList<>();
            inconsistencias = new ArrayList<>();
            listado_preeliminar = new ArrayList<>();
            
            System.out.println("Materias miercoles :");//<------cambio s 
            for (int i = 0; i < materias_miercoles; i++) {

                //primero parametro del obj materia
                nom_materia = request.getParameter("nombre_materia_miercoles_" + i);//<------cambio desde s

                //obtener hora inicial
                hor_inicial = request.getParameter("hor_inicio_miercoles_" + i);//<------cambio desde s
                obj_t_inicial = obj_materia.obtener_hora(hor_inicial);

                //obtener hora final
                hor_final = request.getParameter("hor_final_miercoles_" + i);//<------cambio desde s
                obj_t_final = obj_materia.obtener_hora(hor_final);

                salon = request.getParameter("salon_miercoles_" + i);//<------cambio desde s

                materia = new Materia(nom_materia, obj_t_inicial, obj_t_final, salon);
                inconsistencia = obj_materia.validar_hora_d_materia(materia);

                //validacion para que no inserte materias con hor_i y hor_f de manera inconsistente
                if (inconsistencia) {
                    listado_preeliminar.add(materia);
                } else {
                    incons = new Inconsistencia_hora(i, materia.getNombre_materia());
                    inconsistencias.add(incons);
                    request.setAttribute("traslapadas_miercoles", inconsistencias);//<------cambio desde  s y jsp
                    act_traslapes = true;
                }
            }
            //Validacion listado_preeliminar para una lista de materias con traslapes 
            if (!act_traslapes) {
                listado_traslapes = dia.validacion_lista_materias(listado_preeliminar);
            }

            if (listado_traslapes != null && !listado_traslapes.isEmpty()) {
                request.setAttribute("lista_materias_traslapadas_miercoles", listado_traslapes);//<------cambio desde s y  jsp
            }else{
            miercoles_validado = true ;
        }
            
        }else{
            miercoles_validado = true ;
        }
        if (materias_jueves > 0) {//<------cambio s
            act_traslapes = false;
            listado_traslapes = new ArrayList<>();
            inconsistencias = new ArrayList<>();
            listado_preeliminar = new ArrayList<>();
            
            System.out.println("Materias jueves :");//<------cambio s 
            for (int i = 0; i < materias_jueves; i++) {

                //primero parametro del obj materia
                nom_materia = request.getParameter("nombre_materia_jueves_" + i);//<------cambio desde s

                //obtener hora inicial
                hor_inicial = request.getParameter("hor_inicio_jueves_" + i);//<------cambio desde s
                obj_t_inicial = obj_materia.obtener_hora(hor_inicial);

                //obtener hora final
                hor_final = request.getParameter("hor_final_jueves_" + i);//<------cambio desde s
                obj_t_final = obj_materia.obtener_hora(hor_final);

                salon = request.getParameter("salon_jueves_" + i);//<------cambio desde s

                materia = new Materia(nom_materia, obj_t_inicial, obj_t_final, salon);
                inconsistencia = obj_materia.validar_hora_d_materia(materia);

                //validacion para que no inserte materias con hor_i y hor_f de manera inconsistente
                if (inconsistencia) {
                    listado_preeliminar.add(materia);
                } else {
                    incons = new Inconsistencia_hora(i, materia.getNombre_materia());
                    inconsistencias.add(incons);
                    request.setAttribute("traslapadas_jueves", inconsistencias);//<------cambio desde  s y jsp
                    act_traslapes = true;
                }
            }
            //Validacion listado_preeliminar para una lista de materias con traslapes 
            if (!act_traslapes) {
                listado_traslapes = dia.validacion_lista_materias(listado_preeliminar);
            }

            if (listado_traslapes != null && !listado_traslapes.isEmpty()) {
                request.setAttribute("lista_materias_traslapadas_jueves", listado_traslapes);//<------cambio desde s y  jsp
            }else{
            jueves_validado = true ;
        }
            
        }else{
            jueves_validado = true ;
        }
        if (materias_viernes > 0) {//<------cambio s
            act_traslapes = false;
            listado_traslapes = new ArrayList<>();
            inconsistencias = new ArrayList<>();
            listado_preeliminar = new ArrayList<>();
            
            System.out.println("Materias viernes :");//<------cambio s 
            for (int i = 0; i < materias_viernes; i++) {

                //primero parametro del obj materia
                nom_materia = request.getParameter("nombre_materia_viernes_" + i);//<------cambio desde s

                //obtener hora inicial
                hor_inicial = request.getParameter("hor_inicio_viernes_" + i);//<------cambio desde s
                obj_t_inicial = obj_materia.obtener_hora(hor_inicial);

                //obtener hora final
                hor_final = request.getParameter("hor_final_viernes_" + i);//<------cambio desde s
                obj_t_final = obj_materia.obtener_hora(hor_final);

                salon = request.getParameter("salon_viernes_" + i);//<------cambio desde s

                materia = new Materia(nom_materia, obj_t_inicial, obj_t_final, salon);
                inconsistencia = obj_materia.validar_hora_d_materia(materia);

                //validacion para que no inserte materias con hor_i y hor_f de manera inconsistente
                if (inconsistencia) {
                    listado_preeliminar.add(materia);
                } else {
                    incons = new Inconsistencia_hora(i, materia.getNombre_materia());
                    inconsistencias.add(incons);
                    request.setAttribute("traslapadas_viernes", inconsistencias);//<------cambio desde  s y jsp
                    act_traslapes = true;
                }
            }
            //Validacion listado_preeliminar para una lista de materias con traslapes 
            if (!act_traslapes) {
                listado_traslapes = dia.validacion_lista_materias(listado_preeliminar);
            }

            if (listado_traslapes != null && !listado_traslapes.isEmpty()) {
                request.setAttribute("lista_materias_traslapadas_viernes", listado_traslapes);//<------cambio desde s y  jsp
            }else{
            viernes_validado = true ;
        }
            
        }else{
            viernes_validado = true ;
        }
        
            rd = request.getRequestDispatcher("/Horario_two.jsp");
            rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}