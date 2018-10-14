/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialpregunta4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joel
 */
public class MainCajero {

    public static void main(String[] args) 
    {
        double tiempo_inicio,tiempo_final;
        
        
        List<Cliente> clientes=new ArrayList<>();
        
        Cliente c1 = new Cliente("Cliente 1",1470);
        Cliente c2 = new Cliente("Cliente 2",5210);
        Cliente c3 = new Cliente("Cliente 3",8920);
        Cliente c4 = new Cliente("Cliente 4",4280);
        Cliente c5 = new Cliente("Cliente 5",7390);
        Cliente c6 = new Cliente("Cliente 6",4610);
        Cliente c7 = new Cliente("Cliente 7",3520);
        Cliente c8 = new Cliente("Cliente 8",5270);
        
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        clientes.add(c4);
        clientes.add(c5);
        clientes.add(c6);
        clientes.add(c7);
        clientes.add(c8);
         
        Cajero cajero = new Cajero(clientes);
        cajero.realizarRetiro();
          
        tiempo_inicio = System.nanoTime();
        
        tiempo_final = System.nanoTime() - tiempo_inicio;
        System.out.println("\n");
        System.out.println("Tiempo total : " + (tiempo_final/1000) + " milisegundos");
    }
    
}

/*El programa en paralelo se ejecuta ligeramente mas rapido que el secuencial
En el programa en paralelo reparte de manera diferente el dinero, ya que hay 4 cajeros
cada uno con cierta cantidad.
*/