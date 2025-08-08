/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Handling_exception;

/**
 *
 * @author omaralejandromoralesdiaz
 */
public class Inconsistencia_hora {
    int iterador_inconsistencia;
    String nombre_mat;
    public Inconsistencia_hora(){}
    public Inconsistencia_hora(int iterador_inconsistencia, String nombre_mat) {
        this.iterador_inconsistencia = iterador_inconsistencia;
        this.nombre_mat = nombre_mat;
    }
    public int getIterador_inconsistencia() {
        return iterador_inconsistencia;
    }

    public void setIterador_inconsistencia(int iterador_inconsistencia) {
        this.iterador_inconsistencia = iterador_inconsistencia;
    }

    public String getNombre_mat() {
        return nombre_mat;
    }

    public void setNombre_mat(String nombre_mat) {
        this.nombre_mat = nombre_mat;
    }

    @Override
    public String toString() {
        return "Inconsistencia_hora{" + "iterador_inconsistencia=" + iterador_inconsistencia + ", nombre_mat=" + nombre_mat + '}';
    }
  
}
