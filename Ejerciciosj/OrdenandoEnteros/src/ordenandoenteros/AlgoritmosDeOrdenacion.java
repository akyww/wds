/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenandoenteros;

import java.util.ArrayList;

/**
 *
 * @author joel
 */
public class AlgoritmosDeOrdenacion {
    
    public void bubbleSort(ArrayList<Integer> arr)
    {
        for(int i = arr.size()-1; i >= 0; i--)
        {
            for(int j = 0; j < i; j++)
            {
                if(arr.get(j) > arr.get(j + 1))
                {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }

        for(int i = 0; i<arr.size(); i++)
        {
            System.out.print(arr.get(i) +" ");
            if(i%20 == 0)
            {
                System.out.print("\n");
            }
        }
    }
    
    public void show(ArrayList<Integer> print)
    {
        for(int i = 0; i<print.size(); i++)
        {
            System.out.print(print.get(i) +" ");
            if(i%20 == 0)
            {
                System.out.print("\n");
            }
        }
    }
    		    
   public ArrayList<Integer> mergeSort(ArrayList<Integer> arr) 
   {
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        int mid = arr.size() / 2;
        
        if(arr.size() == 1)
        {
            return arr;
        } else {
            for(int i = 0; i < mid ; i++)
            {
                array1.add(arr.get(i));
            }
            
            for(int i = mid; i< arr.size(); i++)
            {
                array2.add(arr.get(i));
            }
        }
        
        array1= mergeSort(array1);
        array2= mergeSort(array2);
        merge(array1, array2, arr);

        return arr;
       
    }
 
    private void merge(ArrayList<Integer> array1, ArrayList<Integer> array2, ArrayList<Integer> resp) 
    {
        int iArray1 = 0;
        int iArray2 = 0;
        int i = 0;

        while (iArray1 < array1.size() && iArray2 < array2.size()) 
        {
            if ((array1.get(iArray1) < (array2.get(iArray2)))) 
            {
               resp.set(i, array1.get(iArray1));
                iArray1++;
            } else {
                resp.set(i, array2.get(iArray2));
                iArray2++;
            }
            i++;
        }
        
        ArrayList<Integer> temp;
        int iTemp;
        if (iArray1 >= array1.size()) 
        {
            temp = array2;
            iTemp = iArray2;
        } else {
            temp = array1;
            iTemp = iArray1;
        }

        for (int j=iTemp; j<temp.size(); j++) 
        {
            resp.set(i, temp.get(j));
            i++;
        }
    }   
}

  
