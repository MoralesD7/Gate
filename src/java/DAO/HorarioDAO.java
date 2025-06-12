/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;


public interface HorarioDAO {
    public void Agregar_materia (String materia,int hora);
    public void Mostrar_materia ();
    public void Editar_materia (String materia);
    public void Eliminar_materia (String materia);
}
