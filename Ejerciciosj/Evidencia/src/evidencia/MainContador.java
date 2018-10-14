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
public class MainContador {
     public static void main(String[] args) {
        
         for(int i = 1 ; i <= 4 ; i ++){
         Thread trd = new Contador(10);
         trd.start();
         }
       
        
        /*
        for(int i =1; i <=4 ; i++){
            ContadorRunnable wd= new ContadorRunnable(300);
            Thread thread = new Thread(wd);
            thread.start();
        }    

        */
     }

}

