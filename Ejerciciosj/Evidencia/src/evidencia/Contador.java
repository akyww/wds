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
public class Contador extends Thread{
    private int number;
    public Contador(int number)
    {
        this.number = number;
    }

    @Override
    
    public void run()
    {
        for(int i = 1; i<= 4 ;i++)
        {
       
            System.out.printf("%s: %d \n",Thread.
                currentThread().getName() , number+5000);
        }
    }
}
