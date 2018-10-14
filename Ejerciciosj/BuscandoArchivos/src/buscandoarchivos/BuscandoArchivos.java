/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscandoarchivos;

import java.io.File;

/**
 *
 * @author joel
 */
public class BuscandoArchivos {
    
    private String word;

    public BuscandoArchivos(String word)
    {
        this.word = word;
    }
   
    public void find(File ruta) 
    {
        File [] list = ruta.listFiles();
        String wordUp = word.toUpperCase();
        String wordLw = word.toLowerCase();
        String files;
        if( list != null )
        {
            for( File iList : list )
            {
               files = iList.getName();
               if( files.endsWith(wordLw) || files.endsWith(wordUp) )
               {
                   System.out.println(files);
               }
               
               if( iList.isDirectory() )
               {
                   find(iList);
               }
            }
        }    
    }
}
    
