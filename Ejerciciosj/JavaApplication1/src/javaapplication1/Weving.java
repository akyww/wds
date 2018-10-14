/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author joel
 */
public class Weving{

    public void pentavolica(String palabra)
    {
        int a=0,e=0,i=0,o=0,u=0;
        
        for(int j=0; j<palabra.length();j++)
        {
            switch (palabra.charAt(j)) {

            case 'a':
                a=1;
            break;
            
            case 'e':
                e=1;
            break;
            
            case 'i':
                i=1;
            break;
            
            case 'o':
                o=1;
            break;
            
            case 'u':
                u=1;
            break;
            
            default:
           
            break;
           }
        }
        
        if(a==1 && e==1 && i==1 && o==1 && u==1)
        {
            System.out.println("Es pentavolica");
        } else {
            System.out.println("No es pentavolica");
        }
    }
    
    public static void main(String[] args) {
         Weving wb = new Weving();
         
         wb.pentavolica("mercielagogelipm");
         
    }
    
}
