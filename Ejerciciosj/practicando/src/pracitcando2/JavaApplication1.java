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
public class JavaApplication1 {
    
    public static void main(String[] args) throws InterruptedException {
        
        
        Thread []t = new Thread[5];
        SeccionCritica h;
        Thread hilo;
        
        for(int i =0 ; i < 5; i++)
        {
            h = new SeccionCritica();
            hilo = new Thread(h);
            t[i] = hilo;
        }
        
        for(int i =0; i< 5;i++)
        {
            t[i].start();
        }
    }
}
