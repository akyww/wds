/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizpormatriz;

/**
 *
 * @author joel
 */
public class MatrizPorMatriz extends Thread{
    
    public static int num;
    public static int mat[][] = new int[num][num];
    public static int mat1[][] = new int[num][num];
    public static int res[][] = new int[mat.length][mat1.length];
    
    public MatrizPorMatriz()
    {
        
    }
    
    @Override
    public void run()
    {   
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j< mat1.length; j++)
            {
                for(int k = 0; k < res.length; k++)
                {
                res[i][j] += mat[i][k]*mat1[k][j];
                }
            }
        }
        System.out.print("\n");
    }
    
}
