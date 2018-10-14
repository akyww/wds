/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unsafetask;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author joel
 */
public class Core {
    public static void main(String[] args) {
        UnsafeTask task=new UnsafeTask();
        SafeTask task1 = new SafeTask();
        for (int i=0; i<10; i++)
        {
            Thread thread=new Thread(task1);
            thread.start();
            try {
            TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }
        }
    }
}
