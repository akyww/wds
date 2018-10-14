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
public class CalculatorMain {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Creando 10 hilos
        for(int i = 1; i<=10;i++)
        {
            Calculator calculator = new Calculator(i); 
            Thread th = new Thread(calculator);        //Creando los hilos, llamando al constructor de Thread.                                                //de Thread y enviando 
            th.start();                                //Inicializando cada hilo   
        }
    }    
}
