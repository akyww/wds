/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicacion.de.matrices;


/**
 *
 * @author Laboratorio 23
 */
public class MultiplicacionDeMatrices extends Thread{

    public static int tamaño = 5;
    private int inicio;
    private int fin;
    
    
    public static int matrizA[][] = new int [tamaño][tamaño];
    public static int matrizB[][] = new int [tamaño][tamaño];
    public static int respuesta[][] = new int [tamaño][tamaño];
    
    public MultiplicacionDeMatrices(int inicio, int fin)
    {
        this.fin=fin;
        this.inicio=inicio;
    }
    
    public MultiplicacionDeMatrices()
    {
        
    }
    
    @Override
    public void run()
    {
        for( int i=inicio; i<fin; i++ )
        {
            for( int j=0; j<tamaño; j++ )
            {
                for( int k=0; k<tamaño; k++ )
                {
                    respuesta[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        
    //Llenando las matrices de números aleatorios.
        for( int i=0; i<tamaño; i++ )
            for( int j=0; j<tamaño; j++)
                matrizA[i][j] = (int) (Math.random()*10)+1;
        
        for( int i=0; i<tamaño; i++ )
            for( int j=0; j<tamaño; j++)
                matrizB[i][j] = (int) (Math.random()*10)+1;
        
    //Imprimiendo ambas matrices.
        for( int i=0; i<tamaño; i++ )
        {
            for( int j=0; j<tamaño; j++)
            {
                System.out.print(matrizA[i][j]+" ");
            }
            System.out.print("\n");
        }
        
        System.out.print("\n");
        
        for( int i=0; i<tamaño; i++ )
        {
            for( int j=0; j<tamaño; j++)
            {
                System.out.print(matrizB[i][j]+" ");
            }
            System.out.print("\n");
        }
        
        System.out.print("\n");
        
        
        
        Runtime runtime= Runtime.getRuntime();
        int procesadores = runtime.availableProcessors();
        
        System.out.println("Se cuenta con "+procesadores+" procesadores\n");
        
        int inicio=0;
        int fin=0;
        Thread[] hilos;
        int rango=0;
        
        if(tamaño<procesadores)
        {
            hilos = new Thread[tamaño];
            rango = 1;
        } else {
            hilos = new Thread[procesadores];
            rango = tamaño/procesadores;
        }
        
        fin +=rango;
        
        MultiplicacionDeMatrices mm; 
        
        for( int i=0; i<hilos.length; i++ )
        {
            mm = new MultiplicacionDeMatrices(inicio,fin);
            hilos[i] = mm;
            hilos[i].start();
            inicio = fin;
            fin += rango;
            
            if(i == hilos.length-1)
            {
                fin = tamaño;
                MultiplicacionDeMatrices m1 = new MultiplicacionDeMatrices(inicio,fin);
                hilos[i] = m1;
                m1.start();
            }
        }
        
        for( int i=0; i<tamaño; i++ )
        {
            for( int j=0; j<tamaño; j++)
            {
                System.out.print(respuesta[i][j]+" ");
            }
            System.out.print("\n");
        }
        
    }
    
}
