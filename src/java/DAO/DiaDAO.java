/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Model.Materia;
import java.util.ArrayList;

/**
 *
 * @author omaralejandromoralesdiaz
 */
public interface DiaDAO {
    
    public ArrayList<Materia> validacion_lista_materias(ArrayList materias);//metodo para saber la lista de materias traslapadas
    //se uso metodo burbuja obviamente se puede implementar otro mejor pero me da flojera hoy
    public ArrayList<Materia>  ordenamiento_materias(ArrayList materias_validas);//si no hay traslapes retorna las materias en orden 
    public  void insercion_materias_x_dia(int dia,ArrayList materias,String email);//Insercion de materias en la bd 
}
