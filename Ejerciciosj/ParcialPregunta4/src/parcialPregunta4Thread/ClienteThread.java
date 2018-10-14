/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialPregunta4Thread;

/**
 *
 * @author joel
 */
public class ClienteThread {
    private int montoRetiro;
    private String idCliente;
    
    public ClienteThread(String idCliente,int montoRetiro)
    {
        this.idCliente = idCliente;
        this.montoRetiro = montoRetiro;
    }
    
    public int obtenerMonto()
    {
        return montoRetiro;
    }
    
    public String obtenerIdCliente()
    {
        return idCliente;
    }
}
