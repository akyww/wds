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
public class Calculadora implements Runnable{
    //Atributos
    private int number;
    
    //Constructor con parámetros
    public Calculadora(int number) 
    {
    this.number=number;
    }
    
    //Implementando metodo run, de la interface Runabble
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
