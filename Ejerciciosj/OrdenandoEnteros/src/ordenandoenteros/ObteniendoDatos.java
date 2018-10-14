/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenandoenteros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author joel
 */
public class ObteniendoDatos {
    
    public ObteniendoDatos()
    {
        
    }
    public ArrayList<Integer> ordenarDatos(File file) throws FileNotFoundException, IOException
    {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String cadena;
        ArrayList<Integer> buffer = new ArrayList<>();
        String[] arr; 
        while((cadena = br.readLine())!=null)
        {             
            arr = cadena.split(" ");
            for (int i = 0; i < arr.length; i++) {
                int dato = Integer.parseInt(arr[i]);
                buffer.add(dato);
            }
        }
        return buffer;
    }
}
