/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador.lexico;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author joel
 */
public class AnalizadorLexico {

    /**
     * @param args the command line arguments
     */
    private Automata automata;
    
    public AnalizadorLexico()
    {
        automata = new Automata();
    }
	
    public ArrayList<Token> analizar(String archivo) throws java.io.IOException
    {
        ArrayList<Token> tokens = new ArrayList<>();
        
        File txt = new File(archivo);
        FileReader fr = new FileReader(txt);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        
        int i =0;
        while( ( linea = br.readLine())!= null )
        {
            
            tokens.addAll(analizarLinea(linea));
            i++;
        }
            return tokens;
    }
	
	
    private boolean esBlanco(char c)
    {
        return c==' ' || c=='\n' || c=='\t';
    }
	
    private ArrayList<Token> analizarLinea(String linea)
    {
        ArrayList<Token> tokensEnLinea = new ArrayList<Token>();
        int index = 0;
        char c = linea.charAt(index);
		
        String buffer = "";
		
	if(automata.mover(c))
        {
            buffer = buffer + c;
            index++;

            if(automata.esEstadoFinal())
            {   
                Token tokenn = new Token(automata.obtenerTipoToken(), buffer);
                System.out.print(tokenn.getTipo());
                tokensEnLinea.add(tokenn);
                buffer = "";
                automata.reiniciar();
            }else{
                if( buffer.equals("") )
                {
                    if(esBlanco(c)){
                        index++;
                    }else {
                      //     System.out.print("Caracter no valido");
                        index++;
                    }
                }else{
                   //Error token incorrecto
                    buffer = "";
                    automata.reiniciar();
                    index++;               
                }
            }
        }
        return tokensEnLinea;
    }      
}
