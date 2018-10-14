/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladoresev4;

import java.util.Scanner;

/**
 *
 * @author joel
 */
public class CompiladoresEv4 {

    public void arcoiris2()
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int flag = 0;        
        while(num>0){
            int arrSize = sc.nextInt();
            
            int[] arr = new int[arrSize];
            int j = arr.length-1;
            
            for(int index = 0; index<arr.length;index++)
            {
                int datoArray = sc.nextInt();
                arr[index] = datoArray;
            }
            
            for(int k = 0; k<arr.length-1;k++)
            {
                if(Math.abs(arr[k]-arr[k+1]) >= 2)
                {
                    System.out.println("No");                      
                    return;
                }
            }

            for(int i=0;i<arr.length;i++)
            {
                if( arr[i] == arr[j])
                {
                    flag = 0;
                } else {
                    flag = 1;
                }
                j--;
            }
            if(flag == 0)
            {
                System.out.println("Si");
            } else {
                System.out.println("No");
            }   
            num--;
        }
    
    }

    
    public void ajedrez()
    {  
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(T>0)
        {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            
            int puntos1 = x1 + y1;
            int puntos2 = x2 + y2;

            if(puntos1%2 == 0 && puntos2%2 == 0)
            {
                System.out.println("Si");
            } else {
                System.out.println("No");
            }        
            T--;
        }
    }
    
    
    public static void main(String[] args) {
        
        CompiladoresEv4 cs = new CompiladoresEv4();
        
        //cs.arcoiris(3, 1);
        int arr[] = {1,1,2,2,3,4,5,6,6,6,7,6,6,6,5,4,3,2,2,1,1};
        int arr1[] = {1,2,3,4,5,6,7,6};
        int arr2[] = {1,1,2,3,4,5,6,8,6,5,4,3,2,1,1};
        int arr3[] = {1,3,4,3,1};
        
        cs.arcoiris2();
        
        //cs.ajedrez();
        
    }
    
}
