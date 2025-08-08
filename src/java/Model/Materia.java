/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author omaralejandromoralesdiaz
 */
import java.sql.Time;
import java.time.LocalTime;
public class Materia {

    String nombre_materia;
    LocalTime hor_inicial;
    LocalTime hor_final;
    String nombre_salon;

    public Materia() {
    }

    public Materia(String nombre_materia, LocalTime hor_inicial, LocalTime hor_final, String nombre_salon) {
        this.nombre_materia = nombre_materia;
        this.hor_inicial = hor_inicial;
        this.hor_final = hor_final;
        this.nombre_salon = nombre_salon;
    }

    public String getNombre_materia() {
        return nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    public LocalTime getHor_inicial() {
        return hor_inicial;
    }

    public void setHor_inicial(LocalTime hor_inicial) {
        this.hor_inicial = hor_inicial;
    }

    public LocalTime getHor_final() {
        return hor_final;
    }

    public void setHor_final(LocalTime hor_final) {
        this.hor_final = hor_final;
    }

    public String getNombre_salon() {
        return nombre_salon;
    }

    public void setNombre_salon(String nombre_salon) {
        this.nombre_salon = nombre_salon;
    }

    @Override
    public String toString() {
        return "Materia{"
                + "nombre_materia='" + nombre_materia + '\''
                + ", hor_inicial=" + hor_inicial
                + ", hor_final=" + hor_final
                + ", nombre_salon='" + nombre_salon + '\''
                + '}';
    }
}

