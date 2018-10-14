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
public class Token {
	private String lexema;
	private TipoToken tipoToken;
	
	public Token(TipoToken tipoToken, String lexema )
	{
		this.tipoToken = tipoToken;
		this.lexema = lexema;
	}
		
        public TipoToken getTipo() {
            return tipoToken;
        }

        public void setTipo(TipoToken tipoToken) {
            this.tipoToken = tipoToken;
        }
}

