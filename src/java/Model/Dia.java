/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author omaralejandromoralesdiaz
 */
public class Dia {
    String nombre_dia;
    List<Materia> materias;
    
    public Dia(){}
    
    public Dia(String nombre_dia, List<Materia> materias) {
        this.nombre_dia = nombre_dia;
        this.materias = materias;
    }
    
    public String getNombre_dia() {
        return nombre_dia;
    }

    public void setNombre_dia(String nombre_dia) {
        this.nombre_dia = nombre_dia;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "Dia{" + "nombre_dia=" + nombre_dia + ", materias=" + materias + '}';
    }
    
    
    
    
}
