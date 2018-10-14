/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionparalela1;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author joel
 */
public class FileClockMain {
    public static void main(String[] args){
        //Creando objeto de la clase FileClock.
        FileClock clock = new FileClock();
        //Creando un hilo.
        Thread thread = new Thread(clock);
        //Inicializando el hilo.
        thread.start();
        
        //Interrumpiremos la ejecucion tras 5 segundos.
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            System.out.printf("The fileclock has been interrupted");
        }

        thread.interrupt();
    }
}
