package DAO_impl;

import DAO.MateriaDAO;
import Model.Materia;
import java.time.LocalTime;

/**
 *
 * @author omaralejandromoralesdiaz
 */
public class MateriaDAOI implements MateriaDAO {
    //metodo para parsear la hora obtenida del request a su obj correspondiente 
    @Override
    public LocalTime obtener_hora(String hor) {
        //variables para manejo de la division
        int hora = 0, minutos = 0;
        String[] tiempo_division;
        LocalTime obj_tiempo;

        tiempo_division = hor.split(":");
        hora = Integer.parseInt(tiempo_division[0]);
        minutos = Integer.parseInt(tiempo_division[1]);
        obj_tiempo = LocalTime.of(hora, minutos);

        return obj_tiempo;
    }

    //metodo para validar una materia en cuanto a incosistencias de intervalo 
    @Override
    public boolean validar_hora_d_materia(Materia m) {
        // apply compareTo()
        int determinador_hora = m.getHor_inicial().compareTo(m.getHor_final());

        if (determinador_hora >= 0) {
            //return "La materia : " + nom_materia + "tiene un intervalo inconsistente en cuanto a su hora inicial y final";
            return false;
        } else {
            //return "El horario es valida";
            return true;
        }
    }

}
