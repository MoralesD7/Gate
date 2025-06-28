
package DAO_impl;

import static Config.Conexion.getConnection;
import DAO.AlumnoDAO;
import Model.Alumno;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AlumnoDAOI implements AlumnoDAO {

    Connection cx = null;
    PreparedStatement ps;
    ResultSet rs;
    String consulta = null;
    String con_aux,con_aux_secundaria;

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
    public void Mostrar_lista_alumnos() {
    }
    @Override
    public void Editar_alumno(String matricula) {

    }
    @Override
    public void Eliminar_alumno(String matricula) {

    }
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
    public String Verificacion_login(String email, String password) {
        //seran 3 casos , NO encontrado , Encontrado pero contraseña erronea ,encontrado y verificado
        String cadena  = "";
        AlumnoDAOI alumnito = new AlumnoDAOI();
        //declaro un boole para ver si se valido correctamente 
        boolean validado = false ;
        //obtengo la conexion 
        cx = getConnection();
        
        //consultas 
        consulta = "SELECT M_alu_id FROM M_Alumno WHERE M_alu_email = ? ";
        con_aux ="SELECT E_tok_token FROM E_Token WHERE M_alu_id = ? ";
        con_aux_secundaria = "SELECT * FROM M_Alumno WHERE M_alu_id = ?";

        try{
            //preparo la primer consulta para veri el correo
            ps = cx.prepareStatement(consulta);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if(rs.next()){
                //id que ayudara a saber el token 
                String id = rs.getString(1);//obtiene el id de el usuario 
                //testeo para ver si funciona 
                System.out.println("el id del usuario fue :"+id);
                ps = cx.prepareStatement(con_aux);//realiza la consulta del token
                ps.setString(1, id);//asgina el valor del id a la consulta del token
                System.out.println(ps);
                rs = ps.executeQuery();//ejecuta la consulta 
                if(rs.next()){            
                    if(rs.getString(1).equals(password)){
                        cadena ="LOGEOCORRECTO";
                        return cadena ;
                    }else{
                         cadena ="PASSWORDINCORRECTA";
                    return cadena;
                    }
                }
            }else{
                //Aqui verifico si le correo esta dentro de la bd si no esta pues da error de no encontrado 
                cadena ="NOENCONTRADO";
                return cadena;
            }
        }
        catch(SQLException ex){
            System.err.println("Error"+ex);
        }
        return cadena;
    }
    @Override
    public Alumno Busqueda_alumno(String email) {
        Alumno alumno = null;
        consulta = "SELECT * FROM M_Alumno WHERE M_alu_email = ?";
        cx = getConnection();
        try {
            ps = cx.prepareStatement(consulta);
            System.out.println(ps);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("entro al if");
                alumno = new Alumno();
                alumno.setMatricula(rs.getString(2));
                alumno.setNombre(rs.getString(3));
                alumno.setApellido(rs.getString(4));
                alumno.setEmail(rs.getString(5));
                System.out.println(alumno.toString());
                return alumno;
            }else{
                System.out.println("no se encontro ningun alumno");
                return alumno;
            }
        } catch (SQLException ex) {
            System.err.println("Error en la consulta"+ ex);
        }
        return alumno;
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
    --------MAIN PARA LOGEO DE ALUMNO-------------------
     public static void main(String[] args) {
        AlumnoDAOI alumno = new AlumnoDAOI();
        String correo = "breakboy046@gmail.com";
        String contraseña ="Reading";
        String recuperacion = alumno.Verificacion_login(correo,contraseña);
        System.out.println(recuperacion);
    }
    --------MAIN PARA LOGEO DE ALUMNO_2-------------------
    public static void main(String[] args) {
        AlumnoDAOI obj = new AlumnoDAOI();
        String correo = "breakboy046@gmail.com";
        obj.Busqueda_alumno(correo);
    }
    */
    
}
