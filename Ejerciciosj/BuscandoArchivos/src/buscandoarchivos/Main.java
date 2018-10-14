/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscandoarchivos;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author joel
 */
public class Main {
    
    public static void main(String[] args) 
    {
        String ruta = "C:\\";
        File file = new File(ruta);
        System.out.print("Ingrese la extensión del archivo : ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        BuscandoArchivos bs = new BuscandoArchivos(word);
        bs.find(file);
    }
}
