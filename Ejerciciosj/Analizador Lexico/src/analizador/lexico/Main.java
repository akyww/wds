/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador.lexico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author joel
 */
public class Main {
    public static void main (String [ ] args) throws IOException{
        Automata objeto = new Automata();
        AnalizadorLexico lex = new AnalizadorLexico(); 
        String url = "D:\\archivo.txt";
        
        lex.analizar(url);
       
        
        /*
        ArrayList<Token> tk = new ArrayList<>();
        tk = lex.analizar(url);
        
        for(int i = 0; i < tk.size(); i++)
        {
            System.out.print(tk.get(i));
        }
        */
        
        
        /*        
        File archivo = new File ("D:\\archivo.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        
        while( (linea = br.readLine()) != null )
        {   
            System.out.println(linea);
        }
        /*
	String prueba = "ñ";
        
        char[] cadena = prueba.toCharArray();

	for ( char var : cadena){
            System.out.println(var);
            objeto.mover(var);
        }
        */
        //System.out.println(objeto.obtenerTipoToken());

        //System.out.println(objeto.obtenerEstado());
    }
}
