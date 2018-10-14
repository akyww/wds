/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionparalela1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author joel
 */
public class FileClock implements Runnable{
    
    //Implementando metodo run de Runnable.
    @Override
    public void run(){
        for(int i =0; i<10; i++){
            //Linea que nos imprime la fecha y la hora en la que es ejecutado el hilo.
            System.out.printf("%s \n", new Date ());
            try{
                //Se da un tiempo de 4 segundos para que ejecute el proximo hilo
                TimeUnit.SECONDS.sleep(4);
            }catch (InterruptedException e){
                System.out.printf("The fileclock has been interrupted");
            } 
        }
    }
}
