/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joel
 */
public class Procesador
{
    private IFuenteDatos fuente;
    private ISalidaDatos salida;
    
    public Procesador(IFuenteDatos fuente, ISalidaDatos salida)
    {
        this.fuente = fuente;
        this.salida = salida;
    }
    
    public void procesar( IProcesarRegistro lambda )
    {
        fuente.abrir();
        salida.abrir();
        
        while(!fuente.vacia())
        {
            String registro = fuente.leer();
            String registroProcesado = lambda.procesar( registro );
            salida.escribir( registroProcesado );
        }
        
        fuente.cerrar();
        salida.cerrar();
    }
}
