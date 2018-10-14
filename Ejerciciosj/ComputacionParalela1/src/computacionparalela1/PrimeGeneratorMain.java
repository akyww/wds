/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionparalela1;

/**
 *
 * @author joel
 */
public class PrimeGeneratorMain {
    public static void main(String[] args){  
    //Creando el hilo
    Thread task = new PrimeGenerator();
    task.start();
    
    //Interrumpimos el hilo despues de 5 segundos.
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e){
        e.printStackTrace();
    }
    task.interrupt();
    }
}
   
