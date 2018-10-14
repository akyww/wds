/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialpregunta3;
/**
 *
 * @author joel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        Runtime runtime = Runtime.getRuntime();
        int procesadores = runtime.availableProcessors();
        
        System.out.println("Numero de procesadores : " + procesadores);
        
        Thread[] hilos = new Thread[procesadores];
        
        for(int i=0; i<hilos.length; i++)
        {
            RunnableClass run = new RunnableClass();
            Thread th = new Thread(run);
            hilos[i] = th;
        }
        
        for(int i=0; i<hilos.length; i++)
        {
            hilos[i].start();
            //hilos[i].join();
        }
    }
}

/* 
a.¿Qué sucede si no se sincronizan los hilos?

Al ser asíncronos, los hilos acceden a un recurso compartido como en este caso. Eso produce que 
se hagan varias ejecuciones sobre el mismo dato, es por eso que los resultados al final son mucho
mas diferentes a los esperados.

b.En su programa que variable representa la sección critica y cómo elmina el indeterminismo.

En el programa la variable que hace que los hilos entren en sección crítica es la variable entera
"cont" de la clase RunnableClass, porque todos los hilos acceden a ella. El indeterminismo puede elminarse
en este caso sinconizando los hilos con el método "join()", el cual hace que el programa espere hasta que 
el hilo temrine de ejecutarse. (está comentado en el código).
*/