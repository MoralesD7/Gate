/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Model.Tarea;


public interface TareaDAO {
    public void Agregar_tarea (String nombre_tarea,String descripcion,String fecha_i,String fecha_f,String prioridad);
    public void Mostrar_lista_tareas();
    public Tarea Mostrar_tarea();
    public void Editar_tarea (String nombre_tarea);
    public void Eliminar_tarea (String nombre_tarea);
}
