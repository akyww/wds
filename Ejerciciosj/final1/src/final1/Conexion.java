/**
 *
 * @author jean carlo
 */
package final1;
import java.sql.*;

public class Conexion {
   
  
    public static Connection getConnection(){
        Connection conn = null;
 
        try {
          
            String connectionUrl = "jdbc:sqlserver://;" +  
         "database=prueba;user=sa;password=123456;";

            conn = DriverManager.getConnection(connectionUrl);
            if (conn != null){
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                System.out.println("base de datos " + "conectada");
            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("error de conxcion");
        }
        
        return conn;
    }
}
