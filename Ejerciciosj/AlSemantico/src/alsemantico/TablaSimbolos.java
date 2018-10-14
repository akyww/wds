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
public class TablaSimbolos {
    
    NodoTabla raiz;
    List<NodoTabla> nodos = new ArrayList<>();
    
    public TablaSimbolos()
    {
        
    }
    
    public List<NodoTabla> getNodos() {
        return nodos;
    }
    
    void setNodos(List<NodoTabla> nodos) {
        this.nodos = nodos;
    }
    

    public NodoTabla getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoTabla raiz) {
        this.raiz = raiz;
    }    
    
    public void variablesRedefinidas(NodoTabla raiz)
    {   

        if(raiz.getSubBloque() != null){
            for(int i=0;i<raiz.getSubBloque().size();i++)
            {
                NodoTabla tmp = raiz.getSubBloque().get(i);
                NodoTabla padre = tmp.getPadre();
                for(int j=0;j<tmp.getVariables().size();j++)
                {
                    for(int k = 0; k<padre.getVariables().size();k++)
                    {
                        if(tmp.getVariables().get(j).equals(padre.getVariables().get(k)))
                        {
                            System.out.println("Variable "+ tmp.getVariables().get(j) +" re declarada");
                        } 
                    }
                }
                variablesRedefinidas(raiz.getSubBloque().get(i));
            }
        }
        
    }
    
}
