/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Tarea {
    private String nombre_tarea ;
    private String descripcion;
    private String fecha_inicio;
    private String fecha_finalizacion;
    private String prioridad;

    public Tarea(String nombre_tarea, String descripcion, String fecha_inicio, String fecha_finalizacion, String prioridad) {
        this.nombre_tarea = nombre_tarea;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_finalizacion = fecha_finalizacion;
        this.prioridad = prioridad;
    }

    public String getNombre_tarea() {
        return nombre_tarea;
    }

    public void setNombre_tarea(String nombre_tarea) {
        this.nombre_tarea = nombre_tarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getfecha_finalizacion() {
        return fecha_finalizacion;
    }

    public void setfecha_finalizacion(String fecha_finalizacion) {
        this.fecha_finalizacion = fecha_finalizacion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Tarea{" + "nombre_tarea=" + nombre_tarea + ", descripcion=" + descripcion + ", fecha_inicio=" + fecha_inicio + ", fecha_finalizacion=" + fecha_finalizacion + ", prioridad=" + prioridad + '}';
    }
    
}
