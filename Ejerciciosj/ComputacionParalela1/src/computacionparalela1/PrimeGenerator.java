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
public class PrimeGenerator extends Thread{
    @Override
    //Implementando metodo run.
    public void run()
    {
        long number = 1L;
        while (true)
        {
            if(isPrime(number))
                System.out.printf(" Number %d is Prime \n", number);
       
            if(isInterrupted())
            {
                System.out.printf("The Prime Generator has been interrupted \n");
                return;
            }
        number ++ ;
        }
    }
    
    //Funcion para verificar si un numero es primo, retorna un valor boolean.
    //Es privada ya que solo sera usada por esta misma clase.
    private boolean isPrime(long number)
    {
        if(number <=2)
        {
            return true;
        }
        for(long i=2; i < number ;i++)
        {
            if(number%i == 0)
            {
                return false;
            }
        }
        return true;
    }

    
}
