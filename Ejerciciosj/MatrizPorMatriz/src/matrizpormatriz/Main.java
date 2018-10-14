/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizpormatriz;

import static matrizpormatriz.MatrizPorMatriz.mat;
import static matrizpormatriz.MatrizPorMatriz.mat1;
import static matrizpormatriz.MatrizPorMatriz.res;

/**
 *
 * @author joel
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        MatrizPorMatriz.num = 3;
        
        int[][] mat = new int[MatrizPorMatriz.num][MatrizPorMatriz.num];
        int[][] mat1 = new int [MatrizPorMatriz.num][MatrizPorMatriz.num];
        
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat.length; j++)
            {
                mat[i][j] = (int ) (Math.random() * 20) +1;
            }
        }
        
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j<mat.length; j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.print("\n");
        }
        
        for(int i = 0; i < mat1.length; i++)
        {
            for(int j = 0; j < mat1.length; j++)
            {
                mat1[i][j] = (int ) (Math.random() * 20) +1;
            }
        }
        
        System.out.print("\n");
        
        for(int i = 0; i < mat1.length; i++)
        {
            for(int j = 0; j<mat1.length; j++)
            {
                System.out.print(mat1[i][j] + " ");
            }
            System.out.print("\n");
        }
        
        /*
        int res[][] = new int[mat.length][mat1.length];
        
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j< mat1.length; j++)
            {
                for(int k = 0; k < mat.length; k++)
                {
                res[i][j] += mat[i][k]*mat1[k][j];
                }
            }
        }
        
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j< mat1.length; j++)
            {
                System.out.print(res[i][j]+ " ");
            }
            System.out.print("\n");
        }
       */  
        MatrizPorMatriz.mat = mat;
        MatrizPorMatriz.mat1 = mat1;
        
        int[][] result = new Main().multiplicacion(mat,mat1);
        
        for(int i = 0; i < result.length; i++)
        {
            for(int j = 0; j < result.length;j++)
            {
                System.out.print(result[i][j]);
            }
            
        }
    }

    public int[][] multiplicacion(int[][] mat, int[][] mat1)
    {
        int[][] resultado = new int[mat.length][mat1.length];

        for(int i = 0; i<resultado.length;i++)
        {
            for(int j = 0 ; j<resultado.length;j++)
            {
            MatrizPorMatriz hilo = new MatrizPorMatriz();
            hilo.start();
            }
        }
        return resultado;
    }
}
