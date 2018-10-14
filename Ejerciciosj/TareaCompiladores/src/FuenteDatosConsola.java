/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joel
 */
import java.util.*;
import java.io.*;

public class FuenteDatosConsola implements IFuenteDatos {
    private String tmp;
    private Scanner scanner;
    public void abrir()
    {
        scanner = new Scanner( System.in );
    }
    
    public void cerrar()
    {
    
    }
    
    public boolean vacia()
    {
         try 
        {
            tmp = scanner.nextLine();
        } 
        catch(Exception e)
        {
            //System.out.println(e.getMessage());    
            tmp = null;
        } 
        finally 
        {
            
        }
        return tmp == null;
    }
    
    public String leer()
    {
        return tmp;
    }
    
}
