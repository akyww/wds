/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

/**
 *
 * @author joel
 */
public class ElementoGramatical {
    private int tipo;

    private int indiceTabla;

    public ElementoGramatical(int tipo, int indiceTabla)
    {
        this.tipo = tipo;
        this.indiceTabla = indiceTabla;
    }
    
    
    public void setTipo(int tipo) 
    {
        this.tipo = tipo;
    }

    public int getTipo() 
    {
        return tipo;
    }
    
    public int getIndiceTabla() 
    {
        return indiceTabla;
    }
    
    void setIndiceTabla(int indiceTabla) 
    {
        this.indiceTabla = indiceTabla;
    }
    
    public boolean equals( Object obj )
    {
        ElementoGramatical eg = (ElementoGramatical) obj;
        return this.tipo == eg.tipo && this.indiceTabla == eg.indiceTabla;
    }
    
}
