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
public class SeccionCritica implements Runnable{
    private static int x = 0;
    
    @Override
    public void run(){
        for(int i =0 ; i< 500000; i++)
        {
            x++;
        }
    System.out.println("El valor de x es : " + x);
    }
}
