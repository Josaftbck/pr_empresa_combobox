/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author josaftbck
 */
public class Conexion {
    /* nombre del servidor = localhost
    puerto = 3306 
    usuario = root
    contrasena = Lasvegas123
    Driver de Conexion = com.mysql.cj.jdbc.Driver
    url de Conexion (cadena de conexion) :
    tipo conector(jdbc),mysql,nombre del servidor,
    puerto,base de datos
    */
    
    public Connection conexionBD;
    //jdbc:mysql://localhost:3306/db_empresa
    
    private final String puerto = "3306";
    // (esto da error) puerto = "dkjdk;
    
    private final String bd = "bd_empresa";
    
    private final String urlConexion = String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC",puerto,bd);
    //"jdbc:mysql://localhost:3306/db_empresa"
    
    private final String usuario = "root";
    
    private final String contra = "1234";
    
    private final String jdbc = "com.mysql.cj.jdbc.Driver";
    //jdbc = Driver
    
    public void abrir_conexion(){
            try{
                Class.forName(jdbc);
                conexionBD = DriverManager.getConnection(urlConexion,usuario,contra);
                //JOptionPane.showMessageDialog(null,"Conexion Exitosa","Exito",JOptionPane.INFORMATION_MESSAGE);
                
            }catch(ClassNotFoundException | SQLException ex){
                    System.out.println("Error: " + ex.getMessage());
            }
    }
    
    public void cerrar_conexion(){
        try{
            conexionBD.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    
    }
}
