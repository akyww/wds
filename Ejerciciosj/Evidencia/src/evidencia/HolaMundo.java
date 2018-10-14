/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia;

/**
 *
 * @author Laboratorio 23
 */
import java.io.*;
import java.util.concurrent.TimeUnit;
public class HolaMundo implements Runnable
    {
    
    private String word;
    public HolaMundo(String word){
        this.word = word;
    }
    
    @Override
    
    public void run()
    {
            for(int i =1; i <= 10 ; i++){
            System.out.printf("%s: %d %s\n",Thread.
                currentThread().getName(), i, word);
            try {
              TimeUnit.SECONDS.sleep(i);
            } catch (InterruptedException e) {
            System.out.printf("...");
            }
        }
    }
}


// Thread.currentThread().getName()