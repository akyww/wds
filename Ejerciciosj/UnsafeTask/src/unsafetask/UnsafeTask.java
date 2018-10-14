/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unsafetask;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author joel
 */
public class UnsafeTask implements Runnable{
    //Atributos
    private Date startDate;
    @Override
    //Implementando run
    public void run() 
    {
        //Guardando la fecha en nuestra variable tipo Date
        startDate=new Date();
        //Imprimiendo el id del hilo actual y la fecha.
        System.out.printf("Starting Thread: %s : %s\n",Thread.currentThread().getId(),startDate);
        try {
        TimeUnit.SECONDS.sleep( (int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",Thread.currentThread().getId(),startDate);
    }

}
