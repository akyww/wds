/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joel
 */
public class AnalizadorLexico {

    private Automata automata;
    
    public AnalizadorLexico()
    {
        automata = new Automata();
    }
    
    public List<Token> analizar(String archivo) throws java.io.IOException
    {
        List<Token> tokens = new ArrayList<>();
        File file = new File(archivo);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        
        while ( (linea = br.readLine()) != null )
        {
            tokens.addAll(analizarLinea(linea + "\n"));
        }

        return tokens;
    }
    
    public List<Token> analizarLinea(String linea)
    {
        List<Token> tokensEnLinea = new ArrayList<>();
        int posicionLinea = 0;
        char caracter;
        String buffer = ""; 
        
        while( posicionLinea<linea.length() )
        {
            caracter = linea.charAt(posicionLinea);
            if( automata.mover(caracter) )
            {
                buffer += caracter;
                posicionLinea++;
            } else {
                if( automata.esEstadoFinal() )
                {
                    if(automata.esPalabraReservada(buffer))
                    {
                       tokensEnLinea.add(new Token(buffer,automata.obtenerTipoToken().PALABRA_RESERVADA));
                       automata.reiniciarAutomata();
                       buffer="";
                    } else {
                    
                    Token token = new Token(buffer,automata.obtenerTipoToken());
                    tokensEnLinea.add(token);
                    buffer="";
                    automata.reiniciarAutomata();
                    }
                } else {
                    if( buffer.equals("") )
                    {
                        if( esBlanco(caracter) )
                        {
                            posicionLinea++;
                        } else {
                            posicionLinea++;
                        }
                        
                    } else {
                        automata.reiniciarAutomata();
                        buffer="";
                        posicionLinea++;
                    }
                }
            }
        }
        
        return tokensEnLinea;
    }
    
    private boolean esBlanco(char c)
    {
        return c==' ' || c=='\n' || c=='\t';
    }
    
    
    
}
