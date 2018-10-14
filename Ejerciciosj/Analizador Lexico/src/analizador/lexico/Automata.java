/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador.lexico;

/**
 *
 * @author joel
 */

public final class Automata {

        private final int[][] delta; 
        private int estadoActual;
  
        
        public Automata(){
        estadoActual = 0;

        delta = new int[18][18];
        for(int fila=0; fila<18 ;fila++)
        {
            delta[fila] = new int[256];
            for(int columna=0; columna<256 ;columna++)
                delta[fila][columna] = -1;
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
        
        //PALABRAS RESERVADAS 0 a 11
        
	llenarFilaPorCaracteres(0,"@",12);
        llenarFilaPorCaracteres(12,"*",13);
        llenarFilaPorTodoExcepto(13,"*",13);
	llenarFilaPorCaracteres(13,"*",14);
        llenarFilaPorCaracteres(14,"@",15);
	
        
	llenarFilaPorCaracteres(12,"@",16);
	llenarFilaPorTodoExcepto(16,"\n",16);
	llenarFilaPorCaracteres(16,"\n",17);
        
        }
        
        
	public boolean mover(char c)
	{       
            if( c>=0 && c<256 )
            {
		int nuevoEstado = delta[estadoActual][c];
                System.out.println(nuevoEstado);
		if(nuevoEstado == -1)
                    return false;
		estadoActual = nuevoEstado;
		return true;
            }
        	return false;
	}
        
        public int obtenerEstado(){
                return estadoActual;
        }
	
	public boolean esEstadoFinal()
	{       
		return estadoActual == 1 || estadoActual == 2 || estadoActual == 4 
                        || estadoActual == 5 || estadoActual == 6 || estadoActual == 7 || estadoActual == 8
                        || estadoActual == 10;
	}
        
        public void reiniciar(){
                estadoActual = 0;
        }
	//
        public void llenarFilaRango (int fila,int inferior,int superior,int estado)
	{
		for(int columna=inferior; columna<superior ;columna++)
                	delta[fila][columna] = estado;
	}
    
        public void llenarFilaPorCaracteres (int fila,String caracteres, int estado)
        {       
                char[] palabra = caracteres.toCharArray();
                for( char c : palabra ){
                     delta[fila][c] = estado;
                 
                }
        }

        public void llenarFilaPorTodoExcepto (int fila,String caracteres, int estado)
        {
                for( int columna=0; columna<256 ;columna++ )
                        delta[fila][columna] = estado;

                char[] palabra = caracteres.toCharArray();
                for( char c : palabra )
                        delta[fila][c] = -1;
        }
        
        public TipoToken obtenerTipoToken()
	{
            switch( estadoActual )
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
                case 11:
                    
                case 15:
                  
                case 17:
                    
		}
		return TipoToken.ERROR;
                
	}
}


