
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joel
 */
public class SalidaDatosArchivo implements ISalidaDatos {
    
    
   
    
    public void abrir()
    {
        
    }
    
    public void cerrar()
    {
        
    }
    
    public void escribir(String tmp)
    {
        try{
            FileWriter archivo = new FileWriter("archivo.txt");  
//    FileReader fr = new FileReader(archivo);
 //   BufferedReader br = new BufferedReader(fr);
            
        }catch (Exception ex){ex.printStackTrace();}
    } 
    
    
}

    