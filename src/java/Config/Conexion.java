/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;
import java.sql.Connection;
import java.sql.DriverManager;
public   class Conexion {
    //variables de entorno 
    private static final String USER = System.getProperty("DB_USER");
    private static final String PASSWORD = System.getProperty("DB_PASSWORD");
    private static final String BD_NAME = System.getProperty("DB_G_NAME");
    private static final String HOST = System.getProperty("DB_HOST");
    private static final String PORT = System.getProperty("DB_PORT");
    private static final String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+BD_NAME+"?autoReconnect=true&useSSL=false";
                                            

    public static Connection getConnection(){
        Connection cx = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cx = (Connection) DriverManager.getConnection(URL,USER,PASSWORD);
            if(cx== null){
                System.out.println("fallasteXD");
            }else{System.out.println("se logro y no hay problema ");}
        }catch(Exception e ){
                 e.printStackTrace();  
        }
        return cx;
    }
    
}

