/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author joel
 */
public class Puz {

    public int[][] mat = new int[3][3];
    public int posicion=0;
    
    public Puz()
    {
        
    }
    
    private void arriba()
    {
        for(int i=0; i<mat.length;i++)
        {
            for(int j=0; j<mat.length;i++)
            {
                int tmp = posicion;
                mat[i][j] = mat[i][j-1];
                mat[i][j-1] = posicion; 
                        
            }
        }
    }
    
    private void abajo()
    {
        for(int i=0; i<mat.length;i++)
        {
            for(int j=0; j<mat.length;i++)
            {
                
            }
        }
    }
    
    private void derecha()
    {
        for(int i=0; i<mat.length;i++)
        {
            for(int j=0; j<mat.length;i++)
            {
                
            }
        }
    }
    
    private void izquierda()
    {
        for(int i=0; i<mat.length;i++)
        {
            for(int j=0; j<mat.length;i++)
            {
                
            }
        }
    }
    
    public void esPirmo(int n)
    {
        int i = 2;
       
        while(i<=n)
        {
            int flag = 0;
            int tmp = 2;
            while(tmp<i){
                if(i%tmp == 0)
                {
                    flag = 1;
                }
                tmp++;
            }
            if(flag == 0)
            {
                System.out.println(i);
            }
            i++;
        }
    }
    
    public void factorial(int n)
    {
        int factorial = 1;
        int i =0;

        while(i<n)
        {
            int tmp = n-i;
            factorial = factorial * tmp;
            i++;
        }
        System.out.println(factorial);
    }
    
    public void sumatoriaPares(int m)
    {
        int i = 0;
        int suma = 0;
        while(i<m)
        {
            if(i%2 == 0)
            {
                suma = suma + i;
            }
            i++;
        }
        System.out.println(suma);
    }
    
    public void mayoYmenor()
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int mayor = 0;
        
        while(sc.hasNext())
        {
            if(sc.hasNextInt()){
            int num = sc.nextInt();
                if(num>mayor)
                {
                    mayor = num;
                }
            }
        }
        
        System.out.println("El numero mayor es: "+mayor);
        //System.out.println("El numero menor es: "+menor);
        
    }
    
    public void raiz(int n)
    {
        int i = 0;
        int raiz = n;
        
        if(n>1)
        {
            while(raiz!=i)
            {
                i = raiz;
                raiz = (((raiz*raiz)+n) / (2*raiz));
            }
           System.out.println(raiz);
        }
    }
    
    public void print(int num)
    {
        int i = 0;
        int A = 0;
        int B = 0;
        Scanner sc;
        
        while(i < num)
        {
            sc = new Scanner(System.in);
            
        }
    }
    
    public void fibo(int n)
    {
        int n1 = 0;
        int n2 = 1;
        
        for(int i =0;i<n-2;i++)
        {
            n2 = n1 + n2;
            n1 = n2 - n1;
            System.out.print(n2 + ", ");
        }
    }
    
    public void cuadruplos()
    {
        String[] op1 = {"entero","entero","b","a","a","Tmp1","Tmp3","a","Tmp4","entero","a"};
        String[] op2 = {" "," ","b","a","b","Tmp2","10","b","a"," ","c"};
        String[] operator = {"Declaracion","Declaracion","*","+","-","/","-","*","-","Declaracion","-"};
        String[] res = {"a","b","a","Tmp1","Tmp2","Tmp3","a","Tmp4","c","a","B"};
        
        List<String> decVar = new ArrayList<>();
        
        

        for(int i=0; i<res.length;i++)
        {
            if(operator[i]=="Declaracion")
            {
                if(decVar.isEmpty())
                {
                    decVar.add(res[i]);
                } else {
                    int size = decVar.size();
                    for(int j=0; j<size;j++)
                    {
                        if(res[i].equals(decVar.get(j)))
                        {
                            System.out.println("Variable "+res[i] +" re declarada");
                            break;
                        } else {
                            decVar.add(res[i]);
                        }
                    } 
                }
            } 
        }
        int flag;
        for(int i = 0; i <res.length;i++)
        {
            flag = 0;
            for(String str : decVar)
            {
                if((res[i].equals(str)))
                {
                    flag = 1;
                }
            }
             
            if(flag == 0 && res[i]!="Tmp1" && res[i]!="Tmp2" && res[i]!="Tmp3")
            {
                System.out.println("Variable "+ res[i] +" no declarada");
            }
        }
        
        
        for(String std: decVar)
        {
            System.out.print(std);
        }

    }
    
    
    public static void main(String args[])
    {
        Puz obj = new Puz();
        
        //obj.esPirmo(60);
        //obj.factorial(4);

        //obj.sumatoriaPares(10);
        //obj.mayoYmenor();
        
        //obj.raiz(9);
        
        //obj.fibo(10);
        
        obj.cuadruplos();
    }
    
}
