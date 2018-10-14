/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicacionmatrices;

import static multiplicacionmatrices.HiloMultiplicador.mat;

/**
 *
 * @author Laboratorio 23
 */
public class MultiplicacionMatrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        double tiempoInicio, tiempoFinal;
        int mat1[][] = new int[4][4];
        for(int i = 0 ; i<mat1.length; i++)
        {
            for(int j = 0; j<mat1.length;j++)
            {
                 mat1[i][j] = (int)(Math.random()*4) +1;
            }           
        }
        
        for(int i = 0 ; i<mat1.length; i++)
        {
            for(int j = 0; j<mat1.length;j++)
            {
                 System.out.print(mat1[i][j]+" ");     
            }           
            System.out.print("\n");
        }
        
        HiloMultiplicador h1 = new HiloMultiplicador(0,2);
        HiloMultiplicador h2 = new HiloMultiplicador(2,4);
        HiloMultiplicador.mat = mat1;
        h1.start();
        h2.start();
        h1.join();
        h2.join();
        
        tiempoInicio = System.nanoTime();
        tiempoFinal = System.nanoTime() - tiempoInicio;
        
        for(int i = 0 ; i<mat.length; i++)
        {
            for(int j = 0; j<mat.length;j++)
            {
                 System.out.print(mat[i][j]+" ");     
            }           
            System.out.print("\n");
        }
        
        System.out.println("El tiempo final es : " + tiempoFinal);
        
        String sr = "123 34 32";
        String[] arr = sr.split(" ");
        
        for (String arr1 : arr) {
            System.out.println(arr1);
            
        }
        
    }
}
