/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Model.Materia;
import java.time.LocalTime;

/**
 *
 * @author omaralejandromoralesdiaz
 */
public interface MateriaDAO {
        public LocalTime obtener_hora(String hora);//metodo para parsear la hora de manera correcta 
        public boolean validar_hora_d_materia(Materia m);//algun dia lo hare pero hoy no : v,fue dos dias despues XD

}
