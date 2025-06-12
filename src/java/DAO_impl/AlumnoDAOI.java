
package DAO_impl;

import static Config.Conexion.getConnection;
import DAO.AlumnoDAO;
import Model.Alumno;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AlumnoDAOI implements AlumnoDAO {

    static Connection cx = null;
    static PreparedStatement ps;
    static ResultSet rs;
    static String consulta = null;
    static String con_aux;

    public AlumnoDAOI() {
    }

    @Override
    public void Agregar_alumno(Alumno a) {
        cx = getConnection();
        consulta = "INSERT INTO M_Alumno(M_alu_matricula,M_alu_nombre,M_alu_apellido,M_alu_email) VALUES(?,?,?,?)";
        con_aux = "INSERT INTO E_Token(E_tok_token,M_alu_id) VALUES (?,?)";
        int confirmacion = 0;

        try {
            //primera recoleccion de datos 
            ps = cx.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, a.getMatricula());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApellido());
            ps.setString(4, a.getEmail());
            confirmacion = ps.executeUpdate();

            if (confirmacion > 0) {
                System.out.println("Insercion de tabla alumno exitoso.... ");
                //obtengo el id generado de la tabla alumno 
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int id_alumno = rs.getInt(1);
                    confirmacion = 0;
                    //segunda recoleccion 
                    ps = cx.prepareStatement(con_aux);
                    ps.setString(1, a.getContraseña());
                    ps.setInt(2, id_alumno);
                    confirmacion = ps.executeUpdate();
                    if (confirmacion > 0) {
                        System.out.println("Insercion de tok exitosa ");
                    } else {
                        System.out.println("fallo tok Xd");
                    }
                }
            } else {
                System.out.println("fallo alumno");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void Mostrar_lista_alumnos() {

    }

    @Override
    public Alumno Mostrar_alumno(String matricula) {

        return null;

    }

    @Override
    public void Editar_alumno(String matricula) {

    }

    @Override
    public void Eliminar_alumno(String matricula) {

    }

    
    /*public static void main(String[] args) {
        Alumno novato = new Alumno("0000500000", "Ale", "new", "breaik046@gmail.com", "Readings9");
        AlumnoDAOI alumno = new AlumnoDAOI();
        alumno.Agregar_alumno(novato);

    }*/

}
