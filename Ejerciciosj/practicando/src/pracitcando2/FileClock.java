/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pracitcando2;

/**
 *
 * @author joel
 */
import java.util.Date;
import java.util.concurrent.TimeUnit;
public class FileClock implements Runnable{
    @Override
    public void run(){
        for(int i =0; i<10; i++){
            System.out.printf("$s\n", new Date ());
            try{
                TimeUnit.SECONDS.sleep(4);
            }catch (InterruptedException e){
                System.out.printf("The fileclock has been interrupted");
            } 
        }
    }
}
