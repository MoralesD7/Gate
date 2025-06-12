/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;
/*
private String nombre_evento;
    private String Descripcion;
    private String Fecha_evento;
*/
public interface CalendarioDAO {
    public void Agregar_evento (String nom_evento ,String descripcion,String fecha_evento);
    public void Mostrar_eventos ();
    public void Editar_evento (String nom_evento);
    public void Eliminar_evento (String nom_evento);
}
