/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Laboratorio 23
 */
public class HolaMundoThread extends Thread{
    
    private String word;
    public HolaMundoThread(String word)
    {
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
