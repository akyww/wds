/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialPregunta4Thread;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author joel
 */
public class MainCajeroThread {
    
    public static void main(String[] args) throws InterruptedException 
    {
        double tiempo_inicio,tiempo_final;
      
        
      
        List<ClienteThread> clientes = new ArrayList<>();
        
        clientes.add(new ClienteThread("Cliente 1",1470));
        clientes.add(new ClienteThread("Cliente 2",5210));
        clientes.add(new ClienteThread("Cliente 3",8920));
        clientes.add(new ClienteThread("Cliente 4",4280));
        clientes.add(new ClienteThread("Cliente 5",7390));
        clientes.add(new ClienteThread("Cliente 6",4610));
        clientes.add(new ClienteThread("Cliente 7",3520));
        clientes.add(new ClienteThread("Cliente 8",5270));
        
        Thread[] th = new Thread[4];

        int inicio=0;
        int fin=0;
        int rango=0;
        
        CajeroThread cajero;
        
        rango = clientes.size()/th.length;
        fin+=rango;
        for(int i = 0; i<th.length;i++)
        {
            cajero = new CajeroThread(clientes,inicio, fin); 
            th[i] = cajero;
            th[i].start();
            th[i].join();
            inicio = fin;
            fin += rango;
        
        }
        
        tiempo_inicio = System.nanoTime();
        
        tiempo_final = System.nanoTime() - tiempo_inicio;
        System.out.println("Tiempo total : " + (tiempo_final/1000) + " milisegundos");
    }
    
}
