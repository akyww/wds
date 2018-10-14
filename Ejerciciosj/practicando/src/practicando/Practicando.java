/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicando;

/**
 *
 * @author joel
 */
public class Practicando {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Persona persona=new Persona("juan", 31, 'M');
        Empleado empleado = new Empleado("jose", 40, 'M', 123, (float) 1500.30,"ventas" );
        System.out.println(empleado.getCargo());
    }
   
}
