/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionparalela1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

/**
 *
 * @author joel
 */
public class CalculadoraMain {
    public static void main(String[] args) throws IOException {
        //Creanto un arreglo de Threads
        Thread threads[] = new Thread [10];
        //Creando un arreglo de Thread.State, el cual es un enum, con los diferentes estados de un hilo.
        Thread.State status[]=new Thread.State[10];
            for (int i=0; i<10; i++){
                //Creando los hilos, y llenando el arreglo.
                threads[i]=new Thread(new Calculadora(i));
                //Dando la prioridad maxima a los numeros pares y la minima la resto
                if ((i%2)==0){
                    threads[i].setPriority(Thread.MAX_PRIORITY);
                    } else {
                    threads[i].setPriority(Thread.MIN_PRIORITY);
                    }
                //Enviando el nombre del hilo
                threads[i].setName("Thread "+i);
            }
             
            //Escribiremos en un archivo el estado del hilo
            //Se usa una excepcion por si el archivo no existe.
        try (FileWriter file = new FileWriter("D:\\log.txt");
                PrintWriter pw = new PrintWriter(file);){

                for (int i=0; i<10; i++)
                {
                    //Escribiremos en el archivo el estado del hilo, que al principio es NEW
                    pw.println("Main : Status of Thread "+i+" : " +
                    threads[i].getState());
                    //Llenamos nuestro arreglo de estados con los estados actuales.
                    status[i]=threads[i].getState();
                }
            //Inicializando los hilos.
            for(int i=0; i<10; i++)
            {
                threads[i].start();
            }
            
            boolean finish=false;
            while (!finish)
            {
                for (int i=0; i<10; i++)
                {   
                    //Comparando el antiguo estado (NEW), con el estado actual del hilo
                    if (threads[i].getState()!=status[i])
                    {
                        //Escribe en el archivo el pw, el hilo y su estado.
                        writeThreadInfo(pw, threads[i],status[i]);
                        //Guardando en el arreglo el nuevo estado del hilo.
                        status[i]=threads[i].getState();
                    }
                }   
                finish=true;
                for (int i=0; i<10; i++)
                {
                finish=finish &&(threads[i].getState()==State.TERMINATED);
                }
            }
        }
      
    }

    //Creando funcion writeThreadInfo, que escribe en el archivo.
    private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {
        pw.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
        pw.printf("Main : Priority: %d\n",thread.getPriority());
        pw.printf("Main : Old State: %s\n",state);
        pw.printf("Main : New State: %s\n",thread.getState());
        pw.printf("Main : ************************************\n");

    }         
}
