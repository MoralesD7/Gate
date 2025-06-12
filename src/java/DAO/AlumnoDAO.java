/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Model.Alumno;

public interface AlumnoDAO {
    
    public void Agregar_alumno(Alumno a );
    public void Mostrar_lista_alumnos();
    public Alumno Mostrar_alumno(String matricula);
    public void Editar_alumno(String matricula);
    public void Eliminar_alumno(String matricula);
        
    
}
