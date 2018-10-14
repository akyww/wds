/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionhandler;

/**
 *
 * @author joel
 */
public class Task implements Runnable {
    @Override
    //Implementando run, forzando una excepcion
    public void run()
    {
        int numero = Integer.parseInt("TTT");
    }
}
