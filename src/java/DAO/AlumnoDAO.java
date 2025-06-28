//
package DAO;

import Model.Alumno;

public interface AlumnoDAO {
    //para programa actual metodos terminados
    public void Agregar_alumno(Alumno a );//completado 
    public void Mostrar_lista_alumnos();//incompleto sin modulo de admin
    public boolean Verificacion_registro(String email);//completado(verificacion de si el alumno ya esta logeado)
    public String Verificacion_login(String email,String password);//completado(veri si no esta , si esta pero con pass incorrecta)
    public Alumno Busqueda_alumno(String email);//pendiente para implementar en el Verificacion de login
    public void Editar_alumno(String matricula);//incompleto sin modulo de admin
    public void Eliminar_alumno(String matricula);//incompleto sin modulo de admin
        
    
}
