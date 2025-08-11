 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO_impl;

import static Config.Conexion.getConnection;
import DAO.DiaDAO;
import Model.Materia;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author omaralejandromoralesdiaz
 */
public class DiaDAOI implements DiaDAO {

    Connection cx;
    PreparedStatement ps;
    ResultSet rs;
    String consulta, consulta_aux, consulta_aux_secundaria, nombre_materia, hora_i, hora_f, salon;
    LocalTime hora_inicial, hora_final;
    int confirmacion;
    
    @Override
    public ArrayList<Materia> validacion_lista_materias(ArrayList materias) {
        ArrayList<Materia> materias_traslapadas = new ArrayList<>();
        for (int i = 0 ; i<materias.size();i++){
            Materia materia_actual = (Materia) materias.get(i);
            for (int j = 0 ; j<materias.size();j++){
                Materia materia_siguiente = (Materia) materias.get(j);
                if(i==j)continue;
                
                if (materia_actual.getHor_final().compareTo(materia_siguiente.getHor_inicial()) <= 0
                    || materia_actual.getHor_inicial().compareTo(materia_siguiente.getHor_final()) >= 0){}
                else{
                    if(!materias_traslapadas.contains(materia_actual)){
                        materias_traslapadas.add(materia_actual);
                    }

                }

            }
        }
        return materias_traslapadas;
    }
    
    @Override
    public ArrayList<Materia> ordenamiento_materias(ArrayList materias_validas) {
        for (int i = 0; i <materias_validas.size()-1;i++){
                for (int j = 0 ; j< materias_validas.size()-1;j++){
                    Materia materia_actual = (Materia)materias_validas.get(j);
                    Materia materia_siguiente = (Materia)materias_validas.get(j+1);
                    //no se que hacer llamen a la policia
                    if (materia_actual.getHor_inicial().compareTo(materia_siguiente.getHor_final()) >= 0) {
                        
                        Materia obj_aux = materia_siguiente;
                        materias_validas.set(j+1,materia_actual);
                        materias_validas.set(j,obj_aux);
                    }
                }
            }
        return materias_validas;
    }
    
    @Override
    public void insercion_materias_x_dia(int dia, ArrayList materias, String email) {
        switch (dia) {
            case 1:
                cx = getConnection();
                consulta = "SELECT M_alu_id FROM M_alumno WHERE M_alu_email ='" + email + "'";
                consulta_aux = " INSERT INTO E_materia "
                        + "(E_mat_nombre_materia,E_mat_hora_inicio_materia,E_mat_hora_final_materia,E_mat_salon,C_dia_id,M_alu_id)"
                        + "VALUES (?,?,?,?,1,?)";
                try {
                    //consulta para obtener id del alumno 
                    ps = cx.prepareStatement(consulta);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        String id = rs.getString(1);
                        //cambia consulta para insertar en la bd 
                        System.out.println("el id fue :" + id);
                        System.out.println("la primer consulta fue :" + consulta);
                        System.out.println("la consulta aux fue :" + consulta_aux);
                        ps = cx.prepareStatement(consulta_aux);
                        for (int i = 0; i < materias.size(); i++) {

                            Materia mat = (Materia) materias.get(i);
                            nombre_materia = mat.getNombre_materia();
                            hora_inicial = mat.getHor_inicial();
                            hora_final = mat.getHor_final();
                            salon = mat.getNombre_salon();

                            hora_i = hora_inicial.toString();
                            hora_f = hora_final.toString();

                            ps.setString(1, nombre_materia);
                            ps.setString(2, hora_i);
                            ps.setString(3, hora_f);
                            ps.setString(4, salon);
                            ps.setString(5, id);

                            confirmacion = ps.executeUpdate();
                            if (confirmacion > 0) {
                                System.out.println("insercion de materias exitoso");
                            } else {
                                System.out.println("sucedio un error");
                            }
                        }
                    }
                } catch (SQLException ex) {
                    System.err.println("error:" + ex);
                }

                break;

            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;

        }
    }
    /*public static void main(String[] args) {
        DiaDAOI obj = new DiaDAOI();
        ArrayList<Materia> materias= new ArrayList<>();
        LocalTime t_inicial = LocalTime.of(8, 30);
        LocalTime t_final = LocalTime.of(9, 30);
        Materia obj_mat = new Materia ("matematicas",t_inicial,t_final,"lab matematicas");
        materias.add(obj_mat);
        LocalTime t_inicial_dos = LocalTime.of(9, 30);
        LocalTime t_final_dos = LocalTime.of(10, 30);
        Materia obj_mat_dos = new Materia ("progra",t_inicial_dos,t_final_dos,"lab progra");
        materias.add(obj_mat_dos);
        obj.insercion_materias_x_dia(1,materias, "breakboy046@gmail.com");
        
    }
     */
    /*public static void main(String[] args) {
        LocalTime t_inicial_dos = LocalTime.of(9, 30);
        LocalTime t_final_dos = LocalTime.of(9, 40);
        DiaDAOI obj = new DiaDAOI();
        String texto = obj.validar_hora_d_materia("fisica", t_inicial_dos, t_final_dos);
        System.out.println(texto);
        
    }
    */

    

    
}
