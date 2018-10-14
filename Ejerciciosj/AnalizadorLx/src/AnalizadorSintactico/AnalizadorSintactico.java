/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

import analizadorlx.TipoToken;
import analizadorlx.Token;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author joel
 */
public class AnalizadorSintactico {
    
    List<String> errores = new ArrayList<>();
    private Regla[] R;
    int[][] M;
    
    
    public AnalizadorSintactico()
    {   
        
        M =new int[][] {{0,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                        {2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,1,2,2,1,1,1,1},
                        {-1,4,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,5,-1,6,-1,-1,3,3,7,7},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,8,8,-1,-1},
                        {-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,31,-1,-1,-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,49,-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,50,51},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,14,15,-1,-1},
                        {-1,9,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                        {11,11,11,11,11,11,11,11,11,11,11,10,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
                        {13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,12,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13},
                        {-1,17,-1,-1,-1,-1,17,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,17,17,-1,-1,-1,-1},
                        {-1,20,-1,-1,-1,-1,20,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,20,20,-1,-1,-1,-1},
                        {19,19,19,19,19,19,19,19,19,19,19,19,18,18,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19},
                        {22,22,22,22,22,22,22,22,22,22,22,22,22,22,21,21,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22},
                        {-1,29,-1,-1,-1,-1,30,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,27,28,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,23,24,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,25,26,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,38,39,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,42,41,-1,45,44,43,-1,46,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                        {35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,33,33,35,35,35,35,35,35,35,35,35},
                        {-1,32,-1,-1,-1,-1,32,-1,34,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,40,-1,-1,-1,-1,-1,-1,32,32,-1,-1,-1,-1},
                        {-1,37,-1,-1,36,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,37,-1,37,-1,-1,37,37,37,37},
                        {48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,48,47,48,48,48,48,48,48,48}
                          };
        R = new Regla[52];

        ElementoGramatical[] NT = new ElementoGramatical[26];
        NT[0] = new ElementoGramatical(1,0);// P
        NT[1] = new ElementoGramatical(1,1);// LS
        NT[2] = new ElementoGramatical(1,2);// S
        NT[3] = new ElementoGramatical(1,3);// SD
        NT[4] = new ElementoGramatical(1,4);// SA
        NT[5] = new ElementoGramatical(1,5);// SC
        NT[6] = new ElementoGramatical(1,6);// SM
        NT[7] = new ElementoGramatical(1,7);// SF
        NT[8] = new ElementoGramatical(1,8);// TD
        NT[9] = new ElementoGramatical(1,9);// LDV
        NT[10] = new ElementoGramatical(1,10);// LDV*
        NT[11] = new ElementoGramatical(1,11);// A
        NT[12] = new ElementoGramatical(1,12);// EM 
        NT[13] = new ElementoGramatical(1,13);// TM
        NT[14] = new ElementoGramatical(1,14);// TM*
        NT[15] = new ElementoGramatical(1,15);// FM*
        NT[16] = new ElementoGramatical(1,16);// FM
        NT[17] = new ElementoGramatical(1,17);// OP1
        NT[18] = new ElementoGramatical(1,18);// OP2
        NT[19] = new ElementoGramatical(1,19);// OB  
        NT[20] = new ElementoGramatical(1,20);// OR
        NT[21] = new ElementoGramatical(1,21);// EB*
        NT[22] = new ElementoGramatical(1,22);// EB
        NT[23] = new ElementoGramatical(1,23);// BL
        NT[24] = new ElementoGramatical(1,24);// RSC

        ElementoGramatical[] T = new ElementoGramatical[36];
        T[0] = new ElementoGramatical(0,0);// Programa
        T[1] = new ElementoGramatical(0,1);// id
        T[2] = new ElementoGramatical(0,2);// [
        T[3] = new ElementoGramatical(0,3);// ]
        T[4] = new ElementoGramatical(0,4);// {
        T[5] = new ElementoGramatical(0,5);// }
        T[6] = new ElementoGramatical(0,6);// (
        T[7] = new ElementoGramatical(0,7);// )
        T[8] = new ElementoGramatical(0,8);// ¿
        T[9] = new ElementoGramatical(0,9);// ?
        T[10] = new ElementoGramatical(0,10);// ;
        T[11] = new ElementoGramatical(0,11);// ,
        T[12] = new ElementoGramatical(0,12);// +
        T[13] = new ElementoGramatical(0,13);// -
        T[14] = new ElementoGramatical(0,14);// *
        T[15] = new ElementoGramatical(0,15);// /
        T[16] = new ElementoGramatical(0,16);// <
        T[17] = new ElementoGramatical(0,17);// >
        T[18] = new ElementoGramatical(0,18);// =
        T[19] = new ElementoGramatical(0,19);// ==
        T[20] = new ElementoGramatical(0,20);// <=
        T[21] = new ElementoGramatical(0,21);// >=
        T[22] = new ElementoGramatical(0,22);// !
        T[23] = new ElementoGramatical(0,23);// !=
        T[24] = new ElementoGramatical(0,24);// ||
        T[25] = new ElementoGramatical(0,25);// &&
        T[26] = new ElementoGramatical(0,26);// Si
        T[27] = new ElementoGramatical(0,27);// Osino
        T[28] = new ElementoGramatical(0,28);// Mientras
        T[29] = new ElementoGramatical(0,29);// cte_entera
        T[30] = new ElementoGramatical(0,30);// cte_flotante
        T[31] = new ElementoGramatical(0,31);// entero
        T[32] = new ElementoGramatical(0,32);// flotante
        T[33] = new ElementoGramatical(0,33);// imprimirPantalla
        T[34] = new ElementoGramatical(0,34);// leerTeclado
                
        R[0] = new Regla( NT[0], T[0], T[2], T[1], T[3], T[4],NT[1],T[5]);
        R[1] = new Regla( NT[1], NT[2], NT[1]);
        R[2] = new Regla( NT[1] );
        R[3] = new Regla( NT[2], NT[3]);
        R[4] = new Regla( NT[2], NT[4]);
        R[5] = new Regla( NT[2], NT[5]);
        R[6] = new Regla( NT[2], NT[6]);
        R[7] = new Regla( NT[2], NT[7]);
        R[8] = new Regla( NT[3], NT[8], NT[9], T[10]);
        R[9] = new Regla( NT[9], T[1], NT[11], NT[10]);
        R[10] = new Regla( NT[10], T[11], T[1], NT[11],NT[10]);
        R[11] = new Regla( NT[10]);
        R[12] = new Regla( NT[11], T[18], NT[12]);
        R[13] = new Regla( NT[11]);
        R[14] = new Regla( NT[8],T[31]);
        R[15] = new Regla( NT[8],T[32]);
        R[16] = new Regla( NT[4],T[1],T[18],NT[12],T[10]);
        R[17] = new Regla( NT[12],NT[13],NT[14]);
        R[18] = new Regla( NT[14],NT[17],NT[13],NT[14]);
        R[19] = new Regla( NT[14]);
        R[20] = new Regla( NT[13], NT[16], NT[15]);
        R[21] = new Regla( NT[15], NT[18], NT[16], NT[15]);
        R[22] = new Regla( NT[15]);
        R[23] = new Regla( NT[17],T[12]);
        R[24] = new Regla( NT[17],T[13]);
        R[25] = new Regla( NT[18],T[14]);
        R[26] = new Regla( NT[18],T[15]);
        R[27] = new Regla( NT[16],T[29]);
        R[28] = new Regla( NT[16],T[30]);
        R[29] = new Regla( NT[16],T[1] );
        R[30] = new Regla( NT[16],T[6],NT[12],T[7]);
        R[31] = new Regla( NT[5],T[26],T[8],NT[22],T[9],NT[23],NT[24]);
        R[32] = new Regla( NT[22], NT[12], NT[20], NT[12], NT[21]);
        R[33] = new Regla( NT[21], NT[19], NT[22], NT[21]);   
        R[34] = new Regla( NT[22], T[8], NT[22], T[9]);
        R[35] = new Regla( NT[21]);
        R[36] = new Regla( NT[23], T[4], NT[1], T[5]);
        R[37] = new Regla( NT[23], NT[2]);
        R[38] = new Regla( NT[19], T[24]);
        R[39] = new Regla( NT[19], T[25]);
        R[40] = new Regla( NT[22],T[22],NT[22]);
        R[41] = new Regla( NT[20],T[17]);
        R[42] = new Regla( NT[20],T[16]);
        R[43] = new Regla( NT[20],T[21]);
        R[44] = new Regla( NT[20],T[20]);
        R[45] = new Regla( NT[20],T[19]);
        R[46] = new Regla( NT[20],T[23]);
        R[47] = new Regla( NT[24],T[27],NT[23]);
        R[48] = new Regla( NT[24]);
        R[49] = new Regla( NT[6],T[28],T[8],NT[22],T[9],NT[23]);
        R[50] = new Regla( NT[7],T[33],T[6],NT[12],T[7]);
        R[51] = new Regla( NT[7], T[34],T[6],T[1],T[7]);
    }
    
    public boolean analizarSintaxis(List<Token> tokens)
    {
		
        Deque<ElementoGramatical> P = new ArrayDeque<>();

        //1. Paso: Ingresar So a Pila.
        P.push(R[0].getNoTerminal());

        int index = 0;
             
        //2. Paso:
        while(!P.isEmpty() && index < tokens.size())
        {
            int regla = M[P.peek().getIndiceTabla()][test(tokens,index)];
            System.out.print(P.peek().getIndiceTabla());
            if( regla == -1 )
            {
                System.out.println("error 1");
                break;
            }

            Regla objRegla = R[regla];

            P.pop();
            
            for(int i = objRegla.getProduccion().length-1; i>0; i--)
            {
                P.push(objRegla.getProduccion()[i]);
            }
            
            while( !P.isEmpty() && P.peek().getTipo() == 0 /* P.peek().getIndiceTabla() == tokens[index].getIndiceTable() */ )
            {
                if(P.peek().getIndiceTabla() == test(tokens,index))
                {
                    P.pop();
                    index++;
                } else {
                    System.out.println("error 2");
                    break;
                }
            }
            if(!P.isEmpty() && P.peek().getTipo() == 0)
            {
                    //Error
            }
        }

        if(!P.isEmpty())
        {
            //Error
            return false;
        }

        if( index < tokens.size() )
        {
            //Error
            return false;
        }

        return true;
    }
    
    private int test(List<Token> tokens, int index)
    {
        Token tokenActual = tokens.get(index);
        String tmp = tokenActual.obtenerLexema();

        if(tmp.equals("Programa"))
            return 0;
        if(tokenActual.obtenerTipoToken() == TipoToken.IDENTIFICADOR)
            return 1;
        if(tmp.equals("["))
            return 2;
        if(tmp.equals("]"))
            return 3;
        if(tmp.equals("{"))
            return 4;
        if(tmp.equals("}"))
            return 5;
        if(tmp.equals("("))
            return 6;
        if(tmp.equals(")"))
            return 7;
        if(tmp.equals("¿"))
            return 8;
        if(tmp.equals("?"))
            return 9;
        if(tmp.equals(";"))
            return 10;
        if(tmp.equals(","))
            return 11;
        if(tmp.equals("+"))
            return 12;
        if(tmp.equals("-"))
            return 13;
        if(tmp.equals("*"))
            return 14;
        if(tmp.equals("/"))
            return 15;
        if(tmp.equals("<"))
            return 16;
        if(tmp.equals(">"))
            return 17;
        if(tmp.equals("="))
            return 18;
        if(tmp.equals("=="))
            return 19;
        if(tmp.equals("<="))
            return 20;
        if(tmp.equals(">="))
            return 21;
        if(tmp.equals("!"))
            return 22;
        if(tmp.equals("!="))
            return 23;
        if(tmp.equals("||"))
            return 24;
        if(tmp.equals("&&"))
            return 25;
        if(tmp.equals("Si"))
            return 26;
        if(tmp.equals("Osino"))
            return 27;
        if(tmp.equals("Mientras"))
            return 28;
        if(tokenActual.obtenerTipoToken() == TipoToken.CONSTANTE_ENTERA)
            return 29;
        if(tokenActual.obtenerTipoToken() == TipoToken.CONSTANTE_FLOTANTE)
            return 30;
        if(tmp.equals("entero"))
            return 31;
        if(tmp.equals("flotante"))
            return 32;
        if(tmp.equals("imprimirPantalla"))
            return 33;
        if(tmp.equals("leerTeclado"))
            return 34;
        
        return -2;
    }
}
    

