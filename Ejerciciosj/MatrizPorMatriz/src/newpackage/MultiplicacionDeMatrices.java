package newpackage;

/**
 *
 * @author joel
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;

/**
 *
 * @author joel
 */
public class MultiplicacionDeMatrices extends Thread{
    
    public static int tamaño = 6;
    public int inicio;
    public int fin;
    public static int [][] matriz = new int[tamaño][tamaño];
    public static int [][] matriz2 = new int[tamaño][tamaño];
    public static int [][] respuesta = new int[tamaño][tamaño];
    
    
    public MultiplicacionDeMatrices(int inicio, int fin)
    {
        this.fin    = fin;
        this.inicio = inicio;
    }
    
    public MultiplicacionDeMatrices()
    {
                
    }
    
    @Override
    public void run(){
        for(int i=inicio;i<fin;i++)
        {
            for(int j=0;j<tamaño;j++)
            {
                for(int k=0; k < tamaño; k++)
                {
                    respuesta[i][j] += matriz[i][k] * matriz2[k][j];
                }
            }
        }
    }
  
    public static void main(String[] args) {
        // TODO code application logic here
        Random rand = new Random(System.nanoTime());
        Runtime runtime = Runtime.getRuntime();
        int nucleos = runtime.availableProcessors();
        
        System.out.println("Numero de procesadores : " + nucleos);
              
        double tiempo_inicio,tiempo_final;
        for(int i=0;i<tamaño;i++)
        {
            for(int j=0;j<tamaño;j++)
            {
                matriz[i][j] = rand.nextInt(10);
            }
        }
        
        for(int i=0;i<tamaño;i++)
        {
            for(int j=0;j<tamaño;j++)
            {
                matriz2[i][j] = rand.nextInt(10);
            }
        }
               
        for(int i=0;i<tamaño;i++)
        {
            for(int j=0;j<tamaño;j++)
            {
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.print("\n");
        }
        
        System.out.print("\n");
        
         for(int i=0;i<tamaño;i++)
         {
            for(int j=0;j<tamaño;j++)
            {
                System.out.print(matriz2[i][j]+ " ");
            }
            System.out.print("\n");
        }
         
        int rango = 0;
        int inicio = 0; 
        int fin= 0;
        Thread[] hilos;
        
        if(tamaño < nucleos)
        {
            hilos = new Thread[tamaño];
            rango = 1;
        } else {
            hilos = new Thread[nucleos];
            rango = tamaño/nucleos;
        }
        
        fin += rango;
        
        MultiplicacionDeMatrices mm;
        
        for(int i = 0; i<hilos.length;i++)
        {
            mm = new MultiplicacionDeMatrices(inicio, fin); 
            hilos[i] = mm;
            hilos[i].start();
            inicio = fin;
            fin += rango;
            if(i == hilos.length-1)
            {
                fin = tamaño;
                MultiplicacionDeMatrices m1 = new MultiplicacionDeMatrices(inicio,fin);
                hilos[i] = m1;
                hilos[i].start();
            }
        }
       
        tiempo_inicio = System.nanoTime();
        
        tiempo_final = System.nanoTime() - tiempo_inicio;
        System.out.println("Tiempo total : " + (tiempo_final/1000) + " milisegundos");
        for(int i=0;i<tamaño;i++)
        {
            for(int j=0;j<tamaño;j++)
            {
                System.out.print(respuesta[i][j] + " ");
            }
            System.out.println(" ");
        }
         
    }
    
}
