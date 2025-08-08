
package DAO_impl;

import DAO.MateriaDAO;
import Model.Materia;

/**
 *
 * @author omaralejandromoralesdiaz
 */
public class MateriaDAOI implements MateriaDAO{
    //metodo para validar una materia en cuanto a incosistencias de intervalo 
     @Override
    public boolean validar_hora_d_materia(Materia m) {
        // apply compareTo()
        int determinador_hora = m.getHor_inicial().compareTo(m.getHor_final());
        
        if (determinador_hora >= 0) {
            //return "La materia : " + nom_materia + "tiene un intervalo inconsistente en cuanto a su hora inicial y final";
            return false;
        }else {
            //return "El horario es valida";
            return true ;
        }
    }
    
    
}
