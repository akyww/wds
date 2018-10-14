/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksortthread;

/**
 *
 * @author joel
 */
public class MainQSThread extends Thread{
    
    private int arr[];
    private int low,high;
    public static int numThreads = Runtime.getRuntime().availableProcessors();
    public static int count = 0;

    public MainQSThread(int[] arr, int low, int high){
        this.arr = arr;
        this.low = low;
        this.high = high;
    }

    public void run(){
        parallelQuicksort(arr,low,high);    
    }

    public static void quicksort(int[] arr, int low, int high){
        if (high>low){
            int i = partition(arr,low,high);
            quicksort(arr,low,i-1);
            quicksort(arr,i+1,high);
        }
    }

    public static  void parallelQuicksort(int[] arr, int low, int high){
        if (high>low){
            int i = partition(arr,low,high);
            if (count < numThreads){
                count++;
                MainQSThread quicksort  = new MainQSThread(arr, low, i-1);
                quicksort.start();
            } else {
                quicksort(arr,low,i-1);
            }   
            if (count < numThreads){
                count++;
                MainQSThread quicksort  = new MainQSThread(arr, i+1, high);
                quicksort.start();
               
            }else{
                quicksort(arr,i+1,high);
            }
        }
    }

    public static int partition(int[] arr, int low,int high)
    {
        int pivot = arr[high];
        int i = low-1;
        int temp=0;

        for(int j=low; j<high; j++)
        {
            if(arr[j]<=pivot)
            {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
        
    public static void main(String[] args) throws InterruptedException
    {

        int[] v = new int[10000]; 
        
        for(int i = 0; i <v.length;i++)
        {
            v[i] = (int) (Math.random() * 100)+10;
            System.out.print(v[i]+" ");
        }
        
        System.out.print("\n");
        
        long start = System.currentTimeMillis();

        MainQSThread.quicksort(v,0,v.length -1);
        
        System.out.println("Ordenamiento normal "+(System.currentTimeMillis()-start)+" ms");
        
        MainQSThread.printArray(v);
        
        start = System.currentTimeMillis();
        
        MainQSThread.parallelQuicksort(v,0,v.length -1);

        System.out.println("Ordenamiento en paralelo "+(System.currentTimeMillis()-start)+" ms");
        
        MainQSThread.printArray(v);
       
    }
    
}
    

