/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author omaralejandromoralesdiaz
 */
public class Materia {
    private String nombre_materia ;
    private String hora_inicio;
    private String hora_final;
    private String salon;
    
    public Materia(){}
    
    public Materia(String nombre_materia, String hora_inicio, String hora_final, String salon) {
        this.nombre_materia = nombre_materia;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
        this.salon = salon;
    }

    public String getNombre_materia() {
        return nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_final() {
        return hora_final;
    }

    public void setHora_final(String hora_final) {
        this.hora_final = hora_final;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    @Override
    public String toString() {
        return "Materia{" + "nombre_materia=" + nombre_materia + ", hora_inicio=" + hora_inicio + ", hora_final=" + hora_final + ", salon=" + salon + '}';
    }
    
    
}
