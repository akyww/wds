/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialpregunta3;

/**
 *
 * @author joel
 */
public class RunnableClass implements Runnable {
    
    private static int cont = 0;
    
    public RunnableClass()
    {
        
    }
    
    @Override
    public void run()
    {
        for(int i=0; i<500000; i++)
        {
            cont++;
        }
        
        System.out.println("El valor de x es : " + cont);
    }
}
