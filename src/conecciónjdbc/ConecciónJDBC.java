
package conecciónjdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConecciónJDBC {

    public static void main(String[] args) {
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3307/proyeadsosena373";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try { 
            conexion = DriverManager.getConnection(url,usuario,password);
            
            //Cosulta a la DB
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {
                System.out.println(rs.getString("Nombre Cliente"));                              
            }
             
            //Insertar datos
            statement.execute("INSERT INTO `clientes`(`Nombre Cliente`, `Primer Apellido`, `Segundo Apellido`, `Numero Telefonico`) VALUES ('Carlos','Zuluaga','Carvajal','3015559473')");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {
                System.out.println(rs.getString("Nombre Cliente")+" "+rs.getString("Primer Apellido")+" "+rs.getString("Segundo Apellido")+" "+rs.getString("Numero Telefonico"));                              
            }
            
            //Actualización de datos
            statement.execute("UPDATE `clientes` SET `Nombre Cliente` = 'Rosario' , `Primer Apellido` = 'Lince' , `Segundo Apellido` = 'Salazar' , `Numero Telefonico` = '3206992876' WHERE `Id Cliente` = 4;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {
                System.out.println(rs.getString("Nombre Cliente")+" "+rs.getString("Primer Apellido")+" "+rs.getString("Segundo Apellido")+" "+rs.getString("Numero Telefonico"));                              
            }
            
            //Eliminación de datos
            statement.execute("DELETE FROM `clientes` WHERE `Id Cliente` = 24");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()) {
                System.out.println(rs.getString("Nombre Cliente")+" "+rs.getString("Primer Apellido")+" "+rs.getString("Segundo Apellido")+" "+rs.getString("Numero Telefonico"));                              
            }                
            
        } catch (SQLException ex) {
            Logger.getLogger(ConecciónJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
}
