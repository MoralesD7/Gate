
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
                System.out.println("Insercion de datos alumno exitoso");
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
                        System.out.println("Insercion de token exitosa ");
                    } else {
                        System.out.println("fallo la insercion del token");
                    }
                }
            } else {
                System.out.println("Insercion de datos alumno sin exito");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    //no hay necesidad de hacer esto por que aun no hay modulo de administrador activo
    public void Mostrar_lista_alumnos() {
        //no hay necesidad de hacer esto por que aun no hay modulo de administrador activo
    }

    //no hay necesidad de hacer esto por que aun no hay modulo de administrador activo
    @Override
    public void Editar_alumno(String matricula) {

    }
    //no hay necesidad de hacer esto por que aun no hay modulo de administrador activo
    @Override
    public void Eliminar_alumno(String matricula) {

    }

   
    /*
    ------MAIN PARA INSERCION DE ALUMNO-------------------
    public static void main(String[] args) {
        Alumno novato = new Alumno("0000500000", "Ale", "new", "breaik046@gmail.com", "Readings9");
        AlumnoDAOI alumno = new AlumnoDAOI();
        alumno.Agregar_alumno(novato);
    --------MAIN PARA VERFICACION DE ALUMNO REGISTRO--------
     public static void main(String[] args) {
        AlumnoDAOI alumno = new AlumnoDAOI();
        System.out.println(alumno.Verificacion_alumno("breakboy@gmail.com"));
    }
    }
    */
    

    @Override
    public boolean Verificacion_registro(String email) {
        boolean encontrado = false ;
        //obtener la conexion 
        cx = getConnection();
        //crear la consulta indicada 
        consulta  ="SELECT * FROM M_Alumno WHERE M_alu_email = ? ";
        try {
            ps = cx.prepareStatement(consulta);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if(rs.next()){
                encontrado = true ;
                return encontrado ;
            }else{
                encontrado = false ;
                return encontrado ;
            }
        } catch (SQLException ex) {
            System.err.println("excepcion:"+ex);
        }
        return encontrado;
    }

    @Override
    public boolean Verificacion_login(String email, String password) {
        AlumnoDAOI alumnito = new AlumnoDAOI();
        boolean validado = false ;
        cx = getConnection();
        consulta = "SELECT M_alu_id FROM M_Alumno WHERE M_alu_email = ? ";
        con_aux ="SELECT T_tok_token FROM E_Token WHERE M_alu_id =? ";

        try{
            ps = cx.prepareStatement(consulta);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if(rs.next()){
                //id que ayudara a la consulta del token 
                String id = rs.getString(1);
                ps = cx.prepareStatement(con_aux);
                ps.setString(1, id);
                rs = ps.executeQuery();
                if(rs.next()){
                    
                }else{
                    
                }
            }else{
                //no es solo una cuestion de si el alumno esta o no esta si no que el correo y contraseña coincidan
                //entonces el metodo como tal no tendria por que mandar un solo boolean si no una cadena que indique
                //cual es el caso tanto si esta registrado como si los valores coindicen fuaaaaaaaa
            }
        }
        catch(SQLException ex){
            System.err.println("Error"+ex);
        }
        return validado ;
    }
    public static void main(String[] args) {
        AlumnoDAOI alumno = new AlumnoDAOI();
        String correo = "breakboy046@gmail.com";
        String contraseña ="Readings";
        alumno.Verificacion_login(correo,contraseña);

    }
    

}
