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
public class SafeTask implements Runnable{
    
    private static ThreadLocal<Date> startDate= new ThreadLocal<Date>() {
        protected Date initialValue()
        {
            return new Date();
        }   
    };
    
    @Override
    public void run()
    {
        System.out.printf("Starting Thread: %s : %s\n",Thread.currentThread().getId(),startDate.get());
        try {
        TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",Thread.currentThread().getId(),startDate.get());
    }
}
