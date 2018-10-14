/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlx;

import AnalizadorSintactico.AnalizadorSintactico;
import java.io.IOException;
import java.util.List;

import shuntingyard.ShuntingYard;

/**
 *
 * @author joel
 */
public class Main {
    public static void main(String[] args) throws IOException
    {
        AnalizadorLexico lexico = new AnalizadorLexico();
        List<Token> tokens = lexico.analizar("c12.txt");
            
        for(Token tks : tokens)
        {
            System.out.println(tks.obtenerTipoToken() + "   " + tks.obtenerLexema());
        }
        
        AnalizadorSintactico as = new AnalizadorSintactico();
        as.analizarSintaxis(tokens);
        
        /*
        ShuntingYard test = new ShuntingYard();

        System.out.println(test.shuntingYard(tokens));
        System.out.println(test.shuntingYard(tokens1));
        */
    }
}
