/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pracitcando2;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author joel
 */
public class Main {
    public static void main(String[] args){
  /*      for(int i = 1; i<10 ; i++){
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
       
    Thread task = new PrimeGenerator();
    task.start();
    
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e){
        e.printStackTrace();
    }
    task.interrupt();
  */  
    

    FileClock clock = new FileClock();
    Thread thread = new Thread(clock);
    thread.start();
    
    try{
        TimeUnit.SECONDS.sleep(1);
    }catch (InterruptedException e){
        System.out.printf("The fileclock has been interrupted");
    }
    
    thread.interrupt();
    }
}
    

