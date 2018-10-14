/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final1;

import java.sql.Connection;

/**
 *
 * @author Jean carlo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Connection conn = Conexion.getConnection();
        
        ReadCSV rs = new ReadCSV(conn);
        rs.setSeprator(',');
        
        String csvFile = "FL_insurance_sample.csv";
        String tableName = "pruebaMain12";
        
        rs.loadCSVParalelo(csvFile, tableName, true);
        
        
        
        
    }
    
}
