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
public class Main {
    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) {
        
        NodoTabla nd1 = new NodoTabla();
        NodoTabla nd2 = new NodoTabla();
        NodoTabla nd3 = new NodoTabla();
        NodoTabla nd4 = new NodoTabla();
        NodoTabla nd5 = new NodoTabla();

        
        List<String> vn1 = new ArrayList<>();
        vn1.add("var");
        vn1.add("a");
        List<String> vn2 = new ArrayList<>();
        vn2.add("perro");
        vn2.add("bb");
        vn2.add("c");
        
        List<String> vn3 = new ArrayList<>();
        vn3.add("dd");
        vn3.add("variable1");
        vn3.add("var");
        List<String> vn4 = new ArrayList<>();
        vn4.add("casa");
        vn4.add("perro");
        List<String> vn5 = new ArrayList<>();
        vn5.add("vaca");
        vn5.add("c");
        vn5.add("v");
        vn5.add("bb");
        
        nd1.setVariables(vn1);
        nd2.setVariables(vn2);
        nd3.setVariables(vn3);
        nd4.setVariables(vn4);
        nd5.setVariables(vn5);
        
        List<NodoTabla> sb1 = new ArrayList<>();
        sb1.add(nd2);
        sb1.add(nd3);
        nd1.setSubBloque(sb1);
        List<NodoTabla> sb2 = new ArrayList<>();
        sb2.add(nd4);
        sb2.add(nd5);
        nd2.setSubBloque(sb2);
        
        nd2.setPadre(nd1);
        nd3.setPadre(nd1);
        
        nd4.setPadre(nd2);
        nd5.setPadre(nd2);
        
        TablaSimbolos ts = new TablaSimbolos();
        ts.setRaiz(nd1);
        
        List<NodoTabla> nodos = new ArrayList<>();
        nodos.add(nd1);
        nodos.add(nd2);
        nodos.add(nd3);
        nodos.add(nd4);
        nodos.add(nd5);
        
        ts.setNodos(nodos);
        
        ts.variablesRedefinidas(nd1);
    }
 
}
