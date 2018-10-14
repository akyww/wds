/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alsemantico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joel
 */
public class NodoTabla {

    List<String> variables = new ArrayList<>();
    List<NodoTabla> subBloque = new ArrayList<>();
    NodoTabla padre;
    
    public List<String> getVariables() {
        return variables;
    }

    public void setVariables(List<String> variables) {
        this.variables = variables;
    }

    public List<NodoTabla> getSubBloque() {
        return subBloque;
    }

    public void setSubBloque(List<NodoTabla> subBloque) {
        this.subBloque = subBloque;
    }
       
    public NodoTabla getPadre() {
        return padre;
    }
    
    void setPadre(NodoTabla padre) {
        this.padre = padre;
    }
    
    public NodoTabla()
    {
        
    }
    
    
    
}
