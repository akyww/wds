/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenandoenteros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author joel
 */
public class GenerarDatos {
    
    public GenerarDatos()
    {
    }
    public void generar(File archivo,int n) throws IOException{
        
        FileWriter fw = new FileWriter(archivo);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for (int i=1;i<=n;i++)
        {
            int numero = (int) (Math.random() * n) + 1;
            bw.write(numero + " ");
        if(i%20==0)
            {
                bw.write("\n");
            }
        }
        bw.close();
    }
}
