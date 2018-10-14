/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDeDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author joelpt
 */
public class Main {
    public static void main(String [] args) throws SQLException{
        ConnectionDB connection = new ConnectionDB();
        Connection cn = connection.openConnection();
        
        if(cn == null)
        {
            System.out.println("No se pudo conectar");
        } else {
            System.out.println("Conexion exitosa");
        }
     
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        boolean exit= false;
        int opcion;
        String caracter;
        Sentences sn = new Sentences();
       

        while(!exit)
        {   
            System.out.println("\n");
            System.out.println("Ecoja una opcion : ");
            System.out.println("1 : Visualizar la tabla");
            System.out.println("2 : Realizar busqueda por dni ");
            System.out.println("3 : Realizar busqueda por nombre o apellido");
            System.out.println("4 : Realizar busqueda por intervalo de edades");
            System.out.println("5 : Para salir del menu");
            
            opcion = sc.nextInt();
            if(opcion == 1)
            {   
                sn.setConnection(cn);
                ArrayList<String> emp = new ArrayList<>();
                emp = sn.returnTable();
                sn.showTable(emp);
            }
            
            if(opcion == 2)
            {   
                System.out.println("Ingrese numero de dni completo o parcial : ");
                caracter = sc2.nextLine();
                sn.setConnection(cn);
                ArrayList<String> empByDni = new ArrayList<>();
                empByDni = sn.searchByDni(caracter);
                System.out.println("\n");
                sn.showSearchByDni(empByDni);
            }
            
            if(opcion == 3)
            {   
                System.out.println("Ingrese nombres o apellidos : ");
                caracter = sc2.nextLine();
                sn.setConnection(cn);
                ArrayList<String> empByName = new ArrayList<>();
                empByName = sn.searchByName(caracter);
                System.out.println("\n");
                sn.showSearchByName(empByName);
                      
            }
            
            if(opcion == 4)
            {   
                System.out.print("Ingrese intervalo de edades : ");
                int num1 = sc2.nextInt();
                int num2 = sc2.nextInt(); 
                sn.setConnection(cn);
                ArrayList<String> empByAge = new ArrayList<>();
                empByAge = sn.searchByAge(num1,num2);
                System.out.println("\n");
                sn.showSearchByAge(empByAge);

            }
            if(opcion == 5)
            {
                cn.close();
                exit = true;
            }
        }  
    }
}
