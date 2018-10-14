/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionparalela2;

import java.util.Date;

/**
 *
 * @author joel
 */
public class ComputacionParalela2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        //Creando objeto de DataSourcesLoader
        DataSourcesLoader dsLoader = new DataSourcesLoader();
        //Creando el hilo 1.
        Thread thread1 = new Thread (dsLoader, "DataSourceThread");
        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
        //Creando el hilo 2.
        Thread thread2 = new Thread(ncLoader,"NetworkConnectionLoader");
        //Inicializando los hilos.
        thread1.start();
        thread2.start();    
        //Ejecutando los hilos primero, antes que el programa principal.
        //Sincronizando hilos.
        thread1.join();
        thread2.join();
        System.out.printf("Main: Configuration has been loaded:%s\n",new Date());
    }
    
}
