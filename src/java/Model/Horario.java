/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author omaralejandromoralesdiaz
 */
public class Horario {
    String dia ; 
    String nombre_materia ; 
    Date hora_comienzo_materia;
    Date hora_finalizacion_materia;
    String salon ;
    public Horario(){}
    public Horario(String dia, String nombre_materia, Date hora_comienzo_materia, Date hora_finalizacion_materia, String salon) {
        this.dia = dia;
        this.nombre_materia = nombre_materia;
        this.hora_comienzo_materia = hora_comienzo_materia;
        this.hora_finalizacion_materia = hora_finalizacion_materia;
        this.salon = salon;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getNombre_materia() {
        return nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    public Date getHora_comienzo_materia() {
        return hora_comienzo_materia;
    }

    public void setHora_comienzo_materia(Date hora_comienzo_materia) {
        this.hora_comienzo_materia = hora_comienzo_materia;
    }

    public Date getHora_finalizacion_materia() {
        return hora_finalizacion_materia;
    }

    public void setHora_finalizacion_materia(Date hora_finalizacion_materia) {
        this.hora_finalizacion_materia = hora_finalizacion_materia;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    @Override
    public String toString() {
        return "Horario{" + "dia=" + dia + ", nombre_materia=" + nombre_materia + ", hora_comienzo_materia=" + hora_comienzo_materia + ", hora_finalizacion_materia=" + hora_finalizacion_materia + ", salon=" + salon + '}';
    }
    
    
}
