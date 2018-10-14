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
public class Token {
    
    private String lexema;
    private TipoToken tipoToken;
    private int indiceTabla;

    public int getIndiceTabla() {
        return indiceTabla;
    }
    
    void setIndiceTabla(int indiceTabla) {
        this.indiceTabla = indiceTabla;
    }
    
    public Token(String lexema, TipoToken tipoToken)
    {
        this.lexema = lexema;
        this.tipoToken = tipoToken;
    }
    
    public String obtenerLexema()
    {
        return lexema;
    }
    
    public TipoToken obtenerTipoToken()
    {
        return tipoToken;
    }
    
    public void setTipoToken(TipoToken tipoToken)
    {
        this.tipoToken = tipoToken;
    }
    
    public void setLexema(String lexema)
    {
        this.lexema = lexema;
    }
    
}
