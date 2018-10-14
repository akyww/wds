/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlx;

/**
 *
 * @author joel
 */
public class Automata {
    
    private int[][] tabla;
    private int estadoActual;
    private Token token;
    
    public Automata()
    {
        estadoActual = 0;
        tabla = new int[18][18];
        
        for( int fila = 0; fila < 18; fila++ )
        {
            tabla[fila] = new int[256];
            for( int columna=0; columna<256; columna++ )
            {
                tabla[fila][columna] = -1;
            }
        }
        
        llenarFilaRango(0,'a','z',1);
	llenarFilaRango(0,'A','Z',1);
        llenarFilaPorCaracteres(0,"_$",1);
        llenarFilaRango(1,'a','z',1);
        llenarFilaRango(1,'A','Z',1);
        llenarFilaRango(1,'0','9',1);
        llenarFilaPorCaracteres(1,"_$",1);

	llenarFilaRango(0,'0','9',2);
	llenarFilaRango(2,'0','9',2);
        llenarFilaPorCaracteres(2,".",3);
	llenarFilaRango(3,'0','9',4);
	llenarFilaRango(4,'0','9',4);
        llenarFilaPorCaracteres(0,"[](){}¿?,;",5);

	llenarFilaPorCaracteres(0,"+-*/%",6);
	llenarFilaPorCaracteres(0,"><=",7);
        llenarFilaPorCaracteres(7,"=",8);
    
	llenarFilaPorCaracteres(0,"!",9);
	llenarFilaPorCaracteres(9,"=",10);
    
    
	llenarFilaPorCaracteres(0,"@",12);
        llenarFilaPorCaracteres(12,"*",13);
        llenarFilaPorTodoExcepto(13,"*",13);
	llenarFilaPorCaracteres(13,"*",14);
        llenarFilaPorCaracteres(14,"@",15);


	llenarFilaPorCaracteres(12,"@",16);
	llenarFilaPorTodoExcepto(16,"\n",16);
	llenarFilaPorCaracteres(16,"\n",17);   
    }
    
    private void llenarFilaRango(int fila, int inferior, int superior, int estado)
    {
        for(int columna=inferior; columna<=superior; columna++)
        {
            tabla[fila][columna] = estado;
        }
    }
    
    private void llenarFilaPorCaracteres(int fila, String caracteres, int estado)
    {
        char[] arrayCaracteres = caracteres.toCharArray();
        for(char caracter : arrayCaracteres)
        {
            tabla[fila][caracter] = estado;
        }
    }
    
    private void llenarFilaPorTodoExcepto(int fila, String caracteres, int estado)
    {
        for( int columna=0; columna<256; columna++ )
        {
            tabla[fila][columna] = estado;
        }
        
        char[] arrayCaracteres = caracteres.toCharArray();
        for(char caracter : arrayCaracteres)
        {
            tabla[fila][caracter] = -1;
        }
    }
    
    public boolean mover(char c)
    {
        if( c>=0 && c<256 )
        {
            int nuevoEstado = tabla[estadoActual][c];
            if( nuevoEstado == -1 )
            {
                return false;
            }
            estadoActual = nuevoEstado;
            return true;
        }
        return false;
    }
    
    public int obtenerEstado()
    {
        return estadoActual;
    }
    
    public void reiniciarAutomata()
    {
        estadoActual = 0;
    }
    
    public boolean esEstadoFinal()
    {
	return estadoActual == 1 || estadoActual == 2 || 
               estadoActual == 4 || estadoActual == 5 || 
               estadoActual == 6 || estadoActual == 7 || 
               estadoActual == 8 || estadoActual == 10;
    }
    
    public boolean esPalabraReservada(String buffer)
    {
        return buffer.equals("entero")       || buffer.equals("flotante") || 
               buffer.equals("Programa")     || buffer.equals("Si")       ||
               buffer.equals("Osino")        || buffer.equals("Mientras") ||
               buffer.equals("leerTeclado")  || buffer.equals("imprimirPantalla");
    }
    
    public TipoToken obtenerTipoToken()
    {
        switch(estadoActual)
        {
            case 1:
                return TipoToken.IDENTIFICADOR; 
            case 2:
                return TipoToken.CONSTANTE_ENTERA;
            case 4:
                return TipoToken.CONSTANTE_FLOTANTE;
            case 5:
                return TipoToken.DELIMITADOR;
            case 6:
                return TipoToken.OPERADOR;
            case 7:
                return TipoToken.OPERADOR;
            case 8:
                return TipoToken.OPERADOR;
            case 10:
                return TipoToken.OPERADOR;
                
        }
        return TipoToken.ERROR;
    }

}
