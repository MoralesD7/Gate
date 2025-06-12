/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author omaralejandromoralesdiaz
 */
public class Calendario {
    private String nombre_evento;
    private String Descripcion;
    private String Fecha_evento;

    public Calendario(String nombre_evento, String Descripcion, String Fecha_evento) {
        this.nombre_evento = nombre_evento;
        this.Descripcion = Descripcion;
        this.Fecha_evento = Fecha_evento;
    }

    public String getNombre_evento() {
        return nombre_evento;
    }

    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFecha_evento() {
        return Fecha_evento;
    }

    public void setFecha_evento(String Fecha_evento) {
        this.Fecha_evento = Fecha_evento;
    }

    @Override
    public String toString() {
        return "Calendario{" + "nombre_evento=" + nombre_evento + ", Descripcion=" + Descripcion + ", Fecha_evento=" + Fecha_evento + '}';
    }
    
}
