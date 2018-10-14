/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author joelpt
 */
public class Sentences {
    
    private Connection con;
    
    public Connection getConnection()
    {
        return con;
    }
    
    public void setConnection(Connection con)
    {
        this.con = con;
    }
    
    public void showTable(ArrayList<String> arr)
    {
        String array[] = new String[arr.size()];
        array = arr.toArray(array);
        
        for(String d : array)
        {
            System.out.print(d+" ");
        }
    }
    
        
    public ArrayList<String> returnTable() throws SQLException
    {
        ArrayList<String> data = new ArrayList<>();
        
        PreparedStatement ps = con.prepareStatement("Select * from Empleados");
        ResultSet res = ps.executeQuery();

        while(res.next())
        {
            data.add(res.getString("dni"));
            data.add(res.getString("nombre"));
            data.add(res.getString("apellido_paterno"));
            data.add(res.getString("apellido_materno"));
            data.add(res.getString("edad"));
            data.add("\n");
        }
        
        res.close();

        return data;   
    }
    
    public void showSearchByDni(ArrayList<String> arr)
    {
        String array[] = new String[arr.size()];
        array = arr.toArray(array);
        
        for(String d : array)
        {
            System.out.print(d+" ");
        }
    }
    
    public ArrayList<String> searchByDni(String caracter) throws SQLException
    {
        ArrayList<String> data = new ArrayList<>();
        
        PreparedStatement ps = con.prepareStatement
        ("SELECT * from Empleados WHERE dni LIKE '%"+caracter+"%'");
        
        ResultSet res = ps.executeQuery();

        while(res.next())
        {
            data.add(res.getString("dni"));
            data.add(res.getString("nombre"));
            data.add(res.getString("apellido_paterno"));
            data.add(res.getString("apellido_materno"));
            data.add(res.getString("edad"));
            data.add("\n");
        }
        
        res.close();

        return data;   
    }
    
    public void showSearchByName(ArrayList<String> arr)
    {
        String array[] = new String[arr.size()];
        array = arr.toArray(array);
        
        for(String d : array)
        {
            System.out.print(d+" ");
        }
    }
    
    public ArrayList<String> searchByName(String caracter) throws SQLException
    {
        ArrayList<String> data = new ArrayList<>();
        
        PreparedStatement ps = con.prepareStatement
        ("SELECT * FROM Empleados "
        +"WHERE CONCAT (nombre,' ',apellido_paterno,' ',apellido_materno) LIKE '%"+caracter+"%'");
        
        ResultSet res = ps.executeQuery();

        while(res.next())
        {
            data.add(res.getString("dni"));
            data.add(res.getString("nombre"));
            data.add(res.getString("apellido_paterno"));
            data.add(res.getString("apellido_materno"));
            data.add(res.getString("edad"));
            data.add("\n");
        }
        
        res.close();

        return data;   
    }
    
    public void showSearchByAge(ArrayList<String> arr)
    {
        String array[] = new String[arr.size()];
        array = arr.toArray(array);
        
        for(String d : array)
        {
            System.out.print(d+" ");
        }
    }
    
    public ArrayList<String> searchByAge(int num1, int num2) throws SQLException
    {
        ArrayList<String> data = new ArrayList<>();
        
        PreparedStatement ps = con.prepareStatement
        ("SELECT * FROM Empleados WHERE edad BETWEEN "+num1+" and "+num2);
        
        ResultSet res = ps.executeQuery();

        while(res.next())
        {
            data.add(res.getString("dni"));
            data.add(res.getString("nombre"));
            data.add(res.getString("apellido_paterno"));
            data.add(res.getString("apellido_materno"));
            data.add(res.getString("edad"));
            data.add("\n");
        }
        
        res.close();

        return data;   
    }

}
    

