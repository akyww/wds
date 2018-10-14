/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDeDatos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author joelpt
 */
public class ConnectionDB {
    
    Connection cn = null;
    
    public Connection openConnection(){
        
       try {    
       Class.forName("com.mysql.jdbc.Driver");
       cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bank2", "joelpt", "1234");
       } catch (Exception e){
           System.out.print(e.getMessage());
       }
       return cn;
    }
    
    public void closeConnection() throws SQLException{
        cn.close();
    }
}
