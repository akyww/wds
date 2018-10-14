/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenandoenteros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author joel
 */
public class Main {
      
    public static void main(String[] args) throws IOException {
        GenerarDatos texto = new GenerarDatos();
        
        //Creando un archivo de texto en el disco D
        File file = new File("D:\\numeros.txt");
        texto.generar(file, 1000000);
        
        ObteniendoDatos obj1= new ObteniendoDatos();
        obj1.ordenarDatos(file);
        
        AlgoritmosDeOrdenacion alg = new AlgoritmosDeOrdenacion();
   
        Scanner entradaEscaner = new Scanner (System.in);
        boolean quit = false;
        int opcion;
        while(!quit)
        {
            System.out.print("Ingrese opcion : \n");
            System.out.print("1 bubble sort , 2 merge sort , 3 salir :");
            opcion = entradaEscaner.nextInt();
            if(opcion == 1)
            {
                System.out.print("Bubble Sort : ");
                alg.bubbleSort(obj1.ordenarDatos(file));
                System.out.print("\n");
            }
            
            if(opcion == 2)
            {
                System.out.print("Merge Sort : ");
                alg.show(alg.mergeSort(obj1.ordenarDatos(file)));
                System.out.print("\n");
                
            }
            if(opcion == 3)
                quit = true;
        }

}
    
}
