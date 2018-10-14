/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

import java.util.List;

/**
 *
 * @author joel
 */
public class Regla {
    ElementoGramatical noTerminal;
    ElementoGramatical[] produccion;
    
    public Regla( ElementoGramatical noTerminal, ElementoGramatical... produccion)
    {
        this.noTerminal = noTerminal;
        this.produccion = produccion;
    }
    
    public ElementoGramatical getNoTerminal() 
    {
	return noTerminal;
    }

    public void setNoTerminal(ElementoGramatical noTerminal) 
    {
        this.noTerminal = noTerminal;
    }

    public ElementoGramatical[] getProduccion() 
    {
        return produccion;
    }

    public void setProduccion(ElementoGramatical[] produccion) 
    {
        this.produccion = produccion;
    }
    
}
