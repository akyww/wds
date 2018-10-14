/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Laboratorio 23
 */
public class Evidencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i =0; i <=10 ; i++){
            HolaMundo wd= new HolaMundo("Hola Mundo");
            Thread thread = new Thread(wd);
            thread.start();
        }

    }  
        
   
}
