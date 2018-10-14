/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writertask;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author joel
 */
public class writerTaskMain {
     public static void main(String[] args) {
        Deque <Event> deque= new ArrayDeque<>();
        WriterTask writer = new WriterTask(deque);
        for(int i = 0; i<3; i++)
        {
            Thread thread = new Thread(writer);
            thread.start();
        }
        CleanerTask cleaner = new CleanerTask(deque);
        cleaner.start();
    }
}
