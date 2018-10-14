/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IFuenteDatos fuente = new FuenteDatosConsola();
        ISalidaDatos salida = new SalidaDatosConsola();
        
        Procesador procesador = new Procesador( fuente , salida );
        procesador.procesar( registro -> registro.toLowerCase() );
        
    }
    
}
