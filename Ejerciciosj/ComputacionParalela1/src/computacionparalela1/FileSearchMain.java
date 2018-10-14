/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacionparalela1;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author joel
 */
public class FileSearchMain {
    public static void main(String[] args){
        FileSearch searcher=new FileSearch("D:\\","autoexec.bat");
        Thread thread=new Thread(searcher);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
