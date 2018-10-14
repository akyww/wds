/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicacionmatrices;

/**
 *
 * @author Laboratorio 23
 */
public class HiloMultiplicador extends Thread{
    
    public static int num = 10;
    private int inicio;
    private int Final;
    public static int[][] mat = new int[4][4];

    public HiloMultiplicador(int inicio, int Final)
    {
        this.Final = Final;
        this.inicio = inicio;
    }
    
    @Override
    public void run()
    {
        for(int i = inicio; i < Final; i++)
        {
            for(int j = 0; j < mat.length; j++)
            {
                  mat[i][j] = mat[i][j]*num;
            }
        }
    }
}
