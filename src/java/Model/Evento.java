/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author omaralejandromoralesdiaz
 */
public class Evento {
    private String nombre_evento ;
    private String descripcion;
    private String fecha ;
    
    public Evento(){}
    public Evento(String nombre_evento, String descripcion, String fecha) {
        this.nombre_evento = nombre_evento;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getNombre_evento() {
        return nombre_evento;
    }

    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Evento{" + "nombre_evento=" + nombre_evento + ", descripcion=" + descripcion + ", fecha=" + fecha + '}';
    }
    
    
}
