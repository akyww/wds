/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialpregunta4;

import java.util.List;

/**
 *
 * @author joel
 */
public class Cajero {
    
    private int montoTotal = 0;
    private int i=0; 
    private int cantidad200 = 60,cantidad100 = 100,cantidad50 = 200,cantidad20 = 500;
    private int dc=0,cn=0,cc=0,vn=0;
    
    List<Cliente> cliente;
    
    public Cajero(List<Cliente> cliente)
    {
        this.cliente = cliente;
    }
    
    public void ejecutar(Cliente clientes)
    {
        realizarRetiro();
    }
    
    public void realizarRetiro()
    {
       int monto;
       int doscientos=0;
       int cien=0;
       int cincuenta=0;
       int veinte=0;
       for (int i=0; i<cliente.size();i++) {
            monto = cliente.get(i).obtenerMonto();
            System.out.print(cliente.get(i).obtenerIdCliente()+" ");
            doscientos=monto/200;
            
            if(cantidad200>dc && doscientos<=cantidad200)
            {
                monto-=doscientos*200;
                dc+=doscientos;
                if(doscientos>0)
                {
                    System.out.print(" "+doscientos+" billetes de 200");
                }
            }
            
            cien=monto/100;
            if(cantidad100>cn && cien<=cantidad100)
            {
                monto-=cien*100;
                cn+=cien;
                if(cien>0)
                {
                    System.out.print(" "+cien+" billetes de 100");
                }
            }
            
            cincuenta=monto/50;
            if(cantidad50>cc && cincuenta<=cantidad50)
            {           
                monto-=cincuenta*50;
                cc+=cincuenta;
                if(cincuenta>0)
                {
                    System.out.print(" "+cincuenta+" billetes de 50");
                }
            }
            
            veinte=monto/20;
            if(cantidad20>vn && veinte<=cantidad20)
            {
                monto-= veinte*20;
                vn+=veinte;
                if(veinte>0)
                {
                    System.out.print(" "+veinte+" billetes de 20");
                }
            }
            
            if(montoTotal>=42000)
            {
                System.out.print("No hay dinero suficiente");
                return;
            }            

            System.out.print("\n");
        }
    }
}
