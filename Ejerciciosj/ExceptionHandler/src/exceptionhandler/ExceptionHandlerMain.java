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
public class ExceptionHandlerMain {
    public static void main(String[] args ){
        //Creando objeto
        Task task = new Task();
        //Creando hilo
        Thread th = new Thread(task);
        th.setUncaughtExceptionHandler(new ExceptionHandler());
        th.start();
    }
}
