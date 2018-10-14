/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionparalela1;

/**
 *
 * @author joel
 */
public class Calculator implements Runnable{ 
    
    //Atributos
    private int number;
    
    //Constructor con parámetros
    public Calculator(int number)
    {
    this.number=number;
    }
    
    
    //Implementando el metodo run de la interface Runnables
    @Override
    public void run()
    {
        for (int i=1; i<=10; i++)
        {
        System.out.printf("%s: %d * %d = %d\n",Thread.
        currentThread().getName(),number,i,i*number);
        }
    }
}
